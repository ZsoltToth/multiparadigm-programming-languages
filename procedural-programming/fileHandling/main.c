#include <stdio.h>
#include <unistd.h>
#include "file_handling.h"

int main() {
    print_main_file();
    print_users_from_passwd();
    return 0;
}
