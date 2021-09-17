//
// Created by zsolt on 2021. 09. 13..
//
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "file_handling.h"


void print_main_file(){
    FILE* fp;
    const int BUFFER_SIZE = 50;
    char data[BUFFER_SIZE];
    fp = fopen("main.c", "r");
    if(fp == NULL){
        // In CLion set the working directory during execution
        printf("File cannot be opened for reading!\n");
        return;
    }
    while (fgets(data, BUFFER_SIZE, fp) != NULL){
        printf("%s", data);
    }
}

void print_users_from_passwd(){
    FILE *passwd = fopen("/etc/passwd", "r");
    if(passwd == NULL){
        printf("Permission Denied!\n");
        return;
    }
    const int BUFFER_SIZE = 1024;
    const char PASSWD_FILE_FIELD_SEPARATOR = ':';
    char line[BUFFER_SIZE];
    int i;
    while(fgets(line, BUFFER_SIZE, passwd) != NULL){
        i = 0;
        while ( i < BUFFER_SIZE && line[i] != PASSWD_FILE_FIELD_SEPARATOR){
            printf("%c", line[i]);
            i++;
        }
        printf("\n");
    }
}

struct PasswdEntryList* read_passwd_file(){
    struct PasswdEntryList *result = malloc(sizeof (struct PasswdEntryList));
    FILE *passwd = fopen("/etc/passwd", "r");
    if(passwd == NULL){
        printf("Permission Denied!\n");
        return result;
    }
    const int BUFFER_SIZE = 1024;
    char line[BUFFER_SIZE];
    while(fgets(line, BUFFER_SIZE, passwd) != NULL){
        if(result->head == NULL){
            struct PasswdEntryListNode* node = malloc(sizeof(struct PasswdEntryListNode));
            node->data = process_passwd_record(line);
            node->next = NULL;
            result->head = node;
            continue;
        }
        struct PasswdEntryListNode* last_node = result->head;
        while(last_node->next != NULL){
            last_node = last_node->next;
        }
        struct PasswdEntryListNode* node = malloc(sizeof(struct PasswdEntryListNode));
        node->data = process_passwd_record(line);
        node->next = NULL;
        last_node->next = node;
    }
    fclose(passwd);
    return result;
}

struct PasswdEntry* process_passwd_record(char*  line){
    struct PasswdEntry *result = malloc(sizeof (struct PasswdEntryList));
    char dummy_text[50] = "test";
    strcpy(result->username, dummy_text);
    strcpy(result->comment, dummy_text);
    strcpy(result->home_dir, dummy_text);
    strcpy(result->shell, dummy_text);
    result->user_id = 1;
    result->group_id = 1;
    return result;
}
