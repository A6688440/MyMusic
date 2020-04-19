package com.example.mymusic.view;

import com.example.mymusic.base.view.BaseView;
import com.example.mymusic.http.BaseModel;

/**
 * Created by SJC on 2020/4/18.
 * Describe：
 */
public interface IPlayContract {

    interface V {
        String getSingerName();//得到歌手的姓名

        void getSingerAndLrc();//按钮点击事件，获取封面和歌词

        void setSingerImg(String ImgUrl);//将图片设置成背景

        void showLove(boolean love);//判断是否显示我喜欢的图标

        void showLoveAnim();//喜欢的动画

        void saveToLoveSuccess();//保存到我喜欢数据库成功

        void sendUpdateCollection();//发送广播更新收藏列表

        void showLrc(String lrc);//显示歌词

        void getLrcError(String content);//获取不到歌词

        void setLocalSongId(String songId);//设置本地音乐的songId

        void getSongIdSuccess(String songId);//成功获取到该音乐的id

        void saveLrc(String lrc);//保存歌词
    }


    interface M {
        void getSingerImg(String singer, String song, long duration);//获取歌手的图片
    }

}
