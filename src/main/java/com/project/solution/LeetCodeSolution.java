package com.project.solution;

public class LeetCodeSolution {

    public static void main(String[] args) {

        int[][] grid1 = new int[][]{{0,2,1,0},{4,0,0,3},{1,0,0,4},{0,3,2,0}};
        System.out.println(findMaxFish(grid1));

        int[][] grid2 = new int[][]{{1,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,1}};
        System.out.println(findMaxFish(grid2));

    }

    // Helper function to count the number of fishes in a connected component
    private static int calculateFishes(int[][] grid, boolean[][] visited, int row, int col) {

        // Check boundary conditions, water cells, or already visited cells
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length
                || grid[row][col] == 0 || visited[row][col]) {
            return 0;
        }

        // Mark the current cell as visited
        visited[row][col] = true;

        // Accumulate the fish count from the current cell and its neighbors
        return (grid[row][col] +
                        calculateFishes(grid, visited, row, col + 1) +
                        calculateFishes(grid, visited, row, col - 1) +
                        calculateFishes(grid, visited, row + 1, col) +
                        calculateFishes(grid, visited, row - 1, col)
        );

    }

    public static int findMaxFish(int[][] grid) {

        int rows = grid.length, cols = grid[0].length;
        int maxFishCount = 0;

        // A 2D array to track visited cells
        boolean[][] visited = new boolean[rows][cols];

        // Iterate through all cells in the grid
        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                // Start a DFS for unvisited land cells (fish available)
                if (grid[row][col] > 0 && !visited[row][col]) {

                    maxFishCount = Math.max(maxFishCount, calculateFishes(grid, visited, row, col));

                }

            }

        }

        // Return the maximum fish count found
        return maxFishCount;

    }

}
