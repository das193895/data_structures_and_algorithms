## The Node class in LinkedLists

``` java
 public class Node{
        int data;
        Node next;

        public Node(int newdata){ // the constructor
            this.data = newdata;
            this.next = null;
        }
    }

```

## Displaying a linkedlist

```java
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
```

# Insertions in LinkedList

## Insertion at the beginning

``` java
public void addFirst(int newdata){

        Node node = new Node(newdata); // forming a new node with the given value

        node.next = head; // marking the current head as the next of the new node 

        head = node; //eventually making the new node as the new head of the linkedlist
            
    }

```

## insertion at the end

```java

public void addLast(int newdata){

        node node = new Node(newdata);  // forming a new node with the given value

        tail.next = node; // marking the new node as the next of the current tail

        tail = node; // eventually making the new node as the new tail of the linkedlist
 
}
```
