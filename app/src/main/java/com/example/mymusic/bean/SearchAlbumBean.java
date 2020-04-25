package com.example.mymusic.bean;

import java.util.List;

/**
 * Created by SJC on 2020/4/25.
 * Describe：
 */
public class SearchAlbumBean {

    /**
     * code : 0
     * data : {"album":{"curnum":2,"curpage":1,"list":[{"albumID":5597202,"albumMID":"001bnbXE43tJy0","albumName":"AIR·艾热","albumName_hilight":"AIR·<em>艾热<\/em>","albumPic":"http://y.gtimg.cn/music/photo_new/T002R180x180M000001bnbXE43tJy0_1.jpg","catch_song":"","docid":"14786494705902143788","publicTime":"2018-12-18","singerID":944677,"singerMID":"000djEdv2aAycA","singerName":"艾热","singerName_hilight":"<em>艾热<\/em>","singer_list":[{"id":944677,"mid":"000djEdv2aAycA","name":"艾热","name_hilight":"<em>艾热<\/em>"}],"song_count":10,"type":0},{"albumID":5500617,"albumMID":"002YAM6K2f4hWJ","albumName":"光年之外（热爱版）","albumName_hilight":"光年之外（<em>热<\/em>爱版）","albumPic":"http://y.gtimg.cn/music/photo_new/T002R180x180M000002YAM6K2f4hWJ_1.jpg","catch_song":"","docid":"14311062849510524226","publicTime":"2018-12-10","singerID":13948,"singerMID":"001fNHEf1SFEFN","singerName":"G.E.M. 邓紫棋 / 艾热","singerName_hilight":"G.E.M. 邓紫棋 / <em>艾热<\/em>","singer_list":[{"id":13948,"mid":"001fNHEf1SFEFN","name":"G.E.M. 邓紫棋","name_hilight":"G.E.M. 邓紫棋"},{"id":944677,"mid":"000djEdv2aAycA","name":"艾热","name_hilight":"<em>艾热<\/em>"}],"song_count":1,"type":0}],"totalnum":95},"keyword":"艾热","priority":0,"qc":[],"tab":8,"taglist":[],"totaltime":0,"zhida":{"chinesesinger":0,"type":0}}
     * message :
     * notice :
     * subcode : 0
     * time : 1587805726
     * tips :
     */

    private int code;
    private DataBean data;
    private String message;
    private String notice;
    private int subcode;
    private int time;
    private String tips;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public int getSubcode() {
        return subcode;
    }

    public void setSubcode(int subcode) {
        this.subcode = subcode;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public static class DataBean {
        /**
         * album : {"curnum":2,"curpage":1,"list":[{"albumID":5597202,"albumMID":"001bnbXE43tJy0","albumName":"AIR·艾热","albumName_hilight":"AIR·<em>艾热<\/em>","albumPic":"http://y.gtimg.cn/music/photo_new/T002R180x180M000001bnbXE43tJy0_1.jpg","catch_song":"","docid":"14786494705902143788","publicTime":"2018-12-18","singerID":944677,"singerMID":"000djEdv2aAycA","singerName":"艾热","singerName_hilight":"<em>艾热<\/em>","singer_list":[{"id":944677,"mid":"000djEdv2aAycA","name":"艾热","name_hilight":"<em>艾热<\/em>"}],"song_count":10,"type":0},{"albumID":5500617,"albumMID":"002YAM6K2f4hWJ","albumName":"光年之外（热爱版）","albumName_hilight":"光年之外（<em>热<\/em>爱版）","albumPic":"http://y.gtimg.cn/music/photo_new/T002R180x180M000002YAM6K2f4hWJ_1.jpg","catch_song":"","docid":"14311062849510524226","publicTime":"2018-12-10","singerID":13948,"singerMID":"001fNHEf1SFEFN","singerName":"G.E.M. 邓紫棋 / 艾热","singerName_hilight":"G.E.M. 邓紫棋 / <em>艾热<\/em>","singer_list":[{"id":13948,"mid":"001fNHEf1SFEFN","name":"G.E.M. 邓紫棋","name_hilight":"G.E.M. 邓紫棋"},{"id":944677,"mid":"000djEdv2aAycA","name":"艾热","name_hilight":"<em>艾热<\/em>"}],"song_count":1,"type":0}],"totalnum":95}
         * keyword : 艾热
         * priority : 0
         * qc : []
         * tab : 8
         * taglist : []
         * totaltime : 0
         * zhida : {"chinesesinger":0,"type":0}
         */

        private AlbumBean album;
        private String keyword;
        private int priority;
        private int tab;
        private int totaltime;
        private ZhidaBean zhida;
        private List<?> qc;
        private List<?> taglist;

        public AlbumBean getAlbum() {
            return album;
        }

        public void setAlbum(AlbumBean album) {
            this.album = album;
        }

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public int getTab() {
            return tab;
        }

        public void setTab(int tab) {
            this.tab = tab;
        }

        public int getTotaltime() {
            return totaltime;
        }

        public void setTotaltime(int totaltime) {
            this.totaltime = totaltime;
        }

        public ZhidaBean getZhida() {
            return zhida;
        }

        public void setZhida(ZhidaBean zhida) {
            this.zhida = zhida;
        }

        public List<?> getQc() {
            return qc;
        }

        public void setQc(List<?> qc) {
            this.qc = qc;
        }

        public List<?> getTaglist() {
            return taglist;
        }

        public void setTaglist(List<?> taglist) {
            this.taglist = taglist;
        }

        public static class AlbumBean {
            /**
             * curnum : 2
             * curpage : 1
             * list : [{"albumID":5597202,"albumMID":"001bnbXE43tJy0","albumName":"AIR·艾热","albumName_hilight":"AIR·<em>艾热<\/em>","albumPic":"http://y.gtimg.cn/music/photo_new/T002R180x180M000001bnbXE43tJy0_1.jpg","catch_song":"","docid":"14786494705902143788","publicTime":"2018-12-18","singerID":944677,"singerMID":"000djEdv2aAycA","singerName":"艾热","singerName_hilight":"<em>艾热<\/em>","singer_list":[{"id":944677,"mid":"000djEdv2aAycA","name":"艾热","name_hilight":"<em>艾热<\/em>"}],"song_count":10,"type":0},{"albumID":5500617,"albumMID":"002YAM6K2f4hWJ","albumName":"光年之外（热爱版）","albumName_hilight":"光年之外（<em>热<\/em>爱版）","albumPic":"http://y.gtimg.cn/music/photo_new/T002R180x180M000002YAM6K2f4hWJ_1.jpg","catch_song":"","docid":"14311062849510524226","publicTime":"2018-12-10","singerID":13948,"singerMID":"001fNHEf1SFEFN","singerName":"G.E.M. 邓紫棋 / 艾热","singerName_hilight":"G.E.M. 邓紫棋 / <em>艾热<\/em>","singer_list":[{"id":13948,"mid":"001fNHEf1SFEFN","name":"G.E.M. 邓紫棋","name_hilight":"G.E.M. 邓紫棋"},{"id":944677,"mid":"000djEdv2aAycA","name":"艾热","name_hilight":"<em>艾热<\/em>"}],"song_count":1,"type":0}]
             * totalnum : 95
             */

            private int curnum;
            private int curpage;
            private int totalnum;
            private List<ListBean> list;

            public int getCurnum() {
                return curnum;
            }

            public void setCurnum(int curnum) {
                this.curnum = curnum;
            }

            public int getCurpage() {
                return curpage;
            }

            public void setCurpage(int curpage) {
                this.curpage = curpage;
            }

            public int getTotalnum() {
                return totalnum;
            }

            public void setTotalnum(int totalnum) {
                this.totalnum = totalnum;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                /**
                 * albumID : 5597202
                 * albumMID : 001bnbXE43tJy0
                 * albumName : AIR·艾热
                 * albumName_hilight : AIR·<em>艾热</em>
                 * albumPic : http://y.gtimg.cn/music/photo_new/T002R180x180M000001bnbXE43tJy0_1.jpg
                 * catch_song :
                 * docid : 14786494705902143788
                 * publicTime : 2018-12-18
                 * singerID : 944677
                 * singerMID : 000djEdv2aAycA
                 * singerName : 艾热
                 * singerName_hilight : <em>艾热</em>
                 * singer_list : [{"id":944677,"mid":"000djEdv2aAycA","name":"艾热","name_hilight":"<em>艾热<\/em>"}]
                 * song_count : 10
                 * type : 0
                 */

                private int albumID;
                private String albumMID;
                private String albumName;
                private String albumName_hilight;
                private String albumPic;
                private String catch_song;
                private String docid;
                private String publicTime;
                private int singerID;
                private String singerMID;
                private String singerName;
                private String singerName_hilight;
                private int song_count;
                private int type;
                private List<SingerListBean> singer_list;

                public int getAlbumID() {
                    return albumID;
                }

                public void setAlbumID(int albumID) {
                    this.albumID = albumID;
                }

                public String getAlbumMID() {
                    return albumMID;
                }

                public void setAlbumMID(String albumMID) {
                    this.albumMID = albumMID;
                }

                public String getAlbumName() {
                    return albumName;
                }

                public void setAlbumName(String albumName) {
                    this.albumName = albumName;
                }

                public String getAlbumName_hilight() {
                    return albumName_hilight;
                }

                public void setAlbumName_hilight(String albumName_hilight) {
                    this.albumName_hilight = albumName_hilight;
                }

                public String getAlbumPic() {
                    return albumPic;
                }

                public void setAlbumPic(String albumPic) {
                    this.albumPic = albumPic;
                }

                public String getCatch_song() {
                    return catch_song;
                }

                public void setCatch_song(String catch_song) {
                    this.catch_song = catch_song;
                }

                public String getDocid() {
                    return docid;
                }

                public void setDocid(String docid) {
                    this.docid = docid;
                }

                public String getPublicTime() {
                    return publicTime;
                }

                public void setPublicTime(String publicTime) {
                    this.publicTime = publicTime;
                }

                public int getSingerID() {
                    return singerID;
                }

                public void setSingerID(int singerID) {
                    this.singerID = singerID;
                }

                public String getSingerMID() {
                    return singerMID;
                }

                public void setSingerMID(String singerMID) {
                    this.singerMID = singerMID;
                }

                public String getSingerName() {
                    return singerName;
                }

                public void setSingerName(String singerName) {
                    this.singerName = singerName;
                }

                public String getSingerName_hilight() {
                    return singerName_hilight;
                }

                public void setSingerName_hilight(String singerName_hilight) {
                    this.singerName_hilight = singerName_hilight;
                }

                public int getSong_count() {
                    return song_count;
                }

                public void setSong_count(int song_count) {
                    this.song_count = song_count;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public List<SingerListBean> getSinger_list() {
                    return singer_list;
                }

                public void setSinger_list(List<SingerListBean> singer_list) {
                    this.singer_list = singer_list;
                }

                public static class SingerListBean {
                    /**
                     * id : 944677
                     * mid : 000djEdv2aAycA
                     * name : 艾热
                     * name_hilight : <em>艾热</em>
                     */

                    private int id;
                    private String mid;
                    private String name;
                    private String name_hilight;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getMid() {
                        return mid;
                    }

                    public void setMid(String mid) {
                        this.mid = mid;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getName_hilight() {
                        return name_hilight;
                    }

                    public void setName_hilight(String name_hilight) {
                        this.name_hilight = name_hilight;
                    }
                }
            }
        }

        public static class ZhidaBean {
            /**
             * chinesesinger : 0
             * type : 0
             */

            private int chinesesinger;
            private int type;

            public int getChinesesinger() {
                return chinesesinger;
            }

            public void setChinesesinger(int chinesesinger) {
                this.chinesesinger = chinesesinger;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }
    }
}
