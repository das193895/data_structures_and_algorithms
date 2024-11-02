# Questions Count

1. Easy - 4
2. Medium - 1
3. Hard -

# Questions

## Implementations Of heap

## The Heapify Function (easy)

(for maxheap)
```java
void Heapify(int N , int arr[] , int idx){
        int largest = idx;
        int left_child_idx = 2*largest + 1;
        int right_child_idx = 2*largest + 2;
        
        if(left_child_idx < N && arr[largest] < arr[left_child_idx]){
            largest = left_child_idx;
        }
        
        if(right_child_idx < N && arr[largest] < arr[right_child_idx]){
            largest = right_child_idx;
        }
        
        if(largest != idx){
            int temp = arr[idx];
            arr[idx] = arr[largest];
            arr[largest] = temp;
            Heapify(N , arr , largest);
        }
    }
```
 
## Does array represent a Max heap (gfg) (easy)

```java
class Solution {
    
    public boolean countSub(long arr[], long n)
    {   
        boolean flag = true;
        
        for(int i = 0;i<arr.length;i++){
            
            int left_child_ptr = (2*i) + 1;
            
            int right_child_ptr = (2*i) + 2;
            
            if(left_child_ptr < n){
                 if(arr[i] < arr[left_child_ptr]){
                     flag = false;
                 }
            }
            
            else if(right_child_ptr < n){
                if(arr[i] < arr[right_child_ptr]){
                     flag = false;
                 }
            }
        }
        
        return flag;
    }
}
```

## Converting Min heap to max heap (gfg) (Medium)

(O(n) -- think why?)
can be applied if we can to convert an existing array to a min or max heap

```java
class Solution {
    static void Heapify(int N , int arr[] , int idx){
        int largest = idx;
        int left_child_idx = 2*largest + 1;
        int right_child_idx = 2*largest + 2;
        
        if(left_child_idx < N && arr[largest] < arr[left_child_idx]){
            largest = left_child_idx;
        }
        
        if(right_child_idx < N && arr[largest] < arr[right_child_idx]){
            largest = right_child_idx;
        }
        
        if(largest != idx){
            int temp = arr[idx];
            arr[idx] = arr[largest];
            arr[largest] = temp;
            Heapify(N , arr , largest);
        }
    }
    static void convertMinToMaxHeap(int N, int arr[]) {
    // code here
    
    int start_idx = (N/2) -1;
    
    for(int i = start_idx;i >= 0;i--){  // direction of the loop is important
        Heapify(N , arr , i);
    }
  }  
}
```

## Kth Smallest element in an array (easy) (gfg)

```java
class Solution {
    public static int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        
        int count = 0;
        
        while(!pq.isEmpty()){
            int ele = pq.poll();
            
            count += 1;
            if(count == k){
                return ele;
            }
        }
        
        return -1;
    }
}
```

## Kth largest element in an array (easy) (leetcode - 215)

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0;i<nums.length;i++){
            pq.add(nums[i]);
        }

        int count = 0;

        while(!pq.isEmpty()){
            int ele = pq.poll();
            count += 1;
            if(count == k){
                return ele;
            }
        }
        return -1;  
    }
}
```