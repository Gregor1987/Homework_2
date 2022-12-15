public class Main {
    // task_1 Symmetric Tree
    public boolean isSymmetric(TreeNode root) {

        return mirrorCheck(root.left, root.right);
    }

    public boolean mirrorCheck(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        return mirrorCheck(a.left, b.right) && mirrorCheck(a.right, b.left);
    }

    // task_2 Max Area of Island
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int current = areaOfIsland(i, j, grid);
                    if (current > max) {
                        max = current;
                    }
                }
            }
        }
        return max;
    }

    private int areaOfIsland(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length
                || grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = 0;
        return (1 + areaOfIsland(i + 1, j, grid) + areaOfIsland(i - 1, j, grid) + areaOfIsland(i, j + 1, grid) + areaOfIsland(i, j - 1, grid));
    }

    // task_3 Flood Fill
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] != color) {
            paint(image, sr, sc, color, image[sr][sc]);
        }
        return image;
    }

    private void paint(int[][] image, int sr, int sc, int color, int srcColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length
                || image[sr][sc] != srcColor) {
            return;
        }
        image[sr][sc] = color;
        paint(image, sr + 1, sc, color, srcColor);
        paint(image, sr - 1, sc, color, srcColor);
        paint(image, sr, sc + 1, color, srcColor);
        paint(image, sr, sc - 1, color, srcColor);
    }
}