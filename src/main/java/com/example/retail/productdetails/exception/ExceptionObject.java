package com.example.retail.productdetails.exception;

public class ExceptionObject {

    private int code;
    private String classname;
    private String message;

    public ExceptionObject() {
        this.code =100;
        this.message=null;
    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
