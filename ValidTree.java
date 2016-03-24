/*
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Show Hint 

*/
c class Solution {
    //tree: no circle, one node can reach every other node
    Set<Integer> visited=new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        if(n==1) return true;
        Map<Integer,List<Integer>> map=new HashMap<>();
        //map
        for(int[] edge:edges){
            if(map.containsKey(edge[0])) map.get(edge[0]).add(edge[1]);
            else{
                List<Integer> list=new ArrayList<>();
                list.add(edge[1]);
                map.put(edge[0],list);
            }
            if(map.containsKey(edge[1])) map.get(edge[1]).add(edge[0]);
            else{
                List<Integer> list=new ArrayList<>();
                list.add(edge[0]);
                map.put(edge[1],list);
            }
        }
        
        //!!!!
        int root=0;
        visited.add(root);
        return dfs(root,-1,map)&&visited.size()==n;
    }
    public boolean dfs(int root, int val,Map<Integer,List<Integer>> map){
        if(!map.containsKey(root)) return false;
        for(int a:map.get(root)){
            if(a==val) continue;
            if(!visited.add(a)) return false;
            if(!map.get(a).isEmpty()){
                if(!dfs(a,root,map)) return false;
            }
        }
        return true;
    }
    
}
ven n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
