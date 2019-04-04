package com.nbhope.hopelauncher.lib.network.bean.response;


import java.util.List;

/**
 * 具有rows字段的list Response 分页类
 *
 * @param <T> Rows Bean 对象
 * @author EthanCo
 * @since 2017/10/28
 */
public class RowResponse<T>{
    private int code;

    private String message;

    private List<T> rows;

    private int total;

    public List<T> getRows() {
        return rows;
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

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isSuccess() {
        return code == 100000;
    }
}
