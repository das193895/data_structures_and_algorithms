# One Dimensional arrays

## Finding largest element in an array (easy)

```java
class Solution {
    public static int largest(int[] arr) {
        // code here
        
        int largest = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++){
            largest = Math.max(largest,arr[i]);
        }
        return largest;
    }
}

```

## Finding minimum and maximum element in an array (easy)

```java
class Solution
{ 
    public static int findSum(int arr[],int N) 
    {
        //code here
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0;i<arr.length;i++){
            if(arr[i] < min){
                min = arr[i];
            }
            
            if(arr[i] > max){
                max = arr[i];
            }
        }
        
        return max+min;
    }
}
```

## Finding the second largest element in an array (easy) (gfg)

```java
class Solution {
    int print2largest(int arr[], int n) {
        // code here
        
        int lar = arr[0];
        int sl = Integer.MIN_VALUE;
        
        for(int i = 1;i<arr.length;i++){
            if(arr[i]>lar){
                sl = lar;
                lar = arr[i];
            }
            else if(arr[i] == lar){
                continue;
            }
            else if(arr[i] < lar){
                if(arr[i] > sl){
                    sl = arr[i];
                }
            }
        }
        
        if(sl == Integer.MIN_VALUE){
            return -1;
        }
        
        return sl;
    }
}
```

## Finding the 3rd largest element in an array (easy)
```java

class Solution
{
    int thirdLargest(int arr[], int n)
    {
	    // Your code here
	    
	    if(arr.length == 1 || arr.length == 2){
	        return -1;
	    }
	    
	    int l = arr[0];
	    int sl = Integer.MIN_VALUE;
	    int tl = Integer.MAX_VALUE;
	    
	    for(int i = 1;i<arr.length;i++){
	        if(arr[i]>l){
	            tl = sl;
	            sl = l;
	            l = arr[i];
	        }
	        
	        else if(arr[i] == l){
	            continue;
	        }
	        
	        else if(arr[i] < l){
	            if(arr[i] > sl){
	                tl = sl;
	                sl = arr[i];
	            }
	            else if(arr[i] < sl){
	                if(arr[i]>tl){
	                    tl = arr[i];
	                }
	            }
	        }
	    }
	    
	    if(tl == Integer.MAX_VALUE){
	        return -1;
	    }
	    
	    return tl;
    }
}
```

## Check if array is sorted or not (gfg) (easy)

```java
class Solution {
    public boolean arraySortedOrNot(List<Integer> arr) {
        for(int i = 1;i<arr.size();i++){
            if(arr.get(i) < arr.get(i-1)){
                return false;
            }
        }
        return true;
    }
}
```
## Reversing an array (gfg) (easy)

```java
    public static void reverse(int arr[]){
        if(arr.length == 0){
            return;
        }

        int ptr1 = 0;
        int ptr2 = arr.length-1;

        while(ptr1 < ptr2){
            int temp = arr[ptr1];
            arr[ptr1] = arr[ptr2];
            arr[ptr2] = temp;
            
            ptr1++;
            ptr2--;
        }
    }
```

## Removing duplicates from a sorted array (leetcode - 26) (easy)

```java
// method - 1
class Solution {
    public int removeDuplicates(int[] nums) {
        int current_element = nums[0];
        int count = 1;

        int ptr1 = 1;

        while(ptr1 < nums.length){
            if(nums[ptr1] == current_element){
                ptr1++;
            }
            else if(nums[ptr1] != current_element){
                current_element = nums[ptr1];
                count++;
                nums[count-1] = current_element;
                ptr1++;
            }
        }
        return count;
    }
}

// method - 2
class Solution {
    public int removeDuplicates(int[] nums) {

        int ptr1 = 0;
        int ptr2 = 0;

        while(ptr1 != nums.length && ptr2 != nums.length){
            if(nums[ptr1] == nums[ptr2]){
                ptr2 ++;
            }

            else{
                ptr1++;
                nums[ptr1] = nums[ptr2];
            }
        } 
        return ptr1+1;   
    }
}
```

## Contains Duplicate (leetcode - 217) (Easy)

```java
class Solution {
    public boolean containsDuplicate(int[] nums) {

        HashMap<Integer,Integer> m = new HashMap<>();

        for(int i = 0;i<nums.length;i++){
            if(m.containsKey(nums[i])){
                return true;
            }

            m.put(nums[i],1);
        }

        System.out.println(m.size());

        return false;
        
    }
}
```

## moving zeros to end (leetcode 283) (easy)

```java

class Solution {
    public void moveZeroes(int[] nums) {

        int ptr1 = 0;
        int ptr2 = 1;

        while(ptr1 != nums.length && ptr2 != nums.length){
            if(nums[ptr1] != 0 && nums[ptr2] != 0){
                ptr1++;
                ptr2++;
            }

            else if(nums[ptr1] != 0 && nums[ptr2] == 0){
                ptr1++;
                ptr2++;
            }

            else if(nums[ptr1] == 0 && nums[ptr2] == 0){
                ptr2++;
            }

            else if(nums[ptr1] == 0 && nums[ptr2] != 0){
                int temp = nums[ptr2];
                nums[ptr2] = nums[ptr1];
                nums[ptr1] = temp;

                ptr1++;
                ptr2++;

            }
        }
    }
}

```

## Right Rotation (leetcode 189) (Medium)

```java
class Solution {
    public void reverse(int[] nums , int ptr1 , int ptr2){
        while(ptr1 < ptr2){
            int temp = nums[ptr1];
            nums[ptr1] = nums[ptr2];
            nums[ptr2] = temp; 
            ptr1++;
            ptr2--;
        }
    }
    public void rotate(int[] nums, int k) {

        int new_k = -1;

        if(k == nums.length){
            new_k = 0;
        }else if(k < nums.length){
            new_k = k;
        }else if(k > nums.length){
            new_k = k % nums.length;
        }

        reverse(nums , nums.length - new_k , nums.length - 1);
        reverse(nums , 0 , nums.length - new_k - 1);
        reverse(nums , 0 , nums.length - 1);
    }
}
```

## Left rotation (gfg) (Medium)

```java
class Solution{
     public void reverse(int[] nums , int ptr1 , int ptr2){
        while(ptr1 < ptr2){
            int temp = nums[ptr1];
            nums[ptr1] = nums[ptr2];
            nums[ptr2] = temp; 
            ptr1++;
            ptr2--;
        }
    }
    void leftRotate(int nums[], int k) {
        int new_k = -1;

        if(k == nums.length){
            new_k = 0;
        }else if(k < nums.length){
            new_k = k;
        }else if(k > nums.length){
            new_k = k % nums.length;
        }

        reverse(nums , 0 , new_k - 1);
        reverse(nums , new_k , nums.length - 1);
        reverse(nums , 0 , nums.length - 1);
    }
}
   
```

## Check if Array is sorted and rotated(leetcode - 1752) (Easy)

```java
class Solution {
    public boolean check(int[] arr) {

        int count = 0;

        for(int i = 1;i<arr.length;i++){
            if(arr[i] < arr[i-1]){
                count++;
            }
        }

        if(arr[0] < arr[arr.length-1]){
            count++;
        }

        if(count <= 1){
            return true;
        }
        else{
            return false;
        }
    }
}
``` 

## Union of two sorted arrays (gfg) (medium)

```java
class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
        
        ArrayList<Integer> union = new ArrayList<>();
        
        int ptr1 = 0;
        int ptr2 = 0;
        
        while(ptr1 < arr1.length && ptr2 < arr2.length){
            if(arr1[ptr1] < arr2[ptr2]){
                if(union.size() == 0){
                    union.add(arr1[ptr1]);
                    
                }else if(union.size() != 0){
                    if(union.get(union.size()-1) != arr1[ptr1]){
                        union.add(arr1[ptr1]);
                    } 
                }
                ptr1++;
            }
            
            else if(arr1[ptr1] >= arr2[ptr2]){
                if(union.size() == 0){
                    union.add(arr2[ptr2]);
                    
                }else if(union.size() != 0){
                    if(union.get(union.size()-1) != arr2[ptr2]){
                        union.add(arr2[ptr2]);
                    }
                }
                ptr2++;
            }
        }
        
        while(ptr1 < arr1.length){
            if(union.get(union.size()-1) != arr1[ptr1]){
                union.add(arr1[ptr1]);
            }
            ptr1++;
        }
        
        while(ptr2 < arr2.length){
            if(union.get(union.size()-1) != arr2[ptr2]){
                union.add(arr2[ptr2]);
            }
            ptr2++;
        }
        
        return union;
    }
}
```

## Intersection of two Arrays (leetcode - 349) (Easy)

```java
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        ArrayList<Integer> arr = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int ptr1 = 0;
        int ptr2 = 0;

        while(ptr1 < nums1.length && ptr2 < nums2.length){
            if(nums1[ptr1] < nums2[ptr2]){
                ptr1++;

            }
            else if(nums1[ptr1] > nums2[ptr2]){
                ptr2++;
                
            }
            else if(nums1[ptr1] == nums2[ptr2]){
                if(arr.size() == 0){
                    arr.add(nums1[ptr1]);
                }
                else if(arr.get(arr.size()-1) != nums1[ptr1]){
                    arr.add(nums1[ptr1]);
                }
                ptr1++;
                ptr2++;
                
            }
        }

        int[] intersection = new int[arr.size()];
        for(int i = 0;i<arr.size();i++){
            intersection[i] = arr.get(i);
        }

        return intersection;
        
    }
}
```

## Missing Numbeer (leetcode - 268) (Easy)

```java
class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        sum = (nums.length *(nums.length + 1))/2;

        int array_sum = 0;

        for(int i = 0;i<nums.length;i++){
            array_sum = array_sum + nums[i];
        }

        return sum - array_sum;
    }
}
```

## Max consecutive ones(leetcode - 485) (Easy)

```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int max_count = Integer.MIN_VALUE;

        int current_count = 0;

        int ptr = 0;

        while(ptr < nums.length){
            if(nums[ptr] == 1){
                current_count ++;
            }

            if(nums[ptr] != 1){
                max_count = Math.max(max_count , current_count);
                current_count = 0;
            }

            ptr++;
        }

        return Math.max(max_count , current_count);
    }
}
```

## Single number (leetcode - 136) (easy)

```java
class Solution {
    public int singleNumber(int[] nums) {
        int number = nums[0];

        for(int i = 1 ; i<nums.length;i++){
            number = number ^ nums[i];
        }
        return number;
    }
}
```

## Longest Subarray with sum K (gfg) (Medium)

```java
class Solution {
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr(int nums[], int N, int target) {
        // Complete the function
        
        int length = 0;

        HashMap<Integer , Integer> map = new HashMap<>();

        int sum = 0;

        for(int i = 0;i<nums.length;i++){

            sum = sum + nums[i];

            if(sum == target){
                length = Math.max(length , i+1);
            }else if(map.containsKey(sum - target)){
                int prev_idx = map.get(sum - target);
                length = Math.max(length , i - prev_idx);
            }
            
            if(!map.containsKey(sum)){
                map.put(sum , i);

            }
        }

        return length;
    }
}
```

## Two Sum (leetcode - 1) (easy)

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] arr = new int[2];

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(target - nums[i])){
                arr[0] = i;
                arr[1] = map.get(target - nums[i]);
                return arr;
            }

            map.put(nums[i] , i);
        }
        return arr;
    }
}
```

## Sort Colors (leetcode - 75) (Medium)

```java
class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;

        while(mid <= high){
            if(nums[mid] == 0){
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;

            }else if(nums[mid] == 1){
                mid++;

            }else if(nums[mid] == 2){
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}
```

## Majority Element (leetcode - 169) (medium)

```java
class Solution {
    public int majorityElement(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }

        HashMap<Integer,Integer> map1 = new HashMap<>();

        for(int i = 0;i<nums.length;i++){
            if(map1.containsKey(nums[i])){
                int occurance = map1.get(nums[i]);
                if(map1.get(nums[i]) == (nums.length)/2){
                    return nums[i];
                }else{
                    occurance += 1;
                    map1.put(nums[i],occurance);
                }
            }
            else{
                map1.put(nums[i],1);
            }
        }

        return 0;
        
    }
}
```

## Maximum SubArray Sum (leetcode - 53) (Kadane's Algo) (Medium)

```java
class Solution {
    public int maxSubArray(int[] nums) {

        int max_sum = Integer.MIN_VALUE;

        int sum = 0;

        for(int i = 0;i<nums.length;i++){
            if(sum < 0){
                sum = 0;
            }

            sum = sum + nums[i];

            max_sum = Math.max(max_sum , sum);
        }
        return max_sum;
    }
}
```

## Rearrange Array Element by Sign (leetcode - 2149) (Medium)

```java
class Solution {
    public int[] rearrangeArray(int[] nums) {

        int ptr1 = 0;
        int ptr2 = 1;

        int[] ans = new int[nums.length];

        for(int i = 0;i<nums.length;i++){
            if(nums[i] > 0){
                ans[ptr1] = nums[i];
                ptr1 += 2;

            }else if(nums[i] < 0){
                ans[ptr2] = nums[i];
                ptr2 += 2;
            }
        }
        return ans;
    }
}
```

## Next Permutation (leetcode - 31)

```java
class Solution {

    public void reverse(int[] nums , int ptr1 , int ptr2){

        while(ptr1 < ptr2){
            int temp = nums[ptr1];
            nums[ptr1] = nums[ptr2];
            nums[ptr2] = temp;
            ptr1++;
            ptr2--;
        }
    }
    public void nextPermutation(int[] nums) {

        int break_point = -1;

        int min = Integer.MAX_VALUE;
        int min_index = -1;

        for(int i = nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                break_point = i;
                break;
            }
        }

        if(break_point == -1){
            reverse(nums , 0 , nums.length-1);
        }else{
            for(int i = nums.length-1;i>break_point;i--){
                if(min > nums[i] && nums[i] > nums[break_point]){
                    min = nums[i];
                    min_index = i;
                    System.out.println(min_index);
                }
            }

            int temp = nums[break_point];
            nums[break_point] = nums[min_index];
            nums[min_index] = temp;

            reverse(nums , break_point+1 , nums.length-1);
        }
    }
}
```

## Longest Consecutive Sequence (leetcode - 128)

```java
class Solution {
    public int longestConsecutive(int[] a) {
        
       int n = a.length;
        if (n == 0)
            return 0;

        int longest = 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
        }
        for (int it : set) {
            if (!set.contains(it - 1)) {
                int cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }
}
```

## Leaders in an array (gfg)

```java
class Solution{
    
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        
        ArrayList<Integer> arr1 = new ArrayList<>();
        
        arr1.add(arr[n-1]);
        
        int max = arr[n-1];
        
        for(int i = n-2 ; i>=0;i--){
            
            if(arr[i] > max){
                max = arr[i];
                arr1.add(max);
            }
        }
        
        return arr1;
    }
}
```

## Search in rotated sorted array (leetcode - 33)

```java
// A good question apply binary search with logic
class Solution {
    public int search(int[] arr, int target) {

        int s = 0;
        int e = arr.length-1;

        while(s <= e){
            int mid = ((e+s)/2);
            // int mid = mid1+1;

            if(arr[mid] == target){
                return mid;
            }

            if(arr[s] <= arr[mid]){
                if(arr[s] <= target && target <= arr[mid]){
                    e = mid-1;
                }
                else{
                    s = mid+1;
                }
            }
            else{
                if(arr[mid] <= target && target <= arr[e]){
                    s = mid+1;
                }
                else{
                   e = mid-1; 
                }

            }
        }

        return -1;
        
    }
}
```

# Two Dimensional arrays

