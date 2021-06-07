# surpriseparty
Final Project for COMP305

The algorithm finds distance from source from every node by using Dijksrta's Algortihm.
The program takes an input from a txt file, creates a matrix to shape the graph.

 Time Complexity of the implementation is O(V^2)
 The space complexity will be O(V)
 
 (V : the number of vertices)
(E : the number of edges)

Firstly, when we were choosing the algorithm, we think about two choices. First one is the Bellman Ford algorithm and the other one is Dijkstra algorithm. In Bellman Ford, the algorithm looks up all the edges for all the nodes then find the shortest path. In Dijkstra’s algorithm, first looks up the start point’s neighbors. Compare them and takes the shortest one. So, the algorithm goes one by one. We choose Dijkstra’s algorithm because while it’s going one by one, we can implement the workers for the shortest path to make the party girl arrive at the party late as possible. 
The party girls avoids the workers, so we think that if we put the workers to the shortest paths, we forced her to go the longest path. Our graph is:
   1 ---4-------
  /    / /       \ 
0 -2 --/---5---- 6
 \    /  / 
    3 --/
 
We have 3 workers. We put the first worker to the start point to gain 1 min more. In the graph, (0,1,4,6) or (0,2,5,6) or (0,3,5,6) are the same length. From the start point, we compare the shortest distances to the end point.If one of them is shorter from other ones, we put a worker on it. If there is more than one shortest path, algortihm continues searching along these paths for shortests.If the next vertex is party point,and we have workers left, we put worker on that v

So, we thought that if we put the last 2 workers to the points that all three paths’ intersection points, we have gain 1 min extra. So, when the party girl chooses one of these paths, the result is going to be same. We assume that the party girl chose the (0,2,5,6) the total time is going to be 5.

