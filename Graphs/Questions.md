
# Questions Count 

1. Easy - 4
2. Medium - 16
3. Hard - 

degree of a node is the number of edges that are connected to that node . And in a graph total degree = 2 * no_of_edges
directed graph -- indegree and out degree are there

Storing the graph -- Adjacency list(O(2M)) and Adjacency matrix(O(NM)) N is the number of nodes and M is the number of edges

For storing weights in weighted graphs , store weight values in the adjacency matrix between 2 corresponding nodes and in Adjacency lists , store pairs of corresponding node and the weights associated with the edge that is connecting the 2 nodes.

# Basic Problems

## Graph & Vertices (gfg) (easy)

Given an integer n representing number of vertices. Find out how many undirected graphs (not necessarily connected) can be constructed out of a given n number of vertices. -- 2 ^ (n(n-1)/2)

```java
class Solution {
    static long count(int n) {
    
    long power = (n*(n-1))/2;
    
    return (long) Math.pow(2,power);
  }
}
```

## Print Adjacency List (gfg) (easy)

```java
class Solution {
    public List<List<Integer>> printGraph(int v, int edges[][]) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int w = edges[i][1];
            adj.get(u).add(w);
            adj.get(w).add(u);
        }
        return adj;
    }
}
```

# BFS & DFS 

## BFS (gfg) (easy)
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
                    visited[adj.get(element).get(i)] = true;       // Important
                    q.add(adj.get(element).get(i));
                }
            }
        }
        return result;
    }
}
```

# DFS  (gfg) (easy)
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
                dfs(v , adj , visited , result , adj.get(node).get(i));   // Important
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
                if(visited[i] == false){                            // Important
                    dfs(i , isConnected , visited);
                }
            }
        }
    }
}
```

## Number of islands (leetcode - 200) (Medium)

```java

// With dfs and considering neighbours horizontally and vertically (4 directions)
class Solution {
    public int numIslands(char[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int count = 0;

        for(int i = 0;i<visited.length;i++){
            for(int j = 0;j<visited[0].length;j++){
                if(visited[i][j] == false && grid[i][j] == '1'){    // Important
                    dfs(i , j ,grid , visited);
                    count++;
                }
            }
        }

        return count;  
    }

    public void dfs(int idx1 , int idx2 ,char[][] grid , boolean[][] visited){
        visited[idx1][idx2] = true;

        for(int di = -1 ; di<= 1 ;di++){
            for(int dj = -1 ; dj <= 1 ; dj ++){
                int row = idx1+di;
                int col = idx2 + dj;
                if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length){      // Important
                    continue;
                }

                if(row == idx1 || col == idx2){       // Important
                     if(grid[row][col] == '1'){
                        if(visited[row][col] == false){
                            dfs(row , col , grid , visited);
                        }
                    }
                }
            }
        }
    }
}

// With bfs and considering neighbours horizontally and vertically as well as diagonally (8 directions)

class Solution {
    public int numIslands(char[][] grid) {
        // Code here
        
        int r = grid.length;
        int c = grid[0].length;
        
        boolean[][] visited = new boolean[r][c];
        
        int count = 0;
        
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                if(visited[i][j] == false && grid[i][j] == '1') {
                    bfs(i,j,grid,visited);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public void bfs(int idx1 , int idx2 , char[][] grid , boolean[][] visited){
        Queue<int[]> q = new LinkedList<>();
        
        int[] arr ={idx1 , idx2};
        
        q.add(arr);
        
        while(!q.isEmpty()){
            
            int[] arr3 = q.poll();
            int i1 = arr3[0];
            int i2 = arr3[1];
            
            for(int i = -1 ; i <= 1;i++){
                for(int j = -1 ; j <= 1 ; j++){
                    int row = i1 + i;
                    int col = i2 + j;
                    if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length){
                        continue;
                    }
                    if(grid[row][col] == '1'){
                        if(visited[row][col] == false){
                            visited[row][col] = true;
                            int[] arr2 = {row,col};
                            q.add(arr2);
                        }
                    }
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

BFS can only be applied

```java
class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        
        int[][] newGrid = grid;
        
        Queue<int[]> q = new LinkedList<>();
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for(int i = 0;i<newGrid.length;i++){
            for(int j = 0;j<newGrid[0].length;j++){
                if(grid[i][j] == 2 && visited[i][j] == false){
                    visited[i][j] = true;
                    int[] arr = {i , j , 0};
                    q.add(arr);
                }
            }
        }
        
        int final_time = 0;
        
        while(!q.isEmpty()){
            int[] arr = q.poll();
            
            int idx1 = arr[0];
            int idx2 = arr[1];
            int time = arr[2];
            
            for(int i = -1 ; i<=1;i++){
                for(int j = -1 ; j<= 1;j++){
                    int row = idx1+i;
                    int col = idx2+j;
                    
                    if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length){
                        continue;
                    }
                    
                    if(row == idx1 || col == idx2){
                        if(visited[row][col] == false && newGrid[row][col] == 1){
                            visited[row][col] = true;
                            newGrid[row][col] = 2;
                            int curr_time = time + 1;
                            final_time = curr_time;
                            int[] arr1 = {row , col , curr_time};
                            q.add(arr1);
                        }
                    }
                }
            }
        }
        
        for(int i = 0 ;i<newGrid.length;i++){
            for(int j = 0;j<newGrid[0].length;j++){
                if(newGrid[i][j] == 1){
                    return -1;
                }
            }
        }
        
        return final_time;
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

## Distence of nearest cell Having 1 (gfg) (Medium)

BFS can only be applied

```java
class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        
        int[][] newGrid = grid;
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0;i<newGrid.length;i++){
            for(int j = 0;j<newGrid[0].length;j++){
                if(newGrid[i][j] == 1){
                    visited[i][j] = true;
                    newGrid[i][j] = 0;
                    int[] arr = {i , j , 0};
                    q.add(arr);
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] arr = q.poll();
            
            int idx1 = arr[0];
            int idx2 = arr[1];
            int distance = arr[2];
            
            // newGrid[idx1][idx2] = distance;
            
            for(int i = -1 ; i <= 1 ; i++){
                for(int j = -1 ; j <= 1 ; j++){
                    int row = idx1+i;
                    int col = idx2+j;
                    if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length){
                        continue;
                    }
                    
                    if(row == idx1 || col == idx2){
                        if(visited[row][col] == false){     // do not use grid[idx1][idx2] == 0 && visited[row][col] == false;
                            int curr_dist = distance + 1;   // Important to declare a new variable and not use (distance = distance + 1)
                            newGrid[row][col] = curr_dist;
                            visited[row][col] = true;
                            int[] arr1 = {row , col , curr_dist};
                            q.add(arr1);
                        }
                    }
                }
            }
        }
        return newGrid;
    }
}
```

## 0/1 matrix (leetcode - 542) (medium)

Just same as the above problem with a slight variation 

```java

class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int[][] distance = mat;
        boolean[][] visited = new boolean[mat.length][mat[0].length];

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0;i<mat.length;i++){
            for(int j = 0;j<mat[0].length;j++){
                if(mat[i][j] == 0){
                    distance[i][j] = 0;
                    visited[i][j] = true;
                    int[] arr = {i , j , 0};
                    q.add(arr);
                }
            }
        }

        while(!q.isEmpty()){
            int[] arr = q.poll();

            int idx1 = arr[0];
            int idx2 = arr[1];
            int dist = arr[2];

            for(int i = -1 ; i <= 1 ; i++){
                for(int j = -1 ; j <= 1 ; j++){
                    int row = idx1 + i;
                    int col = idx2 + j;


                    if(row < 0 || row >= mat.length || col < 0 || col >= mat[0].length){
                        continue;
                    }

                    if(row == idx1 || col == idx2){
                        if(!visited[row][col]){
                            visited[row][col] = true;
                            int current_distance = dist + 1;
                            distance[row][col] = current_distance;
                            int[] arr1 = {row , col , current_distance};
                            q.add(arr1);
                        }
                    }
                }
            }
        }
        return distance;
    }
}

```

## Surrounded Regions (leetcode - 130) (Medium)

```java
class Solution {
    public void solve(char[][] board) {

        boolean[][] visited = new boolean[board.length][board[0].length];

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < board.length;i++){
            for(int j = 0 ; j < board[0].length;j++){
                if(i == 0 || j == 0 || i == board.length - 1 || j == board[0].length-1){
                    if(board[i][j] == 'O'){
                        visited[i][j] = true;
                        int[] arr = {i,j};
                        q.add(arr);
                    }
                }
            }
        }

        while(!q.isEmpty()){
            int[] arr = q.poll();

            int idx1 = arr[0];
            int idx2 = arr[1];

            for(int i = -1 ; i <= 1 ; i ++){
                for(int j = -1 ; j <= 1 ; j++){
                    int row = idx1 + i;
                    int col = idx2 + j;

                    if(row < 0 || row >= board.length || col < 0 || col >= board[0].length){
                        continue;
                    }

                    if(row == idx1 || col == idx2){
                        if(board[row][col] == 'O'){
                            if(visited[row][col] == false){
                                visited[row][col] = true;
                                int[] arr1 = {row , col};
                                q.add(arr1);
                            }
                        }
                    }
                }
            }
        }


        for(int i = 0 ; i < visited.length ; i++){
            for(int j = 0 ; j < visited[0].length; j++){
                if(visited[i][j] == false && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
```

## Number Of Enclaves (gfg) (Medium)

Similar to previous

```java
class Solution {

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < grid.length;i++){
            for(int j = 0 ; j < grid[0].length;j++){
                if(i == 0 || j == 0 || i == grid.length -1 || j == grid[0].length-1){
                    if(grid[i][j] == 1){
                        visited[i][j] = true;
                        int[] arr = {i, j};
                        q.add(arr);
                    }
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] arr = q.poll();
            
            int idx1 = arr[0];
            int idx2 = arr[1];
            
            for(int i = -1;i<=1;i++){
                for(int j = -1;j<=1;j++){
                    
                    int row = idx1 + i;
                    int col = idx2 + j;
                    
                    if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length){
                        continue;
                    }
                    
                    if(row == idx1 || col == idx2){
                        if(grid[row][col] == 1){
                            if(visited[row][col] == false){
                                visited[row][col] = true;
                                int[] arr1 = {row , col};
                                q.add(arr1);
                            }
                        }
                    }
                }
            }
        }
        
        int count = 0;
        
        
        for(int i = 0;i<grid.length;i++){
            for(int j = 0 ; j < grid[0].length;j++){
                
                if(visited[i][j] == false && grid[i][j] == 1){
                    count++;
                }
            }
        }
        
        return count;
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

# Topological Sort & Problems


## Topological Sort (gfg) (Medium) (With BFS / Kahn's Algo)

```java
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        
        int[] indegrees = new int[V];
        
        ArrayList<Integer> topo_sort = new ArrayList<>();
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0;i<adj.size();i++){
            for(int j = 0;j<adj.get(i).size();j++){
                if(adj.get(i).size() > 0){
                    indegrees[adj.get(i).get(j)]++;
                }
            }
        }
        
        for(int i = 0 ;i < indegrees.length;i++){
            if(indegrees[i] == 0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int ele = q.poll();
            
            for(int i = 0;i<adj.get(ele).size();i++){
                int neighbors = adj.get(ele).get(i);
                indegrees[neighbors]--;
                if(indegrees[neighbors] == 0){
                    q.add(neighbors);
                }
            }
            
            topo_sort.add(ele);
            
        }
        
        int[] topo_arr = new int[V];
        
        for(int i = 0;i<topo_sort.size();i++){
            topo_arr[i] = topo_sort.get(i);
        }
        
        return topo_arr;
    }
}

```

## Topological Sort (gfg) (Medium) (With dfs)

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

## Cycle Detection in directed graphs (gfg) (Medium)

Apply topo sort and we know topo sort is only applicable for directed acyclic graph and if we apply it on a directed cyclic graph then our array having topological ordering will always be lesser than the total number of vertices. 

```java
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        ArrayList<Integer> topo_sort = new ArrayList<>();
        
        int[] indegree = new int[V];
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0;i<adj.size();i++){
            for(int j = 0;j<adj.get(i).size();j++){
                if(adj.get(i).size() > 0){
                    indegree[adj.get(i).get(j)]++;
                }
            }
        }
        
        
        for(int i = 0;i<indegree.length;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int ele = q.poll();
            
            for(int i = 0;i<adj.get(ele).size();i++){
                int neighbors = adj.get(ele).get(i);
                indegree[neighbors]--;
                if(indegree[neighbors] == 0){
                    q.add(neighbors);
                }
            }
            
            topo_sort.add(ele);
        }
        
        if(topo_sort.size() < V){
            return true;
        }else{
            return false;
        }
    }
}
```

## Course Schedule (leetcode - 207) (Medium)

```java
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Form Adjacency list

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0 ;i < numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i<prerequisites.length;i++){
            ArrayList<Integer> arr = adj.get(prerequisites[i][1]);
            arr.add(prerequisites[i][0]);
        }

        // Apply topological sort

        int[] indegrees = new int[numCourses];

        ArrayList<Integer> topo_sort = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0;i<adj.size();i++){
            for(int j = 0;j<adj.get(i).size();j++){
                if(adj.get(i).size() > 0){
                    indegrees[adj.get(i).get(j)]++;
                }
            }
        }

        for(int i = 0;i<indegrees.length;i++){
            if(indegrees[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int ele = q.poll();

            for(int i = 0;i<adj.get(ele).size();i++){
                int neighbors = adj.get(ele).get(i);
                indegrees[neighbors]--;
                if(indegrees[neighbors] == 0){
                    q.add(neighbors);
                }
            }

            topo_sort.add(ele);
        }

        if(topo_sort.size() < numCourses){
            return false;
        }else{
            return true;
        }       
    }
}
```

## Course Schedule - II (leetcode - 210) (Medium)

```java
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Form Adjacency list

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0 ;i < numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i<prerequisites.length;i++){
            ArrayList<Integer> arr = adj.get(prerequisites[i][1]);
            arr.add(prerequisites[i][0]);
        }

        // Apply topological sort

        int[] indegrees = new int[numCourses];

        ArrayList<Integer> topo_sort = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0;i<adj.size();i++){
            for(int j = 0;j<adj.get(i).size();j++){
                if(adj.get(i).size() > 0){
                    indegrees[adj.get(i).get(j)]++;
                }
            }
        }

        for(int i = 0;i<indegrees.length;i++){
            if(indegrees[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int ele = q.poll();

            for(int i = 0;i<adj.get(ele).size();i++){
                int neighbors = adj.get(ele).get(i);
                indegrees[neighbors]--;
                if(indegrees[neighbors] == 0){
                    q.add(neighbors);
                }
            }

            topo_sort.add(ele);
        }

        if(topo_sort.size() < numCourses){
            int[] arr = {}; 
            return arr;
        }else{
            int[] arr = new int[numCourses];
            for(int i = 0;i<topo_sort.size();i++){
                arr[i] = topo_sort.get(i);
            }
            return arr;
        }   
    }
}
```

<!-- # Shortest Path Algorithms

## Shortest Path in undirected graph (gfg) (Medium)

```java
class Solution {
    
    public class Pair{
        int first;
        int second;
        public Pair(int f , int s){
            this.first = f;
            this.second = s;
        }
    }
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        
        // make the adj list 
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i < edges.length;i++){
            
            int firstNode = edges[i][0];
            int secondNode = edges[i][1];
            
            ArrayList<Pair> arr1 = adj.get(firstNode);
            arr1.add(new Pair(secondNode , 1));
            
            ArrayList<Pair> arr2 = adj.get(secondNode);
            arr2.add(new Pair(firstNode , 1));
            
        }
        
        // Apply dijkstra
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if(a.first != b.first){
                return a.first-b.first;
            }
            else{
                return a.second - b.second;
            }
        });
        
        int[] distance = new int[n];
        for(int i = 0;i<distance.length;i++){
            distance[i] = (int)1e9;
        }
        
        distance[src] = 0;
        pq.add(new Pair(src , 0));
        
        while(!pq.isEmpty()){
            Pair node = pq.poll();
            
            int nodeVal = node.first;
            int nodeDistance = node.second;
            
            for(int i = 0;i<adj.get(nodeVal).size();i++){
                Pair neighbors = adj.get(nodeVal).get(i);
                
                int neighborsNode = neighbors.first;
                int neighborsDist = neighbors.second;
                
                int newDist = nodeDistance + neighborsDist;
                
                if(newDist < distance[neighborsNode]){
                    distance[neighborsNode] = newDist;
                    pq.add(new Pair(neighborsNode , newDist));
                }
            }
        }
        
        for(int i = 0;i<distance.length;i++){
            if(distance[i] == (int)1e9){
                distance[i] = -1;
            }
        }
        
        return distance;
        
    }
}
```

## Dijkstra's Algo (gfg) (Medium)

```java
class Solution
{   
    
    public static class Pair{
        int first;
        int second;
        public Pair(int f , int s){
            this.first = f;
            this.second = s;
        }
    }
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> {
            if(a.first != b.first){
                return a.first - b.first;
            }
            else{
                return a.second - b.second;
            }
        });
        
        int[] distance = new int[V];
        for(int i = 0;i<distance.length;i++){
            distance[i] = (int)(1e9);
        }
        
        distance[S] = 0;
        
        pq.add(new Pair(S , 0));
        
        while(!pq.isEmpty()){
            Pair node = pq.poll();
            
            int nodeVal = node.first;
            int nodeDistance = node.second;
            
            for(int i = 0;i<adj.get(nodeVal).size();i++){
                ArrayList<Integer> neighbors = adj.get(nodeVal).get(i);
                int neighborsNode = neighbors.get(0);
                int neighborsDist = neighbors.get(1);
                
                int newDist = neighborsDist + nodeDistance;
                
                if(newDist < distance[neighborsNode]){
                    distance[neighborsNode] = newDist;
                    pq.add(new Pair(neighborsNode , newDist));
                }
            }
        }
        
        return distance;
    }
}
``` -->

# Minimum Spanning tree & Disjoint set problems 

## Prims Algorithm (gfg) (Medium)

```java
class Solution {
    
    static class Compare implements Comparator<int[]>{
        @Override
        public int compare(int[] arr1 , int[] arr2){
            if(arr1[0] == arr2[0]){
                return arr1[1] - arr2[1];
            }else{
                return arr1[0] - arr2[0];
            }
        }
    }
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        
        boolean[] visited = new boolean[V];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Compare());
        
        int[] first = {0,0};
        
        int sum = 0;
        
        pq.add(first);
        
        while(!pq.isEmpty()){
            
            int[] node = pq.poll();
            
            if(!visited[node[1]]){
                
                visited[node[1]] = true;
                
                sum += node[0];
                
                for(int i = 0;i<adj.get(node[1]).size();i++){
                    if(!visited[adj.get(node[1]).get(i)[0]]){
                        int[] arr = {adj.get(node[1]).get(i)[1],adj.get(node[1]).get(i)[0]};
                        pq.add(arr);
                    }
                }
            }
            
        }
        
        return sum;
    }
}
```

## Disjoint Set (Union By rank)

```java
public class disjointSet{
        int[] parent;
        int[] rank;

        public disjointSet(int n){
            this.parent = new int[n];
            this.rank = new int[n];

            for(int i = 0;i<n;i++){
                this.parent[i] = i;
            }
        }

        public int findParent(int i){
            if(i == parent[i]){
                return i;
            }

            int par = findParent(parent[i]);

            parent[i] = par;

            return parent[i];
        }

        public void union(int i , int j){

            int parentOfi = findParent(i);
            int parentOfj = findParent(j);

            if(parentOfi == parentOfj){
                return;
            }else if(rank[parentOfi] < rank[parentOfj]){
                parent[parentOfi] = parentOfj;
            }else if(rank[parentOfj] < rank[parentOfi]){
                parent[parentOfj] = parentOfi;
            }else{
                parent[parentOfi] = parentOfj;
                rank[parentOfj] += 1;
            }
        }
    }
```

## Detect Cycle using DSU (gfg) (Medium)

```java
class Solution
{
    //Function to detect cycle using DSU in an undirected graph.
    
    // make DSU
    
    public class disjointSet{
        
        int[] parent;
        int[] rank;
        
        public disjointSet(int V){
            
            this.rank = new int[V];
            this.parent = new int[V];
            
            for(int i = 0;i<V;i++){
                this.parent[i] = i;
            }
            
        }
        
        public int findParent(int i){
            if(parent[i] == i){
                return i;
            }
            
            int par = findParent(parent[i]);
            
            parent[i] = par;
            
            return parent[i];
            
        }
        
        public void unionByRank(int u , int v){
            
            int parentOfu = findParent(u);
            int parentOfv = findParent(v);
            
            if(parentOfu == parentOfv){
                return;
            }
            
            if(rank[parentOfu] < rank[parentOfv]){
                
                parent[parentOfu] = parentOfv;
            }else if(rank[parentOfu] > rank[parentOfv]){
                parent[parentOfv] = parentOfu;
                
            }else{
                parent[parentOfu] = parentOfv;
                rank[parentOfv] ++;
                
            }
        }
        
    }
    
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        
        disjointSet ds = new disjointSet(V);
        
        for(int i = 0;i<adj.size();i++){
            for(int j = 0;j<adj.get(i).size();j++){
                int node1 = i;
                int node2 = adj.get(i).get(j);
                
                if(node1 < node2){
                    int parentOfnode1 = ds.findParent(node1);
                    int parentOfnode2 = ds.findParent(node2);
                    
                    if(parentOfnode1 == parentOfnode2){
                        return 1;
                    }else{
                        ds.unionByRank(parentOfnode1 , parentOfnode2);
                    }
                }
                
            }
        }

        return 0;
    }
}
```

## Satisfiability of Equality Equations (leetcode - 990) (Medium)

```java
class Solution {

    public class disjointSet{
        int[] rank;
        int[] parent;

        public disjointSet(){
            this.rank = new int[26];
            this.parent= new int[26];

            for(int i = 0;i<26;i++){
                this.parent[i] = i;
            }
        }

        public int findParent(int i){
            if(parent[i] == i){
                return i;
            }

            int par = findParent(parent[i]);

            parent[i] = par;

            return parent[i];
        }

        public void union(int i , int j){
            int parentOfi = findParent(i);
            int parentOfj = findParent(j);

            if(parentOfi == parentOfj){
                return;
            }

            if(rank[parentOfi] < rank[parentOfj]){
                parent[parentOfi] = parentOfj;
            }
            else if(rank[parentOfi] > rank[parentOfj]){
                parent[parentOfj] = parentOfi;
            }else{
                parent[parentOfi] = parentOfj;
                rank[parentOfj] += 1;
            }
        }

    }
    public boolean equationsPossible(String[] equations) {

        disjointSet ds = new disjointSet();

        int n = equations.length;

        for(int i = 0;i<n;i++){
            if(equations[i].charAt(1) == '='){
                int firstChar = (int) equations[i].charAt(0) - (int) 'a';
                int secondChar = (int) equations[i].charAt(3) - (int) 'a';
                ds.union(firstChar , secondChar);
            }
        }


        for(int i = 0;i<n;i++){
            if(equations[i].charAt(1) == '!'){
                int firstChar = (int) equations[i].charAt(0) - (int) 'a';
                int secondChar = (int) equations[i].charAt(3) - (int) 'a';
                
                int firstParent = ds.findParent(firstChar);
                int secondParent = ds.findParent(secondChar);

                if(firstParent == secondParent){
                    return false;
                }
            }
        }

        return true;
    }
}
```

## Number Of Operations To make Network Connected (Medium) (leetcode - 1319)

```java
class Solution {

    public class disjointSet{
        int[] parent;
        int[] rank;

        public disjointSet(int n){
            this.parent = new int[n];
            this.rank = new int[n];

            for(int i = 0;i<n;i++){
                this.parent[i] = i;
            }
        }

        public int findParent(int i){
            if(parent[i] == i){
                return i;
            }

            int par = findParent(parent[i]);

            parent[i] = par;

            return parent[i];
        }

        public void union(int i , int j){
            int parentOfi = findParent(i);
            int parentOfj = findParent(j);

            if(parentOfi == parentOfj){
                return;
            }else if(rank[parentOfi] < rank[parentOfj]){
                parent[parentOfi] = parentOfj;
            }else if(rank[parentOfi] > rank[parentOfj]){
                parent[parentOfj] = parentOfi;
            }else{
                parent[parentOfi] = parentOfj;
                rank[parentOfj] += 1;
            }
        }
    }

    public int makeConnected(int n, int[][] connections) {

        disjointSet ds = new disjointSet(n);

        int noOfCables = connections.length;

        if(n-1 > noOfCables){
            return -1;
        }

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0;i<noOfCables;i++){
            int ele1 = connections[i][0];
            int ele2 = connections[i][1];

            ds.union(ele1 , ele2);
        }

        for(int i = 0;i<n;i++){
            int parent = ds.findParent(i);
            if(!set.contains(parent)){
                set.add(parent);
            }
        }
        return set.size() - 1; 
    }
}
```

## Count unreachable pairs of nodes in an undirected graph (Medium) (leetcode - 2316)

```java
class Solution {
    public class disjointSet{
        int[] parent;
        int[] rank;

        public disjointSet(int n){
            this.parent = new int[n];
            this.rank = new int[n];

            for(int i = 0;i<n;i++){
                this.parent[i] = i;
            }
        }

        public int findParent(int i){
            if(i == parent[i]){
                return i;
            }

            int par = findParent(parent[i]);

            parent[i] = par;

            return parent[i];
        }

        public void union(int i , int j){

            int parentOfi = findParent(i);
            int parentOfj = findParent(j);

            if(parentOfi == parentOfj){
                return;
            }else if(rank[parentOfi] < rank[parentOfj]){
                parent[parentOfi] = parentOfj;
            }else if(rank[parentOfj] < rank[parentOfi]){
                parent[parentOfj] = parentOfi;
            }else{
                parent[parentOfi] = parentOfj;
                rank[parentOfj] += 1;
            }
        }
    }
    public long countPairs(int n, int[][] edges) {

        disjointSet ds = new disjointSet(n);

        int m = edges.length;

        for(int i = 0;i<m;i++){
            int ele1 = edges[i][0];
            int ele2 = edges[i][1];
            ds.union(ele1,ele2);
        }

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i<n;i++){
            int parent = ds.findParent(i);

            if(!map.containsKey(parent)){
                map.put(parent,1);
            }else{
                int val = map.get(parent);
                map.put(parent,val+1);
            }
        }

        long ans = 0L;

        long total = (long) n;

        for(int key:map.keySet()){
            
            int val = map.get(key);

            ans += val * (total-val);

            total -= val;
        } 
        return ans;
    }
}
```


