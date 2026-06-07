/*Q92 leetcode: https://leetcode.com/problems/reverse-linked-list-ii/description/?envType=problem-list-v2&envId=linked-list
Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
l pe aaye purani node jo required hai vo rakhi phir reverse kiya reconnect kiya dummy.next return
*/

class Node{
    int d;
    Node next;
    Node(int x){
        this.d = x;
        this.next = null;
    }
}

class ReverseLeftRight{
    public static Node reverse(Node h, int l, int r){
        if(h == null || l==r) return h;
        Node dummy = new Node(0);
        dummy.next = h;
        Node prev = dummy;
        for(int i = 1; i < l; i++){
            prev = prev.next;
        }
        Node cur = prev.next;
        Node cor = prev;
        Node tail = cur;
        Node prevNode = null;
        for(int i = 0; i <= r-l; i++){
            Node next = cur.next;
            cur.next = prevNode;
            prevNode = cur;
            cur = next;
        }
        cor.next = prevNode;
        tail.next = cur;
        return dummy.next;
    }
    public static void print(Node h){
        while(h != null){
            System.out.print(h.d + " ");
            h = h.next;
        }
        System.out.println();
    }
    public static void main (String[] args) {
        Node h =  new Node(1);
        h.next = new Node(2);
        h.next.next = new Node(3);
        h.next.next.next = new Node(4);
        h.next.next.next.next = new Node(5);
        int l = 2;
        int r = 4;
        h = reverse(h, l, r);
        print(h);
    }
}