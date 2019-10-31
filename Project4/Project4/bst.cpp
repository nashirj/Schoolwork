#include"bst.h"
#include<functional>
#include<iostream>
#include<assert.h>
// Node implementation: Implemented
struct BinarySearchTree::Node {
	Node(int v, Node *l, Node *r) :value(v), left(l), right(r) {}
	Node() :Node(0, nullptr, nullptr) {}

	int value;
	Node *left, *right;
};

//----------------------------------------------------------
//-------------- Binary Search Tree Function Implementations 
//--
//-- Public Interface functions
//--		Completely Implemented, nothing to do.  These functions
//--        call the recurive helper functions you will implement.
//--
// Constructor
BinarySearchTree::BinarySearchTree() :m_root(nullptr) {}

// Destructor
BinarySearchTree::~BinarySearchTree() {

	//Use the post order traversal to delete the nodes.
	//lambda function to delete a node n:
	//				[](Node* n) {delete n; } 
	_postorder(m_root, [](Node* n) {delete n; });
}

void BinarySearchTree::printInorder() {

	//Use inorder traversal to print values in a node in the tree.
	//lambda function to print the value in a node:
	//				[](Node* n) {std::cout << n->value << std::endl; }
	_inorder(m_root, [](Node* n) {std::cout << n->value << " "; });
	std::cout << std::endl;
}
void BinarySearchTree::printPreorder() {

	//Use pre order traversal to print values in a node in the tree.
	//lambda function to print the value in a node:
	//				[](Node* n) {std::cout << n->value << std::endl; }
	_preorder(m_root, [](Node* n) {std::cout << n->value << " "; });
	std::cout << std::endl;
}
void BinarySearchTree::printPostorder() {

	//Use post order traversal to print values in a node in the tree.
	//lambda function to print the value in a node:
	//				[](Node* n) {std::cout << n->value << std::endl; }
	_postorder(m_root, [](Node* n) {std::cout << n->value << " "; });
	std::cout << std::endl;
}
void BinarySearchTree::insert(int value) {
	m_root = _insert(m_root, value);
}
void BinarySearchTree::remove(int value) {
	m_root = _deleteNode(m_root, value);
}
int	BinarySearchTree::min() const {

	assert(m_root != nullptr);

	Node *node = _minNode(m_root);
	return node->value;
}
int	BinarySearchTree::max() const {

	assert(m_root != nullptr);

	Node *node = _maxNode(m_root);
	return node->value;
}
int	BinarySearchTree::height() const {

	return _height(m_root);
}
bool BinarySearchTree::search(int value) const {
	Node *node = _search(m_root, value);
	return (node != nullptr);
}

bool BinarySearchTree::isEmpty() const {
	return (m_root == nullptr);
}

void BinarySearchTree::printTree() const {

	_printTree(m_root, 0);
}

//----------------------------------------------------------
//--
//-- Private Helper Recursive Functions
//--


// Inorder Traversal: Implemented so you can see how passing a function into 
// another function works, other traversals left for you to implement
void BinarySearchTree::_inorder(Node* node, std::function<void(Node*)> process) {
	if (node == nullptr) return;

	_inorder(node->left, process);
	process(node);
	_inorder(node->right, process);
}

// Postorder Traversal: If this node is a leaf, process it, else traverse children before processing.
void BinarySearchTree::_postorder(Node* node, std::function<void(Node*)> process) {
    if (node == nullptr) return;
    
    _postorder(node->left, process);
    _postorder(node->right, process);
    process(node);
}

// Preorder Traversal: Process this node, then traverse its children.
void BinarySearchTree::_preorder(Node* node, std::function<void(Node*)> process) {
    if (node == nullptr) return;
    
    process(node);
    _preorder(node->left, process);
    _preorder(node->right, process);
}

// BinarySearchTree::_insert
// Recursively insert into the BST according to the rules of the BST
// and return the root of the updated tree.
BinarySearchTree::Node* BinarySearchTree::_insert(Node *node, int value) {
    if (node == nullptr) {
        //insert
        node = new Node(value, nullptr, nullptr);
        return node;
    }
    if (node->value > value) {
        node->left = _insert(node->left, value);
    }
    if (node->value < value) {
        node->right = _insert(node->right, value);
    }
    
    // Implicit return if node->value == value, i.e. don't allow duplicates
    return node;
}

// BinarySearchTree::_search
// Recursively search for a node in the tree, return nullptr if not
// found, else return the node.
BinarySearchTree::Node* BinarySearchTree::_search(Node *node, int value) const {
    if (node == nullptr) {
        return nullptr;
    }
    
    if (node->value > value) {
        return _search(node->left, value);
    }
    if (node->value < value) {
        return _search(node->right, value);
    }
    
    // node->value == value
    return node;
}

// Height of a binary tree is the height of the largest subtree + 1
// An empty tree has height -1;
int	BinarySearchTree::_height(Node* node) const {
    if (node == nullptr) {
        return -1;
    }
    
    return 1 + std::max(_height(node->right), _height(node->left));
}

// Return node with smallest value in BinarySearchTree
BinarySearchTree::Node*	BinarySearchTree::_minNode(Node *node) const {
    // Enclosing function assumes that m_root is not null, but this ensures
    // function doesn't have undefined behavior if it is passed nullptr.
    if (node == nullptr) {
        return nullptr;
    }
    
    if (node->left) {
        return _minNode(node->left);
    }
    
    return node;
}

// Return node with largest value in BinarySearchTree
BinarySearchTree::Node*	BinarySearchTree::_maxNode(Node *node) const {
    // Enclosing function assumes that m_root is not null, but this ensures
    // function doesn't have undefined behavior if it is passed nullptr.
    if (node == nullptr) {
        return nullptr;
    }
    
    if (node->right) {
        return _maxNode(node->right);
    }
    
    return node;
}

//BinarySearchTree::_deleteNode
// Recursively removes a node in the binary tree.  The recursive algorithm will 
// be different than the iterative algorithm.  The iterative algorithm conisted
// of first finding the node using two pointers so that we know how to rearrange
// the children of the deleted node. In recursion we are passing in the sub trees
// each recursive step, so by definition we already have a handle on each subtrees'
// parents (it is the node that is passed into the previous recursive step).
// After we find the node to remove (if it is in the tree) everything else is the same, we  
// handle the three cases: leaf, one child (which consist of two cases: left vs right),
// and two children.  With iterative algorithm there were subcases regardling if the 
// node was root or not, with recursion we get that for free.  
//
// In the iterative algorithm discussed in class, in dealing with a node with two children
// We swapped values from one of the nodes in either subtree.  For the recursive algorithm
// We just want to write the subtree node's value into the node to be deleted, not actually 
// swap. This way subtree remains a valid bst, so we can recurse on that subtree and 
// recursively call _deleteNode on that value (not the original) to remove that node.  
// 
// It takes a bit to wrap your head around this, use the 6 steps, draw lots of pictures.
//
// Bonus: recall that in the case of the two children node, we have a choice between
// choosing a node in the left subtree or right subtree.  Either choice is correct so you 
// can always choose one or the other.  However, you could make your algorithm slightly 
// more sophisticated in that you can decide on which subtree to choose based on
// the height or max depth of the either subtree. I'll leave it to you to reason about this.  
// 
BinarySearchTree::Node*	BinarySearchTree::_deleteNode(Node *node, int value) {
    if (node == nullptr) {
        return nullptr;
    }
    
    if (node->value == value) {
        if (node->left && node->right) {
            // TODO: handle this case
            // Recurse on the smaller of the two subtrees
            if (_height(node->left) < _height(node->right)) {
                node->value = node->left->value;
                node->left->value = value;
                node->left = _deleteNode(node->left, value);
            } else { // (left_subtree_depth >= right_subtree_depth)
                node->value = node->right->value;
                node->right->value = value;
                node->right = _deleteNode(node->right, value);
            }
            // decide which way to traverse
            // swap values of node->direction and node, then call _deleteNode
        } else if (node->left) {
            Node* del = node;
            node = node->left;
            delete del;
        } else if (node->right) {
            Node* del = node;
            node = node->right;
            delete del;
        } else { //no children
            delete node;
            node = nullptr;
        }
    } else if (node->value > value) {
        node->left = _deleteNode(node->left, value);
    } else { // (node->value < value)
        node->right = _deleteNode(node->right, value);
    }
    
    return node;
}


// BinarySearchTree::_printTree
// Prints the BST in a tree format rotated -90 degrees
// uses space to determine the space between levels of the tree
// uses the inorder traversal but traverses right first, rather than left.
// parameter space determines the nubmer of spaces needed for each level
// i.e. traverse right 
//		print appropriate number of spaces 
//		print value 
//		traverse left
void BinarySearchTree::_printTree(Node *node, int space = 0) const {
    if (node == nullptr) return;
    
    _printTree(node->right, space + 4);
    // Prints n spaces, where n is the value of space
    std::cout << std::string(space, ' ');
    std::cout << node->value << std::endl;
    _printTree(node->left, space + 4);
    
    return;
}
