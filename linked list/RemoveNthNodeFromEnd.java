/* Q19 leetcode https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/?envType=problem-list-v2&envId=linked-list
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
dummy(0,h) -> slow fast pointer initially dummy -> fast ko n pe lekr aao phir slow aur fast ek ek step move kiye jab fast null pe 
hoga to slow n pe hoga phir slow.next=slow.next.mext
*/

class Node{
    int d;
    Node next;
    Node(int x){
        this.d = x;
        this.next = null;
    }
}

class RemoveNthNodeFromEnd{
    public static Node remove(Node h, int n){
        Node dummy = new Node(0);
        dummy.next = h;
        Node slow = dummy;
        Node fast = dummy;
        for(int i = 0; i <= n; i++){
            fast = fast.next;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
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
        Node h = new Node(1);
        h.next = new Node(2);
        h.next.next = new Node(3);
        h.next.next.next = new Node(4);
        h.next.next.next.next = new Node(5);
        print(remove(h, 3));
    }
}