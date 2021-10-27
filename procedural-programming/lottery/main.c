#include <stdio.h>
#include <stdlib.h>
#include "lottery.h"

/**
 * Task:
 *  - Read Unknown number of ticket from Console then generate a ticket and count the matching numbers.
 *  - Read the ticket into a linked list of LotteryTicket structs.
 *  - Read the tickets in a do while or while loop.
 *  - Add a function for calculating the matches between two LotteryTicket structs.
 * @return
 */
int main() {
    printf("Hello, World!\n");
    int i = 0;
    int iteration = 0;
    struct LotteryTicket* ticket;
//    for(iteration = 0; iteration < 1e4; iteration++){
//        printf("#%d: ", iteration);
//        ticket = generateTicket();
//        printTicket(ticket);
//    }
    ticket = readTicketFromConsole();
    printTicket(ticket);
    return 0;
}
