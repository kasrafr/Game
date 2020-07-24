package com.example.game;

import java.util.jar.Attributes;

class MyContact {
    private String name;
    private String PhoneNumber;
    private int id;
    public MyContact(String name,String PhoneNumber,int id)
    {
        this.name=name;
        this.PhoneNumber=PhoneNumber;
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setPhoneNumber(String PhoneNumber){
        this.PhoneNumber=PhoneNumber;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public String getPhoneNumber(){
        return PhoneNumber;
    }
    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return name;
    }
}
