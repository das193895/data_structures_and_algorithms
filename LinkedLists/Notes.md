# The Node class in LinkedLists

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

# Displaying a linkedlist

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

## Insertion after a given node

```java
public void insert_after_a_given_node(Node lastNode,int newdata){

    if(lastNode == null){
        System.out.println("the given node is null");
    }

    Node node = new Node(newdata); // forming a new node with the given value

    node.next = lastNode.next; // Make next of new Node as next of lastNode

    lastNode.next = node; // make next of lastNode as new_node

}
```

## Insertion at an index

```java
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
```

## Insertion at an index from the last

```java
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

```

# Searching an element 

```java
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

```

# Deletion in linkedlist

## Deleting the first node

```java
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
```

## Deleting the last node

```java
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
```

## deleting the node at an index

```java
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
```
