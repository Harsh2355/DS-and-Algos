// Leetcode Problem : https://leetcode.com/problems/find-if-path-exists-in-graph/submissions/

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (n == 1) {
            return true;
        }
        Queue<Integer> theQueue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        // BFS
        visited.add(source);
        theQueue.add(source);
        while (!theQueue.isEmpty()) {
            int curVisiting = theQueue.poll();
            visited.add(curVisiting);
            if (curVisiting == destination) {
                return true;
            }
            for (Integer ele : adj.get(curVisiting)) {
                if (!visited.contains(ele)) {
                    theQueue.add(ele);
                }
            }
        }
        return false;
    }
}
