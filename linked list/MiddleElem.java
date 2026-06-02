/* 
Q876 leetcode: https://leetcode.com/problems/middle-of-the-linked-list/?envType=problem-list-v2&envId=linked-list
Input: head = [1,2,3,4,5]
Output: 3 
slow, fast pointer -> slow 1 step, fast 2 step -> jab fast null pe hoga to slow mid pe hoga -> jab tk fast null nhi 
hojata aur fast ka next pointer hai aur slow null nhi hojata -> update slow fast) -> return slow/slow ka data
*/

class Node{
    int d;
    Node next;
    Node(int x){
        this.d = x;
        this.next = null;
    }
}

class MiddleElem{
    public static int mid(Node h){
        Node slow = h;
        Node fast = h;
        while(fast != null && fast.next != null && slow != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.d;
    }
    public static void main (String[] args) {
        Node h = new Node(1);
        h.next = new Node(2);
        h.next.next = new Node(3);
        h.next.next.next = new Node(4);
        h.next.next.next.next = new Node(5);
        System.out.println(mid(h));
    }
}
