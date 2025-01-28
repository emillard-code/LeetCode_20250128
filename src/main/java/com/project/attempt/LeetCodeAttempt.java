package com.project.attempt;

public class LeetCodeAttempt {

    public static void main(String[] args) {

        int[][] grid1 = new int[][]{{0,2,1,0},{4,0,0,3},{1,0,0,4},{0,3,2,0}};
        System.out.println(maximumNumberOfFishInAGrid(grid1));

        int[][] grid2 = new int[][]{{1,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,1}};
        System.out.println(maximumNumberOfFishInAGrid(grid2));

    }

    public static int maximumNumberOfFishInAGrid(int[][] grid) {

        int maximumFish = 0;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {

                int fish = travelGrid(grid, i, j);
                if (fish > maximumFish) { maximumFish = fish; }

            }

        }

        return maximumFish;

    }

    private static int travelGrid(int[][] grid, int x, int y) {

        int[][] newGrid = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                newGrid[i][j] = grid[i][j];
            }
        }

        newGrid[x][y] = 0;
        int fish = grid[x][y];

        int east = -1;
        int west = -1;
        int north = -1;
        int south = -1;

        if (x + 1 < grid.length) {
            if (newGrid[x + 1][y] != 0) {
                south = travelGrid(newGrid, x + 1, y);
            }
        }

        if (x - 1 >= 0) {
            if (newGrid[x - 1][y] != 0) {
                north = travelGrid(newGrid, x - 1, y);
            }
        }

        if (y + 1 < grid[0].length) {
            if (newGrid[x][y + 1] != 0) {
                east = travelGrid(newGrid, x, y + 1);
            }
        }

        if (y - 1 >= 0) {
            if (newGrid[x][y - 1] != 0) {
                west = travelGrid(newGrid, x, y - 1);
            }
        }

        if (east == -1 && west == -1 && north == -1 && south == -1) {
            return fish;
        }

        return fish + Math.max(east, Math.max(west, Math.max(north, south)));

    }

}
