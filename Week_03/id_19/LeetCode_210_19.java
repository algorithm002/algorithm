class Solution {
    static int WHITE = 1;
    static int GRAY = 2;
    static int BLACK = 3;
    
    private Map<Integer,Integer>  color;
    private Map<Integer,List<Integer>> adjList;
    private List<Integer> topologicalOrder;
    
    private boolean isPossible;
    
    private void init(int num){
        this.color = new HashMap<Integer,Integer>();
        this.adjList = new HashMap<Integer,List<Integer>>();
        this.topologicalOrder = new ArrayList<Integer>();
        
        this.isPossible = true;
        
        for(int i = 0; i < num; i++) {
            this.color.put(i,WHITE);
        }
    }
    private void dfs(int node) {
        if(!this.isPossible) 
            return;
        if(this.color.get(node) == BLACK) 
            return;
        if(this.color.get(node) == GRAY) {
            isPossible = false;
            return;
        }
        
        this.color.put(node,GRAY);
        
        for(Integer next : this.adjList.getOrDefault(node,new ArrayList<Integer>())) {
                this.dfs(next);
        }
        
        this.color.put(node,BLACK);
        this.topologicalOrder.add(node);
        
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        this.init(numCourses);
        
        for(int i = 0;i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            
            List<Integer> list = this.adjList.getOrDefault(src,new ArrayList<Integer>());
            
            list.add(dest);
            
            this.adjList.put(src,list);
        }
        
        for(int i = 0; i < numCourses; i++) {
            if(this.color.get(i) == WHITE)
                dfs(i);
        }
        
        if(!this.isPossible) {
            return new int[0];
        } else {
            int[] res = new int[numCourses];
            for(int i = 0; i < numCourses; i++) {
                res[i] = this.topologicalOrder.get(numCourses-i-1);
            }
            return res;
        }
    }
}