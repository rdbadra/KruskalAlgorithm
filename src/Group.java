
import com.sun.corba.se.impl.orbutil.ObjectUtility;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

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
public class Group {
    private ArrayList<String> list = new ArrayList<>();
    private boolean deleted = false;
    private int id ;
    
    public Group(String number, int id){
        list.add(number);
        this.id = id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public boolean getDeleted(){
        return deleted;
    }

    public void setDeleted(){
        this.deleted = true;
    }

    public void add(String vertex){
        list.add(vertex);
    }

    public int getGroupLength(){
        return list.size();
    }
    
    public ArrayList<String> getList(){
        return list;
    }
    
    public void addToGroup(String arista){
        list.add(arista);
    }
    
    public void removeFromGroup(String arista){
        list.remove(arista);
    }

    public boolean addGroups(Group secondGroup){
        if(!secondGroup.getDeleted() && !this.getDeleted()){
            if(checkNotIN(secondGroup)){
                ArrayList<String> listGroup = secondGroup.getList();
                int length = listGroup.size();
                System.out.println("Left group:");
                this.printGroup();
                System.out.println("Right group");
                secondGroup.printGroup();
                for(int i = 0; i < length; i++){
                    this.add((String)listGroup.get(i));
                }
                secondGroup.setDeleted();
                secondGroup.setId(this.getId());
                System.out.println("FINAL");
                this.printGroup();
                return true;
            }
        }
        return false;
    }

    private boolean checkNotIN(Group secondGroup){
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < secondGroup.getGroupLength(); j++){
                if(list.get(i).equals(secondGroup.getList().get(j))){
                    return false;
                }
            }
        }
        return true;
    }

    public void printGroup(){
        int length = list.size();
        System.out.println("GROUP:");
        for(int i = 0; i < length; i++){

            System.out.println(list.get(i));
        }
    }
}
