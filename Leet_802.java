import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



// for this question, you have to use traversal. DFS. You check if the node you have leads to a dead end. 
//You have to check its connecting friends to see if they also lead to a dead end. 
//and their friends until you reach a dead end. Then you return true.
//If you reach a node that you've visited before and its not a deadEnd then its a cycle and return false.
//You keep doing this for all nodes and their nodes.
// Runtime complexity (M+N) M = # nodes and N = # edges  because once 
//you reach a node that has potentially connected to all other nodes (M), then after words you just check the first connecting node 
//of each node from then on (N) so (M+N) --> O(N)
//Space complexity  would be (3N) --> O(N)
//
class Leet_802 {

public List<Integer> eventualSafeNodes(int[][] graph) {

     HashSet<Integer> result = new HashSet<>();
    HashSet<Integer> visited = new HashSet<>();

   for(int i=0; i<graph.length;i++){

    if(search(i, graph, visited,result)) result.add(i);
   }

    List<Integer> safeNodes = new ArrayList<>(result);

Collections.sort(safeNodes);
return safeNodes;

    }


    public boolean search(int i, int [][] graph, HashSet<Integer> visited, HashSet<Integer> result){

        if(result.contains(i)) return true;
        
        if(visited.contains(i)) return false;

    visited.add(i);
        for(int j: graph[i]){
            if(!search(j, graph, visited,result)) return false;

        }

    result.add(i);
    return true;

    }

    

}