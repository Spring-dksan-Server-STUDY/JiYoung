package com.example.jiyoung.assignment1;

import java.util.List;

public class MemberServiceImpl implements MemberInterface{


    @Override
    public void join() {
        MemberInterface.super.join();
    }

    public void getIntro(){
        MemberInterface.introduceMember(1L, "양지영");
    }

    @Override
    public void getMemberInfo(int age, String place) {
        System.out.println("나이는 "+age+", 사는 곳은 "+place);
    }
}
