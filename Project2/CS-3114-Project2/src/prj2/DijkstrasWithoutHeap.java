package prj2;

import java.util.ArrayList;


/**
 * 
 * The implementation of Dijkstra's algorithm using a simple array
 * 
 * @Andrew_Hanner
 */
public class DijkstrasWithoutHeap {
	private ArrayList<ArrayList<HeapNode>> adj;


    /**
     * Constructor of the class
     * 
     * @param n:
     *            number of nodes of the graph
     * @param edges:
     *            the set of edges of the graph. Each row of 'edges' is in the
     *            form of [u, v, w], which means that there is an edge between u
     *            and v with weight w. So edges[i][0] and edges[i][1] are the
     *            end-points of the (i+1)-th edge and edges[i][2] is its weight
     */
    public DijkstrasWithoutHeap(int n, int[][] edges) {
    	adj = new ArrayList<>();
    	
        for (int i = 0; i < n;i++) {
        	adj.add(new ArrayList<>());
        }
        

        for (int i = 0; i <edges.length; i++) {
        	adj.get(edges[i][0]-1).add(new HeapNode(edges[i][1],edges[i][2]));
        	adj.get(edges[i][1]-1).add(new HeapNode(edges[i][0],edges[i][2]));
        }

    }
    
    private boolean allVisted(boolean[] visted) {
    	for (int i = 0; i < visted.length;i++) {
    		if(!visted[i]) {
    			return false;
    		}
    	}
    	return true;
    }
    
    private int nextNode(boolean[]visted, int[]dist, int curr) {
    	int min = Integer.MAX_VALUE;
    	int idx = -1;
    	ArrayList<HeapNode> con = adj.get(curr);
    	for(int i = 0; i < con.size();i++) {
    		if(!visted[con.get(i).getId()-1]&& dist[con.get(i).getId()-1] <= min) {
    			min = dist[con.get(i).getId()-1];
    			idx = con.get(i).getId()-1;
    		}
    	}
    	
    	return idx;
    }

    /**
     * This method computes and returns the distances of all nodes of the graph
     * from the source node
     * 
     * @param source
     * 
     * @return an array containing the distances of the nodes of the graph from
     *         source. Element at index i-1 of the returned array represents the distance
     *         of node i from the source
     */
    public int[] run(int source) {
    	int[] dist = new int[adj.size()];
    	boolean[] visted = new boolean[adj.size()];
    	for (int i = 0; i < dist.length; i++) {
    		dist[i] = Integer.MAX_VALUE;
    		visted[i] = false;
    	}
    	int curr = source-1;
    	dist[curr] = 0;
    	HeapNode con;
    	System.out.println(adj.get(curr).get(0).getValue());
    	while(!allVisted(visted)&& curr != -1){
    		visted[curr] = true;
    		for (int i = 0; i < adj.get(curr).size(); i++) {
    			con = adj.get(curr).get(i);
    			if (!visted[con.getId()-1] && dist[curr] != Integer.MAX_VALUE &&dist[con.getId()-1] > dist[curr] + con.getValue()) {
    				dist[con.getId()-1] = dist[curr] + con.getValue();
    			}
    		}
    		curr = nextNode(visted,dist,curr);
    	}

    	for (int j = 0; j <dist.length; j++) {
    		if(dist[j] == Integer.MAX_VALUE) {
    			dist[j] = -1;
    		}
    	}
        return dist;
    }

}
