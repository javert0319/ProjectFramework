package com.nbhope.hopelauncher.lib.network.bean.music;

/**
 * @ClassName: MusicBannerInfo
 * @Description: 作用描述
 * @Author: CHIA
 * @CreateDate: 2019/2/16 11:20
 */
public class MusicBannerInfo {
    /**
     * bannerImg : http://192.168.2.9:8080/multipart/open/image/2019/01/20190108/908483321363730432.png
     * bannerUrl : http://www.baidu.com
     * beginDateStr : 2019-01-07
     * overDateStr : 2019-01-31
     * refrenceId : 908483422484205568
     */

    private String bannerImg;
    private String bannerUrl;
    private String beginDateStr;
    private String overDateStr;
    private long refrenceId;

    public String getBannerImg() {
        return bannerImg;
    }

    public void setBannerImg(String bannerImg) {
        this.bannerImg = bannerImg;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getBeginDateStr() {
        return beginDateStr;
    }

    public void setBeginDateStr(String beginDateStr) {
        this.beginDateStr = beginDateStr;
    }

    public String getOverDateStr() {
        return overDateStr;
    }

    public void setOverDateStr(String overDateStr) {
        this.overDateStr = overDateStr;
    }

    public long getRefrenceId() {
        return refrenceId;
    }

    public void setRefrenceId(long refrenceId) {
        this.refrenceId = refrenceId;
    }
}
