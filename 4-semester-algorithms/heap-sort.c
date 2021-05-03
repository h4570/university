// Sandro Sobczyński <sandro.sobczynski@gmail.com>
// https://github.com/h4570

#include <stdio.h>
#include <time.h>
#include <stdlib.h>

// Macros

#define ARR_SWAP(arr, i, j) do { \ 
   int _temp = arr[i]; \
   arr[i] = arr[j]; \
   arr[j] = _temp; \
 } while(0)

// Forward declarations
    
void heapSort(int* array, int size);
void maxHeap(int* array, int size);
void heapify(int* array, int size, int i);
void generate(int *array, int size);
void printArray(int *array, int size);

// Start

int main() {
    srand(time(NULL));
    
    const int SIZE = 20; // Array declaration
    int arr[SIZE];
    fillArray(arr, SIZE);
    
    printf("Before\n"); // Array feeding
    printArray(arr,SIZE);
    
    heapSort(arr, SIZE); // Array sorting
    printf("After\n");
    printArray(arr,SIZE);
    
    return 0;
}

// Main functions

void heapSort(int* array, int size){
    maxHeap(array, size);
    for(int i = size - 1; i > 0; i--){
        ARR_SWAP(array, 0, i);
        heapify(array, --size, 0);
    }
}

void maxHeap(int* array, int size){
    for(int i = (size - 1) / 2; i >= 0; i--)
        heapify(array, size, i);
}

void heapify(int* array, int size, int i){
    int left = i * 2 + 1;
    int right = i * 2 + 2;
    int largest = i;
    if(left < size && array[left] > array[largest]) largest = left;
    if(right < size && array[right] > array[largest]) largest = right;
    if(largest != i){
        ARR_SWAP(array, largest, i);
        heapify(array, size, largest);
    }
}

// Utility functions

void fillArray(int *array, int size){
    for(int i = 0;i < size; i++)
        array[i] = rand() % 100;
}

void printArray(int *array, int size){
    for(int i = 0; i < size ;i++)
        printf("%d ", array[i]);
    printf("\n");
}
