## Deleting a node if the node itself given as a parameter

Here we just have to replace the data of the next node of the given node with the given node and point the node to the node after the next node of the given node.Here we do not delete the node in memmory but just replace the values and transfer the pointer.

It will not work if the given node is the "tail node".

```java
    public void deleteNode(Node node){
        node.data = node.next.data;
        node.next = node.next.next;
    }
```

## Nth node from the end (By one traversal)

1.take pointers slow and fast pointing to head.

2.move the "fast" pointer to N places forward.

3.then with the help of the loop march the slow and fast pointer one place at a time till the "fast' pointer is null.

```java
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
```

## Deleting Nth node from the end

1.take pointers slow and fast pointing to head.

2.move the "fast" pointer to N places forward.

3.then with the help of the loop march the slow and fast pointer one place at a time till the "fast.next" pointer is null.

4.The we can see that our slow pointer is pointing to the node just before the "required node".Then we can just point slow.next pointer to slow.next.next.

```java
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

```