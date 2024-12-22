
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

## Next greater element-II (leetcode - 503) (Medium)

```java
class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int[] nge = new int[nums.length];

        Stack<Integer> s = new Stack<>();

        int upper_bound = 2 * nums.length - 1;

        for(int i = upper_bound;i >= 0;i--){

            while(!s.isEmpty() && s.peek() <= nums[i%nums.length]){
                s.pop();
            }

            if(i < nums.length){
                if(s.isEmpty()){
                    nge[i] = -1;
                }
                else{
                    nge[i] = s.peek();
                }
            }
            s.push(nums[i%nums.length]);
        }
        return nge;
    }
}
```

## Previous smaller element  (gfg) (Medium)

```java
class Solution{
    static List<Integer> leftSmaller(int n, int a[])
    {
        //code here
        
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0;i<n;i++){
            result.add(0);
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0;i<n;i++){
            
            int current_element = a[i];
            int current_idx = i;
            
            while(!stack.isEmpty() && stack.peek() >= current_element){
                stack.pop();
            }
            
            if(stack.isEmpty()){
                int nge = -1;
                result.set(current_idx , nge);
            }else{
                int nge = stack.peek();
                result.set(current_idx , nge);
            }
            
            stack.add(current_element);
        }
        
        return result;
    }
}
```

## Sum of subarray minimum (leetcode - 907)

```java
class Solution {
    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;

        int mod = (int)(1e9 + 7);

        ArrayList<Integer> nsi = next_smaller_idx(arr);
        ArrayList<Integer> psi = previous_smaller_idx(arr);  

        long sum = 0;

        for(int i = 0;i<n;i++){

            int element = arr[i];
            int nsiOfElement = nsi.get(i);
            int psiOfElement = psi.get(i);

            sum = (sum + (long) element * (nsiOfElement - i) * (i - psiOfElement) % mod) % mod;
        }

        return (int)sum;

    }

    public ArrayList<Integer> next_smaller_idx(int[] arr){

        int n = arr.length;

        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0;i<n;i++){
            result.add(0);
        }

        Stack<Integer> stack = new Stack<>();

        for(int i = n-1;i>=0;i--){

            int current_element = arr[i];
            int current_idx = i;

            while(!stack.isEmpty() && current_element <= arr[stack.peek()]){
                stack.pop();
            }

            if(stack.isEmpty()){
                result.set(i,n);
            }else{
                result.set(i,stack.peek());
            }

            stack.add(i);
        }

        return result;
        
    }

    // find previous smaller or equal element for edge cases

    public ArrayList<Integer> previous_smaller_idx(int[] arr){

        int n = arr.length;

        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0;i<n;i++){
            result.add(0);
        }

        Stack<Integer> stack = new Stack<>();

        for(int i = 0;i < n;i++){

            int current_element = arr[i];
            int current_idx = i;

            while(!stack.isEmpty() && current_element < arr[stack.peek()]){  // here equal sign should no be there because we might encounter duplicate elements
                stack.pop();
            }

            if(stack.isEmpty()){
                result.set(i,-1);
            }else{
                result.set(i,stack.peek());
            }

            stack.add(i);
        }

        return result;

    }
}
```

## Asteroid Collision (leetcode - 735) (Medium)

```java
class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        int n = asteroids.length;
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		while(true){
			if(i >= n){
				break;
            }
            int current_element = asteroids[i];
            if(stack.isEmpty()){
                stack.add(current_element);
                i += 1;
            }else{

                if(current_element*stack.peek() > 0){
                    stack.add(current_element);
                    i += 1;
                }

                else if(current_element < 0 && stack.peek() > 0){
                    if(Math.abs(current_element) == Math.abs(stack.peek())){
                        stack.pop();
                        i += 1;
                    }else if(Math.abs(current_element) < Math.abs(stack.peek())){
                        i += 1;
                    }else{
                        stack.pop();
                    }
                }

                else{
                    stack.add(current_element);
                    i += 1;
                }

            }

        }

        int[] arr = new int[stack.size()];
        int j = arr.length-1;

        while(!stack.isEmpty()){

            arr[j] = stack.pop();
            j-=1; 
        }

        return arr;

    }
}
```

## Largest Rectangle in a histogram (leetcode - 84) (Hard)

```java
class Solution {
    public int largestRectangleArea(int[] heights) {

        ArrayList<Integer> nsi = nextSmalleridx(heights);
        ArrayList<Integer> psi = previousSmalleridx(heights);

        int max = Integer.MIN_VALUE;

        for(int i = 0;i<heights.length;i++){

            int current_area = heights[i]*(nsi.get(i)-psi.get(i)-1);
            max = Math.max(max , current_area);
        }

        return max;
        
    }

    public ArrayList<Integer> nextSmalleridx(int[] arr){

        int n = arr.length;

        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0;i<n;i++){
            result.add(-23);
        }

        Stack<Integer> stack = new Stack<>();

        for(int i = n-1;i>=0;i--){
            int current_element = arr[i];
            int current_idx = i;

            while(!stack.isEmpty() && arr[stack.peek()] >= current_element){
                stack.pop();
            }

            if(stack.isEmpty()){
                int nsi = n;
                result.set(current_idx , nsi);
            }else{
                int nsi = stack.peek();
                result.set(current_idx , nsi);
            }

            stack.add(current_idx);
        }

        return result;

    }

    public ArrayList<Integer> previousSmalleridx(int[] arr){
          int n = arr.length;

        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0;i<n;i++){
            result.add(-23);
        }

        Stack<Integer> stack = new Stack<>();

        for(int i = 0;i<n;i++){
            int current_element = arr[i];
            int current_idx = i;

            while(!stack.isEmpty() && arr[stack.peek()] >= current_element){
                stack.pop();
            }

            if(stack.isEmpty()){
                int nsi = -1;
                result.set(current_idx , nsi);
            }else{
                int nsi = stack.peek();
                result.set(current_idx , nsi);
            }

            stack.add(current_idx);
        }

        return result;
    }
}
```

## Remove k digits (leetcode - 402) (Medium)

```java
class Solution {
    public String removeKdigits(String num, int k) {

        Stack<Integer> stack = new Stack<>();

        for(int i = 0;i<num.length();i++){

            int current_element = Character.getNumericValue(num.charAt(i));

            while(!stack.isEmpty() && stack.peek() > current_element){
                if(k == 0){
                    break;
                }else{
                    stack.pop();
                    k -= 1;
                }
            }

            stack.add(current_element);
        }

        // an edge case
        while(k != 0){
            stack.pop();
            k -= 1;
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        // an edge case
        while(sb.length() != 0 && sb.charAt(sb.length()-1) == '0'){
            sb.deleteCharAt(sb.length()-1);
        }

        // an edge case
        if(sb.length() == 0){
            sb.append('0');
        }

        return sb.reverse().toString();
        
    }
}
```
