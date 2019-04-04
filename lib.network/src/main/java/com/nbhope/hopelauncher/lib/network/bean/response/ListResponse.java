package com.nbhope.hopelauncher.lib.network.bean.response;

/**
 * Created by wang4 on 2017/11/22.
 */

import java.util.List;

/**
 * 具有list字段的list Response
 *
 * @param <T> Object Bean 对象
 * @param <B> List Bean 对象
 * @author EthanCo
 * @since 2017/10/28
 */
public class ListResponse<T, B> extends BaseResponse<T> {
    private List<B> list;

    public List<B> getList() {
        return list;
    }

    public void setList(List<B> list) {
        this.list = list;
    }
}
