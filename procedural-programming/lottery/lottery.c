//
// Created by zsolt on 2021. 10. 27..
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "lottery.h"

int randInRange(int min, int max) {
    return (rand() % (max - min + 1)) + min;
}

int decrease(const void *a, const void *b) {
    return (*(int *) a - *(int *) b);
}

struct LotteryTicket *generateTicket() {
    struct LotteryTicket *result = (struct LotteryTicket *) malloc(sizeof(struct LotteryTicket));
    int i;
    int j;
    for (i = 0; i < LOTTERY_TICKET_SIZE; i++) {
        result->picks[i] = randInRange(LOTTERY_TICKET_MIN, LOTTERY_TICKET_MAX);
        for (j = 0; j < i; j++) {
            if (result->picks[j] == result->picks[i]) {
                i--;
                continue;
            }
        }
    }
    qsort(result->picks, LOTTERY_TICKET_SIZE, sizeof(int), decrease);
    return result;
}

void printTicket(struct LotteryTicket *ticket) {
    int i;
    for (i = 0; i < 5; i++) {
        printf("%d ", ticket->picks[i]);
    }
    printf("\n");
}

struct LotteryTicket *readTicketFromConsole() {
    struct LotteryTicket *result = (struct LotteryTicket *) malloc(sizeof(struct LotteryTicket));
    int i;
    int j;
    for (i = 0; i < LOTTERY_TICKET_SIZE; i++) {
        printf("Select a number in [1,90]\n");
        char *end;
        char *buff[3];
        if (!fgets(buff, sizeof(buff), stdin)) {
            break;
        }
        buff[strlen(buff) - 1] = 0;
        result->picks[i] = strtol(buff, &end, 10);

        if(result->picks[i] < LOTTERY_TICKET_MIN || result->picks[i] > LOTTERY_TICKET_MAX){
            printf("Invalid Pick!\n");
            i--;
            continue;

        }
//        result->picks[i] = randInRange(LOTTERY_TICKET_MIN, LOTTERY_TICKET_MAX);
        for (j = 0; j < i; j++) {
            if (result->picks[j] == result->picks[i]) {
                printf("Number %d was alraedy picked!\n", result->picks[i]);
                i--;
                continue;
            }
        }
    }
    qsort(result->picks, LOTTERY_TICKET_SIZE, sizeof(int), decrease);
    return result;
}
