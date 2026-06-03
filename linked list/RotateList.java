/* Q61 leetcode: https://leetcode.com/problems/rotate-list/description/?envType=problem-list-v2&envId=linked-list
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
overflow nhi k liye k/n -> circular banane k liye tail.next=head -> kitne steps move krna hai=n-k -> 
i=1 se step tk(newtail=newtail.next) -> newhead=newtail.next newTail.next=null -> return newHead
Left rotate-> i- 1 se k tk(newtail=newtail.next)
*/

class Node{
    int d;
    Node next;
    Node(int x){
        this.d = x;
        this.next = null;
    }
}

class RotateList{
    public static Node rotateRight(Node h, int k){
        if(h == null || h.next == null || k == 0) return h;
        int n = 1;
        Node tail = h;
        while(tail.next != null){
            tail = tail.next;
            n++;
        }
        k = k % n;
        if(k == 0) return h;
        tail.next = h;
        Node newTail = h;
        int step = n - k;
        for(int i = 1; i < step; i++){
            newTail = newTail.next;
        }
        Node newHead = newTail.next;;
        newTail.next = null;
        return newHead;
    }
    public static Node rotatleft(Node h, int k){
        if(h == null || h.next == null || k == 0) return h;
        int n = 1;
        Node tail = h;
        while(tail.next != null){
            tail = tail.next;
            n++;
        }
        k = k % n;
        if(k == 0) return h;
        tail.next = h;
        Node newtail = h;
        for(int i = 1; i < k; i++){
            newtail = newtail.next;
        }
        Node newHead = newtail.next;
        newtail.next = null;
        return newHead;
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
        //Node r = (rotateRight(h, 2));
        print(rotatleft(h, 2));
        //Node h1 = rotateRight(h, 2);

    }
}