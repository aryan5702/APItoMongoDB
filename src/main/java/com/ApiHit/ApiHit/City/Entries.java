package com.ApiHit.ApiHit.City;
import java.util.*;
import java.util.List;

public class Entries {
    private Boolean error;
    private String msg;
    private List<City> data;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<City> getData() {
        return data;
    }

    public void setData(List<City> data) {
        this.data = data;
    }
}
