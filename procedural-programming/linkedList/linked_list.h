/**
 * Node of a linked list
 *
 */
struct Node {
    int data;
    struct Node *next;
};

void print_linked_list(struct Node* head);

void insert_element(struct Node* list, int value);

/**
 * Add elements to the list and order it in the same time.
 * If, you add 2, 4, 1, 3 then the list will contain 1,2,3,4 values.
 *
 *
 * @param list
 * @param value
 */
void insert_element_in_order(struct Node* list, int value);

/**
 * Add elements if is not in the list yet.
 * For example you add 1,2,2,3,4,4,2 to the list then it will contain 1,2,3 only.
 *
 * @param list
 * @param value
 */
void insert_element_remove_duplicates(struct Node* list, int value);