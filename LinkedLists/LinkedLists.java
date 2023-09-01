package LinkedLists;



public class LinkedLists{

    public class Node{
        int data;
        Node next;

        public Node(int newdata){ // the constructor
            this.data = newdata;
            this.next = null;
        }
    }

    public Node head;

    public Node tail;

    public class LL{

        public void print(Node head){
            if(head == null){
                System.out.println("there is no existing linkedlist");
                return;
            }

            Node temp = head;
            while(temp != null){
                System.out.println(temp.data+"-->");
                temp = temp.next;
            }
            System.out.println("null");
        }

        public void addFirst(int newdata){

            Node node = new Node(newdata); // forming a new node with the given value

            node.next = head; // marking the current head as the next of the new node 

            head = node; //eventually making the node as the new head of the linkedlist

        }

        public void addLast(int newdata){

            node node = new Node(newdata);  // forming a new node with the given value

            tail.next = node; // marking the new node as the next of the current tail

            tail = node; // eventually making the new node as the new tail of the linkedlist
 
        }


        public void insert_after_a_given_node(Node lastNode,int newdata){
            if(lastNode == null){
                System.out.println("the given node is null");
            }

            Node node = new Node(newdata); // forming a new node with the given value

            node.next = lastNode.next; // Make next of new Node as next of lastNode

            lastNode.next = node; // make next of lastNode as new_node

        }



    }
    
}