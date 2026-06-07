/*Q83 leetcode: https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/?envType=problem-list-v2&envId=linked-list
Input: head = [1,1,2]
Output: [1,2]
cur node li data compare kiya pointer update kiya
*/

class Node{
    int d;
    Node next;
    Node(int s){
        this.d = s;
        this.next = null;
    }
}

class RemoveDupli2{
    public static Node remove(Node h){
        Node cur = h;
        while(cur != null && cur.next != null){
            if(cur.d == cur.next.d){
                cur.next = cur.next.next;
            } else{
                cur = cur.next;
            }
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
        h.next = new Node(1);
        h.next.next = new Node(2);
        h = remove(h);
        print(h);
    }
}