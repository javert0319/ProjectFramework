package com.nbhope.hopelauncher.lib.network.bean.response;


/**
 * 基础 Response
 *
 * @author EthanCo
 * @since 2017/10/28
 */
public class BaseResponse<T> {
    /**
     * method : xxx
     * code : 100000
     * message : 成功
     * desc : success!
     */
    private String method;
    private int code;
    private String message;
    private T object;
    private String desc;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public boolean isSuccess() {
        return code == 100000;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}