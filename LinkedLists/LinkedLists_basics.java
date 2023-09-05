package LinkedLists;



public class LinkedLists_basics{

    public static class Node{
        int data;
        Node next;

        public Node(int newdata){ // the constructor
            this.data = newdata;
            this.next = null;
        }
    }



    public static class LL{


        public static Node head;

        public static Node tail;

        public static void print(Node h){
            if(h == null){
                System.out.println("there is no existing linkedlist");
                return;
            }

            Node temp = h;
            while(temp != null){
                System.out.print(temp.data+"--> ");
                temp = temp.next;
            }
            System.out.println("null");
        }

        public static int size(Node h){
            if(h == null){
                return 0;
            }

            Node temp = h;
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

        public  void addLast(int newdata){

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

        public int deleteFirst(){
            if(head == null){
                System.out.println("the linked list is empty");
                return Integer.MAX_VALUE;
            }

            Node temp = head;

            int val = temp.data;

            head = head.next;

            temp.next = null;

            return val;
        }

        public int deleteLast(){
            
            if(head == null){
                System.out.println("the linked list is empty");
                return Integer.MAX_VALUE;
            }

            int val = tail.data;

            Node temp = head;

            while(temp.next.next != null){
                temp = temp.next;
            }

            temp.next = null;

            tail = temp;

            return val;
        }

        public int delete_at_an_index(int idx){  //zero based indexing

            if(head == null){
                System.out.println("the linked list is empty");
                return Integer.MAX_VALUE;
            }

            if(idx == 0){
                int val = deleteFirst();
                return val;
            }

            int i = 0;
            Node temp = head;

            while(i < idx-1){
                temp = temp.next;
                i++;
            }

            int val = temp.next.data;

            temp.next = temp.next.next;

            return val;

        }

        public int Nth_node(int idx){  // zero based indexing

            if(head == null){
                System.out.println("the linked list is empty");
                return Integer.MAX_VALUE;
            }

            if(idx == 0){
                return head.data;
            }

            int i = 0;
            Node temp = head;

            while(i<idx){
                temp = temp.next;
                i++;
            }

            int val = temp.data;

            return val;

        }

        public int Nth_node_from_end(int idx){  // 1 based indexing from the end
            
            if(head == null){
                System.out.println("linkedlist is empty");
                return Integer.MAX_VALUE;
            }

            if(idx == 0){
                System.out.println("one based indexing is followed so idx can't be zero");
                return Integer.MAX_VALUE;
            }

            if(idx == 1){
                return tail.data;
            }

            int i = 0;
            Node temp = head;

            while(i < size(head)-idx){
                temp = temp.next;
                i++;
            }

            return temp.data;


        }



        /****************************************************************** */


        public class Questions{

            public static void deleteNode(Node node){
            node.data = node.next.data;
            node.next = node.next.next;
        }
    
        public static int Nth_node_from_end_2(int n){
            if(LL.head == null){
                System.out.println("The linked list is empty");
                return Integer.MAX_VALUE;
            }
    
            Node slow = head;
            Node fast = head;
    
            for(int i = 0;i<n;i++){
                fast = fast.next;  
            }
    
            while(fast != null){
                slow = slow.next;
                fast = fast.next;
            }
    
            return slow.data;
    
        }
    
        public static  int delete_Nth_node_from_end(int n){
    
            if(head == null){
                System.out.println("The linked list is empty");
                return Integer.MAX_VALUE;
            }
    
            Node slow = head;
            Node fast = head;
    
            for(int i = 0;i<n;i++){
                fast = fast.next;  
            }
    
            if(fast == null){  // we have to delete the "head" node
                int val = head.data;
                head = head.next;
                slow.next = null;
                return val;
            }
    
            while(fast.next != null){
                slow = slow.next;
                fast = fast.next;
            }
    
            int val = slow.next.data;
    
            slow.next = slow.next.next;
    
            return val;
    
        }
    
        public static int intersecting_Node(Node h1,Node h2){
            // h1 and h2 are pointing towords the head of the two linked lists
            if((h1 == null && h2 == null) || (h1 == null || h2 == null)){
                return -1;
            }
    
            Node temp1 = h1;
            Node temp2 = h2;
    
            int size1 = size(h1);
            int size2 = size(h2);
    
            int d = Math.abs(size2-size1);
    
            Node required = null;
    
            if(size2 > size1){
                required = h2;
            }
            else if(size2 < size1){
                required = h1;
            }
            else{
                required = h1;
            }
    
    
            if(required == h1){
                for(int i = 0;i < d;i++){
                    temp1 = temp1.next;
                }
            }else{
                for(int i = 0;i < d;i++){
                    temp2 = temp2.next;
                }
            }
    
            while(temp1 != null || temp2 != null){
                if(temp1 == temp2){
                    return temp1.data;
                }
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
    
            return -1;
        }
    
        public static int middle_element(Node H){
            if(H == null){
                System.out.println("The linked list is empty");
                return Integer.MAX_VALUE;
            }
    
            Node slow = H;
            Node fast = H;
    
            while(fast != null){
    
                if(fast.next == null){
                    break;
                }
    
                slow = slow.next;
                fast = fast.next.next;
    
            }
    
            return slow.data;
        }
    
    
        public static int delete_middle(Node H){
            if(H == null){
                System.out.println("The linked list is empty");
                return Integer.MAX_VALUE;
            }
    
            Node slow = H;
            Node fast = H;
            Node prev_to_slow = H;
    
            while(fast != null){
    
    
                if(fast.next == null){
                    break;
                }
    
                if(slow == H.next){
                    prev_to_slow = prev_to_slow.next;
                }
    
                slow = slow.next;
                fast = fast.next.next;
    
            }
    
            int val = slow.data;
    
            prev_to_slow.next = prev_to_slow.next.next;
    
            return val;
    
        }
    
        public static boolean detect_cycle(Node H){
            if(H == null || H.next == null){
                System.out.println("The linked list is empty");
                return false;
            }
    
            Node slow = H;
            Node fast = H;
    
            while(fast != null && fast.next != null){
    
                slow = slow.next;
                fast = fast.next.next;
    
                if(slow == fast && slow!=H){
                    return true;
                }
    
            }
    
            return false;
        }
    
        public static Node merge(Node H1,Node H2){
    
            if(H1 == null && H2 == null){
                return null;
            }
    
            if(H1 == null || H2 == null){
                if(H1 == null){
                    return H2;
                }
                else{
                    return H1;
                }
            }
    
            LL new_linkedlist = new LL(); // making a new linkedlist
    
            Node ptr1 = H1;
            Node ptr2 = H2;
    
            while(ptr1 != null || ptr2 != null){
    
                if(ptr1.data <= ptr2.data){
                    new_linkedlist.addLast(ptr1.data);
                    ptr1 = ptr1.next;
                }
                else{
                    new_linkedlist.addLast(ptr2.data);
                    ptr2 = ptr2.next;
                }
            }
    
            while(ptr1 != null){
                new_linkedlist.addLast(ptr1.data);
                ptr1 = ptr1.next;       
            }
    
            while(ptr2 != null){
                new_linkedlist.addLast(ptr2.data);
                ptr2 = ptr2.next;       
            }
    
            return new_linkedlist.head;
        }



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

        l1.print(LL.head);
        // System.out.println(l1.size());

        System.out.println(l1.Nth_node_from_end(5));

      


    }
    
}