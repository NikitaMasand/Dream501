package CompanyPreparation.MorganStanley;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/*
A directed graph is strongly connected if there is a path between all pairs of vertices
We can find all strongly connected components in O(V+E) time using Kosaraju’s algorithm.
Following is detailed Kosaraju’s algorithm.
1) Create an empty stack ‘S’ and do DFS traversal of a graph.
In DFS traversal, after calling recursive DFS for adjacent vertices of a vertex,
 push the vertex to stack.
 In the above graph, if we start DFS from vertex 0,
 we get vertices in stack as 1, 2, 4, 3, 0.
2) Reverse directions of all arcs to obtain the transpose graph.
3) One by one pop a vertex from S while S is not empty.
Let the popped vertex be ‘v’. Take v as source and do DFS (call DFSUtil(v)).
 The DFS starting from v prints strongly connected component of v.
 In the above example, we process vertices in order 0, 3, 4, 2, 1 (One by one popped from stack).

 */
public class NumberOfStronglyConnectedComponents {

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(1,0);
        g.addEdge(0,2);
        g.addEdge(2,1);
        g.addEdge(0,3);
        g.addEdge(3,4);
        System.out.println("strongly connected components in given graph...");
        g.printSCCS();

    }
}

class Graph {
    private int v;  //number of vertices
    private LinkedList<Integer> adj[]; //adjacency list

    Graph(int v){
        this.v = v;
        adj = new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i] = new LinkedList();
        }
    }
    //function to add an edge in the graph
    void addEdge(int v, int w){
        adj[v].add(w);
//        System.out.println(v+" - "+w);
    }

    //recursive function to print dfs starting from v
    void DFSUtil(int vertex, boolean[] visited){
        visited[vertex]=true;
        Iterator<Integer> iterator = adj[vertex].iterator();
        System.out.print(vertex+" ");
        int n;
        while (iterator.hasNext()){
            n = iterator.next();
            if(!visited[n]){
                DFSUtil(n,visited);
            }
        }
    }

    Graph getTranspose(){
        Graph g = new Graph(v);
        for(int i=0;i<v;i++){
            Iterator<Integer> iterator = adj[i].iterator();
            int n;
            while (iterator.hasNext()){
                n = iterator.next();
                g.adj[n].add(i);
            }
        }
        return g;
    }

    void fillOrder(int vertex, boolean[] visited, Stack stack){
        visited[vertex]=true;
        Iterator<Integer> iterator = adj[vertex].iterator();
        int n;
        while (iterator.hasNext()){
            n = iterator.next();
            if(!visited[n]){
                fillOrder(n,visited,stack);
            }
        }
        stack.push(vertex);
    }

    void printSCCS(){
        Stack stack = new Stack();
        boolean[] visited = new boolean[v];
        //fill vertices in stack according to their finishing times
        for(int i=0;i<v;i++){
            if(!visited[i]){
                fillOrder(i,visited,stack);
            }
        }

        //create reversed graph
        Graph gr = getTranspose();
        for(int i=0; i<v; i++){
            visited[i]=false;
        }

        while (!stack.isEmpty()){
            int n = (int)stack.pop();
            if(!visited[n]){
                gr.DFSUtil(n,visited);
                System.out.println();
            }

        }
    }



}
