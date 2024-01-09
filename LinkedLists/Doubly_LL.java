package LinkedLists;

class Node{
    int data;
    Node next;
    Node prev;

    public Node(int newdata){
        this.data = newdata;
        this.next = null;
        this.prev = null;
    }
}

public class Doubly_LL{

    public Node head;

    // printing a doubly linked list

    public void print(){
        if(head == null){
            return;
        }

        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();

    }

    // forming a doubly linkedlist from an array

    public void form_dll(int arr[]){
        Node newnode = new Node(arr[0]);
        head = newnode;
        // System.out.println(head.data);

        Node previous = head;
        // System.out.println(previous.data);
        for(int i = 1;i<arr.length-1;i++){
            // System.out.println(i);
            Node new_node = new Node(arr[i]);

            
            
            new_node.prev = previous;
            previous.next = newnode;
            previous = previous.next;

            System.out.println(head.next.data);

            // System.out.println(new_node.next);
        }

        // System.out.println(head.next.data+"head");
    }


    public static void main(String args[]){
        System.out.println("hello world");

        Doubly_LL list = new Doubly_LL();

        int arr[] = {1,2,3,4,5,6};

        list.form_dll(arr);

        // System.out.println(list.head.next.next.data);

        // list.print();



    }

}
