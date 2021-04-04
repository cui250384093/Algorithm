package com.yl.prim;

import java.util.*;

/**
 * @author candk
 * @Description
 * @date 3/29/21 - 10:01 AM
 */
public class PrimAlgorithm {

    public static void main(String[] args) {

        char[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] weight = new int[][] {
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000}
        };

        Graph graph = new Graph(data, weight);
//        graph.prim(0);

        ArrayList<Edge> edges = graph.getEdges();
        Collections.sort(edges);
        System.out.println(edges);
    }

}
