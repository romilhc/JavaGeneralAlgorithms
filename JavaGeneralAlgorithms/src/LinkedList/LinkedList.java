/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

import java.util.HashSet;

/**
 * @author Romil Chauhan
 */
public class LinkedList {
    
    public Node head = null;
    
    LinkedList(){}
    
    LinkedList(int val)
    {
        this.head = new Node(val,null);
    }
    
    // Class Node
    protected static class Node {
        
        public int val;
        public Node next;

        Node() {}
        
        Node(int val)
        {
            this.val = val;
            this.next = null;
        }

        Node(int val, Node next)
        {
            this.val = val;
            this.next = next;
        }
    
    }
    
    // Append the element to the LinkedList
    public void add(int val)
    {
        // Add new node to head
        if(this.head == null)
        {
            this.head = new Node(val);
        }
        // Append to LinkedList
        else
        {
            Node temp = head;
            while(temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = new Node(val);
        }
    }
    
    // Print the LinkedList
    public void print()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.val + "\t");
            temp = temp.next;
        }
        System.out.println();
    }
    
    // Delete the given value from LinkedList
    public void delete(int val)
    {
        Node curr = head;
        Node prev = null;
        boolean found = false;
        
        // Iterate LinkedList until not the value is not found
        while(curr != null && found == false)
        {
            if(curr.val == val)
            {
                found = true;
            }
            else
            {
                prev = curr;
                curr = curr.next;
            }
        }
        
        // End of LinkedList, data not found
        if(curr == null)
            System.out.println("Data not found");
        
        // If the node found is first node
        if(prev == null)
            this.head = curr.next;
        // If the node is other than first node
        else
            prev.next=curr.next;
        
    }
    
    // Remove duplicates from the LinkedList
    public void removeDuplicates()
    {
        HashSet<Integer> hs = new HashSet<>();
        Node temp = head, prev = null;
        
        // Iterate the LinkedList
        while(temp != null)
        {
            // If set contains the element then delete it
            if(hs.contains(temp.val))
            {
                prev.next = temp.next;
            }
            // Else add to the set
            else
            {
                hs.add(temp.val);
                prev = temp;
            }
            temp = temp.next; 
            
        }
        
    }
    
    // Reverse the given LinkedList and returns the new head
    public Node reverse(Node node)
    {
        Node curr = node;
        Node prev = null;
        Node temp = null;
        
        // Change the pointers to prev node while moving ahead using temp
        while(curr != null)
        {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        // Return new head
        return prev;
    }
    
    // Find the size of LinkedList
    public int size()
    {
        Node temp = head;
        int c = 0;
        
        // Iterate over LinkedList and count the elements
        while(temp != null)
        {
            temp = temp.next;
            c += 1;
        }

        return c;
    }
    
    // Return Kth to last element in LinkedList iteratively.
    public int returnKthToLast(int k)
    {
        Node ptr1 = this.head;
        Node ptr2 = this.head;
        
        int ctr = 0;
        
        if(k > this.size())
        {
            return -1;
        }
            
        // Iterate using ptr1 till kth element
        while(ctr < k && ptr1 != null)
        {
            ptr1 = ptr1.next; 
            ctr++;
        }
        
        // Iterate ptr1 from kth element and ptr2 from beginning.
        // When ptr1 reaches end, ptr2 will return kth last element.
        while(ptr1 != null)
        {
            ptr2 = ptr2.next;
            ptr1 = ptr1.next;
        }
        
        return ptr2.val;
        
    }
    
    // Print Kth to last element in LinkedList    
    public int returnKthToLastRecursiveHelper(Node curr, int k)
    {
        
        if(curr == null)
            return 0;
        else
        {
            int index = returnKthToLastRecursiveHelper(curr.next, k) + 1;
            if(index == k)
                System.out.println("\nThe element found at position " + k + " is " + curr.val);
            return index;
        }   
    }
    
    // Delete middle node.
    public void deleteMiddleNode(Node curr)
    {
        if(curr == null && curr.next != null)
            return;
        
        // Delete next node and set value of next node to current node.
        int val = curr.val;
        curr.val = curr.next.val;
        curr.next = curr.next.next;
            
    }
    
    public int sumListsBack(LinkedList n2)
    {
        /*int n1Size = this.size();
        int n2Size = n2.size();
        Node n1 = 
        for(int i = 0; i < Math.abs(n1Size-n2Size); i++)
        {
            if(n1Size>n2Size)
            {
                
            }
        }*/
        return 0;
    }
    
    public static void main(String args[])
    {
        LinkedList l=new LinkedList();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(2);
        l.add(2);
        l.add(4);
        l.add(5);
        l.add(2);
        l.add(6);
        System.out.println("LinkedList formed:");
        l.print();
        
        l.deleteMiddleNode(l.head.next);
        
        l.delete(2);
        
        l.delete(5);
        
        l.delete(6);
        
        l.removeDuplicates();
        
        l.head = l.reverse(l.head);
        l.print();
        System.out.println(l.returnKthToLast(5));
        
        LinkedList l1 = new LinkedList(6);
        l1.add(1);
        l1.add(7);
        LinkedList l2 = new LinkedList(2);
        l2.add(9);
        l2.add(5);
        
        //LinkedList summedList = l1.sumListsBack(l2);
    }
    
}
