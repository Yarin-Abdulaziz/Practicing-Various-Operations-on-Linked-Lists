
/*
Given a singly-linked list of integers and a positive number k, swap the k'th node from the beginning with the k'th node from the end. The swapping should be done so that only links between the nodes are exchanged, and no data is swapped.

Input:

Linked List: 1 —> 2 —> 3 —> 4 —> 5 —> 6 —> 7 —> 8 —> null
k = 2

Output: 1 —> 7 —> 3 —> 4 —> 5 —> 6 —> 2 —> 8 —> null


Input:

Linked List: 1 —> 2 —> null
k = 2

Output: 2 —> 1 —> null


Assume that k is less than or equal to the length of linked list.

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

	public static Node swapNodes(Node head, int k)
	{
    //Declare numberofnodes and helptr
	int numNodes = 0;
    Node helpPtr = head;
    while (helpPtr != null) {
        numNodes++;
        helpPtr = helpPtr.next;
    }
    //condition 
    if(numNodes == 1 || numNodes == 0)
       return head;
    // Find the last node tail
    Node tail = head;
    while (tail.next != null) {
        tail = tail.next;
    }
    // Number of required moves to reach the targetted node
    int movesk  = numNodes - k;
    // Find kth node from start
    Node start = head;
    for (int i = 0; i < k-1; i++) {
        start = start.next;
    }
    // Find kth node from end
    Node end = head;
    for (int i = 0; i < movesk; i++) {
        end = end.next;
    }
    // Find previous node of start,right before kth node from start
    Node preStart = null;
    if (head != start) {
        preStart = head;
        for (int i = 0; i < k-2; i++) {
            preStart = preStart.next;
        }
    }
    // Find previous node of end,right before kth node from end
    Node preEnd = null;
    if (head != end) {
        preEnd = head;
        for (int i = 0; i < movesk-1; i++) {
            preEnd = preEnd.next;
        }
    }
    // Find the node after of start,right after kth node from start
    Node afterStart = null;
    if (start != tail) {
        afterStart = head;
        for (int i = 0; i < k; i++) {
            afterStart = afterStart.next;
        }
    }
    // Find the node after of end,right after kth node from end
    Node afterEnd = null;
    if (end != tail) {
        afterEnd = head;
        for (int i = 0; i < movesk+1; i++) {
            afterEnd = afterEnd.next;
        }
    }
    //cover all cases
    //Case 1: if k is equal to 1
    if (k == 1) {
        if (numNodes == 2) { // In case that there is only 2 nodes in the linked list
            end.next = start;
            start.next = null;
            head = end;
        }
        else {
            end.next = start.next;
            preEnd.next = start;
            start.next = null;
            head = end;
        }
    }
    //CASE 2: k is equal to the length of linked list
    else if (k == numNodes) {
    	//here we have only tow nodes
        if (numNodes == 2) { 
            start.next = end;
            end.next = null;
            head = start;
        }
        else {
            start.next = end.next;
            preStart.next = end;
            end.next = null;
            head = start;
        }
    }
    // CASE 3: number of nodes is odd , and the k is exactly in the middle of linked list 
    else if (numNodes % 2 != 0 && k == Math.ceil(numNodes/2.0)) {
        return head;
    }
    // CASE 3: Link 'preStart' to 'end', 'end' to 'start', and 'start' to 'afterEnd' when          'start' and 'preEnd' are the same
    else if (start == preEnd) {
      preStart.next = end;
      end.next = start;
      start.next = afterEnd;
    } 
    // CASE 4: Link 'preEnd' to 'start', 'start' to 'end', and 'end' to 'afterStart' when 'end'     and 'preStart' are the same
    else if (end == preStart) {
      preEnd.next = start;
      start.next = end;
      end.next = afterStart;
    }
    //CASE 5: Anywhere else in the linked list
    else {
        preStart.next = end;
        end.next = start.next;
        preEnd.next = start;
        start.next = afterEnd;
    }
    return head;}}

