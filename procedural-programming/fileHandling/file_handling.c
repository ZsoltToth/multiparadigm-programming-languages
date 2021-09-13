//
// Created by zsolt on 2021. 09. 13..
//
#include <stdio.h>

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
    char line[BUFFER_SIZE];
    int i;
    while(fgets(line, BUFFER_SIZE, passwd) != NULL){
        i = 0;
        while ( i < BUFFER_SIZE && line[i] != ':'){
            printf("%c", line[i]);
            i++;
        }
        printf("\n");
    }
}