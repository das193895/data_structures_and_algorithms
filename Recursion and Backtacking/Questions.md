# Easy 

## Printing n to 1

```java
    public static void print_n(int n){
        if(n < 1){
            return;
        }
        System.out.println(n);
        print_n(n-1);
        
    }
```

## Printing 1 to n

```java
    public static void print_n(int n){
        if(n < 1){
            return;
        }
        print_n(n-1);
        System.out.println(n);
        
    }
```

## calculation of Fibonacci (leetcode -- 509)

```java
    public static int fibonacci(int n){
        if(n == 0){
            return 0;
        }
        
        else if(n == 1){
            return 1;
        }
        
        int first = fibonacci(n-2);
        int second = fibonacci(n-1);
        
        return first+second;
    }
```

## Recursive binary search (leetcode - 704)

```java
class Solution {

     public int search(int[] nums, int target) {

        return recursive_binary_search(nums , 0 , nums.length-1 ,target);
        
    }

    public int recursive_binary_search(int[] arr , int ptr1 , int ptr2 ,int target){
        
        if(ptr1 > ptr2){
            return -1;
        }
        
        int s = ptr1;
        int e = ptr2;
        
        int mid = s + (e-s)/2;
        
        if(arr[mid] == target){
            return mid;
        }
        else if(arr[mid] < target){
            return recursive_binary_search(arr , mid + 1 , ptr2 ,target);
        }
        else{
            return recursive_binary_search(arr , ptr1 , mid-1 ,target);
        }
        
    }
   
}
```

## Sum triangle from array(gfg)

```java
    public static void sum_triangle(ArrayList<Integer> arr){
        if(arr.size() == 0){
            return;
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 1 ; i<arr.size();i++){
            list.add(arr.get(i) + arr.get(i-1));
        }
        
        sum_triangle(list);
        
        for(int i = 0 ; i<arr.size();i++){
            System.out.print(arr.get(i)+" ");
        }
        System.out.println();
    }
    
```

## Reverse Array Recursively (leetcode -- 344)

```java
class Solution {

    public void reverse_helper(char[] s , int ptr1 , int ptr2){
        if(ptr1 > ptr2){
            return;
        }

        char temp = s[ptr1];
        s[ptr1] = s[ptr2];
        s[ptr2] = temp; 

        ptr1 = ptr1 + 1;
        ptr2 = ptr2 - 1; 

        reverse_helper(s,ptr1,ptr2);
    }
    public void reverseString(char[] s) {

        reverse_helper(s,0,s.length-1);
        
    }
}
```