package LinkedLists;



public class LinkedLists{

    public static class Node{
        int data;
        Node next;

        public Node(int newdata){ // the constructor
            this.data = newdata;
            this.next = null;
        }
    }



    public static class LL{


        public  Node head;

        public  Node tail;

        public void print(Node head){
            if(head == null){
                System.out.println("there is no existing linkedlist");
                return;
            }

            Node temp = head;
            while(temp != null){
                System.out.print(temp.data+"--> ");
                temp = temp.next;
            }
            System.out.println("null");
        }

        public int size(){
            if(head == null){
                return 0;
            }

            Node temp = head;
            int i = 0;
            while(temp !=  null){
                i++;
                temp = temp.next;
            }

            return i;
        }

        public void addFirst(int newdata){

            if(head == null){
                Node node = new Node(newdata);
                head = tail = node;
                return;
            }

            Node node = new Node(newdata); // forming a new node with the given value

            node.next = head; // marking the current head as the next of the new node 

            head = node; //eventually making the node as the new head of the linkedlist

        }

        public void addLast(int newdata){

            if(head == null){
                Node node = new Node(newdata);
                head = tail = node;
                return;
            }

            Node temp = head;
            while(temp.next != null){
                temp = temp.next;     // traverse to the last node
            }

            Node node = new Node(newdata);  // forming a new node with the given value

            temp.next = node; // marking the new node as the next of the current tail

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

        public void insert_at_an_index(int idx ,int newdata){  // zero based indexing 
            if(idx == 0){
                addFirst(newdata);
                return;
            }

            int i = 0;
            Node temp = head;

            while(i < idx-1){
                temp = temp.next;
                i++;
            }

            Node node = new Node(newdata);

            node.next = temp.next;

            temp.next = node;

        }

        public void insert_at_an_index_from_last(int idx,int newdata){ // zero based indexing from the last 
            if(idx == 0){
                addLast(newdata);
                return;
            }

            int i = 0;
            Node temp = head;

            while(i < idx-2){
                temp = temp.next;
                i++;
            }

            Node node = new Node(newdata);

            node.next = temp.next;

            temp.next = node;
        }

        public int search(int val){
            if(head == null){
                System.out.println("the linked list is empty");
                return -1;
            }

            Node temp = head;
            int i = 0;
            while(temp != null){
                if(temp.data == val){
                    return i;
                }
                temp = temp.next;
                i++;
            }
            return -1;
        }



    }

    public static void main(String args[]){
        System.out.println("hello world");
        LL l1 = new LL();
        l1.addFirst(3);
        l1.addFirst(4);
        l1.addFirst(8);
        l1.addLast(7);
        l1.insert_at_an_index_from_last(2,5);
        System.out.println(l1.size());
        System.out.println(l1.search(11));

        l1.print(l1.head);

    }
    
}