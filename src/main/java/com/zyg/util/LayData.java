package com.zyg.util;

import java.util.List;

public class LayData {
    private int code;
    private String msg;
    private int count;
    private List<?> data;

    public LayData() {
    }

    public LayData(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public LayData(int code, String msg, int count, List<?> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
