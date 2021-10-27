//
// Created by zsolt on 2021. 10. 27..
//

#ifndef LOTTERY_LOTTER_H
#define LOTTERY_LOTTER_H

#endif //LOTTERY_LOTTER_H

#define LOTTERY_TICKET_SIZE 5
#define LOTTERY_TICKET_MIN 1
#define LOTTERY_TICKET_MAX 90

struct LotteryTicket{
    int picks[LOTTERY_TICKET_SIZE];
};

struct LotteryTicket* generateTicket();

struct LotteryTicket* readTicketFromConsole();

void printTicket(struct LotteryTicket* ticket);