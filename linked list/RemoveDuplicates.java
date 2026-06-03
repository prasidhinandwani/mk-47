/*Q82 leetcode: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/?envType=problem-list-v2&envId=linked-list
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
dummy.next=head cur=h prev=dummy cur list explore krta hai aur prev last node jo unique thi uspe point krta hai-> 
jab tk cur null nhi ho jata(bool dup jab tk cur.next null nhi hojata aur cur ki value = cur.next ki value(dup=true, move cur) 
agar dup=true(prev.next=cur.next skip kiya duplicate value ko) nhi to prev=prev.next  -> cur move)
*/

class Node{
    int d;
    Node next;
    Node(int x){
        this.d = x;
        this.next = null;
    }
}

class RemoveDuplicates{
    public static Node remove(Node h){
        Node dummy = new Node(0);
        dummy.next = h;
        Node cur = h;
        Node prev = dummy;
        while(cur != null){
            boolean dup = false;
            while(cur.next != null && cur.d == cur.next.d){
                dup = true;
                cur = cur.next;
            }
            if(dup){
                prev.next = cur.next;
            } else{
                prev = prev.next;
            }
            cur = cur.next;
        }
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
        h.next.next.next = new Node(3);
        h.next.next.next.next = new Node(4);
        h.next.next.next.next.next = new Node(4);
        h.next.next.next.next.next.next = new Node(5);
        print(remove(h));
    }
}