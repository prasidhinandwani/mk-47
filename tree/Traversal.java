import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int x){
        data = x;
        left = right = null;
    }
}

class Traversal{
    //inorder - rec
    static void inOrder(Node node, ArrayList<Integer> res){
        if(node == null) return;
        inOrder(node.left, res);
        res.add(node.data);
        inOrder(node.right, res);
    }
    //inorder - iter 
    static ArrayList<Integer> inOrderInter(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        Node cur = root;
        while(cur != null || !st.isEmpty()){
            while(cur != null){
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            ans.add(cur.data);
            cur = cur.right;
        }
        return ans;
    }
    //inorder - morris
    static ArrayList<Integer> inOrderMor(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        Node cur = root;
        while(cur != null){
            if(cur.left == null){
                ans.add(cur.data);
                cur = cur.right;
            }
            else{
                Node prev = cur.left;
                while(prev.right != null && prev.right != cur){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = cur;
                    cur = cur.left;
                }
                else{
                    prev.right = null;
                    ans.add(cur.data);
                    cur = cur.right;
                }
            }
        }
        return ans;
    }
    //preorder - rec
    static void preOrder(Node node, ArrayList<Integer> res){
        if(node == null) return;
        res.add(node.data);
        preOrder(node.left, res);
        preOrder(node.right, res);
    }
    //preorder - iter - stack 
    static ArrayList<Integer> preOrderIter(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            Node cur = st.pop();
            ans.add(cur.data);
            if(cur.right != null){
                st.push(cur.right);
            }
            if(cur.left != null){
                st.push(cur.left);
            }
        }
        return ans;
    }
    //preorder - iter - current + stack 
    static ArrayList<Integer> preOrderIter2(Node root){
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<Node> st = new Stack<>();
        Node cur = root;
        while(!st.isEmpty() || cur != null){
            while(cur != null){
                res.add(cur.data);
                if(cur.right != null) st.push(cur.right);
                cur = cur.left;
            }
            if(!st.isEmpty()){
                cur = st.pop();
            }
        }
        return res;
    }
    //preorder - morris - time o(n) space o(1)
    public static ArrayList<Integer> preOrderMor(Node root){
        ArrayList<Integer> res = new ArrayList<>();
        Node cur = root;
        while(cur != null){
            if(cur.left == null){
                res.add(cur.data);
                cur = cur.right;
            }
            else{
                Node prev = cur.left;
                while(prev.right != null && prev.right != cur){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = cur;
                    res.add(cur.data);
                    cur = cur.left;
                }
                else{
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }
    //postOrder - rec
    static void postOrder(Node node, ArrayList<Integer> res){
        if(node == null) return;
        postOrder(node.left, res);
        postOrder(node.right, res);
        res.add(node.data);
    }
    //postOrder - iterative 2 stack
    static ArrayList<Integer> postOrderIter(Node root){
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(root);
        while(!st1.isEmpty()){
            root = st1.pop();
            st2.push(root);
            if(root.left != null) st1.push(root.left);
            if(root.right != null) st1.push(root.right);
        }
        while(!st2.isEmpty()){
            res.add(st2.pop().data);
        }
        return res;
    }
    static void printList(ArrayList<Integer> v){
        for(int x : v){
            System.out.print(x + " ");
        }
    }
    
    public static void main (String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        ArrayList<Integer> res = new ArrayList<>();
        inOrder(root, res);
        System.out.println("Inorder traversal: ");
        for(int node : res){
            System.out.print(node + " ");
        }
        System.out.println();
        ArrayList<Integer> res2 = new ArrayList<>();
        preOrder(root, res2);
        System.out.println("Preorder traversal: ");
        for(int node : res2){
            System.out.print(node + " ");
        }
        System.out.println();
        ArrayList<Integer> res3 = new ArrayList<>();
        postOrder(root, res3);
        System.out.println("Postorder traversal: ");
        for(int node : res3){
            System.out.print(node + " ");
        }
        System.out.println();
        ArrayList<Integer> i = inOrderInter(root);
        System.out.println("Inorder- Stack");
        printList(i);
        System.out.println();
        ArrayList<Integer> im = inOrderMor(root);
        System.out.println("Inorder- Morris");
        printList(im);
        System.out.println();
        ArrayList<Integer> pre = preOrderIter(root);
        System.out.println("Preorder traversal - Iter: ");
        printList(pre);
        System.out.println();
        ArrayList<Integer> pre2 = preOrderIter2(root);
        System.out.println("Preorder traversal - Iter 2: ");
        printList(pre2);
        System.out.println();
        ArrayList<Integer> preorderM = preOrderMor(root);
        System.out.println("Preorder traversal - Morris: ");
        printList(preorderM);
         System.out.println();
        ArrayList<Integer> post = postOrderIter(root);
        System.out.println("Postorder traversal - Iter: ");
        printList(post);
        
    }
}