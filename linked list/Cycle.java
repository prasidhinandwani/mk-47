/*Q141 leetcode: https://leetcode.com/problems/linked-list-cycle/description/?envType=problem-list-v2&envId=linked-list
Input: head = [3,2,0,-4], pos = 1
Output: true
2 pointer slow fast jab slow == fast return true
*/

class Node{
    int d;
    Node next;
    Node(int x){
        this.d = x;
        this.next = null;
    }
}

class Cycle{
    public static boolean cycleLst(Node h){
        if(h == null) return false;
        Node slow = h;
        Node fast = h;
        while(fast != null & fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
    public static void main (String[] args) {
        Node h = new Node(3);
        h.next = new Node(2);
        h.next.next = new Node(0);
        h.next.next.next = new Node(4);
        h.next.next.next.next = h.next;
        System.out.print(cycleLst(h));
    }
}