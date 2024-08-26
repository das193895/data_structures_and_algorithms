# Level -- Easy

## Inserting a new value in BST 

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

## Seaerching in BST 

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

## Minimum value in a binary search tree

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

## Binary tree to BST (gfg)

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


# Level - Medium

## Lowest Common Ancestor Of 2 nodes in a binary Search Tree (leetcode -- 235 & gfg)

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

## Kth Smallest elemnt in a BST (gfg & leetcode 230)

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

## Kth Largest elemnt in a BST (gfg)

```java
class Solution
{
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root,int k)
    {
        //Your code here
        
        int[] ans= new int[1];
        int[] count = new int[1];
        
        helper(root , k , ans , count);
        
        return ans[0];
    }
    
    public void helper(Node root , int k , int[] ans , int[] count){
        if(root == null){
            return;
        }
        
        helper(root.right , k , ans , count);
        
        count[0]++;
        if(count[0] == k){
            ans[0] = root.data;
            return;
        }
        
        helper(root.left , k , ans , count);
        
    }
}
```