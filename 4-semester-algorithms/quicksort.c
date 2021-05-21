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
    
void quickSort(int* array, int p, int r);
int partition(int* array, int p, int r);
void generate(int *array, int size);
void fillArray(int *array, int size);
void printArray(int *array, int size);

// Start

int main() {
    srand(time(NULL));
    
    const int SIZE = 20; // Array declaration
    int arr[SIZE];
    fillArray(arr, SIZE);
    
    printf("Before\n"); // Array feeding
    printArray(arr,SIZE);
    
    quickSort(arr, 0, SIZE); // Array sorting
    printf("After\n");
    printArray(arr,SIZE);
    
    return 0;
}

// Main functions

void quickSort(int* array, const int p, const int r){
    if(p < r){
        int q = partition(array, p, r);
        quickSort(array, p, q - 1);
        quickSort(array, q + 1, r);
    }
}

int partition(int* array, const int p, const int r){
    int pivot = array[r];
    int smaller = p;
    for(int i = p; i < r; i++)
        if(array[i] <= pivot){
            ARR_SWAP(array, i, smaller);
            smaller++;
        }
    ARR_SWAP(array, smaller, r);
    return smaller;
}

// Utility functions

void fillArray(int *array, const int size){
    for(int i = 0;i < size; i++)
        array[i] = rand() % 100;
}

void printArray(int *array, const int size){
    for(int i = 0; i < size ;i++)
        printf("%d ", array[i]);
    printf("\n");
}
