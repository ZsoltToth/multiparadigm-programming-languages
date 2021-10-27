#include <stdio.h>
#include <stdlib.h>

int randInRange(int min, int max){
    return (rand() % (max - min +1)) + min;
}

int decrease( const void* a, const void* b){
    return ( *(int*)a - *(int *)b );
}

int main() {
    printf("Hello, World!\n");
    int i = 0;
    int lottery[5];
    int iteration = 0;
    for(iteration = 0; iteration < 1e4; iteration++){
        for(i = 0; i < 5; i++){
            int MAX = 90;
            int MIN = 1;
            lottery[i] = randInRange(MIN, MAX);
            int j = 0;
            for(j = 0; j < i; j++){
                if(lottery[j] == lottery[i]){
                    printf("Problem!\n");
                    i--;
                    continue;
                }
            }
//            printf("%d ", randInRange(MIN, MAX));
        }
        qsort(lottery, 5, sizeof(int), decrease);
        printf("#%d: ", iteration);
        for(i = 0; i < 5; i++){
            printf("%d ", lottery[i]);
        }
        printf("\n");
    }
    return 0;
}
