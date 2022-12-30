// 101. Symmetric Tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution

{

    public boolean isSymmetric(TreeNode root)

    {

        if (root == null)

            return true;

        return Helper(root.left, root.right);

    }

    boolean Helper(TreeNode left, TreeNode right)

    {

        if (left == null && right == null)

            return true;

        else if (left == null || right == null)

            return false;

        boolean cond1 = left.val == right.val;

        boolean cond2 = Helper(left.left, right.right);

        boolean cond3 = Helper(left.right, right.left);

        return cond1 && cond2 && cond3;

    }

}


// 733. Flood Fill

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int baseColor = image[sr][sc];
        if (baseColor == newColor) // corner case
            return image;

        int n = image.length, m = image[0].length;
        Stack<int[]> pixels = new Stack();
        pixels.push(new int[] { sr, sc });

        while (!pixels.empty()) {
            int x = pixels.peek()[0];
            int y = pixels.peek()[1];
            pixels.pop();
            if (image[x][y] != baseColor) // different color or already colored
                continue;

            image[x][y] = newColor;
            if (x > 0)
                pixels.push(new int[] { x - 1, y });
            if (x < n - 1)
                pixels.push(new int[] { x + 1, y });
            if (y > 0)
                pixels.push(new int[] { x, y - 1 });
            if (y < m - 1)
                pixels.push(new int[] { x, y + 1 });
        }

        return image;
    }
}

// 695. Max Area of Island 

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
    int maxArea = 0;
    int n = grid.length, m = grid[0].length;
    for(int i = 0; i < n; i++) {
    for(int j = 0; j < m; j++) {
    // Short-circuit when remaining area is smaller than max area
                   if (n * m - (i + 1)*(j + 1) < maxArea) {
    return maxArea;
    }
    if(grid[i][j] == 1) {
    maxArea = Math.max(maxArea, exploreIsland(i, j, grid, n, m));
    }
    }
    }
    
    return maxArea;
    }
    
    private int exploreIsland(int i, int j, int[][] grid, int n, int m) {
    // calculating n and m increments runtime, so better to pass as args;
           if(i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0) {
    return 0;
    }
    
    grid[i][j] = 0;
    return exploreIsland(i - 1, j, grid, n, m) +
    exploreIsland(i + 1, j, grid, n, m) +
    exploreIsland(i, j - 1, grid, n, m) +
    exploreIsland(i, j + 1, grid, n, m) + 1;
    }
   }