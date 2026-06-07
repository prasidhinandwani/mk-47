import java.util.*;

class Node{
    int d;
    Node next;
    Node(int x){
        this.d = x;
        this.next = null;
    }
}

public class SinglyLinkedList{
    //traversal - iterative (time O(n), space: O(1))
    public static void traversal(Node h){
        while(h != null){
            System.out.print(h.d + " ");
            h = h.next;
        }
        System.out.println();
    }
    
    //traversal - recursive (time: O(n), space: O(n) recursive stack space)
    public static void traversalRec(Node h){
        if(h == null){
            System.out.println();
            return;
        }
        System.out.print(h.d + " ");
        traversalRec(h.next);
    }
    
    //insertion
    //begin (time = space = O(1))
    public static Node insertBeg(Node h, int x){
        Node n = new Node(x);
        n.next = h;
        return n;
    }
    
    //end (time: O(n), space: O(1))
    public static Node insertEnd(Node h, int x){
        Node n = new Node(x);
        if(h == null) return n;
        Node last = h;
        while(last.next != null) last = last.next;
        last.next = n;
        return h;
    }
    
    //specific position (time: O(n) space: O(1))
    public static Node insertPos(Node h, int pos, int x){
        if(pos < 1) return h;
        if(pos == 1){
            Node n = new Node(x);
            n.next = h;
            return n;
        }
        Node cur = h;
        for(int i = 1; i < pos - 1 && cur.next != null; i++){
            cur = cur.next;
        }
        if(cur == null) return h;
        Node n = new Node(x);
        n.next = cur.next;
        cur.next = n;
        return h;
    }
    
    //deletion
    //begin (time= space = O(1))
    public static Node delBeg(Node h){
        if(h == null) return null;
        Node temp = h;
        h = h.next;
        temp = null;
        return h;
    }
    
    //end (time: O(n) space: O(1))
    public static Node delEnd(Node h){
        if(h == null) return null;
        if(h.next == null) return null;
        Node secondLast = h;
        while(secondLast.next.next != null) secondLast = secondLast.next;
        secondLast.next = null;
        return h;
    }
    
    //specific position (time: O(n) space:O(1))
    public static Node delPos(Node h, int p){
        Node temp = h;
        if(p == 1){
            h = temp.next;
            return h;
        }
        Node prev = null;
        for(int i = 1; i < p; i++){
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
        return h;
    }
    
    //search - iterative (time: O(n) space: O(1))
    public static boolean search(Node h, int k){
        Node cur = h;
        while(cur != null){
            if(cur.d == k) return true;
            cur = cur.next;
        }
        return false;
    }
    
    //search - recursive (time: O(n), space: O(1))
    public static boolean searchIter(Node h, int k){
        if(h == null) return false;
        if(h.d == k) return true;
        return searchIter(h.next, k);
    }
    
    //reverse - iterative (time = space = O(n))
    public static Node reverse(Node h){
        Node cur = h;
        Node prev = null, next = null;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    
    //reverse - recursive (time = space = O(n))
    public static Node reverseRec(Node h){
        if(h == null || h.next  == null) return h;
        Node rest = reverseRec(h.next);
        h.next.next = h;
        h.next = null;
        return rest;
    }
    
    //reverse brute force - stack (time = space = O(n))
    public static Node reverseSt(Node h){
        Stack<Node> st = new Stack<>();
        Node temp = h;
        while(temp != null){
            st.push(temp);
            temp = temp.next;
        }
    
        h = st.pop();
        temp = h;
        while(!st.isEmpty()){
            temp.next = st.pop();
            temp = temp.next;
        }
        temp.next = null;
    
        return h;
    }
    
    
    public static void main (String[] args) {
        Node h = new Node(1);
        h.next = new Node(2);
        h.next.next = new Node(3);
        h.next.next.next = new Node(4);
        h.next.next.next.next = new Node(5);
        traversal(h);
        int x = 0;
        h = insertBeg(h, x);
        int y = 6;
        Node h2 = insertEnd(h, y);
        int z = 7;
        int pos = 3;
        h2 = insertPos(h2, pos, z);
        traversalRec(h2);
        h2 = delBeg(h2);
        h2 = delEnd(h2);
        int p = 2;
        h2 = delPos(h2, p);
        traversal(h2);
        int k = 3;
        System.out.println(search(h, k));
        int k2 = 4;
        System.out.println((searchIter(h, k2)));
        Node h3 = reverseSt(h);
        traversal(h3);
    }
}
