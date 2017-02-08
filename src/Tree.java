/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Entrar
 */
public class Tree {
    private int numberOfVertexes;
    private Arista[][] tree;
    private double INF = Double.POSITIVE_INFINITY;
    
    public Tree(int numberOfVertexes){
        this.numberOfVertexes = numberOfVertexes;
    }

    public void createCustomizedTree(Arista[][] tree){
        this.tree = tree;
    }
    
    public void createTree(){
        this.tree = new Arista[numberOfVertexes][numberOfVertexes];
        this.tree[0][0] = new Arista((int)INF, 1, 1);
        this.tree[0][1] = new Arista(5, 1, 2);
        this.tree[0][2] = new Arista(6, 1, 3);
        this.tree[0][3] = new Arista(2, 1, 4);
        this.tree[0][4] = new Arista(4, 1, 5);
        this.tree[1][0] = new Arista((int)INF, 2, 1);
        this.tree[1][1] = new Arista((int)INF, 2, 2);
        this.tree[1][2] = new Arista((int)INF, 2, 3);
        this.tree[1][3] = new Arista((int)INF, 2, 4);
        this.tree[1][4] = new Arista((int)INF, 2, 5);
        this.tree[2][0] = new Arista((int)INF, 3, 1);
        this.tree[2][1] = new Arista(1, 3, 2);
        this.tree[2][2] = new Arista((int)INF, 3, 3);
        this.tree[2][3] = new Arista(2, 3, 4);
        this.tree[2][4] = new Arista((int)INF, 3, 5);
        this.tree[3][0] = new Arista((int)INF, 4, 1);
        this.tree[3][1] = new Arista(2, 4, 2);
        this.tree[3][2] = new Arista((int)INF, 4, 3);
        this.tree[3][3] = new Arista((int)INF, 4, 4);
        this.tree[3][4] = new Arista((int)INF, 4, 5);
        this.tree[4][0] = new Arista((int)INF, 5, 1);
        this.tree[4][1] = new Arista((int)INF, 5, 2);
        this.tree[4][2] = new Arista(1, 5, 3);
        this.tree[4][3] = new Arista(1, 5, 4);
        this.tree[4][4] = new Arista((int)INF, 5, 5);
    }
    
    public Arista[][] getTree(){
        return tree;
    }
    
    public int getNumberOfVertexes(){
        return numberOfVertexes;
    }
    
    public void printInf(){
        System.out.println(INF);
    }
    
}
