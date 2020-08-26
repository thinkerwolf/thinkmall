package com.thinkerwolf.thinkmall.common;

public class OpResult {

    public static final int CODE_OK = 1;
    public static final int CODE_FAIL = -1;

    private int code;
    private String errMsg;
    private Object data;

    public static OpResult ok(Object data) {
        OpResult op = new OpResult();
        op.setCode(CODE_OK);
        op.setData(data);
        return op;
    }

    public static OpResult ok() {
        OpResult op = new OpResult();
        op.setCode(CODE_OK);
        op.setData("");
        return op;
    }

    public static OpResult fail(String msg) {
        OpResult op = new OpResult();
        op.setCode(CODE_FAIL);
        op.setErrMsg(msg);
        return op;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
