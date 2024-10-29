//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class SortLL {
    static Node head;

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            addToTheLast(head);

            for (int i = 1; i < n; i++) {
                int a = Integer.parseInt(str[i]);
                addToTheLast(new Node(a));
            }

            GfG gfg = new GfG();
            Node node = gfg.quickSort(head);

            printList(node);
            System.out.println();
        
System.out.println("~");
}
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = node;
        }
    }
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }

}*/
// you have to complete this function
class GfG {
    static Node getTail(Node head) {
        Node curr = head;
        while(curr != null && curr.next != null)
            curr = curr.next;
        return curr;
    }
    static void sort(Node head,Node tail) {
        if(head == null || head == tail) return;
        Node pivot = partion(head,tail);
        sort(head,pivot);
        sort(pivot.next,tail);
    }
    static void swap(Node node1,Node node2) {
        int temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }
    static Node partion(Node head,Node tail) {
        Node pivot = head;
        Node pre = head;
        Node curr = head;
        
        while(curr != tail.next) {
            if(curr.data < pivot.data) {
                swap(curr,pre.next);
                pre = pre.next;
            }
            curr = curr.next;
        }
        
        swap(pre,pivot);
        return pre;
    }
    public static Node quickSort(Node node) {
        Node tail = getTail(node);
        sort(node,tail);
        return node;
    }
}