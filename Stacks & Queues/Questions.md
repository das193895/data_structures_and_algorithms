
# Questions Count

1. Easy -- 3
2. Medium -- 2
3. Hard -- 0

## Implement Stack using Queue (leetcode - 225) (easy)

```java
class MyStack {

    Queue<Integer> stack;

    public MyStack() {
        this.stack = new LinkedList<>();
    }
    
    public void push(int x) {
        this.stack.add(x);
    }
    
    public int pop() {

        int length = this.stack.size();

        for(int i=1;i<length;i++){
            int ele = this.stack.remove();
            this.stack.add(ele);
        }

        return this.stack.remove();
        
    }
    
    public int top() {

        int length = this.stack.size();

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0;i<length;i++){
            int ele = this.stack.remove();
            arr.add(ele);
        }

        int top = arr.get(arr.size()-1);

        for(int i=0;i<length;i++){
            this.stack.add(arr.get(i));
        }

        return top;
        
    }
    
    public boolean empty() {
        return this.stack.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
```

## Implement Queue Using stack (leetcode - 232) (easy)

```java
class MyQueue {

    Stack<Integer> q ;

    public MyQueue() {

        this.q = new Stack<>();
        
    }
    
    public void push(int x) {

        this.q.push(x);
        
    }
    
    public int pop() {

        Stack<Integer> n_stack = new Stack<>();

        while(!this.q.isEmpty()){
            int ele = this.q.pop();
            n_stack.push(ele);
        }

        int top = n_stack.pop();

        while(!n_stack.isEmpty()){
            int ele = n_stack.pop();
            this.q.push(ele);
        } 

        return top;
    }
    
    public int peek() {

        Stack<Integer> n_stack = new Stack<>();

        while(!this.q.isEmpty()){
            int ele = this.q.pop();
            n_stack.push(ele);
        }

        int top = n_stack.peek();

        while(!n_stack.isEmpty()){
            int ele = n_stack.pop();
            this.q.push(ele);
        } 

        return top;
        
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
```

## Valid Parenthesis (leetcode - 20) (easy)

```java
class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for(int i = 0 ;i<s.length();i++){
            char c = s.charAt(i);

            if(c == '(' || c == '{' || c == '['){
                stack.add(c);
            }else if(c == ')' || c == '}' || c == ']'){
                if(stack.isEmpty() == true){
                    return false;
                }
                char sc = stack.pop();

                if((sc == '(' && c == ')') || (sc == '{' && c == '}') || (sc == '[' && c == ']')){
                    continue;
                }else{
                    return false;
                }
            }
        }

        if(!stack.isEmpty()){
            return false;
        }

        return true;
        
    }
}
```

## Min Stack (leetcode - 155)  (Medium)

```java
class MinStack {

    Stack<int[]> stack;

    public MinStack() {
        this.stack = new Stack<>();  
    }
    
    public void push(int val) {

        int[] arr = new int[2];

        int min = Integer.MAX_VALUE;

        if(this.stack.isEmpty()){
            min = val;
            arr[0] = val;
            arr[1] = min;
            this.stack.push(arr);
            return;
        }

        int min_peek = this.stack.peek()[1];
        min = Math.min(val , min_peek);
        arr[0] = val;
        arr[1] = min;

        this.stack.push(arr);

    }
    
    public void pop() {

        this.stack.pop();
        
    }
    
    public int top() {

        int ele = this.stack.peek()[0];

        return ele;
        
    }
    
    public int getMin() {

        int ele = this.stack.peek()[1];

        return ele;

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```

## Next Greater Element (gfg) (Medium)

```java
class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] nums2, int n)
    { 
        // Your code here
        long[] nge = new long[n];

        Stack<Long> stack = new Stack<>();

        for(int i = n-1;i>=0;i--){
            long ele = nums2[i];

            if(stack.isEmpty()){
                nge[i] = -1L;
            }else{
                while(!stack.isEmpty() && ele >= stack.peek()){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    nge[i] = -1L;
                }else{
                    nge[i] = stack.peek();
                }
                
            }
            stack.push(nums2[i]);
        }
        
        return nge;
    } 
}
```
