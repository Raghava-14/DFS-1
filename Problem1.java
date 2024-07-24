//Time = O(n)
//Space = O(n)

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Save the old color of the starting pixel
        int oldColor = image[sr][sc];
        // If the old and new colors are the same, no need to do any flood filling
        if(oldColor != newColor){
            // Perform a depth-first search to fill in the new color
            dfs(image, sr, sc, oldColor, newColor);
        }
        // Return the updated image
        return image;
    }
    
    private void dfs(int[][] image, int row, int col, int oldColor, int newColor){
        // Check if the current pixel is out of bounds, or has a different color than the old color
        if(row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != oldColor){
            return; // Stop the recursion if any of these conditions are met
        }
        // Fill in the new color at the current pixel
        image[row][col] = newColor;
        // Recursively call dfs on the neighboring pixels if they have the old color
        dfs(image, row+1, col, oldColor, newColor); // Down
        dfs(image, row-1, col, oldColor, newColor); // Up
        dfs(image, row, col+1, oldColor, newColor); // Right
        dfs(image, row, col-1, oldColor, newColor); // Left
    }
}
