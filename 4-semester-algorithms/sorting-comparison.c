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

void setRandomArray(int *array, const int size);
void setAscArray(int *array, const int size);
void setDescArray(int *array, const int size);
void copyArray(int *fromArr, int *toArr, const int size);
void printArray(int* array, int size);

void resetClock();
void printClock();

// Start

const int SIZE = 50000;
int *randomTemplateArray;
int *ascTemplateArray;
int *descTemplateArray;

int main() {
    srand(time(NULL));
    
    randomTemplateArray = malloc(SIZE * sizeof(int));
    ascTemplateArray = malloc(SIZE * sizeof(int));
    descTemplateArray = malloc(SIZE * sizeof(int));
    
    setRandomArray(randomTemplateArray, SIZE);
    setAscArray(ascTemplateArray, SIZE);
    setDescArray(descTemplateArray, SIZE);
    
    presentQuicksort();
    presentHeapsort();
    presentBubblesort();
    
    free(randomTemplateArray);
    free(ascTemplateArray);
    free(descTemplateArray);
    
    return 0;
}

void presentQuicksort(){
    int randomArray[SIZE]; copyArray(randomTemplateArray, randomArray, SIZE);
    int ascArray[SIZE]; copyArray(ascTemplateArray, ascArray, SIZE);
    int descArray[SIZE]; copyArray(descTemplateArray, descArray, SIZE);
    
    printf("Quicksort:\n");
    
    printf("Random: ");
    resetClock();
    quickSort(randomArray, 0, SIZE);
    printClock();
    printf("\n");
    
    printf("Asc: ");
    resetClock();
    quickSort(ascArray, 0, SIZE);
    printClock();
    printf("\n");
    
    printf("Desc: ");
    resetClock();
    quickSort(descArray, 0, SIZE);
    printClock();
    printf("\n");
    
    printf("\n======\n\n");
}

void presentHeapsort(){
    int randomArray[SIZE]; copyArray(randomTemplateArray, randomArray, SIZE);
    int ascArray[SIZE]; copyArray(ascTemplateArray, ascArray, SIZE);
    int descArray[SIZE]; copyArray(descTemplateArray, descArray, SIZE);
    
    printf("Heapsort:\n");
    
    printf("Random: ");
    resetClock();
    heapSort(randomArray, SIZE);
    printClock();
    printf("\n");
    
    printf("Asc: ");
    resetClock();
    heapSort(ascArray, SIZE);
    printClock();
    printf("\n");
    
    printf("Desc: ");
    resetClock();
    heapSort(descArray, SIZE);
    printClock();
    printf("\n");
    
    printf("\n======\n\n");
}

void presentBubblesort(){
    int randomArray[SIZE]; copyArray(randomTemplateArray, randomArray, SIZE);
    int ascArray[SIZE]; copyArray(ascTemplateArray, ascArray, SIZE);
    int descArray[SIZE]; copyArray(descTemplateArray, descArray, SIZE);
    
    printf("Bubblesort:\n");
    
    printf("Random: ");
    resetClock();
    bubbleSort(randomArray, SIZE);
    printClock();
    printf("\n");
    
    printf("Asc: ");
    resetClock();
    bubbleSort(ascArray, SIZE);
    printClock();
    printf("\n");
    
    printf("Desc: ");
    resetClock();
    bubbleSort(descArray, SIZE);
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

void setRandomArray(int *array, const int size){
    for(int i = 0;i < size; i++)
        array[i] = rand() % 100;
}

void setAscArray(int *array, const int size){
    for(int i = 0;i < size; i++)
        array[i] = i;
}

void setDescArray(int *array, const int size){
    for(int i = 0;i < size; i++)
        array[i] = size-i;
}

void copyArray(int *fromArr, int *toArr, const int size){
    for(int i = 0;i < size; i++)
        toArr[i] = fromArr[i];
}

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
