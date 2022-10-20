package com.example.jiyoung.assignment1;

import java.util.List;

public interface MemberInterface
{

    //상수 필드
    public String BELONG="sopt";

    //정적 메소드
    static void introduceMember(Long id, String name){
        System.out.println(BELONG+"에서의 id는 "+id+", 이름은 "+name);
    }

    //디폴드 메소드
    default void join(){
        System.out.println("가입을 환영합니다.");
    }

    void getMemberInfo(int age, String place);


}
