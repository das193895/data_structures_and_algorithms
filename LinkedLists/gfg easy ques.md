## Finding the middle element of a linckedlist

```java
class Solution
{
    int getMiddle(Node head)
    {
         // Your code here.
         if(head == null){
             return -1;
         }
         
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null){  // not -- (fast.ext != null && fast != null)
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow.data;
    }
}
```

## Occurance of a perticular element 

```java
class Solution
{
    public static int count(Node head, int search_for)
    {
        //code here
        
        int count = 0;
        
        Node temp = head;
        
        while(temp != null){
            
            if(temp.data == search_for){
                count++;
            }
            
            temp = temp.next;
            
        }
        
        return count;
    }
}
```

## Check if a linkedlist is circular or not

```java
class GfG
{
    boolean isCircular(Node head)
    {
	// Your code here	
	
	if(head == null){
	    return true;
	}
	
	if(head.next == null){
	    return false;
	}
	
	Node fast = head;
	while(fast != null && fast.next != null){
	    
	    fast = fast.next.next;
	    
	    if(fast == head){
	        return true;
	    }
	    
	}
	
	return false;
	
    }
}
```

## Counting number of nodes in a Circular linkedlist

```java
class GfG
{
    int count_circular(Node head)
    {
	// Your code here	
	
	if(head == null){
	    return 0;
	}
	
    int count = 1;
	Node temp = head.next;
	while(temp != head){

        temp = temp.next;
        count++;
	    
	}
	
	return count;
	
    }
}


```

## Converting a singly linkedlist to a circular linked list 

```java
class GfG
{
    Node create_circular(Node head)
    {
	// Your code here	
	
	if(head == null){
	    return head;
	}
	
	Node temp = head;
	while(temp.next != null){

        temp = temp.next;
	    
	}

    temp.next = head;

    return head;
	
    }
}
```

## Exchange first node and last node in a circular linkedlist

```java
class GfG
{
    Node exchange_nodes(Node head)
    {
	// Your code here	
	
	if(head == null || head.next == null){
	    return head;
	}

    if(head.next.next == head){
        head = head.next;
    }

    // find the last and second last node of the circular linkedlist

	Node temp = head;
	while(temp.next.next != head){

        temp = temp.next;
	    
	}

    Node last_node = temp.next;
    Node second_last_node = temp;

    // doing the exchange operation

    last_node.next = last_node.next.next;
    head.next = last_node;
    second_last_node.next = head;
    head = head.next; 

    return head;
	
    }
}
```

## Reversing a doubly linkedlist

### Can we reverse a simple singly linked list in O(n) ---> NO

## Traversal of a circular linkedlist --- just do normally with changed condition

