#include <stdio.h>
#include <unistd.h>
#include "file_handling.h"

int main() {
//    print_main_file();
//    print_users_from_passwd();
    int i = 0;
    struct PasswdEntryList* passwdEntryList = read_passwd_file();
    struct PasswdEntryListNode* current_node = passwdEntryList->head;
    while(current_node != NULL){
        printf("User: %s (%d,%d)\n",current_node->data->username, current_node->data->user_id, current_node->data->group_id);
        printf("Comment: %s\n",current_node->data->comment);
        printf("Home: %s\n",current_node->data->home_dir);
        printf("Shell: %s\n", current_node->data->shell);
        current_node = current_node->next;
        i++;
    }
    printf("There are %d records",i);
    return 0;
}
