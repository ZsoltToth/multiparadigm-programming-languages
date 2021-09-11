#include <stdio.h>
#include <stdlib.h>
#include "linked_list.h"

int main() {
    printf("Hello, World!\n");
    struct Node *linked_list = NULL;

    int array[10] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int i;
    for (i = 0; i < 10; i++) {
        if(linked_list == NULL){
            linked_list = (struct Node *) malloc(sizeof(struct Node));
            linked_list->data = array[i];
            linked_list->next = NULL;
            continue;
        }
        insert_element(linked_list, array[i]);
    }

    printf("Iterate Through the Linked List\n");
    print_linked_list(linked_list);

    return 0;
}
