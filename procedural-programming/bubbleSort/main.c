#include <stdio.h>
#include "sort.h"

/*
 * Tasks:
 *  - Refactor code
 *  - Discuss Quadratic and Sort functions.
 *  - Discuss Function Pointer
 */
int decrease(double a, double b){
    return a < b ? 1 : 0;
}

int main() {

    double a[5] = {1,4,-2, 3, 9};
    int i;

    for(i = 0; i < 5; i++){
        printf("%d: %f\n", i, a[i]);
    }
    printf("\n----------\n");
    bubbleSort(&a, 5);
    for(i = 0; i < 5; i++){
        printf("%d: %f\n", i, a[i]);
    }

    printf("\n----------\n");
    double a2[] = {1,4,-2, 3, 9};
    bubbleSortEnhanced(&a2, 5, decrease);
    for(i = 0; i < 5; i++){
        printf("%d: %f\n", i, a2[i]);
    }


    return 0;
}

