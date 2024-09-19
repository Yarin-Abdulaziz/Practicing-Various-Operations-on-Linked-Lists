/*
Given a doubly-linked list of integers, rearrange its nodes to be sorted in increasing order.

Input : 6 ⇔ 3 ⇔ 4 ⇔ 8 ⇔ 2 ⇔ 9 ⇔ null
Output: 2 ⇔ 3 ⇔ 4 ⇔ 6 ⇔ 8 ⇔ 9 ⇔ null

Input : 9 ⇔ -3 ⇔ 5 ⇔ -2 ⇔ -8 ⇔ -6 ⇔ null
Output: -8 ⇔ -6 ⇔ -3 ⇔ -2 ⇔ 5 ⇔ 9 ⇔ null

*/

class Solution
{
	/*
		A doubly-linked list node is defined as:

		class Node {
			int data;		// data field
			Node prev;		// pointer to the previous node
			Node next;		// pointer to the next node

			Node() {}
			Node(int data) { this.data = data; }
			Node(int data, Node prev, Node next) { this.data = data; this.prev = prev; this.next = next; }
		}
	*/

	public static Node sort(Node head)
	{
	// Declare helpPtr and numberOfNodes
    int numNodes = 0;
    Node helpPtr = head;
    // Calculate the number of nodes
    while (helpPtr != null) {
        numNodes++;
        helpPtr = helpPtr.next;
    }
    // If there are 0 or 1 nodes, no need to sort
    if (numNodes <= 1) {
        return head;
    }
    helpPtr = head.next;
    // Iterate through each node in the list
    for (int i = 1; i < numNodes; i++) {
        if (helpPtr != null && helpPtr.prev != null && helpPtr.data > helpPtr.prev.data) {
            helpPtr = helpPtr.next;
        } else if (helpPtr != null) {
            Node newP = helpPtr.next;
            while (helpPtr.prev != null && helpPtr.data < helpPtr.prev.data) {
                Node prevNode = helpPtr.prev;
                // Determine the case (nodecase) based on the current node 
                int nodecase;
                //nodes = 2
                if (numNodes == 2) {
                    nodecase = 1;
                } else if (helpPtr.prev == head) {
                    nodecase = 2;
                } else if (helpPtr.next == null) {
                    nodecase = 3;
                } else {
                    nodecase = 4;
                }
                // Handle the case using switch
                switch (nodecase) {
                    case 1: // Case when numberOfNodes == 2
                        helpPtr.prev = prevNode.prev;
                        helpPtr.next = prevNode;
                        prevNode.prev = helpPtr;
                        prevNode.next = null;
                        head = helpPtr;
                        break;
                    case 2: // Case when the previous node is head
                        helpPtr.prev = prevNode.prev;
                        prevNode.next = helpPtr.next;
                        helpPtr.next = prevNode;
                        prevNode.prev = helpPtr;
                        if (prevNode.next != null) {
                            prevNode.next.prev = prevNode;
                        }
                        head = helpPtr;
                        break;
                    case 3: // Case when helpPtr is the last node
                        helpPtr.prev = prevNode.prev;
                        prevNode.next = helpPtr.next;
                        helpPtr.next = prevNode;
                        prevNode.prev = helpPtr;
                        if (helpPtr.prev != null) {
                            helpPtr.prev.next = helpPtr;
                        }
                        break;
                    case 4: // Any other case
                        helpPtr.prev = prevNode.prev;
                        prevNode.next = helpPtr.next;
                        helpPtr.next = prevNode;
                        prevNode.prev = helpPtr;
                        if (prevNode.next != null) {
                            prevNode.next.prev = prevNode;
                        }
                        if (helpPtr.prev != null) {
                            helpPtr.prev.next = helpPtr;
                        }
                        break;
                }
            }
            helpPtr = newP;
        }
    }
    // Return the sorted head of the list
    return head;
}
}