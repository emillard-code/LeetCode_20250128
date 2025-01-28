package com.project;

import com.project.solution.LeetCodeSolution;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LeetCodeSolutionTest {

    @Test
    public void maximumNumberOfFishInAGridTest() {

        int[][] grid1 = new int[][]{{0,2,1,0},{4,0,0,3},{1,0,0,4},{0,3,2,0}};
        assertEquals(7, LeetCodeSolution.findMaxFish(grid1));

        int[][] grid2 = new int[][]{{1,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,1}};
        assertEquals(1, LeetCodeSolution.findMaxFish(grid2));

    }

}
