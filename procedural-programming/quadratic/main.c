#include <stdio.h>
#include "quadratic.h"

int main() {
    printf("Hello, World!\n");
    double x1, x2;
    int resp = solve(1,4, 4,&x1,&x2);
    printf("Response: %d, (%lf,%lf)\n",resp,x1,x2);

    return 0;
}

