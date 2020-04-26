package com.example.mymusic.event;

/**
 * Created by SJC on 2020/4/22.
 * Describe：
 */
public class EventMessage {
    private String songId;
    private String albumId;
    private String singer;

    public EventMessage(String songId, String albumId, String singer) {
        this.songId = songId;
        this.albumId = albumId;
        this.singer = singer;
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

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
