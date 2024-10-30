
# Questions Count

1. Easy - 3
2. Medium - 29
3. Hard - 5

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

## Optimal Strategy Of game (gfg) (Medium)

```java
class solve {
    // Function to find the maximum possible amount of money we can win.
    static long maximumAmount(int arr[], int n) {
        // Your code here
        
        long[][][] dp = new long[n+1][n+1][2];
        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                for(int k = 0;k<2;k++){
                    dp[i][j][k] = -1L;
                }
            }
        }
        
        return helper(0 , n-1 , 1 , arr , dp);
        
    }
    
    static long helper(int ptr1 , int ptr2 , int turn , int[] arr , long[][][] dp){
        
        if(ptr2 < ptr1){
            return 0L;
        }
        
        if(dp[ptr1][ptr2][turn] != -1L){
            return dp[ptr1][ptr2][turn];
        }
        
        long ans = -10L;
        
        if(turn == 1){

            long pick1 = (long)arr[ptr1] + helper(ptr1+1 , ptr2 , 0 , arr , dp);
            
            long pick2 = (long)arr[ptr2] + helper(ptr1 , ptr2 - 1 , 0 , arr , dp);
            
            if(ptr1 == ptr2){
                ans = pick1;
            }else{
                ans = Math.max(pick1 , pick2);
            }
            
        }else if(turn == 0){
            long pick1 = 0 + helper(ptr1+1 , ptr2 , 1 , arr , dp);
            long pick2 = 0 + helper(ptr1 , ptr2 - 1 , 1 , arr , dp);
            if(ptr1 == ptr2){
                ans = pick1;
            }else{
                ans = Math.min(pick1 , pick2);
            }
        }
        
        dp[ptr1][ptr2][turn] = ans;
        
        return ans;
    }
}
```

## Climbing stairs (leetcode - 70) (easy)

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

# DP on Grids 

## Geek's Training (gfg) (Medium)

```java
class Solution {
    public int maximumPoints(int arr[][], int N) {
        // code here
        
        int[][] dp = new int[N+1][5];
        
        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        
        return helper(0 , 3 , arr , dp  , N);
    }
    
    public int helper(int day , int activities , int[][] arr , int[][] dp , int N){
        
        if(day == N-1){
            int maxi = Integer.MIN_VALUE;
            
            for(int i = 0;i<arr[day].length;i++){
                if(i != activities){
                    maxi = Math.max(maxi,arr[day][i]);
                }
            }
            
            return maxi;
        }
        
        if(dp[day][activities] != -1){
            return dp[day][activities];
        }
        
        int ans = -1;
        
        int result = 0;
        
        for(int act = 0;act<3;act++){
            if(act != activities){
                
                result = arr[day][act] + helper(day+1 , act , arr , dp , N);
                ans = Math.max(ans,result);   
            }
        }
        
        dp[day][activities] = ans;
        
        return ans;
    }
}
```

## Unique Paths (leetcode - 62) (Medium)

```java
class Solution {
    public int uniquePaths(int m, int n) {
       
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(0,0,m ,n,dp);
    }

    public int helper(int i , int j , int m , int n , int[][] dp){
        if(i == m-1 && j == n-1){
            return 1;
        }

        if(i >= m || j >= n){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int bottom = helper(i+1 , j , m , n ,dp);
        int right = helper(i , j+1 , m , n ,dp);

        int ans = bottom + right;
        dp[i][j] = ans;

        return ans;
    }
}
```

## Unique Paths - II (leetcode - 63) (Medium)

```java
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1] == 1){
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(obstacleGrid,0,0,m ,n,dp);
        
    }

    public int helper(int[][] grid ,int i , int j , int m , int n , int[][] dp){
        if(i == m-1 && j == n-1){
            dp[i][j] = 1;
            return 1;
        }

        if(i >= m || j >= n){
            return 0;
        }

        if(grid[i][j] == 1){
            dp[i][j] = 0;
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int bottom = helper(grid ,i+1 , j , m , n ,dp);
        int right = helper(grid ,i , j+1 , m , n ,dp);

        int ans = bottom + right;
        dp[i][j] = ans;

        return ans;
    }
}
```

## Minimum Path sum (leetcode - 64) (medium)

```java
class Solution {
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for(int i = 0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(grid , 0 , 0 , m , n ,dp);
        
    }

    public int helper(int[][] grid , int i , int j , int m , int n , int[][] dp){
        if(i == m-1 && j == n-1){
            dp[i][j] = grid[i][j];
            return grid[i][j];
        }
        
        if( i >= m || j >= n){
            return (int)1e9;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int right = grid[i][j] + helper(grid , i , j+1 , m , n , dp);
        int bottom = grid[i][j] + helper(grid , i+1 , j , m , n , dp);

        int ans = Math.min(right , bottom);
        dp[i][j] = ans;

        return ans;
         
    }
}
```

## Triangle (leetcode - 120) (Medium)

```java
class Solution {
    public static int minimizeSum(int k, ArrayList<ArrayList<Integer> >grid) {
        // Code here
        
        int n = grid.size();
        int m = grid.get(n-1).size();
        
        int [][] dp = new int[n+1][m+1];
        
        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        
        return helper(0 , 0 , grid , dp, n , m);
    }
    
    public static int helper(int idx1 , int idx2 , ArrayList<ArrayList<Integer>>grid , int[][] dp , int n , int m){
        if(idx1 == n-1){
            return grid.get(idx1).get(idx2);
        }
        
        if(dp[idx1][idx2] != -1){
            return dp[idx1][idx2];
        }
        
        int bottom = grid.get(idx1).get(idx2) + helper(idx1+1 , idx2 , grid , dp , n , m);
        int corner = grid.get(idx1).get(idx2) + helper(idx1+1 , idx2+1 , grid , dp , n , m);
        
        int ans = Math.min(bottom , corner);
        
        dp[idx1][idx2] = ans;
        
        return ans;
    }
}
```

## Minimum Falling path sum (leetcode - 931)

```java
class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        for(int i = 0 ;i<m ;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }

        return helper_one(matrix , m , n , dp);
  
    }

    public int helper_one(int[][] matrix , int m , int n , int[][] dp){
        int min = Integer.MAX_VALUE;
        for(int j = 0 ; j < matrix[0].length;j++){
            min = Math.min(min , helper_two(matrix,0 ,j,m , n , dp));
        }
        return min;
    }

    public int helper_two(int[][] matrix , int i , int j , int m , int n , int[][] dp){
        if(j < 0 || j >= n){
            return (int)1e9;
        }

        if(i == m-1){
            dp[i][j] = matrix[i][j];
            return matrix[i][j];
        }


        if(dp[i][j] != Integer.MAX_VALUE){
            return dp[i][j];
        }

        int bottom = matrix[i][j] + helper_two(matrix , i+1 , j , m , n , dp);
        int left_corner = matrix[i][j] + helper_two(matrix , i+1 , j-1 , m , n , dp);
        int right_corner = matrix[i][j] +  helper_two(matrix , i+1 , j+1 , m , n , dp);

        int ans = Math.min(bottom , Math.min(left_corner , right_corner));
        dp[i][j] = ans;
        return ans;
    }

}
```

## Assembly line scheduling (gfg) (Medium)

```java
class Solution {
    public static int carAssembly(int nk, int[][] a, int[][] T, int[] e, int[] X) {
        // code here
        
        int n = a.length;
        int m = a[0].length;
        
        int[][] dp = new int[n+1][m+1];
        
        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        
        int ans1 = helper(0 , 0 , a , T , e , X , n , m , dp);
     
        int ans2 = helper(1 , 0 , a , T , e , X , n , m , dp);
        
        return Math.min(ans1,ans2);
        
    }
    
    public static int helper(int idx1 , int idx2 , int[][] a, int[][] T,int[] e,  int[] X ,  int n , int m , int[][] dp){
        
        
        if(idx2 == m-1){
            if(idx1 == 0){
                return X[0] + a[0][m-1];
            }
            else{
                return X[1] + a[1][m-1];
            }
        }
        
        
        if(dp[idx1][idx2] != -1){
            return dp[idx1][idx2];
        }
        
        int ans = Integer.MAX_VALUE;
        
        if(idx1 == 0){
            int cost_from_diagonal = T[idx1][idx2+1];
            
            int starting_cost = 0;
            if(idx2 == 0){
                starting_cost = e[0];
            }
            
            int forward = starting_cost + a[idx1][idx2] + helper(idx1 , idx2+1 , a , T , e , X , n , m , dp);
            int diagonal = starting_cost + a[idx1][idx2] + cost_from_diagonal + helper(idx1+1 , idx2+1 , a , T , e , X , n , m , dp);
            ans = Math.min(forward , diagonal);
            dp[idx1][idx2] = ans;
        }else if(idx1 == 1){
            
            int cost_from_diagonal = T[idx1][idx2+1];
            
            int starting_cost = 0;
            if(idx2 == 0){
                starting_cost = e[1];
            }
            
            int forward = starting_cost + a[idx1][idx2] + helper(idx1 , idx2+1 , a , T , e , X , n , m , dp);
            int diagonal = starting_cost + a[idx1][idx2] + cost_from_diagonal + helper(idx1-1 , idx2+1 , a , T , e , X , n , m , dp);
            ans = Math.min(forward , diagonal);
            dp[idx1][idx2] = ans;
        }
        
        return ans;
        
    }
}
        

```

# DP On subsequences


## Subset Sum Problem (gfg) (Medium)


```java
class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        
        int[][] dp = new int[arr.length+1][sum+1];
        
        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        
        return helper(0 , sum , arr , dp);
    }
    
    static boolean helper(int idx , int sum , int[] arr , int[][] dp){
        if(sum == 0){
            return true;
        }
        
        if(idx >= arr.length){
            if(sum == 0){
                return true;
            }else{
                return false;
            }
        }
        
        if(dp[idx][sum] != -1){
            if(dp[idx][sum] == 1){
                return true;
            }else{
                return false;
            }
        }
        
        boolean take = false;
        
        if(sum >= arr[idx]){
            take = helper(idx+1 , sum - arr[idx] , arr , dp);
        }
        
        boolean no_take = helper(idx+1 , sum , arr , dp);
        
        boolean ans = take || no_take;
        
        if(ans == true){
            dp[idx][sum] = 1;
        }else{
            dp[idx][sum] = 0;
        }
        
        return ans;
        
    }
}
```

## Perfect sum Problem (gfg) (Medium)

(Count subsets with sum k)

(Do not confuse it with "Subarray sum problem")

```java
class Solution{

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    
	    Arrays.sort(arr);
	    
	    int[][] dp = new int[n+1][sum+1];
	    
	    for(int i = 0;i<dp.length;i++){
	        for(int j = 0;j<dp[0].length;j++){
	            dp[i][j] = -1;
	        }
	    }
	    
	    return helper(0 , sum , arr , dp) % 1000000007;
	} 
	
	public int helper(int idx , int sum , int[] arr , int[][] dp){
	    
	    if(sum == 0){
	        dp[idx][sum] = 1;
	        return 1;
	    }
	    
	    if(idx >= arr.length){
	        if(sum == 0){
	            return 1;
	        }else{
	            return 0;
	        }
	    }
	    
	    
	    if(dp[idx][sum] != -1){
	        return dp[idx][sum];
	    }
	    
	    int take = 0;
	    
	    if(sum >= arr[idx]){
	        take = helper(idx+1 , sum - arr[idx] , arr , dp) % 1000000007;
	    }
	    
	    int no_take = helper(idx+1 , sum , arr , dp) % 1000000007;
	    
	    int ans = (take+no_take) % 1000000007;
	    
	    dp[idx][sum] = ans;
	    
	    return ans;
	    
	}
	    
}
```
## Partition equal subset sum (leetcode - 416) (Medium)

Find if there is a subset whose sum equals the target where target = sum of all elements of the array / 2

```java
class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        for(int i = 0 ;i<nums.length;i++){
            sum = sum + nums[i];
        }

        if(sum % 2 != 0){
            return false;
        }

        int[][] dp = new int[nums.length][sum/2 + 1];

        for(int i = 0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(nums , nums.length - 1 , sum/2 , dp);
        
    }

    public boolean helper(int[] nums , int idx , int target , int[][] dp){
        if(target == 0){
            return true;
        }

        if(idx == 0){
            if(target == nums[idx]){
                return true;
            }
            else{
                return false;
            }
        }

        if(dp[idx][target] != -1){
            if(dp[idx][target] == 1){
                return true;
            }
            else{
                return false;
            }
        }

        boolean no_take = helper(nums , idx - 1 , target , dp);
        boolean take = false;
        if(target >= nums[idx]){
            take =  helper(nums , idx - 1 , target - nums[idx] , dp);
        }

        boolean ans = take || no_take;

        if(ans == true){
            dp[idx][target] = 1;
        }
        else{
            dp[idx][target] = 0;
        }

        return ans;
    }

}
```


<!-- ## 0 - 1 Knapsack problem (gfg)

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
``` -->

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
## Printing the longest Common Subsequence  (Medium)

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
        
        return sb.reverse().toString();
        
    }
```

## Longest Common Substring (gfg) (Medium)

```java
class Solution {
    public int longestCommonSubstr(String str1, String str2) {
        // code here
        
        int n = str1.length();
        int m = str2.length();
        
        int[][] dp = new int[n+1][m+1];
        
        for(int j = 0 ; j < dp[0].length;j++){
            dp[0][j] = 0;
        }
        
        for(int i = 0;i<dp.length;i++){
            dp[i][0] = 0;
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int i = 1;i < dp.length;i++){
            for(int j = 1;j < dp[0].length;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max , dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        
        if(max == Integer.MIN_VALUE){
            return 0;
        }
        
        return max;
    }
}
```

## Longest Pallindromic Subsequence (leetcode - 516) (Medium)

```java
class Solution {

    public String reverse(String s){
        int ptr1 = 0;
        int ptr2 = s.length()-1;

        char[] s_arr = s.toCharArray();

        while(ptr1 <= ptr2){
            char temp = s_arr[ptr2];
            s_arr[ptr2] = s_arr[ptr1];
            s_arr[ptr1] = temp;

            ptr1++;
            ptr2--;
        }

        return new String(s_arr);
    }
    public int longestPalindromeSubseq(String s) {

        String str1 = s;
        String str2 = reverse(s);

        return longestCommonSubsequence(str1 , str2);
        
    }

    public int longestCommonSubsequence(String str1 , String str2){

        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n+1][m+1];

        for(int j = 0;j<dp[0].length;j++){
            dp[0][j] = 0;
        }

        for(int i = 0;i<dp.length;i++){
            dp[i][0] = 0;
        }

        for(int i = 1;i<dp.length;i++){
            for(int j = 1;j<dp[0].length;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }
}
```

## Minimum insertion steps to make a String Pallindrome (leetcode - 1312) (Hard)

```java
class Solution {

    public String reverse(String s){
        int ptr1 = 0;
        int ptr2 = s.length()-1;

        char[] s_arr = s.toCharArray();

        while(ptr1 <= ptr2){
            char temp = s_arr[ptr1];
            s_arr[ptr1] = s_arr[ptr2];
            s_arr[ptr2] = temp;
            ptr1++;
            ptr2--;
        }
        return new String(s_arr);
    }
    public int minInsertions(String s) {

        int lps_length = lps(s);

        return s.length() - lps_length;
    }

    public int lps(String s){

        String str1 = s;
        String str2 = reverse(s);

        return lcs(str1 , str2);
    }

    public int lcs(String str1 , String str2){
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i = 0 ; i < dp.length;i++){
            dp[i][0] = 0;
        }

        for(int j = 0;j < dp[0].length;j++){
            dp[0][j] = 0;
        }

        for(int i = 1;i<dp.length;i++){
            for(int j = 1;j<dp[0].length;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }
}
```

## Delete operations for two Strings (leetcode - 583) (Medium)

OR 

Minimum number of insertions or deletions required to convert a string to another

```java
class Solution {
    public int minDistance(String word1, String word2) {

        int longestCommonSubsequence = lcs(word1,word2);

        int deletions1 = word1.length() - longestCommonSubsequence;

        int deletions2 = word2.length() - longestCommonSubsequence;

        return deletions1 + deletions2;
        
    }

    public int lcs(String str1 , String str2){
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i = 0 ; i < dp.length;i++){
            dp[i][0] = 0;
        }

        for(int j = 0;j < dp[0].length;j++){
            dp[0][j] = 0;
        }

        for(int i = 1;i<dp.length;i++){
            for(int j = 1;j<dp[0].length;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }
}
```

## Shortest Common Supersequence (leetcode - 1092) (Hard)

Length of the shortest common supersequence is { length(lcs) + length(str1) - length(lcs) + length(str2) - length(lcs) } finally {length(str1) + length(str2) - length(lcs)} 

```java
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {

        int[][] lcs_matrix = lcs(str1, str2);
        return scs(lcs_matrix,str1,str2);
        
    }

    public String scs(int[][] lcs_matrix,String str1,String str2){
        int i = lcs_matrix.length-1;
        int j = lcs_matrix[0].length-1;

        StringBuilder sb = new StringBuilder();

        while(i > 0 && j > 0){

            if(str1.charAt(i-1) == str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }else{
                if(lcs_matrix[i-1][j] >= lcs_matrix[i][j-1]){
                    sb.append(str1.charAt(i-1));
                    i--;
                }else{
                    sb.append(str2.charAt(j-1));
                    j--;
                }
            }

        } 

        while(i>0){
            sb.append(str1.charAt(i-1));
            i--;
        }
        while(j>0){
            sb.append(str2.charAt(j-1));
            j--;
        }

        return sb.reverse().toString();

    }

    public int[][] lcs(String str1 , String str2){
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];

        for(int j = 0;j<dp[0].length;j++){
            dp[0][j] = 0;
        }

        for(int i = 0;i<dp.length;i++){
            dp[i][0] = 0;
        }

        for(int i = 1;i<dp.length;i++){
            for(int j = 1;j<dp[0].length;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp;
    }
}
```


# DP On stocks

If you are selling the stock in i-th day then you would have bought the stock in between (1 to i-1) days when the stock is at its minimimum. 

## Best time to buy ans sell stock (leetcode -- 121) (Easy)

```java
class Solution {
    public int maximumProfit(int prices[]) {
        // Code here
        
        int min = prices[0];
        int profit = 0; 
        
        for(int i = 1 ; i < prices.length;i++){
            int current_profit = prices[i] - min;
            
            profit = Math.max(profit , current_profit);
            
            min = Math.min(min, prices[i]);
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

# DP On LIS

## Longest Increasing Subsequence (leetcode - 300) (Medium) 

1. Memoaization (Time - O(n^2) , space - O(n^2))

```java
  public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        int[][] dp = new int[n+1][n+1];

        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }

        return helper(0 , -1 , dp , nums);
        
    }

    public int helper(int idx , int prev , int[][] dp , int[] nums){
        if(idx == nums.length){
            return 0;
        }

        if(dp[idx][prev+1] != -1){
            return dp[idx][prev+1];
        }

        int take = Integer.MIN_VALUE;

        int no_take = 0 + helper(idx+1 , prev , dp , nums);

        if(prev == -1 || nums[idx] > nums[prev]){
            take = 1 + helper(idx+1 , idx , dp , nums);
        }

        int ans = Math.max(take , no_take); 

        dp[idx][prev+1] = ans;

        return ans;
    }
```
2. Another method (Time - O(n^2) , space - O(n))

```java
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];

        for(int i = 0;i<dp.length;i++){
            dp[i] = 1;
        }

        int maxi = Integer.MIN_VALUE; 

        for(int i = 0;i<n;i++){
            for(int prev = 0;prev <= i-1;prev++){
                if(i == 0){
                    continue;
                }
                if(nums[prev] < nums[i]){
                    dp[i] = Math.max(dp[i] , dp[prev] + 1);
                }
            }
            maxi = Math.max(maxi , dp[i]);
        }

        return maxi;
    }
```

3. By binary search (Time - O(nlogn) space - O(n))

```java
    public int lengthOfLIS(int[] nums) {

        // By using binary search

        ArrayList<Integer> list = new ArrayList<>();

        int n = nums.length;

        list.add(nums[0]);

        for(int i = 1;i < n;i++){
            if(nums[i] > list.get(list.size()-1)){
                list.add(nums[i]);
            }

            else{
                int idx = Collections.binarySearch(list , nums[i]);

                if(idx < 0){
                    idx = -(idx)-1;
                }
                list.set( idx, nums[i]);
            }
        }

        return list.size();
    }
```

## Longest Subsequence-1 (gfg) (medium)

Given an integer array a[] of size n, find the length of the longest subsequence such that the absolute difference between adjacent elements is 1.

```java
class Solution {
    public static int longestSubseq(int n, int[] a) {
        // code here
        
        int[][] dp = new int[n+1][n+1];
        
        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        
        
        return helper(0 , -1 , a , dp);
        
    }
    
    public static int helper(int idx , int prev , int[] a , int[][] dp){
        
        if(idx == a.length){
            return 0;
        }
        
        if(dp[idx][prev+1] != -1){
            return dp[idx][prev+1];
        }
        
        int no_take = 0 + helper(idx+1 , prev , a , dp);
        
        int take = Integer.MIN_VALUE;
        
        if(prev == -1 || Math.abs(a[idx] - a[prev]) == 1){
            take = 1 + helper(idx+1 , idx , a , dp);
        }
        
        int ans = Math.max(take,no_take);
        
        dp[idx][prev+1] = ans;
        
        return ans;
    }
}
```

## Printing the longest increasing subsequence (gfg) (Medium)

```java

class Solution {
    public ArrayList<Integer> longestIncreasingSubsequence(int n, int a[]) {
        // Code here
        
        int[] dp = new int[n];
        int[] backtrack = new int[n];
        
        for(int i  = 0;i<dp.length;i++){
            dp[i] = 1;
            backtrack[i] = i;
        }
        
        int lis = Integer.MIN_VALUE;
        int max_idx = 0;
        
        for(int i = 0;i<n;i++){
            for(int prev = 0;prev < i;prev++){
                if(i == 0){
                    continue;
                }
                
                if(a[prev] < a[i] && dp[prev] + 1 > dp[i]){ // important step (both the conditions have to be there)
                    dp[i] = dp[prev] + 1;
                    backtrack[i] = prev;
                    
                }
            }
            if(dp[i] > lis){
                lis = dp[i];
                max_idx = i;
            }
        }
        
        ArrayList<Integer> lis_list = new ArrayList<>();
        
        int count = 0;
        
        int ptr = max_idx;
        
        while(count < lis){
            int to_add = a[ptr];
            lis_list.add(to_add);
            ptr = backtrack[ptr];
            count++;
        }
        
        Collections.reverse(lis_list);
        
        return lis_list;
    }
}

```

## Largest divisible subset (leetcode - 368) (Medium)

```java
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        List<Integer> list;
        list = new ArrayList<>();

        int[] dp = new int[nums.length];
        int[] backtrack = new int[nums.length];
        int[] nums1 = new int[nums.length];

        for(int i = 0;i<dp.length;i++){
            dp[i] = 1;
            backtrack[i] = 0;
            nums1[i] = nums[i];
        }

        Arrays.sort(nums1);

        int maxi = Integer.MIN_VALUE;

        int max_idx = -1;

        for(int i = 0;i<nums.length;i++){
            for(int prev = 0;prev<=i-1;prev++){
                if(nums1[i] % nums1[prev] == 0 && dp[prev] + 1 > dp[i]){
                    dp[i] = dp[prev] + 1;
                    backtrack[i] = prev;
                }
            }

            if(maxi < dp[i]){
                maxi = dp[i];
                max_idx = i;
            }
        }

        int count = 0;
        int ptr = max_idx;

        while(count < maxi){
            list.add(nums1[ptr]);
            ptr = backtrack[ptr];
            count++;
        }

        Collections.reverse(list);

        return list;       
    }
}
```

## Longest String Chain (leetcode - 1048) (medium)

```java
class Solution {

    public boolean compare(String str1 , String str2){

        if(str1.length() != str2.length() + 1) {
            return false;
        }

        int first = 0;
        int second = 0;

        while (first < str1.length()) {
            if (second < str2.length() && str1.charAt(first) == str2.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }

        if(first == str1.length() && second == str2.length()){
            return true;
        }
        return false;
    }
    public int longestStrChain(String[] words) {

        int[] dp = new int[words.length];

        Arrays.sort(words, Comparator.comparingInt(String::length)); // sort the array by length

        for(int i = 0;i<dp.length;i++){
            dp[i] = 1;
        }

        int maxi = Integer.MIN_VALUE;

        for(int i = 0;i<words.length;i++){
            for(int prev = 0;prev <= i-1;prev++){
                if(compare(words[i],words[prev]) == true && dp[i] < dp[prev] + 1){
                    dp[i] = dp[prev] + 1;
                }
            }

            maxi = Math.max(maxi , dp[i]);
        }

        return maxi;
        
    }
}
```

## Maximum Length Of pair Chain (leetcode - 646)

```java
class Solution {
    public int findLongestChain(int[][] pairs) {

        int[] dp = new int[pairs.length];

        for(int i = 0;i<dp.length;i++){
            dp[i] = 1;
        }

        // sort  (Important step)

        Arrays.sort(pairs , new Comparator<int[]>(){
            public int compare(int[] a , int[] b){
                return Integer.compare(a[0] , b[0]);
            }
        });

        int maxi = Integer.MIN_VALUE;

        for(int i = 0;i<pairs.length;i++){
            for(int prev = 0;prev<= i-1;prev++){
                if(i == 0){
                    continue;
                }

                if(pairs[prev][1] < pairs[i][0] && dp[prev] + 1 > dp[i]){
                    dp[i] = dp[prev]+1;
                }
            }

            maxi = Math.max(maxi , dp[i]);
        }

        return maxi;
        
    }
}
```

## Longest Biotonic subsequence (gfg) (medium)

1. A strictly increasing or a strictly decreasing sequence should not be considered as a bitonic sequence
```java
class Solution {
    public static int LongestBitonicSequence(int n, int[] nums) {
        // code here
        
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        
        for(int i = 0;i<dp1.length;i++){
            dp1[i] = 1;
            dp2[i] = 1;
        }
        
        for(int i = 0;i<n;i++){
            for(int prev = 0;prev < i;prev++){
                if(i == 0){
                    continue;
                }
                if(nums[prev] < nums[i] && dp1[prev] + 1 > dp1[i]){
                    dp1[i] = dp1[prev] + 1;
                }
            }
        }
        
        for(int i = nums.length-1;i>=0;i--){
            for(int prev = nums.length-1;prev>=i+1;prev--){
                if(i == n-1){
                    continue;
                }
                if(nums[prev] < nums[i] && dp2[prev] + 1 > dp2[i]){
                    dp2[i] = dp2[prev] + 1;
                    
                }
            }
        }
        
        int maxi = Integer.MIN_VALUE;
        
        for(int i = 0;i<n;i++){
            
            if(dp1[i] != 1 && dp2[i] != 1){    // important condition for excluding the strictly increasing and strictly decreasing subsequence
                maxi = Math.max(maxi , dp1[i]+dp2[i]-1);
            }
        }
        
        if(maxi == Integer.MIN_VALUE){
            return 0;
        }else{
            return maxi;
        }
        
    }
}
```

2. A strictly increasing or a strictly decreasing sequence should be considered as a bitonic sequence

```java
class Solution {
    public static int LongestBitonicSequence(int n, int[] nums) {
        // code here
        
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        
        for(int i = 0;i<dp1.length;i++){
            dp1[i] = 1;
            dp2[i] = 1;
        }
        
        for(int i = 0;i<n;i++){
            for(int prev = 0;prev < i;prev++){
                if(i == 0){
                    continue;
                }
                if(nums[prev] < nums[i] && dp1[prev] + 1 > dp1[i]){
                    dp1[i] = dp1[prev] + 1;
                }
            }
        }
        
        for(int i = nums.length-1;i>=0;i--){
            for(int prev = nums.length-1;prev>=i+1;prev--){
                if(i == n-1){
                    continue;
                }
                if(nums[prev] < nums[i] && dp2[prev] + 1 > dp2[i]){
                    dp2[i] = dp2[prev] + 1;
                    
                }
            }
        }
        
        int maxi = Integer.MIN_VALUE;
        
        for(int i = 0;i<n;i++){
            
            maxi = Math.max(maxi , dp1[i]+dp2[i]-1);
 
        }
        
        return maxi;
    }
}
```

# MCM DP / Partition Dp

## Minimum Cost to Cut a stick (leetcode - 1547) (Hard)

```java
class Solution {
    public int minCost(int n, int[] cuts) {

        int c = cuts.length;

        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(0);
        arr.add(n);

        for(int i = 0;i<cuts.length;i++){
            arr.add(cuts[i]);
        }
        Collections.sort(arr);

        int[][] dp = new int[c+1][c+1];

        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }

        return helper(1 , c , arr , dp);
        
    }

    public int helper(int idx1 , int idx2 , ArrayList<Integer> arr , int[][] dp){
        if(idx1 > idx2){
            return 0;
        }

        if(dp[idx1][idx2] != -1){
            return dp[idx1][idx2];
        }

        int cost = Integer.MAX_VALUE;

        for(int cut = idx1;cut <= idx2;cut++){

            int current_cost = arr.get(idx2+1) - arr.get(idx1-1);

            cost = Math.min(cost , current_cost + helper(idx1 , cut-1 , arr , dp) + helper(cut+1 , idx2 , arr , dp));
        }

        dp[idx1][idx2] = cost;

        return cost;
    }
}
```


