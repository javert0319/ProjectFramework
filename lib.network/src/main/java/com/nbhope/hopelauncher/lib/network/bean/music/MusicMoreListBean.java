package com.nbhope.hopelauncher.lib.network.bean.music;

/**
 * @ClassName: MusicMoreListBean
 * @Description: 作用描述
 * @Author: CHIA
 * @CreateDate: 2019/2/26 14:20
 */
public class MusicMoreListBean {

    /**
     * contType : 2
     * displayName : 测试的歌曲
     * musicId : SBC111111
     * musicImage : http://192.168.2.9:8080/multipart/open/image/2019/01/20190102/906263326714007552.jpg
     * musicName : 测试的歌曲
     * authorName : 电子作曲家
     * musicTime : 300
     * musicTimeStr : 00:00
     * refrenceId : 911042978909274100
     * sourceUrl : http://music/130283
     * ircUrl : http://irc/130283
     * updateTime : 1547537696203
     * updateTimeStr : 2019-01-15 15:34:56
     */

    private int contType;
    private String displayName;
    private String musicId;
    private String musicImage;
    private String musicName;
    private String authorName;
    private int musicTime;
    private String musicTimeStr;
    private long refrenceId;
    private String sourceUrl;
    private String ircUrl;
    private long updateTime;
    private String updateTimeStr;

    public int getContType() {
        return contType;
    }

    public void setContType(int contType) {
        this.contType = contType;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getMusicId() {
        return musicId;
    }

    public void setMusicId(String musicId) {
        this.musicId = musicId;
    }

    public String getMusicImage() {
        return musicImage;
    }

    public void setMusicImage(String musicImage) {
        this.musicImage = musicImage;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getMusicTime() {
        return musicTime;
    }

    public void setMusicTime(int musicTime) {
        this.musicTime = musicTime;
    }

    public String getMusicTimeStr() {
        return musicTimeStr;
    }

    public void setMusicTimeStr(String musicTimeStr) {
        this.musicTimeStr = musicTimeStr;
    }

    public long getRefrenceId() {
        return refrenceId;
    }

    public void setRefrenceId(long refrenceId) {
        this.refrenceId = refrenceId;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getIrcUrl() {
        return ircUrl;
    }

    public void setIrcUrl(String ircUrl) {
        this.ircUrl = ircUrl;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateTimeStr() {
        return updateTimeStr;
    }

    public void setUpdateTimeStr(String updateTimeStr) {
        this.updateTimeStr = updateTimeStr;
    }
}
