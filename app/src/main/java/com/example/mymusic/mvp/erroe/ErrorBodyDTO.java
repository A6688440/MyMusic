package com.example.mymusic.mvp.erroe;

/**
 * Created by SJC on 2020/4/20.
 * Describe：
 */
public class ErrorBodyDTO {
    private String errCode;
    private String errMsg;

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
