#define  YOUR_OWN_TESTS_AS_YOU_PROGRAM


#ifdef YOUR_OWN_TESTS_AS_YOU_PROGRAM
#include"bst.h"
#include<iostream>
using std::cout;
using std::endl;

int main() {

	BinarySearchTree bst;

    cout << "height of bst: " << bst.height() << endl;

    bst.insert(1);
    cout << "height of bst: " << bst.height() << endl;
    bst.insert(4);
    cout << "height of bst: " << bst.height() << endl;
    bst.insert(9);
    cout << "height of bst: " << bst.height() << endl;
    bst.insert(-2);
    cout << "height of bst: " << bst.height() << endl;
    bst.insert(-1);
    cout << "height of bst: " << bst.height() << endl;
    bst.insert(3);
    cout << "height of bst: " << bst.height() << endl;
    bst.insert(-3);
    cout << "height of bst: " << bst.height() << endl;
    bst.insert(-3);
    cout << "height of bst: " << bst.height() << endl;
    bst.insert(10);
    cout << "height of bst: " << bst.height() << endl;
    bst.insert(-5);
    bst.insert(-4);

    bst.printInorder();
    bst.printPreorder();
    bst.printPostorder();

    if (bst.search(3)) {
        cout << "contains" << endl;
    } else {
        cout << "something wrong" << endl;
    }

    if (!bst.search(20)) {
        cout << "does not contain" << endl;
    } else {
        cout << "something wrong" << endl;
    }

    cout << bst.min() << endl;
    cout << bst.max() << endl;

    BinarySearchTree bst1;

    bst1.insert(1);
    bst1.insert(-4);
    bst1.insert(4);
    bst1.insert(3);
    bst1.insert(5);
    bst1.insert(-8);
    bst1.insert(-6);

    bst1.printInorder();
    bst1.printPreorder();
    bst1.printPostorder();

    // test deleting node that is a leaf
    bst1.remove(-6);
    bst1.printPreorder();
    bst1.printPostorder();

    // reconstruct tree
    bst1.insert(-6);

    // test deleting node that has only right child
    bst1.remove(-8);
    bst1.printPreorder();
    bst1.printPostorder();

    // reconstruct tree
    bst1.remove(-6);
    bst1.insert(-8);
    bst1.insert(-6);
    bst1.printPreorder();
    bst1.printPostorder();

    // test deleting node that has only left child
    bst1.remove(-4);
    bst1.printPreorder();
    bst1.printPostorder();

    // reconstruct tree
    bst1.remove(-6);
    bst1.remove(-8);
    bst1.insert(-4);
    bst1.insert(-8);
    bst1.insert(-6);
    bst1.printPreorder();
    bst1.printPostorder();
    
    bst1.printTree();
    
    bst1.remove(1);
    bst1.printPreorder();
    bst1.printPostorder();
    
    bst1.printTree();
    
	return 0;
}



#elif defined(COMPLETED_BST_IMPLEMENTATION_AND_CAN_RUN_THE_TESTS_THAT_USES_IT)
#include"tests.h"
//After everything is completely implemented, do some runtime tests to compare between
//data structures, if you have list and/or the sorted doubly linked list implemented
//feel free to modify the tests in test.h to include them.

int main() {

	int test_size = 5000;
	test_insert(test_size);
	test_search(test_size);

	return 0;
}

#elif defined(USE_LONGS_BST_TEST)  // Some tests I used to test my bst implementations
#include"bst.h"
#include<iostream>
using std::cout;
using std::endl;
using std::cin;

int main() {

	int testNum = 0;

	// Loop through each of the tests
	// Note Does not include all possible situations that might occur
	while (testNum >= 0) {

		cout << endl << "Enter Test Number.  A negative value will quit" << endl<<endl;
		cin >> testNum;
		cout << endl;
		switch (testNum) {
		case 0: {
			BinarySearchTree bst;

			cout << bst.isEmpty() << endl;	// 1
			cout << bst.height() << endl;	// -1
			cout << endl;
			break;
		}
		case 1: {
			BinarySearchTree bst;

			// Insert node as root
			bst.insert(8);
			cout << bst.isEmpty() << endl;	// 0
			cout << bst.height() << endl;	// 0
			cout << bst.min() << endl;		// 8
			cout << bst.max() << endl;		// 8
			cout << endl;
			break;
		}
		case 2: {
			BinarySearchTree bst;

			bst.insert(8);

			// Test duplicate
			bst.insert(8);
			cout << bst.isEmpty() << endl;	// 0
			cout << bst.height() << endl;	// 0
			cout << bst.min() << endl;		// 8
			cout << bst.max() << endl;		// 8
			cout << endl;
			break;
		}

		case 3: {
			BinarySearchTree bst;
			bst.insert(8);
			cout << bst.isEmpty() << endl;	// 0
			cout << bst.height() << endl;	// 0
			cout << bst.min() << endl;		// 8
			cout << bst.max() << endl;		// 8
			cout << endl;


			// Insert to left
			bst.insert(6);
			cout << bst.isEmpty() << endl;	// 0
			cout << bst.height() << endl;	// 1
			cout << bst.min() << endl;		// 6
			cout << bst.max() << endl;		// 8
			cout << endl;

			break;
		}
		case 4: {
			BinarySearchTree bst;
			bst.insert(8);
			cout << bst.isEmpty() << endl;	// 0
			cout << bst.height() << endl;	// 0
			cout << bst.min() << endl;		// 8
			cout << bst.max() << endl;		// 8
			cout << endl;

			// Insert to left
			bst.insert(6);
			cout << bst.isEmpty() << endl;	// 0
			cout << bst.height() << endl;	// 1
			cout << bst.min() << endl;		// 6
			cout << bst.max() << endl;		// 8
			cout << endl;

			// Insert to right
			bst.insert(13);
			cout << bst.isEmpty() << endl;	// 0
			cout << bst.height() << endl;	// 1
			cout << bst.min() << endl;		// 6
			cout << bst.max() << endl;		// 13
			cout << endl;
			break;
		}

		case 5: {
			BinarySearchTree bst;
			bst.insert(8);
			bst.insert(6);
			bst.insert(13);
			bst.insert(3);
			bst.insert(7);
			bst.insert(10);
			bst.insert(20);
			cout << bst.isEmpty() << endl;	// 0
			cout << bst.height() << endl;	// 2
			cout << bst.min() << endl;		// 3
			cout << bst.max() << endl;		// 20
			break;
		}
		case 6: {
			BinarySearchTree bst;
			bst.insert(8);
			bst.insert(6);
			bst.insert(13);
			bst.insert(3);
			bst.insert(7);
			bst.insert(10);
			bst.insert(20);
			bst.printInorder();				// 3 6 7 8 10 13 20
			break;
		}
		case 7: {
			BinarySearchTree bst;
			bst.insert(8);
			bst.insert(6);
			bst.insert(13);
			bst.insert(3);
			bst.insert(7);
			bst.insert(10);
			bst.insert(20);
			bst.printPreorder();			// 8 6 3 7 13 10 20
			break;
		}
		case 8: {
			BinarySearchTree bst;
			bst.insert(8);
			bst.insert(6);
			bst.insert(13);
			bst.insert(3);
			bst.insert(7);
			bst.insert(10);
			bst.insert(20);
			bst.printPostorder();			// 3 7 6 10 20 13 8
			break;
		}
		case 9: {
			BinarySearchTree bst;
			bst.insert(8);
			bst.insert(6);
			bst.insert(13);
			bst.insert(3);
			bst.insert(7);
			bst.insert(10);
			bst.insert(20);
			cout << bst.search(6) << endl;		// 1
			cout << bst.search(999) << endl;	// 0
			break;
		}
		case 10: {
			BinarySearchTree bst;
			bst.insert(8);
			bst.insert(6);
			bst.insert(13);
			bst.insert(3);
			bst.insert(7);
			bst.insert(10);
			bst.insert(20);
			bst.insert(22);

			cout << bst.isEmpty() << endl;	// 0
			cout << bst.height() << endl;	// 3
			cout << bst.min() << endl;		// 3
			cout << bst.max() << endl;		// 22
			cout << endl;

			bst.printInorder();				// 3 6 7 8 10 13 20 22
			cout << endl;
			bst.printPreorder();			// 8 6 3 7 13 10 20 22
			cout << endl;

			//					//				22
			//					//			20
			//					//		13
			bst.printTree();	//			10
								//	8
								//			7	
								//		6
								//			3
			break;
		}
		case 11: {
			BinarySearchTree bst;
			bst.insert(8);
			bst.insert(6);
			bst.insert(13);
			bst.insert(3);
			bst.insert(7);
			bst.insert(10);
			bst.insert(20);
			bst.insert(22);

			bst.remove(20);

			cout << bst.isEmpty() << endl;	// 0
			cout << bst.height() << endl;	// 2
			cout << bst.min() << endl;		// 3
			cout << bst.max() << endl;		// 22
			cout << endl;


			bst.printInorder();				// 3 6 7 8 10 13 22
			cout << endl;
			bst.printPreorder();			// 8 6 3 7 13 10 22
			cout << endl;

			//					//			22
			//					//		13
			bst.printTree();	//			10
								//	8
								//			7	
								//		6
								//			3
			break;
		}
		case 12: {
			BinarySearchTree bst;
			bst.insert(8);
			bst.insert(6);
			bst.insert(13);
			bst.insert(3);
			bst.insert(7);
			bst.insert(10);
			bst.insert(20);
			bst.insert(22);

			bst.remove(20);

			bst.remove(6);

			cout << bst.isEmpty() << endl;	// 0
			cout << bst.height() << endl;	// 2
			cout << bst.min() << endl;		// 3
			cout << bst.max() << endl;		// 22
			cout << endl;

			bst.printInorder();				// 3 7 8 10 13 22
			cout << endl;
			bst.printPreorder();			// 8 7 3 13 10 22
			cout << endl;


			//					//				
			//					//			22
			//					//		13
			bst.printTree();	//			10
								//	8
								//		
								//		7
								//			3
			break;
		}
		default:
			exit(1);
			break;
		}


	}//while testNum
	return 0;
}
#else 

#include<iostream>
using namespace std;
int main() {

	cout << "Hello World!" << endl;
	return 0;
}
#endif