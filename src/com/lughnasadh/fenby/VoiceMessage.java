package com.lughnasadh.fenby;

public class VoiceMessage {
    private String msg;
    private int len;
    
    public VoiceMessage(String str, int len){
        this.msg=str;
        this.len=len;
    }

    public String getMsg() {
        return msg;
    }
    
    public int getLen() {
    	return len;
    }

}