package com.example.jiyoung.study1;

import org.apache.catalina.User;

public class UserServiceImpl implements UserInterface {

    @Override
    public void introduce(String name, int age, String mbti) {
        System.out.println("이름은 "+name+", 나이는 "+age+", mbti는 "+mbti);
    }

    @Override
    public void getInfo(int generation, String part) {
        UserInterface.super.getInfo(generation, part);
    }

    public void getSopt(){
        UserInterface.introduceSopt();
    }
}
