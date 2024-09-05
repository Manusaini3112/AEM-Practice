package com.aem.training.site.core.entity;

import com.adobe.xfa.Obj;

public class ClientResponse {
    private int statusCode;
    private Object data;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatuscode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
