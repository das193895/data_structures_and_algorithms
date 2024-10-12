# Questions Count

1. Easy -- 1
2. Medium -- 3
3. Hard -- 


## Fibonacci Number (leetcode - 509)

```java
class Solution {
    public int fib(int n) {
        if(n <= 1){
            return n;
        }
        
        return (fib(n-1) + fib(n-2));
    }
}
```
## Pow (x , n)  (leetcode - 50) (medium)

```java
class Solution {
    public double myPow(double x, int n) {
        if(n < 0){
            double denominator = helper(x,n*-1);
            return 1/denominator;
        }
        else{
            return helper(x,n);
        }
    }

    public double helper(double x , int n){
        if(n == 0){
            return 1;
        }

        double half = helper(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
```

## Reversing A stack Using recursion (gfg) (medium)

```java
class Solution
{   
    static void pushAtBottom(Stack<Integer> s,int data){
        
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        
        int top = s.pop();
        
        pushAtBottom(s,data);
        
        s.push(top);
        
    }
    static void reverse(Stack<Integer> s)
    {
        // add your code here
        
        if(s.isEmpty()){
            return;
        }
        
        int top = s.pop();
        
        reverse(s);
        
        pushAtBottom(s,top);
    }
}
```

## Sort A stack (gfg) (Medium)

```java
class GfG {
    public void insert(Stack<Integer> s , int num){
        if(s.isEmpty() || (!s.isEmpty() && num > s.peek())){
            s.push(num);
            return;
        }
        
        int top = s.pop();
        insert(s,num);
        s.push(top);

    }
    
    public void sortHelper(Stack<Integer> s) {
        // add code here.
        if(s.isEmpty()){
            return;
        }
        
        int top = s.pop();
        sort(s);
        insert(s , top);
        
    }
    
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        sortHelper(s);
        
        return s;
    }
}
```