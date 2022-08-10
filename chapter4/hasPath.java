// Leetcode Problem : https://leetcode.com/problems/find-if-path-exists-in-graph/submissions/

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (n == 1) {
            return true;
        }
        Queue<Integer> theQueue = new PriorityQueue<Integer>();
        Map<Integer, Boolean> visited = new LinkedHashMap<Integer, Boolean>();
        Map<Integer, ArrayList<Integer>> graph = new LinkedHashMap<Integer, ArrayList<Integer>>();
        for (int[] ele : edges) {
            if (!visited.containsKey(ele[0])) {
                visited.put(ele[0], false);
                graph.put(ele[0], new ArrayList<Integer>());
            }
            ArrayList<Integer> curNeighbours1 = graph.get(ele[0]);
            curNeighbours1.add(ele[1]);
            graph.put(ele[0], curNeighbours1);
            
            if (!visited.containsKey(ele[1])) {
                visited.put(ele[1], false);
                graph.put(ele[1], new ArrayList<Integer>());
            }
            ArrayList<Integer> curNeighbours = graph.get(ele[1]);
            curNeighbours.add(ele[0]);
            graph.put(ele[1], curNeighbours);
            
            if (ele[0] == source) {
                theQueue.add(ele[1]);
            }
            else if (ele[1] == source) {
                theQueue.add(ele[0]);
            }
        }
        
        // BFS
        visited.put(source, true);
        while (theQueue.peek() != null) {
            Integer curVisiting = theQueue.remove();
            if (curVisiting == destination) {
                return true;
            }
            visited.put(curVisiting, true);
            ArrayList<Integer> neighbours = graph.get(curVisiting);
            for (Integer ele : neighbours) {
                if (!visited.get(ele)) {
                    theQueue.add(ele);
                }
            }
        }
        return false;
    }
}
