
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Entrar
 */
public class Kruskal {
    private Arista[][] tree;
    private ArrayList<Group> list = new ArrayList<>();
    private ArrayList<Arista> orderedList = new ArrayList<>();
    private double INF = Double.POSITIVE_INFINITY;
    private ArrayList<Arista> chosenList = new ArrayList<>();
    
    
    public Kruskal(Tree tree){
        this.tree = tree.getTree();
    }
    
    public void run(){
        createOrderedList();
        printOrderedList();
        createGroups();
        calculateKruskal();
        printChosen();
        //printGroups();
    }

    private void printGroups(){
        int length = list.size();
        for(int i = 0; i < length; i++){
            list.get(i).printGroup();
        }
    }
    
    private void createGroups(){
        for(int i = 0; i <= 4; i++){
            list.add(new Group(i+1+"", i));
        }
    }

    private void printArista(Arista aris){
        System.out.print(aris.getWeight()+"{"+aris.getFirstVertex()
                +","+aris.getSecondVertex()+"}");
        System.out.println();
    }
    
    private void calculateKruskal(){
        int length = orderedList.size();
        for(int i = 0; i < length; i++){
            Group firstGroup = getGroup(orderedList.get(i).getFirstVertex());
            Group secondGroup = getGroup(orderedList.get(i).getSecondVertex());
            if(getRealGroup(firstGroup.getId()).addGroups(getRealGroup(secondGroup.getId()))){
                chosenList.add(orderedList.get(i));
            }
            if(getGroup(orderedList.get(i).getSecondVertex()).getGroupLength()==5){
                break;
            }
        }
    }

    private void printChosen(){
        System.out.println("Chosed aristas are:");
        int length = chosenList.size();
        for(int i = 0; i  < length; i++){
            System.out.print(chosenList.get(i).getWeight()+"{"+chosenList.get(i).getFirstVertex()
                    +","+chosenList.get(i).getSecondVertex()+"}");
            System.out.println();
        }
    }

    private Group getRealGroup(int number){
        return list.get(number);
    }

    private Group getGroup(int number){
        int length;
        ArrayList<String> groupList;
        Group group;
        for(int i = 0; i <= 5; i++){
            group = list.get(i);
            groupList = group.getList();
            length = groupList.size();
            for(int j = 0; j < length; j++){
                if(Integer.parseInt(groupList.get(j))==number){
                    return group;
                }
            }
        }
        return null;
    }
    
    private void createOrderedList(){
        for(int i = 0; i < 5; i ++){
            for(int j = 0; j < 5; j++){
                if(orderedList.size() > 0){
                    if(tree[i][j].getWeight() <= orderedList.get(0).getWeight()){
                        orderedList.add(0, tree[i][j]);
                    } else {
                        if(tree[i][j].getWeight()!=(int)INF)addBigArista(tree[i][j]);
                    }
                } else {
                    if(tree[i][j].getWeight()!=(int)INF)orderedList.add(tree[i][j]);
                }
            }
        }
    }
    
    private void printOrderedList(){
        System.out.println("--------------------------------------");
        for(int i = 0; i < orderedList.size(); i++){
            System.out.print(orderedList.get(i).getWeight()+"{"+orderedList.get(i).getFirstVertex()
                    +","+orderedList.get(i).getSecondVertex()+"}");
            System.out.println();
        }
    }
    
    private void addBigArista(Arista arista){
        int length = orderedList.size();
        for(int i = 0; i< length; i++){
            if(arista.getWeight()<orderedList.get(i).getWeight()){
                if(i!=0){
                    orderedList.add(i, arista);
                    break;
                } else {
                    orderedList.add(0, arista);
                    break;
                }
            } else {
                if(i==length-1 && arista.getWeight()!=(int)INF){
                    orderedList.add(arista);
                    break;
                }
            }
        }
    }
}
