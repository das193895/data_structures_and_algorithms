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

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        int val = slow.next.data;

        slow.next = slow.next.next;

        return val;

    }

    public static void main(String[] args) {
         LL l2 = new LL();

        // Questions q = new Questions();

        l2.addFirst(4);
        l2.addLast(6);
        l2.addLast(8);
        l2.addLast(9);
        l2.addLast(10);

        l2.print(LL.head);

        System.out.println(delete_Nth_node_from_end(3));
        l2.print(LL.head);
    }
    
}
