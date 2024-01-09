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