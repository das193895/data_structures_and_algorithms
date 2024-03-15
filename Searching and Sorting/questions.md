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