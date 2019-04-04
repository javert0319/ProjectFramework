package com.nbhope.hopelauncher.lib.network.bean.request;

/**
 * 单曲列表Request
 *
 * @author EthanCo
 * @since 2017/11/21
 */

public class ListRequest {
    /**
     * currentPage : 1
     * deviceId : 754057826917978100
     * pageSize : 2
     * tokenId : TnZIS2ZYSmlkV2hwbVVtQWdydGQxZ0NKMGJOWFE4SXo=
     */

    private int currentPage;
    private long deviceId;
    private int pageSize;
    private String tokenId;
    private String authorName;
    private String albumName;
    private Integer sheetId;
    private Integer sheetCata;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Integer getSheetId() {
        return sheetId;
    }

    public void setSheetId(Integer sheetId) {
        this.sheetId = sheetId;
    }

    public Integer getSheetCata() {
        return sheetCata;
    }

    public void setSheetCata(Integer sheetCata) {
        this.sheetCata = sheetCata;
    }
}
