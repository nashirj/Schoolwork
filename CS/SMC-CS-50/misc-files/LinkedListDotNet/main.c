#include <stdio.h>
#include <stdlib.h>
#include "LinkedList.h"

enum CHOICE { INSERT, ERASE, PRINT, QUIT };

enum CHOICE menu( );

int main( ) {
	LISTNODE * list;
	enum CHOICE c;
	int data;

	list = (LISTNODE *) malloc( sizeof( LISTNODE ) );
	initialize( list );

	do {
		c = menu( );
		switch( c ) {
		case INSERT:
			printf( "What integer do you want inserted into the list? " );
			scanf( "%d", &data );
			insert( data, list );
			break;
		case ERASE:
			printf( "What integer do you want erased from the list? " );
			scanf( "%d", &data );
			erase( data, list );
			break;
		case PRINT:
			print( list );
			break;
		}
	} while (c != QUIT);

	release( &list );

	return( 0 );

}

enum CHOICE menu( ) {
	enum CHOICE result;
	char data[ 80 ];
	printf( "(I)nsert (E)rase (P)rint (Q)uit: " );
	scanf( "%s", &data );
	switch( *data ) {
	case 'I':
	case 'i':
		result = INSERT;
		break;
	case 'P':
	case 'p':
		result = PRINT;
		break;
	case 'E':
	case 'e':
		result = ERASE;
		break;
	default:
		result = QUIT;
		break;
	}
	return( result );
}