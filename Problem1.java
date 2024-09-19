
/*

Given a singly-linked list of integers and two positive numbers, m and n, delete every n nodes after skipping m nodes.

Input: List: 1 —> 2 —> 3 —> 4 —> 5 —> 6 —> 7 —> 8 —> 9 —> 10 —> null, m = 1, n = 3
Output: 1 —> 5 —> 9 —> null

Input: List: 1 —> 2 —> 3 —> 4 —> 5 —> 6 —> 7 —> 8 —> 9 —> 10 —> null, m = 2, n = 2
Output: 1 —> 2 —> 5 —> 6 —> 9 —> 10 —> null

Input: List: 1 —> 2 —> 3 —> 4 —> 5 —> 6 —> null, m = 4, n = 6
Output: 1 —> 2 —> 3 —> 4 —> null

Input: List: 1 —> 2 —> 3 —> null, m = 4, n = 2
Output: 1 —> 2 —> 3 —> null

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

	public static Node deleteNodes(Node head, int m, int n)
	{
    //Declare count and help pointer
	int count;
	Node helpPtr = head;
	//first condition if helptr is null
    while (helpPtr != null) {
        //Assign the value of 'm' to 'count'
        count = m;
        // Move helpPtr to the next node if it's not null
        while (count != 1) {
            if (helpPtr != null)
                helpPtr = helpPtr.next;
            //decrement the count.
            count--;
        }
        //Assign the value of 'n' to 'count'
        count = n;
        // Remove the next node if it exists 
        while (helpPtr != null && count !=0 ) {
        	//decrement count until count is 0 or helpPtr is null.
            if (helpPtr.next != null)
                helpPtr.next=helpPtr.next.next;
            count--;
        }
        // Move helpPtr to the next node if it's not null; otherwise, set it to null.
        helpPtr = (helpPtr != null) ? helpPtr.next : null;
    }
    //special condition 
        if (head == null || m <= 0 || n < 0) {
        // Return the original list if no nodes can be removed or invalid parameters
        return head;
    }
    //Return the head of the modified linked list.
    return head;
}
	}