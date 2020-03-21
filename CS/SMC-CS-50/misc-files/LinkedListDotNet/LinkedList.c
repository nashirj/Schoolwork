#include "LinkedList.h"
#include <stdlib.h>
#include <stdio.h>

void initialize( LISTNODE * list ) {
	list->data = 0;
	list->next = NULL;
}

void insert( element data, LISTNODE * list ) {
	LISTNODE * newnode;
	newnode = (LISTNODE *) malloc(sizeof( LISTNODE ));
	if (newnode == NULL) {
		printf( "out of memory!\n" );
		exit( 1 );
	}
	newnode->data = data;
	newnode->next = list->next;
	list->next = newnode;
}

void print( LISTNODE * list ) {
	LISTNODE * temp;
	printf( "%d nodes: ", length( list ) );
	temp = list->next;
	while (temp != NULL) {
		printf( "%d -> ", temp->data );
		temp = temp->next;
	}
	printf( "NULL\n" );
}

void erase( element data, LISTNODE * list ) {
	LISTNODE * current, * previous;
	current = list->next;
	previous = NULL;
	while (current != NULL) {
		if (current->data == data) {
			if (previous != NULL) {
				previous->next = current->next;
			}
			else {
				list->next = current->next;
			}	
			free( (void *) current );
			break;
		}
		previous = current;
		current = current->next;
	}
}

void release( LISTNODE ** list ) {
	LISTNODE * temp, * nextNode;
	temp = *list;
	while( temp != NULL ) {
		nextNode = temp->next;
		free( (void *) temp );
		temp = nextNode;
	}
}

int length( LISTNODE * list ) {
	LISTNODE * temp;
	int counter = 0;
	temp = list->next;
	while (temp != NULL) {
		counter = counter + 1;
		temp = temp->next;
	}
	return( counter );
}