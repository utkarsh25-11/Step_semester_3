#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *next;
};

struct Node *head = NULL;

// Create a new node
struct Node* createNode(int value) {
    struct Node *newNode = (struct Node*)malloc(sizeof(struct Node));

    if (newNode == NULL) {
        printf("Memory Allocation Failed\n");
        return NULL;
    }

    newNode->data = value;
    newNode->next = NULL;

    return newNode;
}

// Insert at front
void insertFront(int value) {
    struct Node *newNode = createNode(value);

    if (newNode != NULL) {
        newNode->next = head;
        head = newNode;
    }
}

// Delete a node by value
void deleteValue(int value) {
    struct Node *temp = head;
    struct Node *prev = NULL;

    while (temp != NULL && temp->data != value) {
        prev = temp;
        temp = temp->next;
    }

    if (temp == NULL) {
        printf("Value not found\n");
        return;
    }

    // If deleting the first node
    if (prev == NULL) {
        head = temp->next;
    }
    else {
        prev->next = temp->next;
    }

    free(temp);
}

// Display the linked list
void display() {
    struct Node *current = head;

    if (current == NULL) {
        printf("List is empty\n");
        return;
    }

    while (current != NULL) {
        printf("%d -> ", current->data);
        current = current->next;
    }

    printf("NULL\n");
}

// Free the entire list
void freeList() {
    struct Node *current = head;

    while (current != NULL) {
        struct Node *nextNode = current->next;
        free(current);
        current = nextNode;
    }

    head = NULL;
}

int main() {

    int choice;

    while (1) {

        printf("\n--- Menu ---\n");
        printf("1. Insert at front\n");
        printf("2. Delete by value\n");
        printf("3. Display list\n");
        printf("4. Exit\n");

        printf("Enter your choice: ");
        scanf("%d", &choice);

        if (choice == 1) {

            int value;

            printf("Enter value to insert: ");
            scanf("%d", &value);

            insertFront(value);
        }

        else if (choice == 2) {

            int value;

            printf("Enter value to delete: ");
            scanf("%d", &value);

            deleteValue(value);
        }

        else if (choice == 3) {

            display();
        }

        else if (choice == 4) {

            freeList();
            printf("Exiting...\n");
            break;
        }

        else {

            printf("Invalid choice!\n");
        }
    }

    return 0;
}