/* Q25 leetcode: https://leetcode.com/problems/reverse-nodes-in-k-group/description/?envType=problem-list-v2&envId=linked-list
Input: head = [1,2,3,4,5], k= 2
Output: [2,1,4,3,5]
check kro k node h ki nhi -> k nodes mil gayi phir reverse -> recurse baki ki list pe
*/

class Node{
    int d;
    Node next;
    Node(int x){
        this.d = x;
        this.next = null;
    }
}

class ReverseInKGrps{
    public static Node reverse(Node h, int k){
        Node cur = h;
        int count = 0;
        while(cur != null && count < k){
            cur = cur.next;
            count++;
        }
        if(count == k){
            Node prev = null;
            Node next = null;
            cur = h;
            for(int i = 0; i < k; i++){
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            h.next = reverse(cur, k);
            return prev;
        }
        return h;
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
        print(reverse(h, 2));
    }
}