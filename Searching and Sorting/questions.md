# Sorting

## Bubble sort (Optimized)

Best case time complexity  - O(n)  {When array is already sorted}
worst case time complexity - O(n^2)  {When arrays is in descending order}

```java
class Solution
{
    //Function to sort the array using bubble sort algorithm.
	public static void bubbleSort(int arr[], int n)
    {
        //code here
        
        for(int i = 0;i<n-1;i++){
            
            boolean flag = false;
            
            for(int j = 0;j<n-1-i;j++){
                
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
                
            }
            
            if(flag == false){
                break;
            }
        }
    }
}
```

## Merge Sort

Time complexity -- O(nlogn) (base 2)

```java
class Solution
{
    private static void merge(int[] arr, int low, int mid, int high) {
        
        ArrayList<Integer> temp = new ArrayList<>();
        
        int ptr1 = low;
        int ptr2 = mid+1;
        
        while(ptr1 <= mid && ptr2 <= high){
            
            if(arr[ptr1] <= arr[ptr2]){
                temp.add(arr[ptr1]);
                ptr1++;
            }
            
            else{
                temp.add(arr[ptr2]);
                ptr2++;
            }
            
        }
        
        while(ptr1 <= mid){
            temp.add(arr[ptr1]);
            ptr1++;
        }
        
        while(ptr2 <= high){
            temp.add(arr[ptr2]);
            ptr2++;
        }
        
        for(int i = low ; i<= high ;i++){
            arr[i] = temp.get(i-low);
        }

    }

    public static void mergeSort(int[] arr, int low, int high) {
        
        if(low >= high){
            return;
        }
        
        int mid = low + (high-low)/2;
        
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,high);

    }
}
```

## Permute two arrays such that sum of every pair is greater or equal to K (gfg)

```java
class Solution {
    
    public void ascending_merge(long arr[] , int low , int mid , int high){
        
        ArrayList<Long> list = new ArrayList<>();
        
        int ptr1 = low;
        int ptr2 = mid+1;
        
        while(ptr1 <= mid && ptr2 <= high){
            if(arr[ptr1] <= arr[ptr2]){
                list.add(arr[ptr1]);
                ptr1++;
            }
            
            else{
                list.add(arr[ptr2]);
                ptr2++;
            }
        }
        
        while(ptr1 <= mid){
            list.add(arr[ptr1]);
            ptr1++;
        }
        
        while(ptr2 <= high){
            list.add(arr[ptr2]);
            ptr2++;
        }
        
        for(int i = low;i<=high;i++){
            arr[i] = list.get(i-low);
        }
        
        
    }
    
    public void descending_merge(long arr[] , int low , int mid , int high){
        
        ArrayList<Long> list = new ArrayList<>();
        
        int ptr1 = low;
        int ptr2 = mid+1;
        
        while(ptr1 <= mid && ptr2 <= high){
            if(arr[ptr1] >= arr[ptr2]){
                list.add(arr[ptr1]);
                ptr1++;
            }
            
            else{
                list.add(arr[ptr2]);
                ptr2++;
            }
        }
        
        while(ptr1 <= mid){
            list.add(arr[ptr1]);
            ptr1++;
        }
        
        while(ptr2 <= high){
            list.add(arr[ptr2]);
            ptr2++;
        }
        
        for(int i = low;i<=high;i++){
            arr[i] = list.get(i-low);
        }
        
        
    }
    
    public void ascending_sort(long a[],int low,int high){
        if(low >= high){
            return;
        }
        
        int mid = low + (high-low)/2;
        
        ascending_sort(a,low,mid);
        ascending_sort(a,mid+1,high);
        ascending_merge(a,low,mid,high);
        
    }
    
    public void descending_sort(long a[],int low,int high){
        if(low >= high){
            return;
        }
        
        int mid = low + (high-low)/2;
        
        descending_sort(a,low,mid);
        descending_sort(a,mid+1,high);
        descending_merge(a,low,mid,high);
        
    }
    public boolean isPossible(long a[], long b[], int n, long k) {
        // Your code goes here
        
        int low = 0;
        int high = n-1;
        
        ascending_sort(a,low,high);
        descending_sort(b,low,high);
        
        boolean flag = true;;
        
        for(int i = 0;i<a.length;i++){
            
            if((a[i] + b[i]) < k){
                
                flag = false;
                
            }
        }

        
        return flag;
    }
}
```

## Find common elements in three sorted arrays(gfg)

```java
class Solution
{
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
        // code here 
        
        ArrayList<Integer> temp = new ArrayList<>();
        
        int ptr1 = 0;
        int ptr2 = 0;
        int ptr3 = 0;
        
        while(ptr1 <= n1-1 && ptr2 <= n2-1){
            
            if(A[ptr1] == B[ptr2] && ptr1 == 0){
                temp.add(A[ptr1]);
                ptr1++;
                ptr2++;
            }
            
            else if(A[ptr1] == B[ptr2] && ptr1 != 0 && A[ptr1] != A[ptr1-1]){
                temp.add(A[ptr1]);
                ptr1++;
                ptr2++;
            }
            
            else if(A[ptr1] < B[ptr2]){
                ptr1++;
            }
            
            else{
                ptr2++;
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        int ptr4 = 0;
        
        
        while(ptr3 <= n3-1 && ptr4 <= temp.size()-1){
            
            if(C[ptr3] == temp.get(ptr4) && ptr3 == 0){
                result.add(C[ptr3]);
                ptr3++;
                ptr4++;
            }
            
            else if(C[ptr3] == temp.get(ptr4) && ptr3 != 0 && C[ptr3] != C[ptr3-1]){
                result.add(C[ptr3]);
                ptr3++;
                ptr4++;
            }
            
            else if(C[ptr3] < temp.get(ptr4)){
                ptr3++;
            }
            
            else{
                ptr4++;
            }
            
        }
        
        return result;
        
    }
}
```

## Searching in an array where adjacent differ by at most k(gfg)

The above solution can be Optimized using the fact that the difference between all adjacent elements is at most k. The idea is to start comparing from the leftmost element and find the difference between the current array element and x. Let this difference be ‘diff’. From the given property of the array, we always know that x must be at least ‘diff/k’ away, so instead of searching one by one, we jump ‘diff/k’. 

```java

class Complete{

    public static int search (int arr[], int n, int x, int k) {
        //Complete the function
        
        int i = 0;
        
        while(i<n){
            if(arr[i] == x){
                return i;
            }
            
            int diff = Math.abs(x - arr[i]);
            
            i = i + Math.max(1,diff/k);
        }
        
        return -1;
    }
    
}
```

# Searching

## Linear Search

Time complexity -- O(n)
```java
class Solution {
    public static int search(int n, int k, int[] arr) {
        
        // code here
        
        for(int i = 0;i<n;i++){
            if(arr[i] == k){
                return i;
            }
        }
        
        return -1;
    }
}
```

## Binary Search

Array is sorted in Ascending order.

Time complexity -- O(logn)

```java
class Solution {
    int binarysearch(int arr[], int n, int k) {
        // code here
        
        int s = 0;
        int e = n-1;
        
        while(s <= e){
            int mid = s+(e-s)/2;
            
            if(arr[mid] == k){
                return mid;
            }
            
            else if(arr[mid] < k){
                s = mid+1;
            }
            
            else{
                e = mid-1;
            }
        }
        
        return -1;
    }
}
```

And we can do it if Array is sorted in descending order.

for checking the order just campare the first and last element of the array.

## First Bad Version (leetcode - 278)

```java
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {

        int ptr1 = 1;
        int ptr2 = n;

        int ans = -1;

        while(ptr1 <= ptr2){
            int mid = ptr1 + (ptr2 - ptr1)/2;

            if(isBadVersion(mid) == true && isBadVersion(mid-1) == false){
                return mid;
            } 

            else if(isBadVersion(mid) == false){
                ptr1 = mid + 1;
            }

            else if(isBadVersion(mid) == true){
                ptr2 = mid - 1;
            }
        }

        return ans;
        
    }
}
```

## Ceiling of an element in an sorted array  (the number which is >= the target element)

time complexity -- O(logn)

```java
class Solution{
    public int ceiling_element(int arr[],int num){
        
        // what if our num is itself greater than the largest element in the array
        if(num > arr[arr.length-1]){
            return -1;
        }
        int s = 0;
        int e = arr.length-1;

        while(s <= e){
            int mid = s + (e-s)/2;

            if(arr[mid] == num){
                return arr[mid];
            }

            else if(arr[mid] < num){
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }

        return s ;
    }
}
```

## floor of an element in an sorted array

time complexity -- O(logn)
```java
class Solution{
    public int floor_element(int arr[],int num){

        if(target < arr[0]){   
            return -1;
        }

        int s = 0;
        int e = arr.length-1;

        while(s <= e){
            int mid = s + (e-s)/2;

            if(arr[mid] == num){
                return arr[mid];
            }

            else if(arr[mid] < num){
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }

        return e;
    }
}
```

## Finding smallest letter greater than the target (leetcode - 744)

Use simple comparision operator for comparing characters.
time complexity -- O(logn)

```java
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {

        int s = 0;
        int e = letters.length - 1;

        while( s <= e){
            int mid = s + (e-s)/2;

            if(letters[mid] <= target){
                s = mid + 1;
            }

            else if(letters[mid] > target){
                e = mid - 1;
            }

        }

        // If there is no letter greater than the target letter return the letter at index 0. 

        if(s == letters.length){
            return letters[0];
        }
        else{
            return letters[s];
        } 
        
    }
}
```

## Two sum II (Input array is sorted) (leetcode - 167)

time complexity -- O(NlogN)

```java
class Solution {
    public int[] twoSum(int[] arr, int target) {

        int n = arr.length;

        for(int i = 0;i<n-1;i++){
            int ptr1 = i+1;
            int ptr2 = n-1;

            int[] result = new int[2];

            while(ptr1 <= ptr2){
                
                int mid = ptr1 + (ptr2 - ptr1)/2;

                if(arr[i] + arr[mid] == target){
                    result[0] = i+1;
                    result[1] = mid+1;
                    return result;
                }

                else if(arr[i] + arr[mid] > target){
                    ptr2 = mid-1;
                }

                else if(arr[i] + arr[mid] < target){
                    ptr1 = mid + 1;
                }
            }
        }

        return new int[2];
        
    }
}
```

## Valid perfect square (leetcode - 367)

```java
class Solution {
    public boolean isPerfectSquare(int num) {

        if(num < 2){
            return true;
        }

        int s = 2;
        int e = num/2;  // an important step

        while(s <= e){
            int mid = s + (e-s)/2;

            if(mid*mid == num){
                return true;
            }

            else if(mid*mid > num){
                e = mid-1;
            }

            else if(mid*mid < num){
                s = mid + 1;
            }
        }

        return false;
        
    }
}
```

## Finding the peak element in a mountain array(leetcode - 852)

time complexity -- O(logn)

```java
class Solution {
    public int peakIndexInMountainArray(int[] arr) {

        int s = 0;
        int e = arr.length - 1;

        while (s <= e){

            int mid = s + (e-s)/2;

            if(mid == 0){
                s = mid+1;
            }

            else if(mid == arr.length - 1){
                e = mid - 1;
            }

            else if(arr[mid-1]<arr[mid] && arr[mid] > arr[mid+1]){
                return mid;
            }

            else if(arr[mid] < arr[mid+1]){
                s = mid + 1;
            }

            else if(arr[mid-1]>arr[mid]){
                e = mid - 1;
            }

        }

        return s;
        
    }
}
```

## Finding first and last position of an element in a sorted array (leetcode - 34)

time complexity -- O(logn)

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {

        int[] arr = {-1,-1};

        // finding the first occurance (apply binary search)
        int s = 0;
        int e = nums.length - 1;

        while ( s <= e){
            int mid = s + (e-s)/2;

            if(nums[mid] == target){
                arr[0] = mid;
                e = mid - 1;
            }

            else if(nums[mid] > target){
                e = mid - 1;
            }
            else{
                s = mid + 1;
            }
        }
        

        // finding the last occurance (apply binary search)
        s = 0;
        e = nums.length - 1;

        while ( s <= e){
            int mid = s + (e-s)/2;

            if(nums[mid] == target){
                arr[1] = mid;
                s = mid + 1;
            }

            else if(nums[mid] > target){
                e = mid - 1;
            }

            else{
                s = mid + 1;
            }
        }
        return arr;
    }
}
```

## Single element in an sorted array (leetcode - 540)

time complexity -- O(logn) (apply binary search)

Case 1 -- If mid element is not equal to mid+1 element  and mid-1 element. This case returns the answer.
Case 2 -- When mid element is even and equal to mid+1 element this means number is not present in the left side of the array. In this case start pointer will change to mid+1.
Case 3 -- When mid element is odd and equal to mid-1 element this means number is not present in the left side of the array. In this case start pointer will change to mid+1.
Case 4-- When mid element is odd and equal to mid+1 element this means number is not present in the right side of the array. In this case end pointer will change to mid-1.
Case 5 -- When mid element is even and equal to mid-1 element this means number is not present in the right side of the array. In this case end pointer will change to mid-1. 

```java
class Solution {
    public int singleNonDuplicate(int[] arr) {

        if(arr.length == 1){
            return arr[0];
        }

        int s = 0;
        int e = arr.length - 1;

        while(s <= e){
            int mid = s + (e-s)/2;

            if(mid == 0 && arr[mid] != arr[mid + 1]){
                return arr[mid];
            }

            else if(mid == arr.length-1 && arr[mid-1] != arr[mid]){
                return arr[mid];
            }

            else if(arr[mid] != arr[mid+1] && arr[mid-1] != arr[mid]){
                return arr[mid];
            }

            else if((mid % 2 == 0 && arr[mid] == arr[mid+1]) || (mid % 2 != 0 && arr[mid] == arr[mid-1]) ){
                s = mid + 1;
            }

            else if((mid % 2 != 0 && arr[mid] == arr[mid+1]) || (mid % 2 == 0 && arr[mid] == arr[mid-1]) ){
                e = mid - 1;
            }
        }

        return s;
        
    }
}
```

## Searching in a rotated soreted array (leetcode -- 33)

time complexity -- O(logn)

logic -- After finding the mid element .... you will always find that one part of the array is always sorted

```java
class Solution {
    public int search(int[] arr, int target) {

        if(arr.length == 1 && target == arr[0]){
            return 0;
        }
        else if(arr.length == 1 && target != arr[0]){
            return -1;
        }

        int s = 0;
        int e = arr.length-1;


        while(s <= e){
            int mid = s + (e-s)/2;

            if(arr[mid] == target){
                return mid;
            }

            // check if left part is sorted and the target is present in the left part or not

            else if ((arr[s] <= arr[mid])){
                if(arr[s] <= target && target <= arr[mid]){
                    e = mid -1;
                }
                else{
                    s = mid + 1;
                }
            }

            // check if right part is sorted and the target is present in the right part or not

            else if((arr[e] >= arr[mid])){
                if(arr[mid] <= target && target <= arr[e]){
                    s = mid + 1;
                }

                else{
                    e = mid -1;
                }
            }
        }

        return -1;
        
    }

}

```

## Searching in a rotated soreted array (leetcode -- 81)

time complexity -- O(logn)

dry run with examples -- 

nums = [1,0,1,1,1] , target = 0

nums = [1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1] , target = 2

```java
class Solution {
    public boolean search(int[] nums, int target) {

        if(nums.length == 1 && nums[0] == target){
            return true;
        }
        else if(nums.length == 1 && nums[0] != target){
            return false;
        }

        int s = 0;
        int e = nums.length - 1;

        while(s <= e){
            int mid = s + (e-s)/2;

            if(nums[mid] == target){
                return true;
            }

            // Important 3 conditions (If we are not able to find the sorted half)
            else if(nums[s] == nums[mid] && nums[mid] == nums[e]){
                    s = s + 1;
                    e = e - 1;
                }

            else if(nums[s] == nums[mid] && nums[mid] != nums[e]){
                s = mid + 1;
            }

            else if(nums[s] != nums[mid] && nums[mid] == nums[e]){
                e = mid - 1;
            }


            else if(nums[s] <= nums[mid]){
                if(nums[s] <= target && target <= nums[mid]){
                    e = mid - 1;
                }
                else {
                    s = mid + 1;
                }
            }

            else if(nums[mid] <= nums[e]){
                if(nums[mid] <= target && target <= nums[e]){
                    s = mid + 1;
                }
                else {
                    e = mid - 1;
                }
            }
        }

        return false;
    }
}
```

