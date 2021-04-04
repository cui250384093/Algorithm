package com.yl.floyd;

import org.junit.jupiter.api.Test;

/**
 * @author candk
 * @Description
 * @date 4/4/21 - 11:22 AM
 */
public class FloydAlgorithm {

    @Test
    public void test1() {
        final int N = 65535;
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] distance = new int[][]{
                {0, 5, 7, N, N, N, 2},
                {5, 0, N, 9, N, N, 3},
                {7, N, 0, N, 8, N, N},
                {N, 9, N, 0, N, 4, N},
                {N, N, 8, N, 0, 5, 4},
                {N, N, N, 4, 5, 0, 6},
                {2, 3, N, N, 4, 6, 0}
        };

        Graph graph = new Graph(vertex, distance);
        graph.floyd();
        graph.show();


    }
}
