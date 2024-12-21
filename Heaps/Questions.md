# Questions Count

1. Easy - 6
2. Medium - 7
3. Hard - 2

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

## Merge 2 binary max heaps (gfg) (easy)

```java
class Solution{
    public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        // your code here
        
        int[] merged = new int[n+m];
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i = 0;i<n;i++){
            arr.add(a[i]);
        }
        
        for(int i = 0;i<m;i++){
            arr.add(b[i]);
        }
        
        int starting_idx = (arr.size()/2)-1; 
        
        for(int i = starting_idx;i>=0;i--){
            Heapify(arr , i);
        }
        
        for(int i = 0;i<arr.size();i++){
            merged[i] = arr.get(i);
        }
        
        return merged;
    }
    
    public void Heapify(ArrayList<Integer> arr , int idx){
        int n = arr.size();
        int largest = idx;
        int l = 2*idx + 1;
        int r = 2*idx + 2;
        
        if(l < n && arr.get(largest) < arr.get(l)){
            largest = l;
        }
        
        if(r < n && arr.get(largest) < arr.get(r)){
            largest = r;
        }
        
        if(largest != idx){
            int temp = arr.get(largest);
            arr.set(largest , arr.get(idx));
            arr.set(idx , temp);
            Heapify(arr,largest);
        }
    }
}
```

## Heap sort (gfg) (Medium)

```java
class Solution
{
    void buildHeap(int arr[], int n)
    {
        int start_idx = (n/2) - 1;
        
        for(int i = start_idx;i>=0;i--){
            heapify(arr , n , i);
        }
        
    }
 
    //Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i)
    {
        
        int smallest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;
        
        if(left < n && arr[smallest] > arr[left]){
            smallest = left;
        }
        
        if(right < n && arr[smallest] > arr[right]){
            smallest = right;
        }
        
        if(smallest != i){
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
            heapify(arr , n , smallest);
        }
    }
    
    //Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n)
    {   
        ArrayList<Integer> sorted = new ArrayList<>();
        
        buildHeap(arr , n);
        
        int ptr = n-1;
        
        while(ptr >= 0){
            int temp = arr[ptr];
            arr[ptr] = arr[0];
            arr[0] = temp;
            
            sorted.add(arr[ptr]);
            ptr--;
            heapify(arr , ptr+1 , 0);
        }
        
        for(int i = 0;i<sorted.size();i++){
            arr[i] = sorted.get(i);
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
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0;i<nums.length;i++){
            if(pq.size() < k){
                pq.add(nums[i]);
            }else{
                if(nums[i] > pq.peek()){
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
        return pq.peek();  
    }
}
```

## Kth largest sum contigous subarray (gfg) (medium)

```java
class Solution {
    
    public static ArrayList<Integer> subarray_sum(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            int sum = arr[i];
            list.add(sum);
            for(int j = i + 1;j<arr.length;j++){
                sum += arr[j];
                list.add(sum);
            }
        }
        return list;
    }
    public static int kthLargest(int[] arr, int k) {
        // code here
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        ArrayList<Integer> list = subarray_sum(arr);
        
        for(int i = 0;i<list.size();i++){
            if(pq.size() < k){
                pq.add(list.get(i));
            }
            else{
                if(pq.peek() < list.get(i)){
                    pq.poll();
                    pq.add(list.get(i));
                }
            }
        }
        
        return pq.peek();
    }
}
```


## Minimum cost of ropes (gfg) (easy)

```java
class Solution {
    // Function to return the minimum cost of connecting the ropes.
    public long minCost(long[] arr) {
        // code here
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for(int i = 0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        
        long min_sum = 0;
        
        while(pq.size() > 1){
            
            long ele1 = pq.poll();
            long ele2 = pq.poll();
            
            long current_sum = ele1 + ele2;
            
            min_sum += current_sum;
            
            pq.add(current_sum);
        }
        
        return min_sum;
    }
}
```

## Check if a binary tree is a maxheap or not (gfg) (Medium)

```java
class Solution {
    boolean isComplete(Node tree){
        Queue<Node> q = new LinkedList<>();
        
        q.add(tree);
        
        while(!q.isEmpty()){
            Node ele = q.poll();
            
            if(ele != null){
                q.add(ele.left);
                q.add(ele.right);
            }else{
                while(!q.isEmpty()){
                    if(q.poll() != null){
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    boolean isHeapHelper(Node tree) {
        // code here
        
        if(tree == null){
            return true;
        }
        
        if(tree.left == null && tree.right == null){
            return true;
        }
        
        boolean left_info = isHeapHelper(tree.left);
        boolean right_info = isHeapHelper(tree.right);
        
        
        boolean current_info = false;
        
        if(tree.left != null){
            if(tree.right != null){
                current_info = (tree.data >= tree.left.data) && (tree.data >= tree.right.data);
                
            }else if(tree.right == null){
                current_info = (tree.data >= tree.left.data);
            }
        }else if(tree.right != null){
            if(tree.left == null){
                current_info = (tree.data >= tree.right.data);
            }
            
        }
        
        return left_info && current_info && right_info;
    }
    
    boolean isHeap(Node tree){
        
        boolean flag1 = isComplete(tree); // for checking completenesee
        boolean flag2 = isHeapHelper(tree); // for checking the max heap property
        
        return flag1 && flag2;
        
    }
}
```

## Replace element by their rank in an array (gfg) (Medium)

```java
class Solution {
    static int[] replaceWithRank(int arr[], int N) {
     // code here
     
     HashSet<Integer> visited = new HashSet<>();
     
     PriorityQueue<Integer> pq = new PriorityQueue<>();
     
     HashMap<Integer , ArrayList<Integer>> map = new HashMap<>();
     
     for(int i = 0;i<arr.length;i++){
         pq.add(arr[i]);
         
         if(!map.containsKey(arr[i])){
             ArrayList<Integer> list = new ArrayList<>();
             list.add(i);
             map.put(arr[i] , list);
         }else{
             ArrayList<Integer> list = map.get(arr[i]);
             list.add(i);
             map.put(arr[i] , list);
         }
     }
     
     int count = 0;
     
     while(!pq.isEmpty()){
         int ele = pq.poll();
    
         if(!visited.contains(ele)){
             count += 1;
         }
         
         ArrayList<Integer> list = map.get(ele);
         int idx = list.remove(list.size()-1);
         
         arr[idx] = count;
         visited.add(ele);
     }
     
     return arr;
  }
}
     
```

## Top K frequent elements (leetcode - 347) (medium)

```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int val = map.get(nums[i]);
                val += 1;
                map.put(nums[i],val);
            }else{
                map.put(nums[i],1);
            }
        }

        HashMap<Integer,ArrayList<Integer>> map1 = new HashMap<>();

        for(int key:map.keySet()){
            int val = map.get(key);
            if(!pq.contains(val)){
                pq.add(val);
            }
            if(map1.containsKey(val)){
                ArrayList<Integer> list = map1.get(val);
                list.add(key);
                map1.put(val , list);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(key);
                map1.put(val , list);
            }
        }
        ArrayList<Integer> final_arr = new ArrayList<>();
        while(!pq.isEmpty()){

            if(final_arr.size() == k){
                break;
            }

            int ele = pq.poll();

            ArrayList<Integer> list = map1.get(ele);

            for(int i = 0;i<list.size();i++){
                final_arr.add(list.get(i));
            }
        }

        int[] arr1 = new int[k];

        for(int i = 0;i<k;i++){
            arr1[i] = final_arr.get(i);
        }
        return arr1;
        
    }
}
```

## Merge K sorted Arrays (gfg) (Medium)

```java
class Solution
{
    //Function to merge k sorted arrays.
    
    static class compareByElement implements Comparator<Node>{
        
        @Override
        
        public int compare(Node n1 , Node n2){
            return n1.element - n2.element;
        }
    }
    
    static class Node{
        int element;
        int i;
        int j;
        public Node(int ele , int i , int j){
            this.element = ele;
            this.i = i;
            this.j = j;
        }
    }
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        // Write your code here.
        
        ArrayList<Integer> merged = new ArrayList<>();
        
        if(arr.length == 0){
            return merged;
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>(new compareByElement());
        
        for(int i = 0;i<arr.length;i++){
            if(arr[i].length > 0){
                Node node = new Node(arr[i][0] , i , 0);
                pq.add(node);
            }
        }
        
        while(!pq.isEmpty()){
            Node n = pq.poll();
            
            merged.add(n.element);
            
            int idx1 = n.i;
            int idx2 = n.j;  
            
            if(idx2+1 < arr[idx1].length){
                Node new_node = new Node(arr[idx1][idx2+1] , idx1 , idx2+1);
                pq.add(new_node);
            }
            
        }
        return merged;
        
    }
}
```

## Merge K sorted LinkedLists (leetcode - 23) (Hard)

```java
class Solution {
    class compareByValue implements Comparator<Pair>{

        @Override
        public int compare(Pair p1 , Pair p2){
            return p1.val - p2.val;
        }
    }

    class Pair{
        int val;
        ListNode node;
        public Pair(int val,ListNode node){
            this.val = val;
            this.node = node;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode head = new ListNode(-1);

        ListNode temp = head;

        PriorityQueue<Pair> pq = new PriorityQueue<>(new compareByValue());

        for(int i = 0;i<lists.length;i++){
            if(lists[i] != null){
                Pair pair = new Pair(lists[i].val , lists[i]);
                pq.add(pair);
            }
        }

        while(!pq.isEmpty()){
            Pair p = pq.poll();

            temp.next = p.node;
            temp = temp.next;

            if(p.node.next != null){
                pq.add(new Pair(p.node.next.val , p.node.next));
            }
        }

        return head.next;
    }
}
```

## Smallest Range covering elements from K sorted lists (leetcode - 632) (Hard)

```java
class Solution {

    public class compareByElement implements Comparator<Node>{
        @Override
        public int compare(Node n1 , Node n2){
            return n1.element - n2.element;
        }
    }
    public class Node{
        int element;
        int row_idx;
        int col_idx;

        public Node(int ele , int i , int j){
            this.element = ele;
            this.row_idx = i;
            this.col_idx = j;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {

        int[] ans = new int[2];

        PriorityQueue<Node> min_q = new PriorityQueue<>(new compareByElement());

        int current_max = Integer.MIN_VALUE;

        for(int i = 0;i<nums.size();i++){
            min_q.add(new Node(nums.get(i).get(0) , i, 0));
            current_max = Math.max(nums.get(i).get(0),current_max);
        }

        int current_min = min_q.peek().element;

        ans[0] = current_min;
        ans[1] = current_max;

        int current_difference = current_max - current_min;

        while(true){
            Node node = min_q.poll();

            int idx1 = node.row_idx;
            int idx2 = node.col_idx;
            int ele = node.element;

            int new_idx1 = idx1;
            int new_idx2 = idx2 + 1;
            if(new_idx2 >= nums.get(idx1).size()){
                break;
            }
            int new_ele = nums.get(new_idx1).get(new_idx2);

            min_q.add(new Node(new_ele,new_idx1,new_idx2));

            current_max = Math.max(current_max , new_ele);
            current_min = min_q.peek().element;

            if(current_max - current_min < current_difference){
                current_difference = current_max - current_min;
                ans[0] = current_min;
                ans[1] = current_max;
            }
        }
        return ans;
    }
}
```