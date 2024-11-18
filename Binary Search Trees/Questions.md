# Questions Count

1. Easy - 5
2. Medium - 8
3. Hard -

# Points to keep in Mind
1. The inorder traversal of BST gives a sorted Array

# Questions

## Check if BT is a BST or not given the inorder traversal (gfg) (easy)

```java
class Solution {
    static boolean isBSTTraversal(int arr[]) {
        // code here
        for(int i = 1;i<arr.length;i++){
            if(arr[i] > arr[i-1]){
                continue;
            }else{
                return false;
            }
        }
        
        return true;
    }
}
```

## Inserting a new value in BST (gfg) (easy)

```java
class Solution {
    // Function to insert a node in a BST.
    Node insert(Node root, int key) {
        // your code here
        
        Node nodeToBeInserted = new Node(key);
        
        if(root == null){
            root = nodeToBeInserted;
            return root;
        }
        
        Node curr = root;
        
        while(true){
            
            if(curr.data == key){
                break;
            }
            else if(curr.data <= key){
                if(curr.right == null){
                    curr.right = nodeToBeInserted;
                    break;
                }
                else{
                    curr = curr.right;
                }
            }
            else if(curr.data > key){
                if(curr.left == null){
                    curr.left = nodeToBeInserted;
                    break;
                }
                else{
                    curr = curr.left;
                }
            }
            
        }
        
        return root;
    }
}
```

## Seaerching in BST (gfg) (easy)

```java
class BST {
    // Function to search a node in BST.
    boolean search(Node root, int x) {
        // Your code here
        
        if(root == null){
            return false;
        }
    
        Node curr = root;
        
        while(true){
            
            if(curr == null){
                break;
            }
            
            else if(curr.data == x){
                return true;
            }
            
            else if(curr.data <  x){
                curr = curr.right;
            }
            
            else{
                curr = curr.left;
            }
        }
        
        return false;
    }
}
```

## Deleting a node in a BST (leetcode - 450) (Medium)

```java
class Solution{
	public TreeNode deleteNode(TreeNode root , int key){
		if(root == null){
			return null;
        }

        if(root.val < key){
            root.right = deleteNode(root.right , key);
        }

        if(root.val > key){
            root.left = deleteNode(root.left , key);
        }

        if(root.val == key){

            // left child present
            if(root.right == null){
                return root.left;
            }

            // right child present
            if(root.left == null){
                return root.right;
            }
            
            // both present
            if(root.right != null && root.left != null){
                int succ_val = getSuccVal(root.right);
                root.val = succ_val;
                root.right = deleteNode(root.right , succ_val);
            }
        }

        return root;
    }

    public int getSuccVal(TreeNode root){
        TreeNode temp = root;
        while(temp.left != null){
            temp = temp.left;
        }
        return temp.val;
    }
}

```

## Count BST nodes that lie in a given range (gfg) (easy)

```java
class Solution
{
    //Function to count number of nodes in BST that lie in the given range.
    
    void helper(Node root , int l , int h , int[] count){
        if(root == null){
            return;
        }
        
        if(root.data <= h && root.data >= l){
            count[0] ++;
            helper(root.left , l , h , count);
            helper(root.right , l, h , count);
        }else if(root.data < l){
            helper(root.right , l , h , count);
        }else if(root.data > h){
            helper(root.left , l , h , count);
        }
    }
    int getCount(Node root,int l, int h)
    {
        //Your code here
        int[] count = {0};
        
        helper(root , l , h , count);
        return count[0];
    }
}

```

## Minimum value in a binary search tree (gfg) (easy)

```java
class Solution {
    // Function to find the minimum element in the given BST.
    int minValue(Node root) {
        // code here
        
        if(root.left == null){
            return root.data;
        }
        
        return minValue(root.left);
    }
}
```

## Ceil of a number in a BST (gfg) (Medium)

```java
class Tree {
    // Function to return the ceil of given number in BST.
    
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        // Code here
        
        int ceil = Integer.MIN_VALUE;
        
        Node temp = root;
        
        while(true){
            if(temp == null){
                break;
            }
            if(temp.data == key){
                ceil = temp.data;
                break;
            }
            
            else if(temp.data > key){
                ceil = temp.data;
                temp = temp.left;
            }
            
            else if(temp.data < key){
                temp = temp.right;
            }
        }
        
        if(ceil == Integer.MIN_VALUE){
            return -1;
        }else{
            return ceil;
        }
    }
}
```

## Floor of a number in a BST (gfg) (Medium)

```java
class Solution {
    public static int floor(Node root, int key) {
        // Code here
        
        if(root == null){
            return -1;
        }
        
        int floor = Integer.MIN_VALUE;
        
        Node temp = root;
        
        while(temp != null){
            
            if(temp.data == key){
                floor = temp.data;
                break;
            }
            
            else if(temp.data < key){
                floor = temp.data;
                temp = temp.right;
            }
            
            else if(temp.data > key){
                temp = temp.left;
            }
        }
        
        if(floor == Integer.MIN_VALUE){
            return -1;
        }else{
            return floor;
        }
    }
}
```

## Finding inorder successor and predecessor of BST (gfg) (Medium) 

```java
class Solution {
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        // code here.
        // update pre[0] with the predecessor of the key
        // update suc[0] with the successor of the key
        
        suc[0] = successor(root , key);
        pre[0] = predecessor(root , key);
        
        
    }
    
     public static Node successor(Node root , int key){
        if(root == null){
            return null;
        }
        
        Node temp = root;
        
        Node succ = null;
        
        while(temp != null){
            
            if(temp.data <= key){
                temp = temp.right;
            }
            
            else if(temp.data > key){
                succ = temp;
                temp = temp.left;
            }
        }
        
        return succ;
    }
    
    public static Node predecessor(Node root , int key){
        if(root == null){
            return null;
        }
        
        Node temp = root;
        
        Node pre = null;
        
        while(temp != null){
            
            if(temp.data >= key){
                temp = temp.left;
            }
            
            else if(temp.data < key){
                pre = temp;
                temp = temp.right;
            }
        }
        
        return pre;
    }
}
```

## Kth Smallest element in a BST with O(1) space (leetcode - 230) (Medium)

```java
class Solution {
    public int kthSmallest(TreeNode root, int k) {

        int[] count = new int[1];

        int[] ans = new int[1];

        helper(root , k , count , ans);

        return ans[0];

    }

    public void helper(TreeNode root, int k,int[] count , int[] ans){
        if(root == null){
            return;
        }       

        helper(root.left , k , count , ans);

        count[0]++;
        if(count[0] == k){
            ans[0] = root.val;
            return;
        }

        helper(root.right , k , count , ans);
    }
}
```

## Kth Largest element in a BST with O(1) space (gfg) (Medium)

```java
class Solution {
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root, int k) {
        // Your code here
        
        if(root == null){
            return -1;
        }
        
        int[] count = {0};
        int[] ans = {-1};
        
        helper(root , k , count , ans);
        
        return ans[0];
    }
    
    public void helper(Node root , int k , int[] count , int[] ans){
        if(root == null){
            return;
        }
        
        helper(root.right , k , count , ans);
        
        count[0]++;
        
        if(count[0] == k){
            ans[0] = root.data;
            return;
        }
        
        helper(root.left , k , count , ans);
    }
}
```

## Converting a binary tree to BST keeping the original structure intact (gfg) (easy)

```java
class Solution
{
    // The given root is the root of the Binary Tree
    // Return the root of the generated BST
    
    Node binaryTreeToBST(Node root)
    {
       // Your code here
       
       ArrayList<Integer> inorder_list = new ArrayList<>();
       
       int[] i = new int[1];
       
       inorder(root , inorder_list);
       
       Collections.sort(inorder_list);

       convertToBST(root , inorder_list , i);
       
       return root;
    }
    
    void inorder(Node root , ArrayList<Integer> inorder_list){
        
        if(root == null){
            return;
        }
        
        inorder(root.left , inorder_list);
        
        inorder_list.add(root.data);
        
        inorder(root.right , inorder_list);
        
    }
    
    void convertToBST(Node root , ArrayList<Integer> sorted_list , int[] idx){
        if(root == null){
            return;
        }
        
        convertToBST(root.left , sorted_list , idx);
        
        
        int listdata = sorted_list.get(idx[0]);
        
        root.data = listdata;
        
        idx[0] = idx[0] + 1;
        
        convertToBST(root.right , sorted_list , idx);
    }
    
}
```

## Validate Binary Search Tree (leetcode - 98) (medium)

```java
class Solution {
    public void helper(TreeNode root , TreeNode[] prev , boolean[]result){
        if(root == null){
            return;
        }

        helper(root.left , prev , result);

        if(prev[0] != null){
            if(root.val <= prev[0].val){
                result[0] = false;
            }
        }

        if(root != null){
            prev[0] = root;
        }


        helper(root.right , prev , result);
    }
    public boolean isValidBST(TreeNode root) {

        TreeNode[] prev = {null};
        boolean[] result = {true};

        helper(root , prev , result);

        return result[0];
    }
}
```

## Lowest Common Ancestor Of 2 nodes in a binary Search Tree (leetcode -- 235 & gfg) (Medium)

```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null){
            return null;
        }

        else if (root.val == p.val || root.val == q.val){
            return root;
        }

        else if((root.val < p.val && root.val > q.val) || (root.val > p.val && root.val < q.val)){
            return root;
        }

        else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right , p , q);
        }

        else{
            return lowestCommonAncestor(root.left , p , q);
        }
        
    }
}
```

## Construct a binary tree from preorder traversal (leetcode - 1008) (Medium)

```java
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {

        if(preorder.length == 0){
            return null;
        }

        int inorder[] = new int[preorder.length];

        for(int i = 0;i<inorder.length;i++){
            inorder[i] = preorder[i];
        }

        Arrays.sort(inorder);

        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0;i<inorder.length;i++){
            map.put(inorder[i] , i);
        }

        int preorder_start = 0;
        int inorder_start = 0;

        int preorder_end = preorder.length-1;
        int inorder_end = inorder.length-1;

        TreeNode root = helper(preorder_start , preorder_end , inorder_start , inorder_end , preorder , inorder , map);

       return root;
    }

    public TreeNode helper(int preorder_start , int preorder_end , int inorder_start , int inorder_end , int[] preorder , int[] inorder , HashMap<Integer , Integer> map){

        if(preorder_start > preorder_end  || inorder_start > inorder_end){
            return null;
        }

        int root_val = preorder[preorder_start];

        int root_idx = map.get(root_val);

        int nums_left = root_idx - inorder_start;

        TreeNode root = new TreeNode(root_val);

        int updated_preorder_start_left = preorder_start + 1;
        int updated_preorder_end_left = preorder_start + nums_left;

        int updated_inorder_start_left = inorder_start;
        int updated_inorder_end_left = root_idx - 1;

        int updated_preorder_start_right = updated_preorder_end_left + 1;
        int updated_preorder_end_right = preorder_end;

        int updated_inorder_start_right = root_idx+1;
        int updated_inorder_end_right = inorder_end;


        root.left = helper(updated_preorder_start_left , updated_preorder_end_left , updated_inorder_start_left , updated_inorder_end_left , preorder , inorder , map);
        root.right = helper(updated_preorder_start_right , updated_preorder_end_right , updated_inorder_start_right , updated_inorder_end_right , preorder , inorder , map);

        return root;
    }
}
```

## Flatten BST to sorted list (gfg) (Medium) 

```java
class Solution {
    
    public void inorder(Node root , ArrayList<Integer> arr){
        if(root == null){
            return;
        }
        
        inorder(root.left , arr);
        
        arr.add(root.data);
        
        inorder(root.right , arr);
    }
    
   
    public Node flattenBST(Node root) {
        // Code here
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        inorder(root, arr);
        
        Node new_root = new Node(-1);
        Node temp = new_root;
        
        int current = 0;
        
        while(current < arr.size()){
            
            temp.right = new Node(arr.get(current));
            temp.left = null;
            temp = temp.right;
            current += 1;
        }
        
        return new_root.right;
    }
}

```

## Populate inorder successor for all nodes (gfg) (Medium)

```java
class Solution {
    
    public void helper(Node root , Node[] prev){
        if(root == null){
            return;
        }
        
        helper(root.right , prev);
        
        if(prev[0] != null){
            root.next = prev[0];
        }
       
        if(root != null){
            prev[0] = root;
        }
        
        helper(root.left , prev);
    }
    public void populateNext(Node root) {
        // code here
        
        Node[] prev = {null};
        
        helper(root , prev);
    }
}
```

## Normal BST to balanced BST (leetcode - 1382) (Medium)

```java
class GfG
{   
    
    void inorder(Node root , ArrayList<Integer> arr){   
        if(root == null){
            return;
        }
        
        inorder(root.left , arr);
        
        arr.add(root.data);
        
        inorder(root.right , arr);
    }
    
    Node buildTree(ArrayList<Integer>arr , int s , int e){
        
        if(s > e){
            return null;
        }
        
        int mid = s + (e-s)/2;
        
        Node root = new Node(arr.get(mid));
        
        root.left = buildTree(arr , s , mid - 1);
        root.right = buildTree(arr , mid + 1 , e);
        
        
        return root;
    
    }
    Node buildBalancedTree(Node root) 
    {
        //Add your code here.
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        inorder(root , arr);
        
        Node new_root = buildTree(arr , 0 , arr.size() - 1);
        
        return new_root;
        
    }
}

```


<!-- ## Binary tree to BST (gfg)

```java
class Solution
{
    // The given root is the root of the Binary Tree
    // Return the root of the generated BST
    
    int i = 0;
    
    Node binaryTreeToBST(Node root)
    {
       // Your code here
       
       ArrayList<Integer> inorder_list = new ArrayList<>();
       
       int[] i = new int[1];
       
       inorder(root , inorder_list);
       
       Collections.sort(inorder_list);
       
       convertToBST(root , inorder_list , i);
       
       return root;
       
       
    }
    
    void inorder(Node root , ArrayList<Integer> inorder_list){
        
        if(root == null){
            return;
        }
        
        inorder(root.left , inorder_list);
        
        inorder_list.add(root.data);
        
        inorder(root.right , inorder_list);
        
    }
    
    void convertToBST(Node root , ArrayList<Integer> sorted_list , int[] idx){
        if(root == null){
            return;
        }
        
        convertToBST(root.left , sorted_list , idx);
        
        
        int listdata = sorted_list.get(idx[0]);
        
        root.data = listdata;
        
        idx[0] = idx[0] + 1;
        
        convertToBST(root.right , sorted_list , idx);
    }
    
}
```

## BST contains a deadEnd or not (gfg)

```java
class Solution
{   
    static int min = 1;
    static int max = Integer.MAX_VALUE;
    
    public static boolean isDeadEnd(Node root)
    {
        //Add your code here.
        
        boolean[] val = new boolean[1];
        
        helper(root , min , max , val);
        
        return val[0];

    }
    
    public static void helper(Node root ,int min ,int max, boolean[] val){
        if(root == null){
            return;
        }
        
        if(root.left == null && root.right == null){
            if(min == max){
                val[0] = true;
                
            }
        }
        
        helper(root.left , min , root.data - 1 , val);
        helper(root.right , root.data+1 , max , val);
    }

}
```

## Finding inorder successor and predecessor of a binary tree (gfg)

```java
class Solution {
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        // code here.
        // update pre[0] with the predecessor of the key
        // update suc[0] with the successor of the key
        
        pre[0] = new Node(-1);
        suc[0] = new Node(-1);
        
        findPre(root , pre , key);
        findSuc(root , suc , key);
        
    }
    
    public static void findPre(Node root , Node[] pre , int key){
        if(root == null){
            return;
        }
        
        else if(root.data < key){
            pre[0] = root;
            findPre(root.right , pre, key);
        }
        
        else if(root.data >= key){
            findPre(root.left , pre ,key);
        }
    }
    
    public static void findSuc(Node root , Node[] suc , int key){
        if(root == null){
            return;
        }
        
        else if(root.data > key){
            suc[0] = root;
            findSuc(root.left , suc , key);
        }
        
        else if(root.data <= key){
            findSuc(root.right , suc , key);
        }
    }

    
}
```
``` -->