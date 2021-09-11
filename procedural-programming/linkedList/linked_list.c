//
// Created by zsolt on 2021. 09. 11..
//
#include<stdio.h>
#include<stdlib.h>
#include "linked_list.h"

void print_linked_list(struct Node* head){
    do{
        printf("%d\n", head->data);
        head = head->next;
    } while (head != NULL);
}

void insert_element(struct Node* list, int value){
    while(list->next != NULL){
        list = list->next;
    }
    struct Node* new_list_item = (struct Node *) malloc(sizeof(struct Node));
    new_list_item->data = value;
    new_list_item->next = NULL;
    list->next = new_list_item;
}
