
degree of a node is the number of edges that are connected to that node . And in a graph total degree = 2 * no_odf_edges
directed graph -- indegree and out degree are there

Storing the graph -- Adjacency list(O(2M)) and Adjacency matrix(O(NM)) N is the number of nodes and M is the number of edges

For storing weights in weighted graphs , store weight values in the adjacency matrix between 2 corresponding nodes and in Adjacency lists , store pairs of corresponding node and the weights associated with the edge that is connecting the 2 nodes.

# BFS & DFS 

## BFS 
time complexity -- O(V+E)
```java
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[v+1];
        
        visited[0] = true;
        q.add(0);
        
        while(!q.isEmpty()){
            int element = q.poll();
            
            result.add(element);
            
            for(int i = 0;i<adj.get(element).size();i++){
                if(visited[adj.get(element).get(i)] == false){
                    visited[adj.get(element).get(i)] = true;
                    q.add(adj.get(element).get(i));
                }
            }
        }
        return result;
    }
}
```

# DFS 
time complexity -- O(V+E)
```java
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[v+1];
        
        dfs(v , adj , visited , result , 0);
        
        return result;
    }
    
    public void dfs(int v , ArrayList<ArrayList<Integer>> adj , boolean[] visited , ArrayList<Integer> result , int node){
        visited[node] = true;
        result.add(node);
        
        for(int i = 0;i<adj.get(node).size();i++){
            if(visited[adj.get(node).get(i)] == false){
                dfs(v , adj , visited , result , adj.get(node).get(i));
            }
        }
        
    }
}
```

## Number of provinces (leetcode 547) (Medium)

```java
class Solution {
    public int findCircleNum(int[][] isConnected) {

        boolean[] visited = new boolean[isConnected.length];

        return helper(isConnected , visited);
        
    }

    public int helper(int[][] isConnected , boolean[] visited){
        int count = 0;

        for(int i = 0;i<visited.length;i++){
            if(visited[i] == false){
                dfs(i , isConnected , visited);
                count++;
            }
        }

        return count;
    }

    public void dfs(int node ,int[][] isConnected , boolean[] visited){

        visited[node] = true;

        for(int i = 0;i<isConnected[node].length;i++){
            if(isConnected[node][i] == 1){
                if(visited[i] == false){
                    dfs(i , isConnected , visited);
                }
            }
        }
    }
}
```

## Flood Fill Algorithm (gfg) (Medium)
```java
class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
        
        int initialColor = image[sr][sc];
        
        int[][] newImage = image;
        
        boolean[][] visited = new boolean[image.length][image[0].length];  
        
        dfs(newImage , sr , sc , initialColor , newColor , visited);
        
        return newImage;
        
    }
    
    public void dfs(int[][] newImage , int sr , int sc , int initialColor , int newColor , boolean[][] visited){
        if(newImage[sr][sc] == initialColor){
            newImage[sr][sc] = newColor;
            visited[sr][sc] = true;
        }
        
        for(int di = -1 ; di<=1;di++){
            for(int dj = -1 ;dj<=1;dj++){
                int row = sr + di;
                int col = sc + dj;
                if(row != sr && col != sc){
                    continue;
                }
                if(row >= 0 && row < newImage.length && col >= 0 && col < newImage[0].length && !visited[row][col] && newImage[row][col] == initialColor){
                    dfs(newImage , row , col , initialColor , newColor , visited);
                }
            }
        }
        
    }
}
```

## Rotten oranges (leetcode -- 994) (Medium)

```java
class Solution {
    class Pair{
        int idx1;
        int idx2;
        int time;
        Pair(int i1 , int i2 , int t){
            this.idx1 = i1;
            this.idx2 = i2;
            this.time = t;
        }
    }
    public int orangesRotting(int[][] grid) {

        int[][] newGrid = grid;

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        Queue<Pair> q = new LinkedList<>();

        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    visited[i][j] = true;
                    newGrid[i][j] = 2;
                    q.add(new Pair(i , j , 0));
                }
            }
        }

        int finalTime = 0;

        while(!q.isEmpty()){
            Pair pair = q.poll();

            for(int i = -1;i<=1;i++){
                for(int j = -1 ;j<=1;j++){
                    int row = pair.idx1 + i;
                    int col = pair.idx2 + j;

                    if(row != pair.idx1 && col != pair.idx2){
                        continue;
                    }

                    if(row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && !visited[row][col] && newGrid[row][col] == 1){
                        visited[row][col] = true;
                        newGrid[row][col] = 2;
                        int currt = pair.time + 1;
                        finalTime = currt;
                        q.add(new Pair(row , col , currt));
                    }
                }
            }
        }

        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    if(newGrid[i][j] != 2){
                        return -1;
                    }
                }
            }
        }

        return finalTime;
    }
}
```

## Is Graph Biparatite (leetcode -- 785) (Medium)

```java
class Solution{

    public class Pair{
        int node;
        int color;
        public Pair(int n , int c){
            this.node = n;
            this.color = c;
        }
    }
    public boolean isBipartite(int[][] graph) {

        int[] visited = new int[graph.length];

        for(int i = 0;i<visited.length;i++){
            visited[i] = -1;
        }

        for(int i = 0;i<visited.length;i++){
            if(visited[i] == -1){
                if(bfs(graph , visited , i , 0) == false){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean bfs(int[][] graph , int[] visited , int node , int color){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node , color));
        visited[node] = color;

        while(!q.isEmpty()){

            Pair pair = q.poll();

            int newNode = pair.node;
            int newColor = pair.color;

            for(int i = 0;i<graph[newNode].length;i++){
                int neighbors = graph[newNode][i];

                if(visited[neighbors] != -1 && visited[neighbors] == newColor){
                    return false;
                }

                else if(visited[neighbors] != -1 && visited[neighbors] != newColor){
                    continue;
                }

                else if(visited[neighbors] == -1){
                    visited[neighbors] = 1-newColor;
                    q.add(new Pair(neighbors , 1-newColor));
                }
            }
        }
        return true;
    }
}
```

## Detect Cycle in undirected graph (gfg) (Medium)

```java
class Solution {
    // Function to detect cycle in an undirected graph.
    
    public class Pair{
        int node;
        int parent;
        public Pair(int node , int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[v];
        
        for(int i = 0;i<visited.length;i++){
            visited[i] = false;
        }
        
        for(int i = 0;i<visited.length;i++){
            if(visited[i] == false){
                if(bfs(v , adj , visited , i , -1) == true){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public Boolean bfs(int v , ArrayList<ArrayList<Integer>> adj , boolean[] visited , int node , int parent){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node , parent));
        visited[node] = true;
        
        while(!q.isEmpty()){
            Pair n = q.poll();
            
            int newNode = n.node;
            int newParent = n.parent;
            
            for(int i = 0;i<adj.get(newNode).size();i++){
                int neighbors = adj.get(newNode).get(i);
                if(visited[neighbors] == true & neighbors == newParent){
                    continue;
                }
                else if(visited[neighbors] == true & neighbors != newParent){
                    return true;
                }
                else if(visited[neighbors] == false){
                    visited[neighbors] = true;
                    q.add(new Pair(neighbors , newNode));
                }
            }
            
        }
        
        return false;
    } 
}
```

## Detect Cycle in directed graph (gfg) (Medium)

```java
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        boolean visited[] = new boolean[v];
        boolean pathVisited[] = new boolean[v];
        
        for(int i = 0;i<visited.length;i++){
            if(visited[i] == false){
                if(dfs(i , adj , visited , pathVisited) == true){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean dfs(int node ,ArrayList<ArrayList<Integer>> adj, boolean[] visited , boolean[] pathVisited){
        visited[node] = true;
        
        pathVisited[node] = true;
        
        for(int i = 0;i<adj.get(node).size();i++){
            int neighbors = adj.get(node).get(i);
            
            if(pathVisited[neighbors] == true){
                return true;
            }
            
            if(visited[neighbors] == false){
                if(dfs(neighbors , adj , visited , pathVisited) == true){
                    return true;
                }
            }
        }
        
        pathVisited[node] = false;;
        
        return false;
    }
}
```

## Topological Sort (gfg) (Medium)

Only applicable for directed acyclic graph (DAG);

```java
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        
        int[] finalArray = new int[V];
        
        boolean[] visited = new boolean[V];
        
        Stack<Integer> s = new Stack<>();
        
        for(int i = 0;i<visited.length;i++){
            if(visited[i] == false){
                dfs(i,adj , visited , s);
                
            }
        }
        
        int i = 0;
        
        while(!s.isEmpty()){
            int ele = s.pop();
            finalArray[i] = ele;
            i++;
        }
        
        return finalArray;
        
    }
    
    public static void dfs(int node , ArrayList<ArrayList<Integer>> adj , boolean[] visited , Stack<Integer> s){
        visited[node] = true;
        
        for(int i = 0;i<adj.get(node).size();i++){
            int neighbors = adj.get(node).get(i);
            if(visited[neighbors] == false){
                dfs(neighbors , adj , visited , s);
            }
        }
        
        s.add(node);
    }
}
```


