/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Entrar
 */
public class Arista {
    private int weight;
    private int firstVertex;
    private int secondVertex;
    
    public Arista(int weight, int firstVertex, int secondVertex){
        this.weight = weight;
        this.firstVertex = firstVertex;
        this.secondVertex = secondVertex;
    }
    
    public int getWeight(){
        return weight;
    }
    
    public int getFirstVertex(){
        return firstVertex;
    }
    
    public int getSecondVertex(){
        return secondVertex;
    }
    
}
