import java.util.*;

class Node{
    int data;
    List<Node>children;
    Node(int x){
        data = x;
        children = new ArrayList<>();
    }
}

class BinaryTree{
    static void addChild(Node parent, Node child){
        parent.children.add(child);
    }
    static void printParents(Node node, Node parent){
        if(parent == null){
            System.out.println(node.data + " -> NULL");
        }
        else{
            System.out.println(node.data + " -> " + parent.data);
        }
        for(Node child : node.children){
            printParents(child, node);
        }
    }
    static void printChildren(Node node){
        System.out.print(node.data + " -> ");
        for(Node child : node.children){
            System.out.print(child.data + " ");
        }
        System.out.println();
        for(Node child : node.children){
            printChildren(child);
        }
    }
    static void printLeafNodes(Node node){
        if(node.children.isEmpty()){
            System.out.print(node.data + " ");
            return;
        }
        for(Node child : node.children){
            printLeafNodes(child);
        }
    }
    static void printDegree(Node node, Node parent){
        int degree = node.children.size();
        if(parent != null){
            degree++;
        }
        System.out.println(node.data +  " -> " + degree);
        for(Node child : node.children){
            printDegree(child, parent);
        }
    }
    public static void main (String[] args) {
        Node root = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        addChild(root, n2);
        addChild(root, n3);
        addChild(n2, n4);
        addChild(n2, n5);
        System.out.println("Parents of each Node: ");
        printParents(root, null);
        System.out.println("Children of each node");
        printChildren(root);
        System.out.println("leaf Node: ");
        printLeafNodes(root);
        System.out.println();
        System.out.println("Degrees: ");
        printDegree(root, null);
    }
}