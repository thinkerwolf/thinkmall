package com.thinkerwolf.thinkmall.common;

public abstract class OpResult {

    public static final int CODE_OK = 1;
    public static final int CODE_FAIL = -1;

    private int code;

    public static OpResult ok(Object data) {
        OpResultSuccess op = new OpResultSuccess();
        op.setCode(CODE_OK);
        op.setData(data);
        return op;
    }

    public static OpResult ok() {
        OpResultSuccess op = new OpResultSuccess();
        op.setCode(CODE_OK);
        op.setData("");
        return op;
    }

    public static OpResult fail(String msg) {
        OpResultFail op = new OpResultFail();
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


}
