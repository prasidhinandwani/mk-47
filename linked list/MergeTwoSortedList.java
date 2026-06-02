/* 
Q21 leetcode: https://leetcode.com/problems/merge-two-sorted-lists/description/?envType=problem-list-v2&envId=linked-list
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
dummy, tail node -> jab tak dono list me se koi null nhi ho jata tb tk((data compare kiya -> tail.next me add kiya) tai.next move kiya) 
-> jo bacha vo tail.next me add kiya -> dummy.next return kiya
time: O(n1 + n2) space: O(1)
*/


class Node{
    int d;
    Node next;
    Node(int x){
        this.d = x;
        this.next = null;
    }
}
class MergeTwoSortedList{
    public static Node merge(Node h1, Node h2){
        Node dummy = new Node(0);
        Node tail = dummy;
        while(h1 != null && h2 != null){
            if(h1.d <= h2.d){
                tail.next = h1;
                h1 = h1.next;
            } else{
                tail.next = h2;
                h2 = h2.next;
            }
            tail = tail.next;
        }
        if(h1 != null) tail.next = h1;
        else tail.next = h2;
        return dummy.next;
    }
    public static void trav(Node h){
        while(h != null){
            System.out.print(h.d + " ");
            h = h.next;
        }
        System.out.println();
    }
    public static void main (String[] args) {
        Node h1 = new Node(1);
        h1.next = new Node(2);
        h1.next.next = new Node(4);
        Node h2 = new Node(1);
        h2.next = new Node(3);
        h2.next.next = new Node(4);
        trav(merge(h1, h2));
    }
}
