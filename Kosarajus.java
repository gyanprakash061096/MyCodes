class Solution
{
    public void dfs(int node, boolean vis[] , ArrayList<ArrayList<Integer>> adj, 
        Stack<Integer> s){
        vis[node]=true;
        for(int i : adj.get(node)){
            if(vis[i]==false){
                dfs(i,vis,adj,s);
            }
        }
        s.push(node);
    }
    public void dfs2(int node, boolean vis[] , ArrayList<ArrayList<Integer>> revAdj){
            vis[node]=true;
            for(int i : revAdj.get(node)){
            if(vis[i]==false){
                dfs2(i,vis,revAdj);
            }
        }
        }
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean vis[] = new boolean[V];
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<V;i++){
            if(vis[i]==false)
            dfs(i,vis,adj,s);
        }
        
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for(int i=0;i<V;i++){
            revAdj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<V;i++){
            vis[i]=false;
            for(int it : adj.get(i)){
                revAdj.get(it).add(i);
            }
        }
        int ans=0;
        while(!s.isEmpty()){
            int node= s.peek();
            s.pop();
            if(vis[node]==false){
                ans++;
                dfs2(node,vis,revAdj);
            }
        }
        return ans;
    }
}