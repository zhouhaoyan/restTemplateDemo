package com.ibm.com.ibm.model;

public class Result
{
    private int result;
    private String message;
    private Object model;

    public int getResult()
    {
        return this.result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getModel() {
        return this.model;
    }

    public void setModel(Object model) {
        this.model = model;
    }
}