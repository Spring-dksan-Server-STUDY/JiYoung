package com.example.jiyoung.study1;

public class User {
    private int id;
    private String name;
    private String part;

    public User(int id, String name, String part){
        this.id=id;
        this.name=name;
        this.part=part;
    }

    public void introduce(){
        System.out.println("이름은 "+name+", 파트는 "+part+"입니다");
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getPart(){
        return part;
    }

    public void setPart(String part){
        this.part=part;
    }
}
