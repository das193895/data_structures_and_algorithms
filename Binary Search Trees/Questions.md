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