
# Singly LinkedLists

## Array to LinkedList (gfg) (Easy)

```java
class Solution {
    static Node constructLL(int arr[]) {
        // code here
        if(arr.length == 0){
            return null;
        }
        
        Node head = new Node(arr[0]);
        
        Node temp = head;
        
        for(int i = 1 ; i < arr.length ; i++){
            Node node = new Node(arr[i]);
            temp.next = node;
            temp = temp.next;
        }
        
        return head;
    }
}
```
## Count LinkedList Nodes (gfg) (Easy)

```java
class Solution {
    // Function to count nodes of a linked list.
    public int getCount(Node head) {
        // code here
        
        if(head == null){
            return 0;
        }
        
        int ct = 0;
        
        Node temp = head;
        
        while(temp != null){
            ct = ct + 1;
            temp = temp.next;
        }
        
        return ct;
    }
}
```

## Search in LinkedList (gfg) (easy)

```java
class Solution {
    static boolean searchKey(int n, Node head, int key) {
        // Code here
        if(head == null){
            return false;
        }
        
        Node temp = head;
        while(temp != null){
            if(temp.data == key){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}
```
## Node at a given index in linkedlist (gfg) (easy)

```java
class Solution {
    public int GetNth(Node head, int index) {
        // Code here
        if(head == null){
            return -1;
        }
        
        Node temp = head;
        int ct = 0;
        
        while(temp != null){
            ct = ct + 1;
            if(ct == index){
                return temp.data;
            }
            
            temp = temp.next;
        }
        
        return -1;
    }
}
```

## Kth from the end of the linkedlist (gfg) (easy)

```java
class Solution {

    // Function to find the data of kth node from
    // the end of a linked list.
    
    int countLength(Node head){
        if(head == null){
            return 0;
        }
        
        Node temp = head;
        int ct = 0;
        
        while(temp != null){
            ct = ct + 1;
            temp = temp.next;
        }
        
        return ct;
    }
    int getKthFromLast(Node head, int k) {
        // Your code here
        
        if(head == null){
            return -1;
        }
        
        int length = countLength(head);
        
        int newIdx = length - k + 1;
        
        if(newIdx < 1 || newIdx > length){
            return -1;
        }
        
        Node temp = head;
        int ct = 0;
        
        while(temp != null){
            ct = ct + 1;
            if(ct == newIdx){
                return temp.data;
            }
            temp = temp.next;
        }
        
        return -1;
    }
}
```

## Deleting a node in a singly LinkeList (gfg) (easy)

```java
class Solution {
    Node deleteNode(Node head, int x) {
        // code here
        if(head == null){
            return null;
        }
        
        if(head.next == null){
            head = null;
            return head;
        }
        
        if(x == 1){
            Node temp = head;
            head = temp.next;
            temp.next = null;
            return head;
        }
        
        int ct = 0;
        Node temp = head;
        Node prev = null;
        
        while(temp != null){
            ct = ct + 1;
            
            if(ct == x){
                prev.next = prev.next.next;
            }
            
            prev = temp;
            temp = temp.next;
        }
        
        return head;
    }
}
```

## Remove Nth Node from the end of the linkedlist (leetcode - 19) (Medium)

```java
class Solution {

    public int length(ListNode head){
        if(head == null){
            return 0;
        }

        ListNode temp = head;
        int ct = 0;

        while(temp != null){
            ct = ct + 1;
            temp = temp.next;
        }

        return ct;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null){
            return head;
        }

        int size = length(head);

        int new_n = size - n + 1;

        if(new_n < 1 || new_n > size){
            return head;
        }

        if(new_n == 1){
            head = head.next;
            return head;
        }

        int ct = 0;
        ListNode temp = head;
        ListNode prev = null;

        while(temp != null){
            ct = ct + 1;
            if(ct == new_n){
                prev.next = prev.next.next;
                temp = prev.next;
            }else{
                prev = temp;
                temp = temp.next;
            }
        }

        return head;
        
    }
}
```

## Reversing a linkedList (gfg) (leetcode - 206) (easy)

```java
class Solution {
    // Function to reverse a linked list.
    Node reverseList(Node head) {
        // code here
        
        if(head == null || head.next == null){
            return head;
        }
        
        Node curr = head;
        Node prev = null;
        Node temp = null;
        
        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        head = prev;
        return prev;
    }
}
```

## Add 2 numbers (leetcode - 2) (Medium)

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyhead = new ListNode(-1);

        ListNode temp = dummyhead;

        ListNode ptr1 = l1;
        ListNode ptr2 = l2;

        int carry = 0;

        while(ptr1 != null || ptr2 != null){

            int data1 = 0;
            int data2 = 0;
            
            if(ptr1 != null){
                data1 = ptr1.val;
            }

            if(ptr2 != null){
                data2 = ptr2.val;
            }

            int total = data1 + data2 + carry;

            int add = total % 10;
            carry = total/10;

            ListNode node = new ListNode(add);

            temp.next = node;

            temp = temp.next;

            if(ptr1 != null){
                ptr1 = ptr1.next;
            }

            if(ptr2 != null){
                ptr2 = ptr2.next;
            }
        }

        if(carry != 0){
            ListNode node = new ListNode(carry);
            temp.next = node;
        }

        return dummyhead.next;

    }
}
```

## Intersection Point of 2 linkedlists (leetcode - 160)

```java
public class Solution {

     public int size(ListNode h){
            if(h == null){
                return 0;
            }

            ListNode temp = h;
            int i = 0;
            while(temp !=  null){
                i++;
                temp = temp.next;
            }

            return i;
        }
    public ListNode getIntersectionNode(ListNode h1, ListNode h2) {

         // h1 and h2 are pointing towords the head of the two linked lists
        if((h1 == null && h2 == null) || (h1 == null || h2 == null)){
            return null;
        }

        ListNode temp1 = h1;
        ListNode temp2 = h2;

        int size1 = size(h1);
        int size2 = size(h2);

        int d = Math.abs(size2-size1);

        ListNode required = null;

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
                return temp1;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return null;
        
    }
}
```
# Doubly LinkedLists

## Array to Doubly LinkedLists

```java
class Solution {
    Node constructDLL(int arr[]) {
        // Code here
        if(arr.length == 0){
            return null;
        }
        
        Node head = new Node(arr[0]);
        
        Node temp = head;
        
        for(int i = 1;i<arr.length;i++){
            Node node = new Node(arr[i]);
            temp.next = node;
            node.prev = temp;
            temp = temp.next;
        }
        
        return head;
    }
}
```

## Delete Node from an index in a doubly LinkedLists 

```java
class Solution {
    public Node deleteNode(Node head, int x) {
        // code here
        
        if(head == null){
            return null;
        }
        
        if(x == 1){
            Node temp = head.next;
            head.next = null;
            head = temp;
            head.prev = null;
            return head;
        }
        
        Node temp = head;
        
        int ct = 0;
        
        while(temp != null){
            ct += 1;
            if(ct == x){
                Node pre = temp.prev;
                Node ne = temp.next;
                pre.next = ne;
                if(ne != null){
                    ne.prev = pre;
                }
                temp.next = null;
                temp.prev = null;
                break;
            }
            temp = temp.next;
        }
        
        return head;
    }
}

```

## Reverse a doubly LinkedList (gfg) (easy)

```java
class Solution {
    public DLLNode reverseDLL(DLLNode head) {
        // Your code here
        
        if(head == null || head.next == null){
            return head;
        }
        
        DLLNode prev = null;
        DLLNode curr = head;
        // DLLNode next = null;
        
        while(curr != null){
           prev = curr.prev;
           curr.prev = curr.next;
           curr.next = prev;
           curr = curr.prev;
        }
        
        head = prev.prev;
        
        return head;
    }
}
```