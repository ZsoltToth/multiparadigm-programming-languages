#include <stdio.h>
#include <stdlib.h>
#include "lottery.h"


int main() {
    printf("Hello, World!\n");
    int i = 0;
    int iteration = 0;
    struct LotteryTicket* ticket;
    for(iteration = 0; iteration < 1e4; iteration++){
        printf("#%d: ", iteration);
        ticket = generateTicket();
        printTicket(ticket);
    }
    return 0;
}
