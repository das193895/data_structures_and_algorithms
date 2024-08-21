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

