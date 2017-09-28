package com.example.nabhiraj.currencyrecoder;

import java.io.Serializable;
import java.util.Vector;

/**
 * Created by nabhiraj on 11/12/2016.
 */
public class Logic implements Serializable {
    //lets make this class singletonn.
    static Logic logic=null;
    static String data="deafult";
    Vector<People> mylist=null;
    private Logic(){
        mylist=new Vector<People>();
    }
    public static Logic getLogic(){
        if(logic!=null){
            return logic;
        }
        logic = new Logic();
        return logic;
    }
    public static void putLogic(Logic logica){
        logic=logica;
    }
}