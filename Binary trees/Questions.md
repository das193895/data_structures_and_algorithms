

# Questions Count 

1. easy - 14
2. Medium - 19
3. Hard - 5


## Count maximum number of nodes in a level of a tree (gfg) (easy)

2^(level) / 2

```java
class Solution {
    static int countNodes(int i) {
        // code here
        return (int)Math.pow(2,i) /2;
    }
}
```
## Inorder traversal (easy)

(left , root , right)
```java
class Solution {
    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        // Code
        
        helper(root,arr);
        
        return arr;
    }
    
    void helper(Node node , ArrayList<Integer> arr){
        
        if(node == null){
            return;
        }
        
        helper(node.left , arr);
        arr.add(node.data);
        helper(node.right , arr);
    }
}
```
## Preorder traversal (easy)

(root , left , right)
class BinaryTree

```java
{
    //Function to return a list containing the preorder traversal of the tree.
    static ArrayList<Integer> preorder(Node root)
    {
        // Code here
        
        ArrayList<Integer> arr = new ArrayList<>();
        helper(root , arr);
        return arr;
    }
    
    static void helper(Node node , ArrayList<Integer> arr){
        if(node == null){
            return;
        }
        
        arr.add(node.data);
        helper(node.left , arr);
        helper(node.right , arr);
    }

}
```

## PostOrder traversal  (easy)

(left , right , root)
```java
{
    //Function to return a list containing the postorder traversal of the tree.
    static ArrayList<Integer> postorder(Node root)
    {
        // Code here
        
        ArrayList<Integer> arr = new ArrayList<>();
        helper(root , arr);
        return arr;
    }
    
    static void helper(Node node , ArrayList<Integer> arr){
        if(node == null){
            return;
        }

        helper(node.left , arr);
        helper(node.right , arr);
        arr.add(node.data);
    }

}
```

## Levelorder traversal (BFS) (easy)

```java
class Solution
{
    //Function to return the level order traversal of a tree.
    static ArrayList <Integer> levelOrder(Node root) 
    {
        // Your code here
        ArrayList<Integer> arr = new ArrayList<>();
        
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            Node node = q.poll();
            int val = node.data;
            
            arr.add(val);
            
            if(node.left != null){
                q.add(node.left);
            }
            
            if(node.right != null){
                q.add(node.right);
            }
        }
        return arr;
    }
}
```

## Binary Tree Level order Traversal (leetcode - 102) (Medium)

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list;
        list = new ArrayList<>();

        if(root == null){
            return list;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){

            int current_size = q.size();

            List<Integer> individual;
            individual = new ArrayList<>();

            for(int i = 0;i<current_size;i++){
                TreeNode node = q.poll();

                individual.add(node.val);

                if(node.left != null){
                    q.add(node.left);
                }

                if(node.right != null){
                    q.add(node.right);
                }
            }

            list.add(individual);

        }

        return list;
    }
}
```

## Average of levels in Binary tree (leetcode - 637) (easy)

```java
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();

        List<Double> average_list;
        average_list = new ArrayList<>();

        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            Double level_sum = 0.0;

            for(int i = 0;i<size;i++){
                TreeNode current_node = q.poll();

                level_sum += current_node.val;

                if(current_node.left != null){
                    q.add(current_node.left);
                }

                if(current_node.right != null){
                    q.add(current_node.right);
                }
            }

            Double level_avg = level_sum / size;

            average_list.add(level_avg);
        }

        return average_list;
        
    }
}
```

## Binary Tree zig zag level order traversal (leetcode - 103) (Medium)

```java
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> list;
        list = new ArrayList<>();

        if(root == null){
            return list;
        }

        Queue<TreeNode> q = new LinkedList<>();

        int count = 0;

        q.add(root);

        while(!q.isEmpty()){

            int size = q.size();

            List<Integer> individual;
            individual = new ArrayList<>();

            for(int i = 0;i<size;i++){
                TreeNode node = q.poll();
                individual.add(node.val);

                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            
            if(count % 2 == 0){
                list.add(individual);
            }else if(count % 2 != 0){
                Collections.reverse(individual);
                list.add(individual);
            }
            count += 1;
        }

        return list;
        
    }
}
```

## Binary tree right side view (leetcode - 199) (Medium)

```java
class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> list;
        list = new ArrayList<>();

        if(root == null){
            return list;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){

            int size = q.size();

            List<Integer> individual;
            individual = new ArrayList<>();

            for(int i = 0;i<size;i++){
                TreeNode node = q.poll();

                individual.add(node.val);

                if(node.left != null){
                    q.add(node.left);
                }

                if(node.right != null){
                    q.add(node.right);
                }
            }

            list.add(individual.get(individual.size()-1));
        }

        return list;
    }
}
```

## Check Completeness of a binary tree (Medium) (Leetcode - 958)

```java
class Solution {
    public boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();

            if(node != null){
                q.add(node.left);
                q.add(node.right);
            }else{
                while(!q.isEmpty()){
                    if(q.poll() != null){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
```

## Maximum depth of a binary tree (leetcode - 104) (Easy)

```java
class Solution {
    public int maxDepth(TreeNode root) {

        if(root == null){
            return 0;
        }

        return Math.max(maxDepth(root.left) , maxDepth(root.right)) +1;
        
    }
}
```

## Invert a binary tree / Mirror of a binary tree (leetcode - 226) (easy)

```java
class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        // Your code here
        
        if(node == null){
            return;
        }
        
        Node left = node.left;
        Node right = node.right;
        
        node.left = right;
        node.right = left;
        
        mirror(node.left);
        mirror(node.right);
    }
}
```

## Transforming to sum tree (gfg) (easy)

```java
class Solution{
    public void toSumTree(Node root){
         //add code here.
        
        toSumTreeHelper(root);
         
    }
    
    public int toSumTreeHelper(Node root){
        
        if(root == null){
            return 0;
        }
        
        int val = root.data;
        
        int left_val = toSumTreeHelper(root.left);
        int right_val =toSumTreeHelper(root.right);
        
        root.data = left_val+right_val;
        
        return val+left_val+right_val;
        
    }

}
```

## Same tree (leetcode - 226) (easy)

```java
class Solution
{
    //Function to check if two trees are identical.
	boolean isIdentical(Node root1, Node root2)
	{
	    // Code Here
	    
	    if(root1 == null && root2 == null){
	        return true;
	    }
	    
	    else if(root1 == null && root2 != null){
	        return false;
	    }
	    
	    else if(root1 != null && root2 == null){
	        return false;
	    }
	    
	    return isIdentical(root1.left , root2.left) && (isIdentical(root1.right , root2.right)) && (root1.data == root2.data);
	}
	
}
```

## Symmetric tree (leetcode - 101) (easy)
```java
class Solution {

    public boolean is_same_tree(TreeNode node1,TreeNode node2){

        // condition-1
        if(node1 == null && node2 == null){
            return true;
        }
        
        // condition 2
        if(node1 == null && node2 != null){
            return false;
        }

        // condition 3
        if(node1 != null && node2 == null){
            return false;
        }
        
        // check for left and right subtree for both the trees
        return (is_same_tree(node1.left,node2.left))  && (is_same_tree(node1.right,node2.right) && (node1.val == node2.val));
    }


     public TreeNode invert(TreeNode node){

        if(node == null){
            return node;
        }

        TreeNode left = node.left;
        TreeNode right = node.right;
        
        node.left = right;
        node.right = left;

        node.left = invert(node.left);
        node.right = invert(node.right);
        
        return node;

    }

    public boolean isSymmetric(TreeNode root) {

        TreeNode new_left = invert(root.left);

        root.left = new_left;

        return is_same_tree(root.left, root.right);
        
    }
}
```

## Balanced Binary tree (leetcode - 110) (easy)

```java
class Solution {
    public class Pair{
        int height;
        boolean balanced;
        public Pair(int h , boolean b){
            this.height = h;
            this.balanced = b;
        }
    }
    public boolean isBalanced(TreeNode root) {

        Pair pair = helper(root);

        return pair.balanced;
    }

    public Pair helper(TreeNode root){
        if(root == null){
            return new Pair(0 , true);
        }

        Pair left_info = helper(root.left);
        Pair right_info = helper(root.right);

        int left_h = left_info.height;
        boolean left_b = left_info.balanced;

        int right_h = right_info.height;
        boolean right_b = right_info.balanced;

        int current_height = Math.max(left_h , right_h) + 1;
        boolean current_b = (Math.abs(left_h - right_h) <= 1) && (left_b) && (right_b);

        return new Pair(current_height , current_b);
    }
}
```

## Diameter of a binary tree (leetcode - 543) (Medium)

```java
class Solution {

    class Pair{
        int height;
        int diameter;
        public Pair(int new_height , int new_diameter){
            this.height = new_height;
            this.diameter = new_diameter;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {

        if(root == null){
            return 0;
        }

        Pair info = helper(root);

        return info.diameter;  
    }

    public Pair helper(TreeNode root){
        if(root == null){
            return new Pair(0,0);
        }

        Pair left_info = helper(root.left);
        Pair right_info = helper(root.right);

        int left_h = left_info.height;
        int right_h = right_info.height;

        int left_dia = left_info.diameter;
        int right_dia = right_info.diameter;

        int current_height = Math.max(left_h , right_h) + 1;

        int current_diameter = Math.max(Math.max(left_dia,right_dia),left_h+right_h+1);

        return new Pair(current_height , current_diameter);
    }
}
```

## Maximum path sum in a binary tree (leetcode - 124) (Hard)

```java
class Solution{
    public int helper(TreeNode root , int[] max){
		if(root == null){
			return 0;
        }

        int left_path_sum = helper(root.left , max);
        int right_path_sum = helper(root.right , max);

        int path_sum_through_root = left_path_sum + right_path_sum + root.val;

        int left_path_sum_through_root = left_path_sum + root.val;
        int right_path_sum_through_root = right_path_sum + root.val;
        int only_root = root.val;

        max[0] = Math.max(max[0] , Math.max(left_path_sum_through_root , Math.max(right_path_sum_through_root , Math.max(only_root , path_sum_through_root))));

        return Math.max(left_path_sum_through_root , Math.max(right_path_sum_through_root , only_root));

    }

	public int maxPathSum(TreeNode root){

        int[] max = {Integer.MIN_VALUE};
		helper(root,max);
		return max[0];
    }
}
```

## Vertical order traversal (leetcode - 987) (Hard)

```java
class Solution {
    public class Pair{
        TreeNode node;
        int column;
        int row;

        public Pair(TreeNode n , int col , int r){
            this.node = n;
            this.column = col;
            this.row = r;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> list;
        list = new ArrayList<>();

        if(root == null){
            return list;
        }

        Queue<Pair> q = new LinkedList<>();

        HashMap<Integer , HashMap<Integer , PriorityQueue<Integer>>> map = new HashMap<>();

        int max_col = Integer.MIN_VALUE;
        int min_col = Integer.MAX_VALUE;

        q.add(new Pair(root , 0 , 0));

        while(!q.isEmpty()){

            Pair pair = q.poll();

            TreeNode curr_node = pair.node;
            int curr_col = pair.column;
            int curr_row = pair.row;

            max_col = Math.max(max_col , curr_col);
            min_col = Math.min(min_col , curr_col);

            if(map.containsKey(curr_col)){
                HashMap<Integer , PriorityQueue<Integer>> existing_map = map.get(curr_col);
                if(existing_map.containsKey(curr_row)){
                    PriorityQueue<Integer> existing = existing_map.get(curr_row);
                    existing.add(curr_node.val);
                }else{
                    PriorityQueue<Integer> new_pq = new PriorityQueue<>();
                    new_pq.add(curr_node.val);
                    existing_map.put(curr_row , new_pq);
                }
               
            }else{
                HashMap<Integer, PriorityQueue<Integer>> new_map = new HashMap<>();
                PriorityQueue<Integer> new_pq = new PriorityQueue<>();
                new_pq.add(curr_node.val);
                new_map.put(curr_row , new_pq);
                map.put(curr_col , new_map);
            }

            if(curr_node.left != null){
                int new_col = curr_col - 1;
                int new_row = curr_row + 1;
                TreeNode new_node = curr_node.left;
                q.add(new Pair(new_node , new_col , new_row));

            }
            if(curr_node.right != null){
                int new_col = curr_col + 1;
                int new_row = curr_row + 1;
                TreeNode new_node = curr_node.right;
                q.add(new Pair(new_node , new_col , new_row));
            }
        }

        for(int i = min_col;i<=max_col;i++){

            HashMap<Integer , PriorityQueue<Integer>> traversal_map = map.get(i);

            List<Integer> individual;
            individual = new ArrayList<>();

            List<Integer> keys = new ArrayList<>(traversal_map.keySet());
            Collections.sort(keys);

            for(int key:keys){

                PriorityQueue<Integer> pq = traversal_map.get(key);
                while(!pq.isEmpty()){
                    int ele = pq.poll();
                    individual.add(ele);
                }
            }

            list.add(individual);
        }

        return list;
    }
}
```

## Top view of a binary tree (gfg) (medium)

```java
class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    
    static class Pair{
        Node node;
        int column;
        public Pair(Node n , int c){
            this.node = n;
            this.column = c;
        }
    }
    static ArrayList<Integer> topView(Node root) {
        // add your code
        
        ArrayList<Integer> list = new ArrayList<>();
        
        if(root == null){
            return list;
        }
        
        HashMap<Integer , Integer> map = new HashMap<>();
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(root , 0));
        
        int max_col = Integer.MIN_VALUE;
        int min_col = Integer.MAX_VALUE;
        
        while(!q.isEmpty()){
            Pair pair = q.poll();
            
            Node curr_node = pair.node;
            int curr_col = pair.column;
            
            max_col = Math.max(max_col , curr_col);
            min_col = Math.min(min_col , curr_col);
            
            if(!map.containsKey(curr_col)){
                map.put(curr_col , curr_node.data);
            }
            
            if(curr_node.left != null){
                q.add(new Pair(curr_node.left , curr_col-1));
            }
            
            if(curr_node.right != null){
                q.add(new Pair(curr_node.right , curr_col+1));
            }
        }
        
        for(int i = min_col;i<=max_col;i++){
            list.add(map.get(i));
        }
        
        return list;
        
    }
}
```

## Bottom view of a binary tree (gfg) (Medium)

```java
class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    
    public class Pair{
        
        Node node;
        int column;
        
        public Pair(Node n , int col){
            this.node = n;
            this.column = col;
        }
    }
    
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        
        ArrayList<Integer> list = new ArrayList<>();
        
        if(root == null){
            return list;
        }
        
        Queue<Pair> q = new LinkedList<>();
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int max_col = Integer.MIN_VALUE;
        int min_col = Integer.MAX_VALUE;
        
        q.add(new Pair(root , 0));
        
        while(!q.isEmpty()){
            Pair pair = q.poll();
            
            Node curr_node = pair.node;
            int curr_col = pair.column;
            
            max_col = Math.max(max_col , curr_col);
            min_col = Math.min(min_col , curr_col);
            
            if(!map.containsKey(curr_col)){
                map.put(curr_col , curr_node.data);
            }else{
                map.remove(curr_col);
                map.put(curr_col , curr_node.data);
            }
            
            if(curr_node.left != null){
                q.add(new Pair(curr_node.left,curr_col-1));
            }
            
            if(curr_node.right != null){
                q.add(new Pair(curr_node.right,curr_col+1));
            }
            
        }
        
        for(int i = min_col;i<=max_col;i++){
            list.add(map.get(i));
        }
        
        return list;
    }
}
```

## Diagonal traversal (gfg) (medium)

```java
class Tree

{   
    public void find_max_left_count(Node root ,int left_count , int[] max_left_count){
        if(root == null){
            return;
        }
        
        int max = Math.max(max_left_count[0] , left_count);
        max_left_count[0] = max;
        
        find_max_left_count(root.left , left_count+1 , max_left_count);
        find_max_left_count(root.right , left_count , max_left_count);
        
    }
    public void traversal(Node root , ArrayList<ArrayList<Integer>> arr , int left_idx){
     
         if(root == null){
             return;
         }
         ArrayList<Integer> individual = arr.get(left_idx);
         individual.add(root.data);
         
         traversal(root.left , arr , left_idx + 1);
         traversal(root.right , arr , left_idx);
     }
     public ArrayList<Integer> diagonal(Node root)
      {
       //add your code here.
       
       ArrayList<Integer> ans = new ArrayList<>();
       
       int[] max_left_count = {0};
       
       find_max_left_count(root , 0 , max_left_count);
       
       ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
       
       for(int i = 0;i<=max_left_count[0];i++){
           arr.add(new ArrayList<>());
       }
       
       traversal(root , arr , 0);
       
    
        for(int i = 0;i<arr.size();i++){
            ArrayList<Integer> individual = arr.get(i);
            
            for(int j = 0;j<individual.size();j++){
                ans.add(individual.get(j));
            }
        }
       
        return ans;
      }
}
```

## Boundary traversal (gfg) (Medium)

```java
class Solution
{   
    void left_b_nodes(Node node,ArrayList<Integer> arr){
        
        if(node == null){
            return;
        }
        
        if(node.left == null && node.right == null){
            return;
        }
        
        arr.add(node.data);
        
        if(node.left != null){
            left_b_nodes(node.left , arr);
        }else if(node.right != null){
            left_b_nodes(node.right , arr);
        }
        
    }
    
    void leaf_nodes(Node node , ArrayList<Integer> arr){
        if(node == null){
            return;
        }
        
        if(node.left == null && node.right == null){
            arr.add(node.data);
            return;
        }
        
        leaf_nodes(node.left , arr);
        leaf_nodes(node.right , arr);
        
    }
    
    void right_b_nodes(Node node , ArrayList<Integer> arr){
        
        if(node == null){
            return;
        }
        
        if(node.left == null && node.right == null){
            return;
        }
        
        if(node.right != null){
            right_b_nodes(node.right , arr);
        }
        else if(node.right == null){
            right_b_nodes(node.left , arr);
        }
        
        arr.add(node.data);
        
    }
	ArrayList <Integer> boundary(Node node)
	{
	    
	    ArrayList<Integer> arr = new ArrayList<>();
	    
	    if(node == null){
	        return arr;
	    }
	    
	    arr.add(node.data);
	    
	    left_b_nodes(node.left , arr);
	    
	    leaf_nodes(node , arr);
	    
	    right_b_nodes(node.right , arr);
	    
	   if(arr.size() == 2 && arr.get(0) == arr.get(1)){
	       arr.remove(0);  // when there is only the root node
	   }
	    return arr;
	}
}

```
## Lowest Common Ancestor Of 2 nodes in a binary tree (leetcode -- 236 & gfg) (Medium)

```java
class Solution
{
    //Function to return the lowest common ancestor in a Binary Tree.
	Node lca(Node root, int n1,int n2)
	{
		// Your code here
		
		if(root == null){
		    return null;
		}
		
		if(root.data == n1 || root.data == n2){
		    return root;
		}
		
		Node lca_left = lca(root.left , n1 ,n2);
		Node lca_right = lca(root.right , n1 , n2);
		
		if(lca_left != null && lca_right != null){
		    return root;
		}
		
		else if(lca_left != null && lca_right == null){
		    return lca_left;
		}
		
		else if(lca_right != null && lca_left == null){
		    return lca_right;
		}
		
		return null;
	}
}

```

## Minimum distance between 2 nodes in a binary tree (gfg) (Hard)

```java
class GfG {
    Node findLCA(Node root , int a , int b){
        if(root == null){
            return null;
        }
        
        if(root.data == a || root.data == b){
            return root;
        }
        
        Node left_lca = findLCA(root.left , a , b);
        Node right_lca = findLCA(root.right , a , b);
        
        if(left_lca == null && right_lca == null){
            return null;
        }
        
        if(left_lca == null && right_lca != null){
            return right_lca;
        }
        
        if(left_lca != null && right_lca == null){
            return left_lca;
        }
        
        if(left_lca != null && right_lca != null){
            return root;
        }
        
        return null;
    }
    
    void findDistance(Node LCA , int a , int b , int[] distance , int[] final_distance){
        if(LCA == null){
            return;
        }
        
        distance[0]++;
        
        if(LCA.data == a || LCA.data == b){
            final_distance[0] = distance[0];
            return;
        }
        
        findDistance(LCA.left , a , b , distance , final_distance);
        findDistance(LCA.right , a , b , distance , final_distance);
        
        distance[0]--;
        
        
    }
    int findDist(Node root, int a, int b) {
        // Your code here
        
        Node LCA = findLCA(root , a , b);
        
        int[] distance = {0};
        int[] final_distance = {0};
        
        findDistance(LCA.left , a , b, distance , final_distance);

        int left_distance = final_distance[0];
        
        distance[0] = 0;
        final_distance[0] = 0;
        
        findDistance(LCA.right ,a , b ,distance , final_distance);
        
        int right_distance = final_distance[0];
        
        return left_distance + right_distance;
        
    }
}
```

## Find duplicate subtrees (leetcode-652) (Medium)

```java
class Solution {
    public String helper(TreeNode root , List<TreeNode> list , HashMap<String,Integer> map){
        if(root == null){
            return "N";
        }

        String left = helper(root.left , list , map);
        String right = helper(root.right , list , map);

        String root_string = root.val + " "+left+ " "+right;

        if(map.containsKey(root_string)){
            if(map.get(root_string) == 1){
                list.add(root);
                map.put(root_string , 2);
            }
        }else{
            map.put(root_string , 1);
        }
        return root_string;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        List<TreeNode> list;
        list = new ArrayList<>();

        HashMap<String , Integer> map = new HashMap<>();

        helper(root , list , map);

        return list;
    }
}
```

## Kth ancestor of a node in a binary tree (gfg) (Medium)

```java
class Solution
{   
    public Node helper(Node root , int[] k , int node){
        
        if(root == null){
            return null;
        }
        
        Node l = helper(root.left ,k , node);
        
        Node r = helper(root.right , k , node);
        
        if(root.data == node){
            return root;
        }
        
        if(l == null && r == null && root.data != node){
            return null;
        }
        
        if((l == null && r != null)  ||  (l != null && r == null)){
            k[0]--;
            if(k[0] == 0){
                return root;
            }else{
                if(l != null){
                    return l;
                }else{
                    return r;
                }
            }
        }
        
        return null;
        
    }
    public int kthAncestor(Node root, int k, int node)
    {
        //Write your code here
        
        if(root == null){
            return -1;
        }
        
        int[] k_updated = {k};
        
        Node kth_ancestor = helper(root , k_updated , node);
        
        if(kth_ancestor == null || k_updated[0] > 0){
            return -1;
        }else{
            return kth_ancestor.data;
        }
        
    }
}
```

## Maximum Width of binary tree (leetcode - 662) (Medium) 

```java
class Solution {

    public class Pair{
        TreeNode node;
        long idx;

        public Pair(TreeNode node , long idx){
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root , 1L));

        int level = 1;

        int max_difference = Integer.MIN_VALUE;

        while(!q.isEmpty()){

            int level_difference = -1;

            int size = q.size();
            long current_min_idx = Long.MAX_VALUE;
            long current_max_idx = Long.MIN_VALUE;

            for(int i = 0;i<size;i++){
                Pair pair = q.poll();
                TreeNode current_node = pair.node;
                long current_idx = pair.idx;

                current_min_idx = Math.min(current_min_idx , current_idx);
                current_max_idx = Math.max(current_max_idx , current_idx);

                if(current_node.left != null){
                    q.add(new Pair(current_node.left , 2*current_idx));
                }

                if(current_node.right != null){
                    q.add(new Pair(current_node.right, 2*current_idx + 1));
                }
            }

            level_difference = (int)(current_max_idx - current_min_idx) + 1;

            max_difference = Math.max(max_difference , level_difference);

            level += 1;

        } 

        return max_difference;
        
    }
}
```

## Count complete tree nodes (leetcode - 222) (easy)

```java
class Solution {

    public int find_left_height(TreeNode root){
        if(root == null){
            return 0;
        }

        TreeNode temp = root;

        int count = 0;

        while(temp != null){
            count += 1;
            temp = temp.left;
        }

        return count;
    }

    public int find_right_height(TreeNode root){
        if(root == null){
            return 0;
        }

        TreeNode temp = root;

        int count = 0;

        while(temp != null){
            count += 1;
            temp = temp.right;
        }

        return count;
    }

    public int countNodes(TreeNode root) {

        if(root == null){
            return 0;
        }

        int left_height = find_left_height(root.left);
        int right_height = find_right_height(root.right);

        if(left_height == right_height){
            int num_levels = left_height + 1;
            int num_nodes = (int)Math.pow(2,num_levels) - 1;
            return num_nodes;
        }else{
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
        
    }
}
```

## All nodes at a distance k in a binary tree (leetcode - 863) (Medium)

```java
class Solution {

    class Pair{
		TreeNode parent;
		TreeNode node;
		public Pair(TreeNode r , TreeNode p){
			this.node = r;
			this.parent = p;
        }
    }

    public void parent_map(TreeNode root,HashMap<TreeNode , TreeNode> map){

        if(root == null){
            return;
        }

        map.put(root , null);

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            TreeNode current_node = q.poll();

            if(current_node.left != null){
                map.put(current_node.left , current_node);
                q.add(current_node.left);
            }
            if(current_node.right != null){
                map.put(current_node.right , current_node);
                q.add(current_node.right);
            } 
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> result;
		result = new ArrayList<>();

        HashMap<TreeNode , TreeNode> map = new HashMap<>();

        parent_map(root , map);

        HashSet<TreeNode> visited = new HashSet<>();

        Queue<TreeNode> q = new LinkedList<>();

        int distance = 0;

        q.add(target);

        while(!q.isEmpty()){
            
            int size = q.size();

            for(int i = 0;i<size;i++){

                TreeNode current_node = q.poll();

                visited.add(current_node);

                if(distance == k){
                    result.add(current_node.val);
                }

                TreeNode parent = map.get(current_node);
                TreeNode left_child = current_node.left;
                TreeNode right_child = current_node.right;

                if(parent != null && !visited.contains(parent)){
                    visited.add(parent);
                    q.add(parent);
                }

                if(left_child != null && !visited.contains(left_child)){
                    visited.add(left_child);
                    q.add(left_child);
                }

                if(right_child != null && !visited.contains(right_child)){
                    visited.add(right_child);
                    q.add(right_child);
                }
            }

            distance += 1;
           
        }

        return result;
    }
}
```

## Minimum time required to burn a binary tree (gfg) (Hard)

```java
class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    public static class Pair{
		Node node;
		Node parent;
		public Pair(Node n , Node p){
			this.node = n;
			this.parent = p;

        }
    }
    
    public static void build_parent_map(Node root , HashMap<Node , Node> parent_map , Node[] target_arr,int target){
    	if(root == null){
    		return;
        }
        
        Queue<Node> q = new LinkedList<>();
        
        parent_map.put(root , null);
        
        q.add(root);
        
        while(!q.isEmpty()){
        	Node current_node = q.poll();
        
        	if(current_node.data == target){
        		target_arr[0] = current_node;
            }
        	
        	if(current_node.left != null){
        		parent_map.put(current_node.left , current_node);
        		q.add(current_node.left);
            }
        
            if(current_node.right != null){
            	parent_map.put(current_node.right , current_node);
            	q.add(current_node.right);
            }
        }
    }


    
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        
        HashMap<Node , Node> parent_map = new HashMap<>();
        Node[] target_arr = {null};
        
        build_parent_map(root,parent_map , target_arr,target);
        
        HashSet<Node> visited = new HashSet<>();
        
        Queue<Node> q = new LinkedList<>();
        q.add(target_arr[0]);
        
        int time = 0;
        
        while(!q.isEmpty()){
        	int size = q.size();
        
        	for(int i = 0;i<size;i++){
        	    
        		Node current_node = q.poll();
        		
        		visited.add(current_node);
        		
        
        		Node parent = parent_map.get(current_node);
        		Node left_child = current_node.left;
        		Node right_child = current_node.right;
        		
        		if(parent != null && !visited.contains(parent)){
        			visited.add(parent);
        			q.add(parent);
                }
                
                if(left_child != null && !visited.contains(left_child)){
            			visited.add(left_child);
            			q.add(left_child);
                }
                
                if(right_child != null && !visited.contains(right_child)){
                		visited.add(right_child);
                		q.add(right_child);
                }
                
            }
        
            time += 1;
        }
        
        return time-1;

    }
}
```

## Populating next pointers in each node a binary tree (leetcode -- 116) (Medium)

```java
class Solution {
    public Node connect(Node root) {

        if(root == null){
            return root;
        }

        Node curr = root;

        while(curr.left != null){

            Node temp = curr;

            while(true){
                if(temp == null){
                    break;
                }
                temp.left.next = temp.right;
                if(temp.next != null){
                    temp.right.next = temp.next.left;
                }

                temp = temp.next;
            }

            curr = curr.left;
        }
        return root;
    }
}
```

## Populating next pointers in each node a binary tree - II (leetcode -- 117) (Medium)

```java
class Solution {
    public Node connect(Node root) {

        if(root == null){
            return root;
        } 

        Node  curr = root;

        while(curr != null){
            Node dummy = new Node(0);
            Node temp = dummy;

            while(curr != null){

                if(curr.left != null){
                    temp.next = curr.left;
                    temp = temp.next;
                }

                if(curr.right != null){
                    temp.next = curr.right;
                    temp = temp.next;
                }

                curr = curr.next;
            }

            curr = dummy.next;
            
        }

        return root;
    }
}
```

## Flatten binary tree to linked list (leetcode - 114) (Medium)

```java
class Solution {
    public void flatten(TreeNode root) {

        TreeNode[] prev = {null};

        helper(root , prev); 
    }

    public void helper(TreeNode root , TreeNode[] prev){
        if(root == null){
            return;
        }

        helper(root.right , prev);
        helper(root.left , prev);

        root.right = prev[0];
        root.left = null;
        prev[0] = root;
    }
}
```

## Path sum (leetcode - 112) (easy)

```java
class Solution {

    public void helper(TreeNode root , int targetSum , int[] sum , boolean[] result){
        if(root == null){
            return;
        }

        sum[0] = sum[0] + root.val;

        if(root.left == null && root.right == null){
            
            if(sum[0] == targetSum){
                result[0] = true;
            }
            sum[0] = sum[0] - root.val;
            return;
        }

        helper(root.left , targetSum , sum , result);
        helper(root.right , targetSum , sum , result);

        sum[0] = sum[0] - root.val;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {

        int[] sum = {0};

        boolean[] result = {false};

        helper(root , targetSum , sum , result);

        return result[0];
        
    }
}
```

## Sum root to leaf numbers (leetcode - 129) (Medium)

```java
class Solution {
    public void helper(TreeNode root , ArrayList<String> arr , StringBuilder[] sb){

        if(root == null){
            return;
        }

        sb[0].append(root.val);

        if(root.left == null && root.right == null){
            arr.add(sb[0].toString());
            sb[0].deleteCharAt(sb[0].length()-1);
            return;
        }

        helper(root.left , arr , sb);
        helper(root.right , arr , sb);

        sb[0].deleteCharAt(sb[0].length()-1);
    }

    public int sumNumbers(TreeNode root) {

        ArrayList<String> arr = new ArrayList<>();

        StringBuilder[] sb = {new StringBuilder("")};

        helper(root , arr , sb);

        int total_sum = 0;

        for(int i = 0;i<arr.size();i++){
            total_sum += Integer.parseInt(arr.get(i));
        }
        return total_sum;
    }
}
```

## Paths from root with a specified sum (gfg) (medium)

```java
class Solution
{   
    public static void helper(Node root , int sum , int[] current_sum , ArrayList<ArrayList<Integer>> final_list , ArrayList<Integer> target_sum_list){
        
        if(root == null){
            return;
        }
        
        target_sum_list.add(root.data);
        
        current_sum[0] += root.data;
        
        if(current_sum[0] == sum){
            ArrayList<Integer> arr = new ArrayList<>(target_sum_list);
            final_list.add(arr);
        }
        
        helper(root.left , sum , current_sum , final_list  , target_sum_list);
        helper(root.right , sum , current_sum , final_list  , target_sum_list);
        
        target_sum_list.remove(target_sum_list.size()-1);
        current_sum[0] -= root.data;
        
    }
        
    public static ArrayList<ArrayList<Integer>> printPaths(Node root, int sum)
    {
        // code here
        
        int[] current_sum = {0};
        
        ArrayList<ArrayList<Integer>> final_list = new ArrayList<>();
        
        ArrayList<Integer> target_sum_list = new ArrayList<>();
        
        helper(root , sum , current_sum , final_list , target_sum_list);
        
        return final_list;   
    }
}
```

## Serielize & deserielize binary tree (hard) (leetcode - 297)

```java
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder("");

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();

            if(node == null){
                sb.append("N,");
            }else{
                sb.append(node.val);
                sb.append(",");
            }

            if(node != null){
                q.add(node.left);
                q.add(node.right);
            }
        }

        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data.charAt(0) == 'N'){
            return null;
        }

        String[] str_arr = data.split(",");

        Queue<TreeNode> q = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(str_arr[0]));

        q.add(root);

        int i = 1;

        while(!q.isEmpty()){
            TreeNode current_node = q.poll();

            TreeNode leftNode = null;

            if(!str_arr[i].equals("N")){

                leftNode = new TreeNode(Integer.parseInt(str_arr[i]));
                q.add(leftNode);
            }

            current_node.left = leftNode;
            
            i += 1;

            TreeNode rightNode = null;

            if(!str_arr[i].equals("N")){
                rightNode = new TreeNode(Integer.parseInt(str_arr[i]));
                q.add(rightNode);
            }

            current_node.right = rightNode;

            i += 1;
        }
        return root;
        
    }
}
```







