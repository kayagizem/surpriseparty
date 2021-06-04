package comp305;


import java.util.*;
import java.io.*;

class ShortestPath {
	
	public static int stop;
	int minDistance(int distance[], Boolean set[])
	{
		int min = Integer.MAX_VALUE;
		int	minInd = -1;

		for (int v = 0; v < stop; v++)
			if (set[v] == false && distance[v] <= min) {
				min = distance[v];
				minInd = v;
			}
		return minInd;
	}

	
	void dijkstra(int graph[][], int source)
	{
		int distance[] = new int[stop]; 
		Boolean set[] = new Boolean[stop];

		for (int i = 0; i < stop; i++) {
			distance[i] = Integer.MAX_VALUE;
			set[i] = false;
		}
		
		distance[source] = 0;

		for (int i = 0; i < stop - 1; i++) {
			
			int u = minDistance(distance, set);

			set[u] = true;

			for (int v = 0; v < stop; v++) {
				
				if (!set[v] && graph[u][v] != 0 && distance[u] != Integer.MAX_VALUE && distance[u] + graph[u][v] < distance[v]) {
					distance[v] = distance[u] + graph[u][v];
				}
			}
		}
		printSolution(distance);
	}
	
	void printSolution(int distance[])
	{
		System.out.println("Vertex \t\t Time \t\tNumber of Workers:" );
		for (int i = 0; i < stop; i++)
			System.out.println(i + " \t\t " + distance[i]);
	}

	
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner inFile = new Scanner(new File("input.txt"));
		String line = inFile.nextLine();
	    String[] data=line.split(" ");
	    
	    		stop=Integer.parseInt(data[0]);
	        int path=Integer.parseInt(data[1]);
	        int worker= Integer.parseInt(data[2]);
	        int graph[][] = new int[stop][stop];
	        
	        for(int i=0; i<stop; i++) {
	        	for(int j=0; j<stop; j++) {
	        		graph[i][j]=0;
	        	}
	        }
	        
	        
	        while(inFile.hasNext())
	    {
	        line=inFile.nextLine();
	        String[] data2=line.split(" ");
		    
	        int x=Integer.parseInt(data2[0]);
	        int y=Integer.parseInt(data2[1]);
	        graph[x][y]=1;
	        graph[y][x]=1;
	        
	    }
	        
	        for(int a=0; a<stop; a++) {
	    	    
	        	for(int b=0; b<stop; b++) {
	    	        System.out.print(graph[a][b]);
	        	}
	        	System.out.println();
	        	}
	       						
																
		ShortestPath t = new ShortestPath();
		t.dijkstra(graph, 0);
	
 }
}

	

