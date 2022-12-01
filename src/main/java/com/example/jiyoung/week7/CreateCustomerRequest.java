package com.example.jiyoung.week7;

import java.util.Objects;

public final class CreateCustomerRequest {
    private final String name;
    private final int age;
    private final String email;

    CreateCustomerRequest(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String name() {
        return name;
    }

    public int age() {
        return age;
    }

    public String email() {
        return email;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (CreateCustomerRequest) obj;
        return Objects.equals(this.name, that.name) &&
                this.age == that.age &&
                Objects.equals(this.email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, email);
    }

    @Override
    public String toString() {
        return "CreateCustomerRequest[" +
                "name=" + name + ", " +
                "age=" + age + ", " +
                "email=" + email + ']';
    }

}
//public class CreateCustomerRequest {
//    //name, age, email 받아오기
//    private final String name;
//    private final int age;
//    private final String email;
//
//    public CreateCustomerRequest(String name, int age, String email){
//        this.name=name;
//        this.age=age;
//        this.email=email;
//    }
//}
