//USE THIS FORMAT WHEN THE NODES ARE NUMBERED FROM THE 0 TO N-1.
//ALSO IF THE NODES HAVE SOME VALUES ASSIGNED TO IT (IT MAY BE COST, OR ETC AS PER THE QUESTION STATEMENT) WE USE THIS REPRESENTATION

/*IN THIS REPRESENTATION --
      INDEX OF ARRAY---> THE CURRENT NODE NUMBER
      ARRAY[I] ---> REPRESENTS THE NEIGHBOUR
*/  
//CODE IMPLEMENTATION:

int n = vals.length;
List<Integer>[] graph = new List[n];
        
for (int i = 0; i < n; i++) {
  graph[i] = new ArrayList<Integer>();
}
        
for (int[] edge : edges) {
  int a = edge[0], b = edge[1];
  graph[a].add(b);
  //IF ARRAY IS NOT UNIDIRECTIONAL
  graph[b].add(a);
}

