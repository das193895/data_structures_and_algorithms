## Finding largest element in an array

```java
class Compute {
    
    public int largest(int arr[], int n)
    {
        
        int l = Integer.MIN_VALUE;
        
        for(int i = 0;i<arr.length;i++){
            if(arr[i] > l){
                l = arr[i];
            }
        }
        
        return l;
        
    }
}
```

## Finding minimum and maximum element in an array

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

## Finding the second largest element in an array

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

## Finding the 3rd largest element in an array
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
## Reversing an array

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

## Removing duplicates from a sorted array (leetcode - 26)

```java
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

## moving zeros to end (leetcode 283)

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

## Right Rotation (leetcode 189)

```java
class Solution {

    public void reverse(int arr[], int ptr1 , int ptr2){

        while(ptr2 > ptr1){
            int temp = arr[ptr1];
            arr[ptr1] = arr[ptr2];
            arr[ptr2] = temp;

            ptr1++;
            ptr2--;
        }
    }
    public void rotate(int[] nums, int k) {  // beware of corner cases

        if(k == -1){
            return;
        }

        if(nums.length == 1){
            return;
        }
        

        // we can solve the whole problem by this also 
        if(k > nums.length){
            int c = 0;
            while(c<k){
                int temp = nums[nums.length-1];
                for(int j = nums.length-1;j>0;j--){
                    nums[j] = nums[j-1];
                }
                nums[0] = temp;
                c++;
            }

            return;
        }
        
        // the reversal algorithm only can be used when k >= nums.length
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        
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

