package com.example.jiyoung.study1;

public interface UserInterface {
    String CLUB="SOPT";

    void introduce(String name, int age, String mbti);

    default void getInfo(int generation, String part){
        System.out.println("SOPT "+generation+"기의 "+part+"파트 입니다");
    }
    static void introduceSopt(){
        System.out.println("shout out our passion together");
    }
}
