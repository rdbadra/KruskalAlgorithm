/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Entrar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Tree tree = new Tree(5);
        tree.createTree();
        //tree.printTree();
        Kruskal kruskal = new Kruskal(tree);
        kruskal.run();
    }
    
}
