
# Questions Count

1. Easy - 2
2. Medium - 4
3. Hard - 

## Computing Fibonacci Series (Easy)

```java
class Solution {
    
    // top down approach -- The recursion way
    static long topDown(int n) {
        // code here
        // Collections.nCopies(size, -1)
        ArrayList<Long> dp = new ArrayList<>(Collections.nCopies(n+1 , -1L));
        System.out.println(dp.get(n));
        return topDown_helper(n , dp);
    }
    
    static long topDown_helper(int n , ArrayList<Long> arr){
        if(n == 0 || n == 1){
            return n;
        }
        
        else if(arr.get(n) != -1){
            return arr.get(n);
        }
        
        long ans = topDown_helper(n-1 , arr) + topDown_helper(n-2 , arr);
        arr.set(n,ans);
        return ans;
        
    }
    
    // Bottom up approach (Tabulation)
    static long bottomUp(int n) {
        // code here
        if(n <= 1){
            return n;
        }
        
        long current = -1;
        long prev = 1;
        long prev2 = 0;
        
        for(int i = 2;i<=n;i++){  
            current = prev + prev2;
            prev2 = prev;
            prev = current;
        }
        
        return prev;
    }
}
```

## Frog Jump (coding ninja) (easy)

```java
public class Solution {
    public static int frogJump(int N, int arr[]) {

        int[] dp = new int[N+1];
        for(int i = 0;i<dp.length;i++){
            dp[i] = -1;
        }
        
        return helper(arr , N-1 , dp);

    }

    public static int helper(int arr[] , int idx , int[] dp){
        if(idx == 0){
            dp[idx] = 0;
            return 0;
        }
        
        if(dp[idx] != -1){
            return dp[idx];
        }
        
        int min = Integer.MAX_VALUE;
        
        int ans1 = Math.abs(arr[idx]-arr[idx-1])+helper(arr , idx -1 , dp);
        
        int ans2 = Integer.MAX_VALUE;
        
        if(idx != 1){
            ans2 = Math.abs(arr[idx]-arr[idx-2])+helper(arr , idx - 2,dp);
        }
        
        int ans = Math.min(ans1,ans2);
        
        dp[idx] = ans;
        
        return ans;
    }
}
```

## Frog Jump with K distances (Coding ninja) (Medium)

```java
public class Solution {
    public static int minimizeCost(int n , int k, int arr[]) {
        // code here
        
        int[] dp = new int[n+1];
        
        for(int i = 0;i<dp.length;i++){
            dp[i] = -1;
        }
        
        return helper(n-1 , k , arr , dp);
    }
    
    public static int helper(int idx , int k , int[] arr , int[] dp){
        if(idx == 0){
            dp[idx] = 0;
            return 0;
        }
        
        if(dp[idx] != -1){
            return dp[idx];
        }
        
        int ans = Integer.MAX_VALUE;
        
        for(int i = 1;i<=k;i++){
            if(idx-i >= 0){
                ans = Math.min(ans , Math.abs(arr[idx]-arr[idx-i])+helper(idx-i,k,arr,dp));
            }
        }
        
        dp[idx] = ans;
        
        return ans;
    }
}
```

## House Robber (leetcode - 198) (Medium)

```java
class Solution {
    public int rob(int[] nums) {

        ArrayList<Integer> dp = new ArrayList<>(Collections.nCopies(nums.length,-1));

        return helper(nums , nums.length - 1 , dp);  
    }

    public int helper(int[] nums , int i , ArrayList<Integer> dp){
        if(i == 0){
            dp.set(0,nums[i]);
            return nums[i];
        }

        if(i < 0){
            return 0;
        }

        if(dp.get(i) != -1){
            return dp.get(i);
        }

        int take = helper(nums , i-2 ,dp) + nums[i];
        int no_take = helper(nums , i-1 ,dp);
        
        int ans = Math.max(take , no_take);
        dp.set(i , ans);
        return ans;

    }
}
```

## House Robber - II (leetcode - 213) (Medium)

```java
class Solution {
     public int rob(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }

        ArrayList<Integer> dp1 = new ArrayList<>(Collections.nCopies(nums.length,-1));
        ArrayList<Integer> dp2 = new ArrayList<>(Collections.nCopies(nums.length,-1));

        int ans1 = helper_1(nums , nums.length - 1 , dp1);

        int ans2 = helper_2(nums , nums.length - 2 , dp2);

        return Math.max(ans1,ans2);  
    }

    public int helper_1(int[] nums , int i , ArrayList<Integer> dp){
        if(i == 1){
            dp.set(1,nums[i]);
            return nums[i];
        }

        if(i <= 0){
            return 0;
        }

        if(dp.get(i) != -1){
            return dp.get(i);
        }

        int take = helper_1(nums , i-2 ,dp) + nums[i];
        int no_take = helper_1(nums , i-1 ,dp);
        
        int ans = Math.max(take , no_take);
        dp.set(i , ans);
        return ans;

    }

    public int helper_2(int[] nums , int i , ArrayList<Integer> dp){
        if(i == 0){
            dp.set(1,nums[i]);
            return nums[i];
        }

        if(i < 0){
            return 0;
        }

        if(dp.get(i) != -1){
            return dp.get(i);
        }

        int take = helper_2(nums , i-2 ,dp) + nums[i];
        int no_take = helper_2(nums , i-1 ,dp);
        
        int ans = Math.max(take , no_take);
        dp.set(i , ans);
        return ans;

    }
}
```

## Climbing stairs (leetcode - 70)

```java
class Solution {
    public int climbStairs(int n) {
        ArrayList<Integer> dp = new ArrayList<>(Collections.nCopies(n+1 , -1));
        return helper(n , dp);     
    }

    public int helper(int n , ArrayList<Integer> dp){
        if(n == 0 || n == 1){
            dp.set(0,1);
            dp.set(1,1);
            return 1;
        }

        if(dp.get(n) != -1){
            return dp.get(n);
        }

        int ans = helper(n-1 , dp) + helper(n-2 , dp);
        dp.set(n , ans);
        return ans;
    }
}
```


## 0 - 1 Knapsack problem (gfg)

```java
class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[]) {
        // your code here
        
        int[][] dp = new int[val.length][W+1];
        
        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        
        return helper(val.length - 1 , W , wt , val , dp);
    }
    
    public static int helper(int idx , int W , int wt[], int val[] , int[][] dp){
        if(W <= 0){
            dp[idx][W] = 0;
            return 0;
        }
        if(idx == 0){
            if(W >= wt[idx]){
                dp[idx][W] = val[idx];
                return val[idx];
            }
            else{
                return 0;
            }
        }
        
        if(dp[idx][W] != -1){
            return dp[idx][W];
        }
        
        int no_take = helper(idx - 1 , W  , wt , val , dp);
        int take = Integer.MIN_VALUE;
        if(W >= wt[idx]){
            take = val[idx] + helper(idx - 1 , W - wt[idx] ,wt , val , dp);
        }
        
        int ans = Math.max (take , no_take);
        
        dp[idx][W] = ans;
        
        return ans;
    }
}
```

## Coin change (leetcode -- 322)

```java
class Solution {
    public int coinChange(int[] coins, int amount) {

        if(amount == 0){
            return 0;
        }

        int[][] dp = new int[coins.length][amount+1];

        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        int ans = helper(coins.length - 1 , coins , amount , dp);

        return ans >= (int)1e9 ? -1 : ans;
        
    }

    public int helper(int idx , int[] coins , int amount , int[][] dp){
        if(amount == 0){
            dp[idx][amount] = 0;
            return 0;
        }

        if(idx == 0){
            if(amount % coins[idx] == 0){
                dp[idx][amount] = amount/coins[idx];
                return amount/coins[idx];
            }
            else{
                dp[idx][amount] = (int)1e9;
                return (int)1e9 ;
            }
        }

        if(dp[idx][amount] != Integer.MAX_VALUE){
            return dp[idx][amount];
        }

        int no_take = helper(idx - 1 , coins , amount , dp);
        int take = Integer.MAX_VALUE;
        if(coins[idx] <= amount){
            take = 1 + helper(idx , coins  , amount - coins[idx] , dp);
        }

        int ans = Math.min(no_take , take);

        dp[idx][amount] = ans;

        return ans;
    }
}
```

# DP On Strings

## Longest Common Subsequence (leetcode -- 1143) (Medium)

```java

class Solution {

    /*Memoization*/

    public int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }

        return helper(text1.length() , text2.length() , text1 , text2 , dp);

    }

    public int helper(int idx1 , int idx2 , String text1 , String text2 ,int[][] dp){

        if(idx1 == 0 || idx2 == 0){
            return 0;
        }

        if(text1.charAt(idx1-1) == text2.charAt(idx2-1)){
            return 1 + helper(idx1-1 , idx2 -1 , text1 , text2 , dp);
        }

        if(dp[idx1][idx2] != -1){
            return dp[idx1][idx2];
        }

        int no_match = Math.max(helper(idx1 - 1 , idx2 , text1 , text2 , dp) , helper(idx1 , idx2 - 1, text1 , text2 , dp));

        dp[idx1][idx2] = no_match;

        return no_match;

    }

    /*Tabulation*/

    public int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for(int j = 0;j<dp[0].length;j++){
            dp[0][j] = 0;
        }

        for(int i = 0;i<dp.length;i++){
            dp[i][0] = 0;
        }

        for(int i = 1 ;i<dp.length;i++){
            for(int j = 1 ;j<dp[0].length;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];

    }

}

```
## Printing the longest Common Subsequence  

-> Will not work if there is several longest common subsequences . It can only generate one of the longest common usubsequences incase of multiple subsequences possible;

```java
 public static String printLongestCommonSubsequence(String text1 , String text2){
        
        // first make the dp matrix of finding the length of the longest common subsequence
        
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        
        for(int j = 0;j<dp[0].length;j++){
            dp[0][j] = 0;
        }
        
        for(int i = 0;i<dp.length;i++){
            dp[i][0] = 0;
        }
        
        for(int i = 1 ; i < dp.length ; i++){
            for(int j = 1;j<dp[0].length ; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        
        // Then backtrack in the dp matrix to findout the longest common subsequence
        
        StringBuilder sb = new StringBuilder("");
        
        int i = dp.length - 1;
        int j = dp[0].length - 1;
        
        while(i > 0 && j > 0){
            
            if(text1.charAt(i-1) == text2.charAt(j-1)){
                sb.append(text1.charAt(i-1));
                i--;
                j--;
            }
            
            else{
                if(dp[i][j-1] > dp[i-1][j]){
                    j = j-1;
                }
                else{
                    i = i-1;
                }
            }
        }
        
        // reverse the stringBuilder sb
        
        int ptr1 = 0;
        int ptr2 = sb.length()-1;
        
        while(ptr1 <= ptr2){
            char temp = sb.charAt(ptr1);
            sb.setCharAt(ptr1 , sb.charAt(ptr2));
            sb.setCharAt(ptr2 , temp);
            
            ptr1++;
            ptr2--;
        }
        
        return sb.toString();
        
    }
```


# DP On stocks

If you are selling the stock in i-th day then you would have bought the stock in between (1 to i-1) days when the stock is at its minimimum. 

## Best time to buy ans sell stock (leetcode -- 121) (Easy)

```java
class Solution {
    public int maxProfit(int[] prices) {

        int minimum = prices[0];

        int profit = Integer.MIN_VALUE;

        for(int i = 1 ; i< prices.length ;i++){
            int current_profit = prices[i] - minimum;
            if(current_profit > 0){
                profit = Math.max(profit , current_profit);
            }
            minimum = Math.min(minimum , prices[i]);
        }
        if(profit == Integer.MIN_VALUE){
            return 0;
        }

        return profit;
    }
}
```

## Best time to buy and sell stock - 2 (leetcode -- 122) (Medium)

```java
class Solution {
    public int maxProfit(int[] prices) {

        int[][] dp = new int [prices.length][3]; 

        for(int i = 0;i<dp.length;i++){
            Arrays.fill(dp[i],Integer.MIN_VALUE);
        }

        return helper(prices , 0 , 1 , dp);
        
    }

    public int helper(int[] prices , int idx , int allowed_to_buy , int[][] dp){
        if(idx == prices.length){
            return 0;
        }

        if(dp[idx][allowed_to_buy] != Integer.MIN_VALUE){
            return dp[idx][allowed_to_buy];
        }

        int profit = 0;

        if(allowed_to_buy == 1){
            profit = Math.max(-prices[idx] + helper(prices , idx + 1 , 0 , dp) , 0 + helper(prices , idx+1 , 1 , dp));
            dp[idx][allowed_to_buy] = profit;
        }

        if(allowed_to_buy != 1){
            profit = Math.max(prices[idx] + helper(prices , idx + 1 , 1 , dp) , 0 + helper(prices , idx+1 , 0 , dp));
            dp[idx][allowed_to_buy] = profit;
        }

        return profit;
    } 
}
```

## Best time to buy and sell stock - 3 (leetcode -- 123) (Hard)

```java
class Solution {
    public int maxProfit(int[] prices) {

        int[][][] dp = new int[prices.length][3][3];

        for(int i = 0;i<prices.length;i++){
            for(int j = 0;j<3 ;j++){
                for(int k = 0;k<3;k++){
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            } 
        }

        return helper(prices , 0 , 1 , 2 , dp);
        
    }

    public int helper(int[] prices , int idx , int allowed_to_buy , int no_of_transactions , int[][][] dp){
        if(no_of_transactions == 0){
            return 0;
        }

        if(idx == prices.length){
            return 0;
        }

        if(dp[idx][allowed_to_buy][no_of_transactions] != Integer.MIN_VALUE){
            return dp[idx][allowed_to_buy][no_of_transactions];
        }

        int profit = 0;

        if(allowed_to_buy == 1){
            profit = Math.max(-prices[idx] + helper(prices , idx + 1 , 0 , no_of_transactions , dp) , 0 + helper(prices , idx + 1 , 1 , no_of_transactions , dp));
            dp[idx][allowed_to_buy][no_of_transactions] = profit;
        }

        if(allowed_to_buy != 1){
            profit = Math.max(prices[idx] + helper(prices , idx + 1 , 1 , no_of_transactions - 1 , dp), 0+ helper(prices , idx + 1 , 0 , no_of_transactions , dp ));
            dp[idx][allowed_to_buy][no_of_transactions] = profit;
        }

        return profit;
    }
}
```

## Best time to buy and sell stock - 4 (leetcode -- 188) (Hard)

```java
class Solution {
    public int maxProfit(int k, int[] prices) {

        int[][][] dp = new int[prices.length][3][k+1];

        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<3;j++){
                for(int w = 0;w<k+1;w++){
                    dp[i][j][w] = Integer.MIN_VALUE;
                }
            }
        }

        return helper(prices , 0 , 1 , k , dp);    
    }

    public int helper(int[] prices , int idx , int allowed_to_buy , int k , int[][][] dp){
        if(k == 0){
            return 0;
        }

        if(idx == prices.length){
            return 0;
        }

        if(dp[idx][allowed_to_buy][k] != Integer.MIN_VALUE){
            return dp[idx][allowed_to_buy][k];
        }

        int profit = 0;

        if(allowed_to_buy == 1){
            profit = Math.max(-prices[idx] + helper(prices , idx + 1 , 0 , k , dp) , 0 + helper(prices , idx + 1 , 1 , k , dp));
            dp[idx][allowed_to_buy][k] = profit;
        }

        if(allowed_to_buy != 1){
            profit = Math.max(prices[idx] + helper(prices , idx + 1 , 1 , k-1 , dp) , 0 + helper(prices , idx + 1 , 0 , k , dp));
            dp[idx][allowed_to_buy][k] = profit;
        }

        return profit;
    }
}
```

## Best time to buy and sell stock With cooldown (leetcode -- 309) (Medium)

```java
class Solution {
    public int maxProfit(int[] prices) {

        int[][] dp = new int[prices.length][3];

        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        return helper(prices , 0 , 1 , dp);
        
    }

    public int helper(int[] prices , int idx , int allowed_to_buy , int[][] dp){
        if(idx >= prices.length){
            return 0;
        }

        if(dp[idx][allowed_to_buy] != Integer.MIN_VALUE){
            return dp[idx][allowed_to_buy];
        }

        int profit = 0;

        if(allowed_to_buy == 1){

            profit = Math.max(-prices[idx] + helper(prices , idx + 1 , 0 , dp) , 0 + helper(prices , idx + 1 , 1 , dp));
            dp[idx][allowed_to_buy] = profit;

        }

        if(allowed_to_buy != 1){
            profit = Math.max(prices[idx] + helper(prices , idx + 2 , 1 , dp) , 0 + helper(prices , idx + 1 , 0 , dp));
            dp[idx][allowed_to_buy] = profit;
        }

        return profit;
    }
}
```

## Best time to buy and sell stock With Transaction fee (leetcode -- 714) (Medium)

```java
class Solution {
    public int maxProfit(int[] prices, int fee) {

        int[][] dp = new int[prices.length][3];

        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        return helper(prices , fee , 0 , 1 , dp); 
    }

    public int helper(int[] prices ,int fee , int idx , int allowed_to_buy , int[][] dp){
        if(idx >= prices.length){
            return 0;
        }

        if(dp[idx][allowed_to_buy] != Integer.MIN_VALUE){
            return dp[idx][allowed_to_buy];
        }

        int profit = 0;

        if(allowed_to_buy == 1){

            profit = Math.max(-prices[idx]-fee + helper(prices , fee , idx + 1 , 0 , dp) , 0 + helper(prices , fee , idx + 1 , 1 , dp));
            dp[idx][allowed_to_buy] = profit;

        }

        if(allowed_to_buy != 1){
            profit = Math.max(prices[idx] + helper(prices , fee , idx + 1 , 1 , dp) , 0 + helper(prices , fee , idx + 1 , 0 , dp));
            dp[idx][allowed_to_buy] = profit;
        }

        return profit;
    }
}
```

