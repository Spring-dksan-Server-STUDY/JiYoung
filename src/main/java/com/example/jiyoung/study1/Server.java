package com.example.jiyoung.study1;

public class Server extends Part{
    private String study;

    public String getStudy(){
        return study;
    }
    public void setStudy(String study){
        this.study=study;
    }
    public Server(String name, String study){
        super(name);
        this.study=study;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }
}
