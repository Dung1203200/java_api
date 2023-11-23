package com.example.Test.Models.ObjRespon;

public class ObjRp<T> {
    private String mess;
    private T data;
    private int stt;
    
    public String getMess() {
        return mess;
    }
    public void setMess(String mess) {
        this.mess = mess;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public int getStt() {
        return stt;
    }
    public void setStt(int stt) {
        this.stt = stt;
    }
    

}
