package com.example.mymusic.http;

/**
 * Created by SJC on 2020/4/18.
 * Describe：
 */
public class Api {
    //根据歌手获取歌手图片
    public static final String SINGER_PIC_BASE_URL="";//歌手图片的baseUrl
    public static final String SING_PTC="api/search/get/web?csrf_token=&type=100";//歌手图片url
    //获取歌手图片需要添加user-agent的表头
    public static final String HEADER_USER_AGENT="User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64)" +
            " AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Safari/537.36";

}
