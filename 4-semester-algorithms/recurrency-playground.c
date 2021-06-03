// Online C compiler to run C program online
#include <stdio.h>

int factorial(int n) {
    if (n >= 1)
        return n * factorial(n-1);
    else
        return 1;
}

int oddSum(int n) {
    if (n >= 1){
        if(n % 2) // is odd
            return n+oddSum(n-1); 
        else
            return oddSum(n-1);
    }
    else return 0;
}

int div3Sum(int n) {
    if (n >= 1){
        if(n % 3 == 0)
            return n+div3Sum(n-1); 
        else
            return div3Sum(n-1);
    }
    else return 0;
}

int cusSum(int n) {
    if (n == 0) return 0;
    return 2 * n + 3 + cusSum(n-1);
}

int cusSum2(int n) {
    if (n == 0) return 0;
    else if (n == 1) return 1;
    return 3 * cusSum2(n - 1) - cusSum2(n - 2);
}

int main() {
    printf("Silnia z %d = %d\n",5, factorial(5));
    printf("Suma nparz. z %d = %d\n",8, oddSum(8));
    printf("Suma podz przez 3 z %d = %d\n",6, div3Sum(6));
    printf("Suma 2a+3 dla a równego %d = %d\n",2, cusSum(2));
    printf("Suma 3f(n) − f(n−1) dla n równego %d = %d\n",10, cusSum2(10));
    return 0;
}
