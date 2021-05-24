#include <stdio.h>
#include <stdlib.h>
#include <string.h>
typedef enum { false, true } bool;

int head(int* array){
    return array[0];
}

// ---
// W C++ zrobilbym to lepiej (jeden tail), 
// no ale niestety, nie bede robil tutaj void*
char* charTail(char* array, const int size){
    char* result = malloc(sizeof(char) * size);
    if(size <= 1) return NULL;
    for(int i = 0; i < size - 1; i++)
        result[i] = array[i + 1];
    return result;
}

int* intTail(int* array, const int size){
    int* result = malloc(sizeof(int) * size);
    if(size <= 1) return NULL;
    for(int i = 0; i < size - 1; i++)
        result[i] = array[i + 1];
    return result;
}
// ---

bool isEmpty(int* array, const int size){
    if(size <= 0 || array == NULL) return true;
    int sum = 0;
    for(int i = 0;i < size; i++)
        sum += array[i];
    return sum == 0;
}

// Przyznam, że nie przeczytałem dobrze zadania i przez przypadek zrobilem
// reku, która sprawdza nieposortowane i o tablicach różnej długości,
// ale w sumie była spoko zabawa
void printCommonPart(
    int* array1, 
    const int size1, 
    int* array2, 
    const int size2, 
    bool isEntrypoint // hack ;)
    ){
        
    if(isEmpty(array1, size1) || isEmpty(array2, size2)) return;
    if(head(array1) == head(array2)) {
        printf("%d ", head(array1));
        if(!isEntrypoint)
            return;
    }
    int* temp2 = intTail(array2, size2);
    printCommonPart(array1, size1, temp2, size2 - 1, false);
    free(temp2);  
    if(isEntrypoint){
        int* temp1 = intTail(array1, size1);
        printCommonPart(temp1, size1 - 1, array2, size2, true);
        free(temp1);
    }
}

void reverseText(char* text, int length, bool isEntrypoint){
    if(length <= 1) return;
    char* res = charTail(text, length);
    reverseText(res, length - 1, false);
    printf("%c",res[0]);
    free(res);
    if(isEntrypoint) printf("%c", text[0]);
}

int main()
{
    int arr1[] = { 1, 2, 3, 4, 5 };
    int arr2[] = { 10, 2, 3, 6, 5, 7 };
    printCommonPart(arr1, 5, arr2, 6, true);
    printf("\n");
    
    char *text = "Hello world!";
    reverseText(text, strlen(text), true);
    return 0;
}
