// stack using dynamic array all operations time=space=O(1)

import java.util.*;

class StackDynamicArr{
    ArrayList<Integer> arr = new ArrayList<>();
    void push(int x){
        arr.add(x);
    }
    int pop(){
        if(arr.isEmpty()){
            System.out.println("Stack Underflow");
            return -1;
        }
        int val = arr.get(arr.size()-1);
        arr.remove(arr.size()-1);
        return val;
    }
    int peek(){
        if(arr.isEmpty()){
            System.out.println("Stack Underflow");return -1;
        }
        return arr.get(arr.size()-1);
    }
    boolean isEmpty(){
        return arr.isEmpty();
    }
    int size(){
        return arr.size();
    }
    public static void main (String[] args) {
        StackDynamicArr st = new StackDynamicArr();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        System.out.println(st.size());
        System.out.println(st.pop());
        System.out.println(st.peek());
        System.out.println(st.isEmpty());
    }
}