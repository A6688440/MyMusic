package com.example.mymusic.event;

import java.util.List;

/**
 * Created by SJC on 2020/4/22.
 * Describe：
 */
public class EventMessage {
    //歌曲的Id   专辑Id   歌名  歌手s
    private String songId;
    private String albumId;
    private String songName;
    private List<String> singers;

    public EventMessage(String songId, String albumId, String songName, List<String> singers) {
        this.songId = songId;
        this.albumId = albumId;
        this.songName = songName;
        this.singers = singers;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public List<String> getSingers() {
        return singers;
    }

    public void setSingers(List<String> singers) {
        this.singers = singers;
    }
}
