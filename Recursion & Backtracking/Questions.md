# Questions Count

1. Easy -- 1
2. Medium -- 3
3. Hard -- 


## Fibonacci Number (leetcode - 509)

```java
class Solution {
    public int fib(int n) {
        if(n <= 1){
            return n;
        }
        
        return (fib(n-1) + fib(n-2));
    }
}
```
## Pow (x , n)  (leetcode - 50) (medium)

```java
class Solution {
    public double myPow(double x, int n) {
        if(n < 0){
            double denominator = helper(x,n*-1);
            return 1/denominator;
        }
        else{
            return helper(x,n);
        }
    }

    public double helper(double x , int n){
        if(n == 0){
            return 1;
        }

        double half = helper(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
```

## Reversing A stack Using recursion (gfg) (medium)

```java
class Solution
{   
    static void pushAtBottom(Stack<Integer> s,int data){
        
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        
        int top = s.pop();
        
        pushAtBottom(s,data);
        
        s.push(top);
        
    }
    static void reverse(Stack<Integer> s)
    {
        // add your code here
        
        if(s.isEmpty()){
            return;
        }
        
        int top = s.pop();
        
        reverse(s);
        
        pushAtBottom(s,top);
    }
}
```

## Sort A stack (gfg) (Medium)

```java
class GfG {
    public void insert(Stack<Integer> s , int num){
        if(s.isEmpty() || (!s.isEmpty() && num > s.peek())){
            s.push(num);
            return;
        }
        
        int top = s.pop();
        insert(s,num);
        s.push(top);

    }
    
    public void sortHelper(Stack<Integer> s) {
        // add code here.
        if(s.isEmpty()){
            return;
        }
        
        int top = s.pop();
        sort(s);
        insert(s , top);
        
    }
    
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        sortHelper(s);
        
        return s;
    }
}
```

##  Subsets (leetcode - 78) (Medium)

```java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> subsetList;

        subsetList = new ArrayList<>();

        ArrayList<Integer> list = new ArrayList<>();

        helper(0 , list , subsetList , nums);

        return subsetList;
        
    }

    public void helper(int idx , ArrayList<Integer> list ,  List<List<Integer>> subsetList , int[] nums){
        if(idx > nums.length-1){
            subsetList.add(new ArrayList<>(list));
            return;
        }

        // pick
        list.add(nums[idx]);
        helper(idx + 1 , list , subsetList , nums);


        // nopick

        list.remove(list.size() - 1);
        helper(idx + 1 , list , subsetList , nums);
    }
}
```

## Subset II (leetcode - 90) (Medium)

```java

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> subsetList;

        subsetList = new ArrayList<>();

        ArrayList<Integer> list = new ArrayList<>();

        helper(0 , list , subsetList , nums);

        return subsetList;
        
    }

     public void helper(int idx , ArrayList<Integer> list ,  List<List<Integer>> subsetList , int[] nums){
        if(idx > nums.length-1){
            subsetList.add(new ArrayList<>(list));
            return;
        }

        // pick
        list.add(nums[idx]);
        helper(idx + 1 , list , subsetList , nums);


        // nopick

        list.remove(list.size() - 1);
        while(idx+1 < nums.length && nums[idx] == nums[idx + 1]){
            idx += 1;
        }
        helper(idx + 1 , list , subsetList , nums);
    }
}

```

## Subset Sums (gfg) (Medium)

```java
class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        
        ArrayList<Integer> subsetSumList = new ArrayList<>();
        
        ArrayList<Integer> subsetList = new ArrayList<>();
        
        helper(0 , arr , subsetList , subsetSumList);
        
        return subsetSumList;
    }
    
    public void helper(int idx , int[] arr , ArrayList<Integer> subsetList, ArrayList<Integer> subsetSumList){
        
        if(idx >= arr.length){
            
            int sum = 0;
            
            for(int i = 0;i<subsetList.size();i++){
                sum += subsetList.get(i);
            }
            
            subsetSumList.add(sum);
            
            return;
        }
        
        subsetList.add(arr[idx]);
        
        helper(idx + 1 , arr , subsetList , subsetSumList);
        
        subsetList.remove(subsetList.size()-1);
        
        helper(idx + 1 , arr , subsetList , subsetSumList);
    }
}
```

## Combination sum (leetcode - 39) (Medium)

```java
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> combinationSumList;
        combinationSumList = new ArrayList<>();

        ArrayList<Integer> list = new ArrayList<>();

        helper(0 , target , list , combinationSumList , candidates);

        return combinationSumList;
        
    }

    public void helper(int idx , int target , ArrayList<Integer> list, List<List<Integer>> combinationSumList , int[] candidates){
        if(target == 0){
            combinationSumList.add(new ArrayList<Integer>(list));
            return;
        }

        if(idx == candidates.length){

            if(target == 0){
                combinationSumList.add(new ArrayList<Integer>(list));
            }

            return;

        }

        // pick 

        if(target >= candidates[idx]){
            list.add(candidates[idx]);
            
            helper(idx , target - candidates[idx] , list ,  combinationSumList , candidates);
            list.remove(list.size()-1);
        }
        
        helper(idx+1 , target , list ,  combinationSumList , candidates);
    
    }
}
```

## Combination sum - II (leetcode - 40) (Medium)

```java
class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> answer = new ArrayList<>();

        ArrayList<Integer> ds = new ArrayList<>();

        helper(0,target,candidates, answer, ds);

        return answer;
    }

    public void helper(int idx , int target , int[] candidates , List<List<Integer>> answer , ArrayList<Integer> ds){
        if(target == 0){
            answer.add(new ArrayList<>(ds));
            return;
        }

        if(idx >= candidates.length){

            if(target == 0){
                answer.add(new ArrayList<>(ds));
            }

            return;
        }

        if(target >= candidates[idx]){
            ds.add(candidates[idx]);
            helper(idx+1 , target - candidates[idx] , candidates , answer , ds);
            ds.remove(ds.size()-1);
        }

        while(idx + 1 < candidates.length && candidates[idx] == candidates[idx+1]){
            idx += 1;
        }

        helper(idx+1 , target, candidates, answer , ds);

    }
}
```

## Permutations (leetcode - 46) (medium)

```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> permutationList;
        permutationList = new ArrayList<>();

        helper(0 , nums , permutationList);

        return permutationList;
        
    }

    public void helper(int idx , int[] nums , List<List<Integer>> permutationList){

        if(idx >= nums.length){
            ArrayList<Integer> list = new ArrayList<>();

            for(int i = 0;i<nums.length;i++){
                list.add(nums[i]);
            }

            permutationList.add(list);
        }

        for(int i = idx;i < nums.length ; i++){
            swap(nums , idx , i);
            helper(idx + 1 , nums , permutationList);
            swap(nums , idx , i);
        }
    }

    public void swap(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

## N - Queens (leetcode - 51) (hard)

```java
class Solution {
    public List<List<String>> solveNQueens(int n) {

        Character[][] board = new Character[n][n];

        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                board[i][j] = '.';
            }
        }

        List<List<String>> answer;
        answer = new ArrayList<>();

        helper(0 , answer , board);

        return answer;
        
    }

    public void helper(int column , List<List<String>> answer , Character[][] board){
        if(column == board.length){
            saveBoard(answer , board);
            return;
        }

        for(int i = 0;i<board.length;i++){
            if(isSafe(board , column , i)){
                board[i][column] = 'Q';
                helper(column + 1 , answer , board);
                board[i][column] = '.';
            }
        }
    }

    public boolean isSafe(Character[][] board , int column , int row){

        int n = board.length;

        boolean ans = true;

        for(int j = 0;j<board.length;j++){
            if(board[row][j] == 'Q'){
                ans = false;
                return false;
            }
        }

        for(int i = 0;i<board.length;i++){
            if(board[i][column] == 'Q'){
                ans = false;
                return false;
            }
        }

        // upper right

        int i = row;
        int j = column;

        while(i >= 0 && j < n){
            if(board[i][j] == 'Q'){
                ans = false;
                return false;
            }
            j++;
            i--;
        }


        // upper left

        i = row;
        j = column;

        while(i >= 0 && j >= 0){
            if(board[i][j] == 'Q'){
                ans = false;
                return false;
            }
            j--;
            i--;
        } 


        // lower right

        i = row;
        j = column;

        while(i < n && j < n){
            if(board[i][j] == 'Q'){
                ans = false;
                return false;
            }
            j++;
            i++;
        } 


        // lower left

        i = row;
        j = column;

        while(i < n && j >= 0){
            if(board[i][j] == 'Q'){
                ans = false;
                return false;
            }
            j--;
            i++;
        }


        return ans; 
    }

    public void saveBoard(List<List<String>> answer , Character[][] board){
        List<String> str_arr = new ArrayList<>();
        for(int i = 0;i<board.length;i++){
           
            StringBuilder sb = new StringBuilder("");
            for(int j = 0;j<board[0].length;j++){
                
                sb.append(board[i][j]);
            }
            str_arr.add(sb.toString());
        }
        answer.add(str_arr);
    }
}
```