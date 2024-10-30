


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
## Inorder traversal

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
## Preorder traversal

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

## PostOrder traversal

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

## Levelorder traversal (BFS) 

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

## Invert a binary tree / Mirror of a binary tree

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

## Transforming to sum tree (gfg)

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

## Lowest Common Ancestor Of 2 nodes in a binary tree (leetcode -- 236 & gfg)

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



