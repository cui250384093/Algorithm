package com.yl.prim;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author candk
 * @Description
 * @date 3/29/21 - 10:02 AM
 */

public class Graph {

    int vertexNum;
    char[] data;
    int[][] weight;

    public Graph(int vertexNum) {
        this.vertexNum = vertexNum;
        data = new char[vertexNum];
        weight = new int[vertexNum][vertexNum];
    }

    public Graph(char[] data, int[][] weight) {
        this.vertexNum = data.length;
        this.data = data;
        this.weight = weight;
    }

    public void printGraph() {
        for (int[] ints : weight) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public int getVertexNum() {
        return vertexNum;
    }

    public void setVertexNum(int vertexNum) {
        this.vertexNum = vertexNum;
    }

    public char[] getData() {
        return data;
    }

    public void setData(char[] data) {
        this.data = data;
    }

    public int[][] getWeight() {
        return weight;
    }

    public void setWeight(int[][] weight) {
        this.weight = weight;
    }

    /**
     * prim算法求最小生成树
     * @param v 从图的第几个顶点开始生成‘A’->0, 'B'->1...
     */
    public void prim(int v) {

        //记录已经被访问的顶点
        int[] visited = new int[getVertexNum()];

        visited[v] = 1;
        //记录两个顶点的下标
        int h1 = -1, h2 = -1;
        for (int k = 1; k < getVertexNum(); k++) {
            int minWeight = 10000;

            for (int i = 0; i < getVertexNum(); i++) {

                for (int j = 0; j < getVertexNum(); j++) {
                    if (visited[i] == 1 && visited[j] == 0 && getWeight()[i][j] < minWeight) {
                        minWeight = getWeight()[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }

            System.out.println("边<" + getData()[h1] + "," + getData()[h2] + "> 权值：" + minWeight);
            visited[h2] = 1;
        }
    }

    /**
     * 克鲁斯卡尔求最小生成树
     */
    public void kruskal() {

    }

    public ArrayList<Edge> getEdges() {
        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < vertexNum; i++) {
            for (int j = i + 1; j < vertexNum; j++) {
                if (weight[i][j] < 10000) {
                    Edge edge = new Edge(data[i], data[j], weight[i][j]);
                    edges.add(edge);
                }
            }
        }

        return edges;
    }

    public int getPosition(char vertex) {
        for (int i = 0; i < vertexNum; i++) {
            if (data[i] == vertex) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 功能：获取下标为i的顶点的终点，用于后面判断两个顶点的终点是否相同
     * @param ends 数组就是记录了各个顶点的对应的终点是哪个，ends数组是在遍历过程中，逐步形成
     * @param v 表示传入的顶点对应的下标
     * @return 下标为i的顶点对应的终点的下标
     */
    public int getEnd(int[] ends, int v) {
        while (ends[v] != 0) {
            v = ends[v];
        }
        return v;
    }
}
