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

