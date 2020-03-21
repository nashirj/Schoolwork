#ifndef LIST_H
#define LIST_H

typedef int element;

struct node {
	element data;
	struct node * next;
};

typedef struct node LISTNODE;

void initialize( LISTNODE * list );
void insert( element data, LISTNODE * list );
void erase( element data, LISTNODE * list );
void print( LISTNODE * list );
void release( LISTNODE ** list );
int length( LISTNODE * list );

#endif LIST_H
