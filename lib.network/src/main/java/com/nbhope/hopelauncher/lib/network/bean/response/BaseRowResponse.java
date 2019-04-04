package com.nbhope.hopelauncher.lib.network.bean.response;

import java.util.List;

/**
 *
 * @param <T> Object
 * @param <B> List
 */
public class BaseRowResponse<T, B> extends BaseResponse<T>{
    private List<B> list;

    private List<B> row;

    private List<B> rows;

    private int total;

    public List<B> getList() {
        if (list != null) {
            return list;
        }
        if (rows != null) {
            return rows;
        }
        if (row != null) {
            return row;
        }
        return null;
    }

    public void setList(List<B> list) {
        this.list = list;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<B> getRow() {
        return getList();
    }

    public void setRow(List<B> row) {
        this.row = row;
    }

    public List<B> getRows() {
        return getList();
    }

    public void setRows(List<B> rows) {
        this.rows = rows;
    }
}
