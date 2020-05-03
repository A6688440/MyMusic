package com.example.mymusic.mvp.retrofit;

import com.example.mymusic.bean.AlbumInfoBean;
import com.example.mymusic.bean.SearchAlbumBean;
import com.example.mymusic.bean.SearchSongBean;
import com.example.mymusic.bean.SingerImgBean;
import com.example.mymusic.bean.SongUrlBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by SJC on 2020/4/18.
 * Describe：Retrofit的接口
 */
public interface ApiService {


    /**
     * 搜索专辑：https://c.y.qq.com/soso/fcgi-bin/client_search_cp?p=1&n=2&w=林宥嘉&format=json&t=8
     * @param seek 搜索关键字
     * @param offset 页数
     */
    @GET(Api.SEARCH_ALBUM)
    Observable<SearchAlbumBean> searchAlbum(@Query("w") String seek, @Query("p")int offset);

    /**
     * 专辑详细：https://c.y.qq.com/v8/fcg-bin/fcg_v8_album_info_cp.fcg?albummid=004YodY33zsWTT&format=json
     * @param id 专辑mid
     */
    @GET(Api.ALBUM_DETAIL)
    Observable<AlbumInfoBean> getAlbumInfo(@Query("albummid")String id);


    /**
     *  搜索歌曲：https://c.y.qq.com/soso/fcgi-bin/client_search_cp?p=2&n=2&w=周杰伦&format=json
     */
    @GET(Api.FIDDLER_BASE_QQ_URL+Api.SEARCH_SONG)
    Observable<SearchSongBean> getSearch(@Query("w") String seek, @Query("p")int offset);

    /**
     * 得到歌曲的播放地址，变化的只有songmid，即{}所示
     * https://u.y.qq.com/cgi-bin/musicu.fcg?format=json&data=%7B%22req_0%22%3A%7B%22module%22%3A%22vkey.GetVkeyServer%22%2C%22method%22%3A%22CgiGetVkey%22%2C%22param%22%3A%7B%22guid%22%3A%22358840384%22%2C%22       +
     * songmid%22%3A%5B%22{003wFozn3V3Ra0} +
     * %22%5D%2C%22songtype%22%3A%5B0%5D%2C%22uin%22%3A%221443481947%22%2C%22loginflag%22%3A1%2C%22platform%22%3A%2220%22%7D%7D%2C%22comm%22%3A%7B%22uin%22%3A%221443481947%22%2C%22format%22%3A%22json%22%2C%22ct%22%3A24%2C%22cv%22%3A0%7D%7D
     */
    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @GET(Api.SONG_URL)
    Observable<SongUrlBean> getSongUrl(@Query(value="data",encoded = true) String data);

    /**
     * 得到歌手照片，主要用于本地音乐：http://music.163.com/api/search/get/web?s=刘瑞琦&type=100
     * @param singer 歌手的名字
     * @return
     */

    @Headers(Api.HEADER_USER_AGENT)
    @POST(Api.SINGER_PIC)
    @FormUrlEncoded
    Observable<SingerImgBean> getSingerImg(@Field("s")String singer);






}
