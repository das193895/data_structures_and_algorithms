package Arrays;

public class Arrays{

    // linear search

    public static int linear_search(int arr[],int key){
        if(arr.length == 0){
            return -1;
        }

        for(int i = 0;i<arr.length;i++){
            if(arr[i] == key){
                return i;
            }
        }

        return -1;

    }


    // Binary search

    public static int binary_search(int arr[],int key){
        if(arr.length == 0){
            return -1;
        }

        int s = 0;
        int e = arr.length-1;

        while(s<=e){

            int mid = s+(e-s)/2;

            if(arr[mid] == key){
                return mid;
            }

            else if(arr[mid] < key){
                s = mid+1;
            }

            else if(arr[mid] > key){
                e = mid-1;
            }
        }

        return -1;
    }

    // Reversing an array

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


    public static void main(String[] args) {

        int arr[] = {1,2,3,4,5};
        // reverse(arr);

        // for(int i = 0;i<arr.length;i++){
        //     System.out.print(arr[i]+" ");
        // }

        System.out.println(binary_search(arr,78));

        System.out.println("hello world");
    }
}