# Questions Count

1. Easy - 2
2. medium - 2
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