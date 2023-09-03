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

4.check if the "fast" node is pointing to null or not.If it is pointing to null the we just have to delete the "head" node,

5.The we can see that our slow pointer is pointing to the node just before the "required node".Then we can just point slow.next pointer to slow.next.next.

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

```

## Intersecting node of two linkedlists

Given the heads of two singly linked-lists headA and headB, return the value of the node at which
the two lists intersect. If the two linked lists have no intersection at all, return -1.Note: the values in each
node are distinct.

Steps:

1.find the difference in sizes of the 2 linked lists (let difference = d) and take 2 pointers pointing to the heads of the both the linked lists.

2.Take the the pointer of the bigger list to d places forward.

3. And the with a while loop traverse the two linked lists simultaneously with the two pointers and find the intersection point and if there is no intersection point then simply return -1.

```java
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

```
