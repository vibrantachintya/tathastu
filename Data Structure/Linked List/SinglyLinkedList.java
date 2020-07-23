package demo2;

public class SinglyLinkedList {
	
	Node head;

	static class Node { 
        int data; 
        Node next; 
        Node(int d) 
        { 
            data = d; 
            next = null; 
        } 
    } 
	
	public void printLinkedList() { 
        Node n = head; 
        while (n != null) { 
            System.out.print(n.data + " "); 
            n = n.next; 
        } 
        System.out.println();
    } 
	
	public void addInStart(int data) { 
	    Node node = new Node(data); 
	    node.next = head;
	    head = node;
	} 
	
	public void addAfter(Node prevNode, int data) { 
		
		if(prevNode == null) {
			System.out.println("Input a non empty list");
			return;
		}
		
	    Node node = new Node(data); 
	    node.next = prevNode.next;
	    prevNode.next = node;
	} 
	
	public void addInLast(int data) { 
	    Node node = new Node(data); 

	    if (head == null) { 
	        head = new Node(data); 
	        return; 
	    } 

	    Node last = head;
	    while (last.next != null) 
	        last = last.next; 
	    last.next = node; 
	} 
	
	public void deleteNodeByKey(int value) { 
	    Node temp = head, prevNode = null; 

	    if (temp != null && temp.data == value) { 
	        head = temp.next; 
	        return; 
	    } 

	    while(temp != null && temp.data != value) {
	    	prevNode = temp;
	    	temp = temp.next;
	    }
	    
	    if(temp == null) return;
	    prevNode.next = temp.next;
	    
	} 
	
	public void deleteNodeByPosition(int pos) { 
	    
        if(head == null) return;
        
        Node temp = head;

        if (pos == 0) { 
	        head = temp.next; 
	        return; 
	    } 

	    for(int i = 1; temp != null && i < pos - 1; i++)
	    	temp = temp.next;
	    
	    if(temp == null || temp.next == null) return;
	    
	    Node next = temp.next.next;
	    temp.next = next;
	    
	} 
 
	public static void main(String[] args) {
		
		SinglyLinkedList ll = new SinglyLinkedList();
		
		ll.head = new Node(5);
		Node node2 = new Node(7);
		Node node3 = new Node(2);
		Node node4 = new Node(15);
		
		ll.head.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		System.out.println("Original List :");
		ll.printLinkedList();
		
		System.out.println("## Add 0 in beginning ##");
		ll.addInStart(0);
		
		System.out.println("After adding, new list :");
		ll.printLinkedList();
		
		System.out.println("## Add 1 after 7 ##");
		ll.addAfter(node2, 1);
		
		System.out.println("After adding, new list :");
		ll.printLinkedList();
		
		System.out.println("## Add 11 in last ##");
		ll.addInLast(11);
		
		System.out.println("After adding, new list :");
		ll.printLinkedList();
		
		System.out.println("## Delete 5 ##");
		ll.deleteNodeByKey(5);
		
		System.out.println("After deleting, new list :");
		ll.printLinkedList();
		
		System.out.println("## Delete 3rd node ##");
		ll.deleteNodeByPosition(3);
		
		System.out.println("After deleting, new list :");
		ll.printLinkedList();
			
	}

}
