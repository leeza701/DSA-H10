class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for (int[] p : prerequisites) adj.get(p[1]).add(p[0]);
        
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int neighbor : adj.get(i)) indegree[neighbor]++;
        }
        
   
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.add(i);
        }
        
      
        int[] topo = new int[numCourses];
        int index = 0;
        
        while (!q.isEmpty()) {
            int node = q.poll();
            topo[index++] = node;
            
            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) q.add(neighbor);
            }
        }
        
        if (index == numCourses) return topo;
        
        
        return new int[0];
    }
}
