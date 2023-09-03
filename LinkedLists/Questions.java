package LinkedLists;

import LinkedLists.LinkedLists_basics.LL;
import LinkedLists.LinkedLists_basics.Node;

public class Questions {

    public static void deleteNode(Node node){
        node.data = node.next.data;
        node.next = node.next.next;
    }

    public static int Nth_node_from_end(int n){
        if(LL.head == null){
            System.out.println("The linked list is empty");
            return Integer.MAX_VALUE;
        }

        Node slow = LL.head;
        Node fast = LL.head;

        for(int i = 0;i<n;i++){
            fast = fast.next;  
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        return slow.data;

    }

    public static int delete_Nth_node_from_end(int n){

        if(LL.head == null){
            System.out.println("The linked list is empty");
            return Integer.MAX_VALUE;
        }

        Node slow = LL.head;
        Node fast = LL.head;

        for(int i = 0;i<n;i++){
            fast = fast.next;  
        }

        if(fast == null){  // we have to delete the "head" node
            int val = LL.head.data;
            LL.head = LL.head.next;
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

        int size1 = LL.size(h1);
        int size2 = LL.size(h2);

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



    public static void main(String[] args) {
         LL l2 = new LL();
         LL l1 = new LL();

        // Questions q = new Questions();

        l2.addFirst(4);
        l2.addLast(6);
        l2.addLast(8);
        l2.addLast(9);
        l2.addLast(10);

        

        l1.addLast(55);
        l1.addLast(67);
        l1.addLast(89);
        Node i = l2.head.next.next;
        l1.head.next = i;



        l2.print(l2.head);

       
        // l2.print(LL.head);
    }
    
}
