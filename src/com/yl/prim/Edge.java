package com.yl.prim;


/**
 * @author candk
 * @Description
 * @date 3/29/21 - 4:05 PM
 */
public class Edge implements Comparable {

    private char startVertex;
    private char endVertex;
    private int weight;

    public Edge() {
    }

    public Edge(char startVertex, char finishVertex, int weight) {
        this.startVertex = startVertex;
        this.endVertex = finishVertex;
        this.weight = weight;
    }

    public char getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(char startVertex) {
        this.startVertex = startVertex;
    }

    public char getFinishVertex() {
        return endVertex;
    }

    public void setFinishVertex(char finishVertex) {
        this.endVertex = finishVertex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "startVertex=" + startVertex +
                ", finishVertex=" + endVertex +
                ", weight=" + weight +
                '}';
    }


    @Override
    public boolean equals(Object obj) {
        Edge e = (Edge) obj;
        return e.startVertex == startVertex && e.endVertex == endVertex && e.weight == weight;
    }

    @Override
    public int compareTo(Object o) {
        Edge e = (Edge) o;
        return weight - e.weight;
    }
}
