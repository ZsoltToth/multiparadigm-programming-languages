//
// Created by zsolt on 2020. 09. 11..
//

void bubbleSort(double *array, int length){
    int i,j;
    double tmp;
    for(i = 0; i < length -1; i++){
        for(j = 1; j < length - i; j++){
            if(*(array+j-1) > *(array+j)){
                tmp = *(array + j);
                *(array + j) = *(array + j -1);
                *(array + j -1 ) = tmp;
            }
        }
    }
}

void bubbleSortEnhanced(double *array, int length, int (*comparator)(double , double )){

    int i,j;
    double tmp;
    for(i = 0; i < length -1; i++){
        for(j = 1; j < length - i; j++){
            if(comparator(*(array+j-1), *(array+j)) == 1){
                tmp = *(array + j);
                *(array + j) = *(array + j -1);
                *(array + j -1 ) = tmp;
            }
        }
    }
}
