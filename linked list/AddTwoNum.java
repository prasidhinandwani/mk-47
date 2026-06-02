/* Q2 leetcode: https://leetcode.com/problems/add-two-numbers/description/?envType=problem-list-v2&envId=linked-list
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
digits reverse order me saved -> jab tk h1 null nhi ho jata ya h2 null nhi ho jata ya carry 0 nhi ho jata
                                (2+5=7, c=7/10=0, digit=7%10=7 -> temp.next=d -> temp=temp.next
                                4+6=10, c=10/10=1, d=10&10=0 -> {7 -> 0}
                                sum =2+5+1=8, c=0, d=8 -> {7->0->8}) 
                                -> dummy.next return
*/

class Node{
    int d;
    Node next;
    Node(int x){
        this.d = x;
        this.next = null;
    }
}

class AddTwoNum{
    public static Node add(Node h1, Node h2){
        Node dummy = new Node(0);
        Node temp = dummy;
        int carry = 0;
        while(h1 != null || h2 != null || carry != 0){
            int sum = 0;
            if(h1 != null){
                sum += h1.d;
                h1 = h1.next;
            }
            if(h2 != null){
                sum += h2.d;
                h2 = h2.next;
            }
            sum += carry;
            carry = sum / 10;
            Node n = new Node(sum % 10);
            temp.next = n;
            temp = temp.next;
        }
        return dummy.next;
    }
    public static void print(Node h){
        while(h != null){
            System.out.print(h.d + " ");
            h = h.next;
        }
    }
    public static void main (String[] args) {
        Node h1 = new Node(2);
        h1.next = new Node(4);
        h1.next.next = new Node(3);
        Node h2 = new Node(5);
        h2.next = new Node(6);
        h2.next.next = new Node(4);
        print(add(h1, h2));
        
    }
}