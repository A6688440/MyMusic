package com.example.mymusic.bean;

import java.util.List;

/**
 * Created by SJC on 2020/4/18.
 * Describe：
 */
public class SingerImgBean {

    /**
     * result : {"artistCount":1,"artists":[{"id":840134,"name":"刘瑞琦","picUrl":"http://p2.music.126.net/FxdEWD82ltCMocBr3pHKAA==/109951164034204967.jpg","alias":[],"albumSize":28,"picId":109951164034204967,"img1v1Url":"http://p2.music.126.net/iZMbryk8-rLOvCV99GDn-g==/109951164034200598.jpg","accountId":3788031,"img1v1":109951164034200598,"mvSize":33,"followed":false,"trans":null}]}
     * code : 200
     */

    private ResultBean result;
    private int code;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class ResultBean {
        /**
         * artistCount : 1
         * artists : [{"id":840134,"name":"刘瑞琦","picUrl":"http://p2.music.126.net/FxdEWD82ltCMocBr3pHKAA==/109951164034204967.jpg","alias":[],"albumSize":28,"picId":109951164034204967,"img1v1Url":"http://p2.music.126.net/iZMbryk8-rLOvCV99GDn-g==/109951164034200598.jpg","accountId":3788031,"img1v1":109951164034200598,"mvSize":33,"followed":false,"trans":null}]
         */

        private int artistCount;
        private List<ArtistsBean> artists;

        public int getArtistCount() {
            return artistCount;
        }

        public void setArtistCount(int artistCount) {
            this.artistCount = artistCount;
        }

        public List<ArtistsBean> getArtists() {
            return artists;
        }

        public void setArtists(List<ArtistsBean> artists) {
            this.artists = artists;
        }

        public static class ArtistsBean {
            /**
             * id : 840134
             * name : 刘瑞琦
             * picUrl : http://p2.music.126.net/FxdEWD82ltCMocBr3pHKAA==/109951164034204967.jpg
             * alias : []
             * albumSize : 28
             * picId : 109951164034204967
             * img1v1Url : http://p2.music.126.net/iZMbryk8-rLOvCV99GDn-g==/109951164034200598.jpg
             * accountId : 3788031
             * img1v1 : 109951164034200598
             * mvSize : 33
             * followed : false
             * trans : null
             */

            private int id;
            private String name;
            private String picUrl;
            private int albumSize;
            private long picId;
            private String img1v1Url;
            private int accountId;
            private long img1v1;
            private int mvSize;
            private boolean followed;
            private Object trans;
            private List<?> alias;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public int getAlbumSize() {
                return albumSize;
            }

            public void setAlbumSize(int albumSize) {
                this.albumSize = albumSize;
            }

            public long getPicId() {
                return picId;
            }

            public void setPicId(long picId) {
                this.picId = picId;
            }

            public String getImg1v1Url() {
                return img1v1Url;
            }

            public void setImg1v1Url(String img1v1Url) {
                this.img1v1Url = img1v1Url;
            }

            public int getAccountId() {
                return accountId;
            }

            public void setAccountId(int accountId) {
                this.accountId = accountId;
            }

            public long getImg1v1() {
                return img1v1;
            }

            public void setImg1v1(long img1v1) {
                this.img1v1 = img1v1;
            }

            public int getMvSize() {
                return mvSize;
            }

            public void setMvSize(int mvSize) {
                this.mvSize = mvSize;
            }

            public boolean isFollowed() {
                return followed;
            }

            public void setFollowed(boolean followed) {
                this.followed = followed;
            }

            public Object getTrans() {
                return trans;
            }

            public void setTrans(Object trans) {
                this.trans = trans;
            }

            public List<?> getAlias() {
                return alias;
            }

            public void setAlias(List<?> alias) {
                this.alias = alias;
            }
        }
    }
}
