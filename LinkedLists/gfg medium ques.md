## Detecting loop in a linkedlist

```java
class Solution {
    // use hashmap for storing the previous data
    //Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head){
        // Add code here
        
        Node temp = head;
        
        Map<Node,Integer> hashmap = new HashMap<>();
        
        while(temp != null){
            
            if(hashmap.containsKey(temp)){
                return true;
            }
            
            hashmap.put(temp,1);
            
            temp = temp.next;
        }
        
        return false;
        
    }
}
```


## Counting the length of a loop in a linkedlist

```java
class Solution
{
    
    // Use hashmap and use (address,timer) as key,value pairs
    //Function to find the length of a loop in the linked list.
    static int countNodesinLoop(Node head)
    {
        //Add your code here.
        
        if(head == null || head.next == null){
            return 0;
        }
        
       Node temp = head;
       
       int timer = 0;
       
       Map<Node,Integer> hash = new HashMap<>();
       
       while(temp != null){
           
           if(hash.containsKey(temp)){
              int time_now = timer;
              
              int previous_time = hash.get(temp);
              
              return (time_now - previous_time);
           }
           
           hash.put(temp,timer++);
           
           temp = temp.next;
       }
       
       return 0;
    }
}
```

## Remove dupicates from a linkedlist

```java
class GfG
{
    //Function to remove duplicates from sorted linked list.
    Node removeDuplicates(Node head)
    {
	// Your code here	
	if(head == null || head.next == null){
	    return head;
	}
	
	Node temp = head;
	
	Map<Integer,Integer> hash = new HashMap<>();
	
	hash.put(head.data,1);
	
	while(temp.next != null){
	    if(hash.containsKey(temp.next.data)){
	        Node temp_s = temp.next;
	        
	        int repeated_var = temp.next.data;
	        
	         while(temp_s.data == repeated_var){
	                
	                 temp_s = temp_s.next;
	                 
	                 if(temp_s == null){
	                     break;
	                 }
	         }
	        
	        temp.next = temp_s;
	    }
	    
	    if(temp.next != null){
	         hash.put(temp.next.data,1);
	         temp = temp.next;
	    }
	 
	}
	
	return head;
	
    }
}

```

## Intersection of two sorted linkedlists

```java
class Solution   // use 2 pointer approach
{
   public static Node findIntersection(Node head1, Node head2)
    {
        // code here.
        
       Node head = new Node(1);
       Node ptr3 = head;
       
       Node ptr1 = head1;
       Node ptr2 = head2;
       
       while(ptr1 != null && ptr2 != null){
           
           if(ptr1.data == ptr2.data){
               ptr3.next = new Node(ptr1.data);
               ptr3 = ptr3.next;
               
               ptr1 = ptr1.next;
               ptr2 = ptr2.next;
           }
           
           else if(ptr1.data < ptr2.data){
               ptr1 = ptr1.next;
           }
           
           else if(ptr1.data > ptr2.data){
               ptr2 = ptr2.next;
           }
       }
       
       head = head.next;
       
        return head;
    }
}
```

## Splitting a circular linkedlist into 2 halves (The 2 halves shoul be circular lists)

```java
class gfg
{
        // Function  to split a circular LinkedList
	    void splitList(circular_LinkedList list)
        {
             //DO NOT REMOVE THESE 3 LINES
             Node head=list.head;
             Node head1=null;
             Node head2=null;
             
             //Modify these head1 and head2 here, head is the starting point of our original linked list.
             
              Node slow = head;
             Node fast = head;
             
               while(fast.next != head && fast.next.next != head){
                 slow = slow.next;
                 fast = fast.next.next;
             }
             
             if(fast.next.next == head){
                 head2 = slow.next;
                 slow.next = head;
                 head1 = head;
                 fast.next.next = head2;
             }
             
             else if(fast.next == head){
                 head2 = slow.next;
                 slow.next = head;
                 head1 = head;
                 fast.next = head2;
             }
             
             
             //DO NOT REMOVE THESE 2 LINES
             list.head1=head1;
             list.head2=head2;
             
            
	 }
}
```