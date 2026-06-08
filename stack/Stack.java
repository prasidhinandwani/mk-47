// stack using array all operations time=space=O(1)

class myStack{
    private int[] arr;
    private int capacity;
    private int top;
    public myStack(int cap){
        capacity = cap;
        arr = new int[capacity];
        top = -1;
    }
    public void push(int x){
        if(top == capacity-1){
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = x;
    }
    public int pop(){
        if(top == -1){
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }
    public int peek(){
        if(top == -1){
            System.out.println("Stack empty");
            return -1;
        }
        return arr[top];
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public boolean isFull(){
        return top == capacity-1;
    }
}
public class Stack{
    public static void main (String[] args) {
        myStack st = new myStack(4);
        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println(st.pop());
        System.out.println(st.peek());
        System.out.println(st.isEmpty());
        System.out.println(st.isFull());
    }
}