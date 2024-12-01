# Questions Count

1. Easy - 4
2. medium - 10
3. hard -


# Questions

## Binary Search (leetcode - 704) (easy)

```java
class Solution {
    public int binarysearch(int[] arr, int k) {
        // Code Here
        
        int s = 0;
        int e = arr.length-1;
        
        while(s <= e){
            int mid = s + (e-s)/2;
            
            if(arr[mid] == k){
                return mid;
            }
            
            else if(arr[mid] < k){
                s = mid+1;
            }
            else if(arr[mid] > k){
                e = mid-1;
            }
        }
        
        return -1;
    }
}
```

## Floor in a sorted Array (gfg) (easy)

```java
class Solution {

    // Function to find floor of x
    // arr: input array
    // n is the size of array
    static int findFloor(long arr[], int n, long x) {
        int ans = -1;
        
        int s = 0;
        int e = arr.length - 1;
        
        while(s <= e){
            int mid = s + (e-s)/2;
            
            if(arr[mid] <= x){
                ans = mid;
                s = mid +1;
            }else{
                e = mid-1;
            }
        }
        
        return ans;
    }
}
```

## Find first and last position of element in sorted array (Medium) (leetcode - 34)

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {

        // finding the first occurance 

        int[] arr = {-1,-1};

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

## Search in a rotated sorted array (leetcode - 33) (Medium)

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

## Search in rotated sorted Array - II (leetcode - 81) (Medium)

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

            // An important condition (If we are not able to find the sorted half)
            else if(nums[s] == nums[mid] && nums[mid] == nums[e]){
                    s = s + 1;
                    e = e - 1;
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

## Find minimum in a sorted and rotated array (leetcode - 153) (Medium) 

```java
class Solution {
    // always take the smallest element of the right half and then move forward
    public int findMin(int[] arr) {

        int s = 0;
        int e = arr.length - 1;

        int min = Integer.MAX_VALUE;

        while(s <= e){
            int mid = s + (e-s)/2;

            if(arr[s] <= arr[mid]){
                min = Math.min(min , arr[s]);
                s = mid + 1;
            }else if(arr[mid] <= arr[e]){
                min = Math.min(min , arr[mid]);
                e = mid - 1;
            }
        }
        return min;
    }
}
```

## Find how many times an array is rotated (easy) (gfg)

```java
class Solution {
    public int findKRotation(List<Integer> arr) {
        // Code here
        
        int k = Integer.MIN_VALUE;
        
        for(int i = 1 ; i <= arr.size()-1;i++){
            if(arr.get(i) < arr.get(i-1)){
                k = i;
            }
        }
        
        if(arr.get(0) < arr.get(arr.size()-1)){
            k = 0;
        }
        
        return k;
    }
}
```

## Single element in sorted array (leetcode - 540) (Medium)

```java
class Solution 
{
    int findOnce(int arr[], int n)
    {
        // Complete this function
        
        if(arr.length == 1){
            return arr[0];
        }
        
        if(arr[0] != arr[1]){
            return arr[0];
        }
        
        if(arr[n-2] != arr[n-1]){
            return arr[n-1];
        }
        int s = 1;
        int e = n - 2;
        
        while(s <= e){
            int mid = s + (e-s)/2;
            
            if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]){
                return arr[mid];
            }
            
            else if(mid % 2 == 0 && arr[mid] == arr[mid+1]){
                s = mid + 1;
            }
            
            else if(mid % 2 == 0 && arr[mid] == arr[mid-1]){
                e = mid - 1;
            }
            
            else if(mid % 2 != 0 && arr[mid] == arr[mid+1]){
                e = mid - 1;
            }
            
            else if(mid % 2 != 0 && arr[mid] == arr[mid-1]){
                s = mid + 1;
            }
        }
        
        return -1;
    }
}
```

## Find peak element (leetcode - 162) (Medium)

```java
class Solution {
    public int findPeakElement(int[] nums) {

        int n = nums.length;

        if(nums.length == 1){
            return 0;
        }

        if(nums[0] > nums[1]){
            return 0;
        }

        if(nums[n-1] > nums[n-2]){
            return n-1;
        }

        int s = 1;
        int e = nums.length-2;

        while(s <= e){
            int mid = s + (e-s)/2;

            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            }

            else if(nums[mid] > nums[mid-1]){
                s = mid + 1;
            }

            else{
                e = mid - 1;
            }
        }
        return -1;
    }
}
```

## Sqrt of X (leetcode - 69) (easy)

```java
class Solution {
    public int mySqrt(int x) {

        long ans = -1L;

        long s = 0;
        long e = x;

        while(s <= e){
            long mid = s + (e-s)/2;

            if(mid * mid <= x){
                ans = mid;
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }

        return (int)ans;
    }
}
```

## Koko eating Bananas (leetcode - 875) (Medium)

```java
class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int ans = -1;

        int max = Integer.MIN_VALUE;

        for(int i = 0;i<piles.length;i++){
            max = Math.max(max , piles[i]);
        }

        int s = 1;
        int e = max;

        while(s <= e){
            int mid = s + (e-s)/2;
            int total = totalNumberOfBananas(piles , mid);

            if(total <= h){
                ans = mid;
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }

        return ans;
        
    }

    public int totalNumberOfBananas(int[] piles , int k){
        int total = 0;

        for(int i = 0;i<piles.length;i++){
            double hoursRequired = Math.ceil(((double)(piles[i]) / (double)(k)));
            total += hoursRequired;
        }

        return total;
    }
}
```

## Minimum number of days to make m Boquets (leetcode - 1482) (Medium)

```java
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        int ans = -1;

        int n = bloomDay.length;

        if(m*k > n){
            return -1;
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0;i<n;i++){
            max = Math.max(max , bloomDay[i]);
        }

        int s = 1;
        int e = max;

        while(s <= e){
            int mid = s + (e-s)/2;
            boolean canBeFormed = helper(bloomDay , m , k , mid);
            if(canBeFormed){
                ans = mid;
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        return ans;

    }

    public boolean helper(int[] bloomDay , int m , int k , int day){
        
        int k_copy = k;
        for(int i = 0;i<bloomDay.length;i++){

            if(day >= bloomDay[i]){
                k_copy -= 1;
            }else if(day < bloomDay[i]){
                k_copy = k;
            }

            if(k_copy == 0){
                m -= 1;
                k_copy = k;
            }

            if(m == 0){
                return true;
            }
           
        }

        return false;
    }
}
```

## Find the smallest divisor given threshold (leetcode - 1283) (Medium)

```java
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

        int ans = -1;

        int n = nums.length;

        int max = Integer.MIN_VALUE;

        for(int i = 0;i<n;i++){
            max = Math.max(max , nums[i]);
        }

        int s = 1;
        int e = max;

        while(s <= e){
            int mid = s + (e-s)/2;

            boolean isPossible = helper(nums , threshold , mid);

            // System.out.println(mid + " " + isPossible);

            if(isPossible){
                ans = mid;
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        
        return ans;
    }

    public boolean helper(int[] nums , int threshold, int mid){

        int sum = 0;

        for(int i = 0;i<nums.length;i++){
            sum += Math.ceil((double)nums[i]/(double)mid);
        }

        if(sum <= threshold){
            return true;
        }else{
            return false;
        }

    }
}
```

## Capacity to Ship packages within D days (leetcode - 1011) (Medium)

```java
class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int ans = -1;

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0;i<weights.length;i++){
            max = Math.max(max , weights[i]);
            sum += weights[i];
        }

        int s = max;
        int e = sum;

        while(s <= e){
            int mid = s + (e-s)/2;

            boolean isPossible = helper(weights , days , mid);

            if(isPossible){

                ans = mid;

                e = mid -1;

            }else{
                s = mid + 1;
            }
        }
        
        return ans;
    }

    public boolean helper(int[] weights , int days , int mid){
        int day = 1;

        int mid_copy = mid;
        for(int i = 0;i<weights.length;i++){
            if(mid_copy - weights[i] < 0){
                day += 1;
                
                mid_copy = mid;

                mid_copy -= weights[i];

            }else{
                mid_copy -= weights[i];
            }
        }

        if(day <= days){
            return true;
        }else{
            return false;
        }
    }
}
```

## Median of Two sorted Arrays (leetcode - 4) (Hard)

```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2){
            return findMedianSortedArrays(nums2 , nums1);
        }

        int total_on_left_half = (n1+n2+1)/2;
        int total = (n1 + n2);

        int s = 0;
        int e = nums1.length;

        while(s <= e){

            int mid1 = s + (e-s)/2;
            int mid2 = total_on_left_half - mid1;

            int r1 = Integer.MAX_VALUE;
            int l1 = Integer.MIN_VALUE;

            int r2 = Integer.MAX_VALUE;
            int l2 = Integer.MIN_VALUE;

            if(mid1 < n1){
                r1 = nums1[mid1];
            }

            if(mid2 < n2){
                r2 = nums2[mid2];
            }

            if(mid1-1 >= 0){
                l1 = nums1[mid1 - 1];
            }

            if(mid2 - 1 >= 0){
                l2 = nums2[mid2-1];
            }

            if(l1 <= r2 && l2 <= r1){

                // it is the required condition

                if(total % 2 == 0){
                    return (Math.max(l1 , l2) + Math.min(r1 , r2)) / 2.0;
                }else{
                    return Math.max(l1 , l2);
                }

            }else if(l1 > r2){
                e = mid1 - 1;
            }else{
                s = mid1 + 1;
            }
        }

        return -1.0;
        
    }
}
```

## Find the row with Max ones (gfg) (Medium)

```java
class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        
        int m = arr.length;
        int n = arr[0].length;
        
        int idx = -1;
        int maxNumOfOnes = Integer.MIN_VALUE;
        
        for(int i = 0;i<m;i++){
            
            int lowerBound = lowerBound(arr[i]);
            
            if(lowerBound == -1){
                continue;
            }
            
            int numOfOnesInCurrentRow = arr[i].length - lowerBound;
            
            if(numOfOnesInCurrentRow > maxNumOfOnes){
                idx = i;
                maxNumOfOnes = numOfOnesInCurrentRow;
            }
        }
        
        return idx;
    }
    
    public int lowerBound(int[] arr){
        
        int ans = -1;
        
        int s = 0;
        int e = arr.length-1;
        
        while(s <= e){
            
            int mid = s + (e-s)/2;
            
            if(arr[mid] == 1){
                
                ans = mid;
                e = mid -1;
                
                
            }else if(arr[mid] < 1){
                s = mid + 1;
                
            }
            
        }
        
        return ans;
    }
}
```

## Search in a 2D matrix (leetcode - 74) (Medium)

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int s = 0;
        int e = (m*n) - 1;


        while(s <= e){
            int mid = s + (e-s)/2;

            // System.out.println(mid);

            int rowNum = mid / n;
            int columnNum = mid % n;

            if(matrix[rowNum][columnNum] == target){
                return true;
            }

            else if(matrix[rowNum][columnNum] < target){
                s = mid + 1;
            }

            else{
                e = mid - 1;
            }
        }

        return false;
    }
}
```

## Search in a 2D matrix - II (leetcode - 240)

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        

        int m = matrix.length;
        int n = matrix[0].length;

        int row = 0;
        int column = n - 1;

        while(row < m && column >= 0){
            if(matrix[row][column] == target){
                return true;
            }

            else if(matrix[row][column] > target){

                column--;

            }else{
                row++;
            }
        }

        return false;
    }
}
```

<!-- ```java
class Main {
    
    // make a new student class 
    
    static class Student{
        String name;
        int roll_number;
        float marks;
    }
    
    // A class with constructor
    static class Human{
        String name;
        int age;
        boolean isMarried;
        
        // A constructor
        Human(String new_name , int new_age , boolean marital_status){
            this.name = new_name;
            this.age = new_age;
            this.isMarried = marital_status;
        }
    }
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        
        Student student; // just makes a referance 
        student = new Student(); // allocates memory (new - dynamically allocates memory at run time)
    
        // it will just print the default values
        System.out.println(student.name); // null
        System.out.println(student.roll_number); // 0
        System.out.println(student.marks); //0.0
        
        // we can assign values to the instance variables 
        student.name = "rahul";
        student.roll_number = 2;
        student.marks = 33;
        
        Human human = new Human("rahul" , 23 , false); // initialize instance variables with help of the constructor
        
        System.out.println(human.name); // rahul
        System.out.println(human.age); // 23
        System.out.println(human.isMarried); // false
        
        human.age = 34; // we can override the values
        System.out.println(human.age); // 34
        
        
        
    }
}
``` -->