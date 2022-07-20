package com.example.demo.Catalog;

import java.util.ArrayList;

public class WoodContainer extends ArrayList<Wood> {
    //ArrayList<Wood> AllWood = new ArrayList();
    public void WoodContainer(){

    }
    public void Random(int num){
        for(int i = 0;i< num; i++){
            Wood wood = new Wood();
            wood.GenerateRandomWood("Random " + this.size());
            this.add(wood);
        }
    }
    public void Print(){
        int i = 0;
        while(i < this.size()){
            System.out.println(this.get(i).toString());
            i++;
        }
    }

}
