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

void presentQuicksort();
void presentHeapsort();
void presentBubblesort();

void bubbleSort(int* array, const int size);

void quickSort(int* array, int p, int r);
int partition(int* array, int p, int r);

void heapSort(int* array, int size);
void maxHeap(int* array, int size);
void heapify(int* array, int size, int i);

void printArray(int* array, int size);

void resetClock();
void printClock();

// Start

int main() {
    presentQuicksort();
    presentHeapsort();
    presentBubblesort();
    return 0;
}

void presentQuicksort(){
    const int SIZE = 10;
    int randomArray[] = { 13, 5, 845, 12, 15, 41, 25, 78, 128, 954 };
	int ascArray[] = { 1, 5, 8, 12, 15, 18, 25, 78, 128, 172 };
	int descArray[] = { 613, 472, 231, 169, 96, 57, 43, 23, 21, 1 };
    
    printf("Quicksort:\n");
    
    printArray(randomArray, SIZE);
    resetClock();
    quickSort(randomArray, 0, SIZE);
    printArray(randomArray, SIZE);
    printClock();
    printf("\n");
    
    printArray(ascArray, SIZE);
    resetClock();
    quickSort(ascArray, 0, SIZE);
    printArray(ascArray, SIZE);
    printClock();
    printf("\n");
    
    printArray(descArray, SIZE);
    resetClock();
    quickSort(descArray, 0, SIZE);
    printArray(descArray, SIZE);
    printClock();
    printf("\n");
    
    printf("\n======\n\n");
}

void presentHeapsort(){
    const int SIZE = 10;
    int randomArray[] = { 13, 5, 845, 12, 15, 41, 25, 78, 128, 954 };
	int ascArray[] = { 1, 5, 8, 12, 15, 18, 25, 78, 128, 172 };
	int descArray[] = { 613, 472, 231, 169, 96, 57, 43, 23, 21, 1 };
    
    printf("Heapsort:\n");
    
    printArray(randomArray, SIZE);
    resetClock();
    heapSort(randomArray, SIZE);
    printArray(randomArray, SIZE);
    printClock();
    printf("\n");
    
    printArray(ascArray, SIZE);
    resetClock();
    heapSort(ascArray, SIZE);
    printArray(ascArray, SIZE);
    printClock();
    printf("\n");
    
    printArray(descArray, SIZE);
    resetClock();
    heapSort(descArray, SIZE);
    printArray(descArray, SIZE);
    printClock();
    printf("\n");
    
    printf("\n======\n\n");
}

void presentBubblesort(){
    const int SIZE = 10;
    int randomArray[] = { 13, 5, 845, 12, 15, 41, 25, 78, 128, 954 };
	int ascArray[] = { 1, 5, 8, 12, 15, 18, 25, 78, 128, 172 };
	int descArray[] = { 613, 472, 231, 169, 96, 57, 43, 23, 21, 1 };
    
    printf("Bubblesort:\n");
    
    printArray(randomArray, SIZE);
    resetClock();
    bubbleSort(randomArray, SIZE);
    printArray(randomArray, SIZE);
    printClock();
    printf("\n");
    
    printArray(ascArray, SIZE);
    resetClock();
    bubbleSort(ascArray, SIZE);
    printArray(ascArray, SIZE);
    printClock();
    printf("\n");
    
    printArray(descArray, SIZE);
    resetClock();
    bubbleSort(descArray, SIZE);
    printArray(descArray, SIZE);
    printClock();
    printf("\n");
    
    printf("\n======\n\n");
}

// Main functions

void bubbleSort(int* array, const int size)
{
    for (int i = 0; i < size-1; i++)    
        for (int j = 0; j < size-i-1; j++)
            if (array[j] > array[j+1])
                ARR_SWAP(array, j, j+1);
}

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

void printArray(int *array, const int size){
    for(int i = 0; i < size ;i++)
        printf("%d ", array[i]);
    printf("\n");
}

clock_t _clock;

void resetClock(){
    _clock = clock();
}

void printClock(){
    clock_t now = clock();
    double cpu_time_used = ((double) (now - _clock)) / CLOCKS_PER_SEC;
    printf("Operation took %f seconds.\n", cpu_time_used);
}

