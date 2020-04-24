package com.example.mymusic.event;

/**
 * Created by SJC on 2020/4/22.
 * Describe：
 */
public class EventMessage {
    private boolean ShowView;

    public EventMessage(boolean showView) {
        ShowView = showView;
    }

    public boolean isShowView() {
        return ShowView;
    }

    public void setShowView(boolean showView) {
        ShowView = showView;
    }
}
