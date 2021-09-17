//
// Created by zsolt on 2021. 09. 13..
//

#ifndef FILEHANDLING_FILE_HANDLING_H
#define FILEHANDLING_FILE_HANDLING_H

#endif //FILEHANDLING_FILE_HANDLING_H

#define PASSWD_ENTRY_STR_LEN 50

struct PasswdEntry {
    char username[PASSWD_ENTRY_STR_LEN];
    int user_id;
    int group_id;
    char comment[PASSWD_ENTRY_STR_LEN];
    char home_dir[PASSWD_ENTRY_STR_LEN];
    char shell[PASSWD_ENTRY_STR_LEN];
};

struct PasswdEntryList {
    struct PasswdEntryListNode* head;
};

struct PasswdEntryListNode {
    struct PasswdEntry* data;
    struct PasswdEntryListNode* next;
};
void print_main_file();

void print_users_from_passwd();

struct PasswdEntryList* read_passwd_file();
struct PasswdEntry* process_passwd_record(char*  line);