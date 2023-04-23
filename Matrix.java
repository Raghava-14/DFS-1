//Time = O(m*n) 
/*  where m is the number of rows and n is the number of columns in the matrix. This is because we perform a BFS on each cell in the matrix exactly once  */
//Space = O(m*n)

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length; // number of rows
        int n = mat[0].length; // number of columns
        int[][] dist = new int[m][n]; // distance matrix
        Queue<int[]> queue = new LinkedList<>(); // queue to perform BFS
        boolean[][] visited = new boolean[m][n]; // array to keep track of visited cells
        
        // initialize distance matrix and queue with all 0s
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) { // if the cell is a 0
                    dist[i][j] = 0; // set the distance to 0
                    queue.offer(new int[]{i, j}); // add the cell to the queue
                    visited[i][j] = true; // mark the cell as visited
                } else { // if the cell is not a 0
                    dist[i][j] = Integer.MAX_VALUE; // set the distance to maximum value
                }
            }
        }
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // array of neighbor directions
        
        // perform BFS on the queue
        while (!queue.isEmpty()) {
            int[] curr = queue.poll(); // get the current cell from the queue
            int row = curr[0];
            int col = curr[1];
            
            // iterate through the neighboring cells
            for (int[] dir : dirs) {
                int r = row + dir[0];
                int c = col + dir[1];
                
                // if the neighboring cell is out of bounds or has already been visited, skip it
                if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c]) {
                    continue;
                }
                
                // if the distance to the neighboring cell is greater than the distance to the current cell + 1, update the distance
                if (dist[r][c] > dist[row][col] + 1) {
                    dist[r][c] = dist[row][col] + 1;
                    queue.offer(new int[]{r, c}); // add the neighboring cell to the queue
                }
                visited[r][c] = true; // mark the neighboring cell as visited
            }
        }
        
        return dist; // return the distance matrix
    }
}




//----------------------------------------------Exceeds Time Limit------------------------------------------------------------------------
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        // Get the number of rows and columns in the input matrix
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Create a new matrix to store the result
        int[][] result = new int[m][n];
        
        // Iterate over each element in the input matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If the current element is 0, set the corresponding element in the result matrix to 0
                if (matrix[i][j] == 0) {
                    result[i][j] = 0;
                } else {
                    // Otherwise, set the corresponding element in the result matrix to a very large value
                    result[i][j] = Integer.MAX_VALUE;
                    
                    // Iterate over each element in the input matrix again
                    for (int k = 0; k < m; k++) {
                        for (int l = 0; l < n; l++) {
                            // If the current element in the input matrix is 0, calculate the Manhattan distance
                            // between it and the current element in the outer loop
                            if (matrix[k][l] == 0) {
                                int distance = Math.abs(i-k) + Math.abs(j-l);
                                
                                // Keep track of the minimum distance found so far
                                result[i][j] = Math.min(result[i][j], distance);
                            }
                        }
                    }
                }
            }
        }
        
        // Return the result matrix
        return result;
    }
}
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------
