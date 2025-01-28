package com.project;

import com.project.attempt.LeetCodeAttempt;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LeetCodeAttemptTest {

    @Test
    public void maximumNumberOfFishInAGridTest() {

        int[][] grid1 = new int[][]{{0,2,1,0},{4,0,0,3},{1,0,0,4},{0,3,2,0}};
        assertEquals(7, LeetCodeAttempt.maximumNumberOfFishInAGrid(grid1));

        int[][] grid2 = new int[][]{{1,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,1}};
        assertEquals(1, LeetCodeAttempt.maximumNumberOfFishInAGrid(grid2));

    }

}
