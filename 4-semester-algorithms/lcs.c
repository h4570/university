#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef enum { false, true } bool;

int max(int a, int b) { return (a > b) ? a : b; } 

void printLcs(char *x, char *y, const int m, const int n, const int C[][n + 1]){
    int index = C[m][n];
    char res[index+1];
    res[index] = '\0';
    
    for (int i = 0; i <= m; i++) {
        for (int j = 0; j <= n; j++)  
            printf("[%d][%d]=%d ", i, j, C[i][j]);
        printf("\n");
    }
        
    int i = m, j = n;
    while (i > 0 && j > 0){
        if (x[i-1] == y[j-1]){
            res[index-1] = x[i-1];
            i--; 
            j--; 
            index--;
        }
        else if (C[i-1][j] > C[i][j-1])
            i--;
        else
            j--;
    }
    printf("Result: %s\n", res);
}

int lcs(char *x, char *y, const bool print) 
{ 
    int m = strlen(x); 
    int n = strlen(y); 
    int C[m + 1][n + 1];
     
    for (int i = 0; i <= m; i++) 
        for (int j = 0; j <= n; j++) 
        { 
            if (i == 0 || j == 0) 
                C[i][j] = 0; 
            else if (x[i - 1] == y[j - 1])
                C[i][j] = C[i - 1][j - 1] + 1; 
            else
                C[i][j] = max(C[i - 1][j], C[i][j - 1]); 
        } 
    if(print)
        printLcs(x, y, m, n, C);
    return C[m][n]; 
} 

int main()
{
    char x[] = "GTCCAC"; 
    char y[] = "TCAGAC"; 
    
    printf("LCS: %d", lcs(x, y, true)); 
    return 0;
}
