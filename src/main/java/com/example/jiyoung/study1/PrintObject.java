package com.example.jiyoung.study1;

public class PrintObject<T> {
        private T objectData;

        public PrintObject(T objectData){
            this.objectData=objectData;
        }

        public T getObjectData(){
            return objectData;
        }

        public void setObjectData(T objectData) {
            this.objectData = objectData;
        }

        public void printData(){
            System.out.println(this.objectData);
        }

}
