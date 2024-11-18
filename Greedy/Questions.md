# Questions

## Jump game (leetcode - 55)

```java
class Solution {
    public boolean canJump(int[] nums) {
        int max_idx_till_we_can_go = 0;

        for(int i = 0;i<nums.length;i++){
            if(i <= max_idx_till_we_can_go){
                max_idx_till_we_can_go = Math.max(max_idx_till_we_can_go , i + nums[i]);
                if(max_idx_till_we_can_go >= nums.length-1){
                    return true;
                }
            }
        }

        return false;
    }
}
```