package com.yl.floyd;


import java.util.Arrays;

/**
 * @author candk
 * @Description
 * @date 4/4/21 - 11:22 AM
 */

public class Graph {

    private char[] vertex;
    private int[][] distance;
    /**
     * 到达目标顶点的前驱顶点
     */
    private int[][] preVertex;

    public Graph() {
        preVertex = new int[vertex.length][vertex.length];
    }

    public Graph(char[] vertex, int[][] distance) {
        this.vertex = vertex;
        this.distance = distance;
        preVertex = new int[vertex.length][vertex.length];
        for (int i = 0; i < preVertex.length; i++) {
            for (int j = 0; j < preVertex.length; j++) {
                preVertex[i][j] = i;
            }
        }
    }

    public void show() {
        for (int[] row : distance) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println();
        for (int[] row : preVertex) {
            for (int pre : row) {
                System.out.print(vertex[pre] + "\t");
            }
            System.out.println();
        }
    }
}
