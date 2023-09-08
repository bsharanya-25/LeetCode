//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}
class GFG{
    static void printList(Node node) 
    { 
        while (node != null) 
        { 
            System.out.print(node.data + " "); 
            node = node.next; 
        } 
        System.out.println(); 
    }
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            int n = sc.nextInt();
            Node head = null;
            for(int i=0; i<n; i++)
            {
                int value = sc.nextInt();
                int indicator = sc.nextInt();

                Solution ob = new Solution();
                if(indicator == 0)
                    head = ob.insertAtBeginning(head, value);
                else
                    head = ob.insertAtEnd(head, value);
            }
            printList(head); 
            t--;
        }
    } 
} 

// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution {
    // Function to insert a node at the beginning of the linked list.
    Node insertAtBeginning(Node head, int x) {
        // Create a new node with the given value.
        Node newNode = new Node(x);
        // Set the next of the new node to point to the current head.
        newNode.next = head;
        // Update the head to point to the new node, making it the new head.
        head = newNode;
        return head; // Return the new head of the linked list.
    }

    // Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int x) {
        // Create a new node with the given value.
        Node newNode = new Node(x);
        // If the list is empty, make the new node the head and return it.
        if (head == null) {
            return newNode;
        }
        // Traverse to the end of the list.
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        // Set the next of the last node to point to the new node.
        current.next = newNode;
        return head; // Return the head of the linked list.
    }
}
