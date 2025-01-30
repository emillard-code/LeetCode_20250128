package com.project.attempt;

public class LeetCodeAttempt {

    public static void main(String[] args) {

        int[][] grid1 = new int[][]{{0,2,1,0},{4,0,0,3},{1,0,0,4},{0,3,2,0}};
        System.out.println(maximumNumberOfFishInAGrid(grid1));

        int[][] grid2 = new int[][]{{1,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,1}};
        System.out.println(maximumNumberOfFishInAGrid(grid2));

    }

    // This method returns the maximum number of fish you can catch from this grid.
    public static int maximumNumberOfFishInAGrid(int[][] grid) {

        int maximumFish = 0;

        // We loop through every index and call a helper method that will calculate the maximum number
        // of fish that can be caught if we started from that index. Whatever value turns out to be the
        // highest after looping through everything is the value that we ultimately return at the end.
        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {

                // int fish indicates the maximum number of fish obtained if we start at this index.
                // For each index we compare it with int maximumFish and if int fish is higher,
                // we update the value of int maximumFish to reflect this.
                int fish = travelGrid(grid, i, j);
                if (fish > maximumFish) { maximumFish = fish; }

            }

        }

        return maximumFish;

    }

    // A helper method that calculates the highest number of fish that can be
    // caught if we start from a certain index. It is a recursive function.
    private static int travelGrid(int[][] grid, int x, int y) {

        // We create a new copy of the grid every time we call this method to prevent
        // any unwanted behaviors in the grid between its various method calls.
        int[][] newGrid = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                newGrid[i][j] = grid[i][j];
            }
        }

        // We set the current coordinates to 0 to indicate that everything has been fished
        // and that it is a cell that we may no longer return to.
        newGrid[x][y] = 0;
        int fish = grid[x][y];

        // We have four int primitives each pertaining to a cardinal direction. They will
        // represent the amount of fish that can be obtained if the fisher moves in that direction.
        // We set them to a default of -1 which will remain that way if the cell in that particular
        // direction is not a valid path (either out of bounds of the array or is a land cell).
        int east = -1;
        int west = -1;
        int north = -1;
        int south = -1;

        // For each direction, we make a recursive call to this function if it is a valid path
        // to go on. We record the number of fish obtained that each direction would result in.
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

        // If none of the directions are valid, we simply return the value
        // of the current number of fish that have been accumulated.
        if (east == -1 && west == -1 && north == -1 && south == -1) {
            return fish;
        }

        // Otherwise, we calculate which direction results in the highest number of
        // fish obtained, and increment that by the number of fish in this cell.
        return fish + Math.max(east, Math.max(west, Math.max(north, south)));

    }

}
