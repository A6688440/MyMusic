package com.example.mymusic.play;

import com.example.mymusic.bean.SingerImgBean;

import io.reactivex.Observer;

/**
 * Created by SJC on 2020/4/18.
 * Describe：
 */
public interface IPlayContract {

    //view 需要的方法
    interface V {
        void getSingerImgUrl(String SingerImgUrl);//将图片设置成背景

        //      void setSingerImgUrl(String SingerImageUrl);







        /*String getSingerName();//得到歌手的姓名

        void getSingerAndLrc();//按钮点击事件，获取封面和歌词


        void showLove(boolean love);//判断是否显示我喜欢的图标

        void showLoveAnim();//喜欢的动画

        void saveToLoveSuccess();//保存到我喜欢数据库成功

        void sendUpdateCollection();//发送广播更新收藏列表

        void showLrc(String lrc);//显示歌词

        void getLrcError(String content);//获取不到歌词

        void setLocalSongId(String songId);//设置本地音乐的songId

        void getSongIdSuccess(String songId);//成功获取到该音乐的id

        void saveLrc(String lrc);//保存歌词*/
    }


    interface P{
        void getSingerImgUrl(String singerName);
    }


    //model需要的方法
    interface M {
       void getSingerImgUrl(String singerName, Observer<SingerImgBean> observer);
    }
}
