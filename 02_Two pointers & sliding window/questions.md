# Questions Count

Medium - 3
Hard - 

# Questions

## Maximum points you can obtain from the cards (leetcode - 1423) (medium)

```java
class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int left_ptr = k-1;
        int right_ptr = cardPoints.length;

        int left_sum = 0;
        int right_sum = 0;

        int max_sum = Integer.MIN_VALUE;

        for(int i = 0;i<=left_ptr;i++){
            left_sum = left_sum + cardPoints[i];
        }

        int total_sum = left_sum + right_sum;

        max_sum = Math.max(max_sum , total_sum);

        if(k == cardPoints.length){
            return max_sum;
        }

        while(left_ptr >= 0){

            left_sum = left_sum - cardPoints[left_ptr];

            right_sum = right_sum + cardPoints[right_ptr-1];

            total_sum = left_sum + right_sum;

            max_sum = Math.max(max_sum , total_sum);

            left_ptr--;
            right_ptr--;
        }

        return max_sum;

    }
}
```
## Longest Substring without Repeating Characters (leetcode - 3) (medium)

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 0){  // do not forget write this
            return 0;
        }
        HashMap<Character , Integer> map = new HashMap<>();

        int ptr1 = 0;
        int ptr2 = 0;

        int max_length = Integer.MIN_VALUE;

        while(ptr1 < s.length()){

            if(!map.containsKey(s.charAt(ptr1))){
                char key = s.charAt(ptr1);
                int val = ptr1;
                map.put(key,val);
                int curr_length = ptr1 - ptr2 + 1;
                max_length = Math.max(max_length , curr_length);
                ptr1++;
            }

            else{

                int val = map.get(s.charAt(ptr1));
                if(val < ptr2){
                    map.put(s.charAt(ptr1),ptr1);     // important 
                    int curr_length = ptr1 - ptr2 + 1;
                    max_length = Math.max(max_length , curr_length);
                    ptr1++;
                }else if(val >= ptr2){                // do not forget that equal to sign
                    ptr2 = val + 1;                   // important
                    map.put(s.charAt(ptr1),ptr1);     // important
                    int curr_length = ptr1 - ptr2 + 1;
                    max_length = Math.max(max_length , curr_length);
                    ptr1++;
                }
            }
        }
        return max_length;
    }
}
```

## Maximum consecutive ones III (leetcode - 1004) (medium)

Maximum Length of the subarray having zeros >= k  

```java
class Solution {
    public int longestOnes(int[] nums, int k) {

        int max_length = Integer.MIN_VALUE;

        int left = 0;
        int right = 0;

        int num_zeros = 0;

        while(right < nums.length){

            if(nums[right] == 0){
                num_zeros = num_zeros + 1;
            }

            if(num_zeros > k){
                while(num_zeros > k){
                    if(nums[left] == 0){
                        num_zeros = num_zeros - 1;
                    }
                    left++;
                }
            }

            if(num_zeros <= k){
                int curr_length = right - left + 1;
                max_length = Math.max(max_length,curr_length);
            }

            right++;
        }

        return max_length;
    }
}
```

