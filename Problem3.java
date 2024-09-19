/*
Given two sorted singly-linked lists of integers, return a new list representing their intersection.

Input:

X: 1 —> 4 —> 7 —> 10 —> null
Y: 2 —> 4 —> 6 —> 8 —> 10 —> null

Output: 4 —> 10 —> null

*/

class Solution
{
	/*
		A singly-linked list node is defined as:

		class Node {
			int data;		// data field
			Node next;		// pointer to the next node

			Node() {}
			Node(int data) { this.data = data; }
			Node(int data, Node next) { this.data = data; this.next = next; }
		}
	*/
public static Node sortedIntersect(Node X, Node Y){
	//Declare newlist and assign null	
    Node newListP = null;
    Node xP = X;
    Node yP = Y;
    //while loop to check both of xp and yp arenot null
    while (xP != null && yP != null) {
        if (xP.data == yP.data) {
            // If 'newListP' is null, initialize it with a new node containing the data from  'xP'
            if (newListP == null) {
                newListP = new Node(xP.data);
            }
            else {
            	// Create a pointer to traverse to the end of 'newListP'
                Node helpPtr = newListP;
                 // Traverse to the last node in 'newListP'
                while (helpPtr.next != null) {
                    helpPtr = helpPtr.next;
                }
                // Link the new node with data from 'xP' to the end of the list
                helpPtr.next = new Node(xP.data);
            }
            // Move to the next nodes in both lists
            xP = xP.next;
            yP = yP.next;
        }
        else {
            // Compare the data of the current nodes in both lists
            if (xP.data < yP.data)
            // Move to the next node in the 'xP' list if its data is smaller
                xP = xP.next;
            else
            // Otherwise, move to the next node in the 'yP' list
                yP = yP.next;
        }
    }
    return newListP;
}
}