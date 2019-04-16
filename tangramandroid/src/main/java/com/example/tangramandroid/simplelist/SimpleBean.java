package com.example.tangramandroid.simplelist;

public class SimpleBean {
    public static final int TYPE_IMG_NONE = 0;
    public static final int TYPE_IMG_ARROW = 1;
    public static final int TYPE_IMG_MENE = 2;
    public static final int TYPE_IMG_CHOOSED = 3;
    public static final int TYPE_EMPTY = 10;

    private int mType;
    private String mTitle;
    private String mSubTitle;
    private String mContent;
    private int mRightIconId;
    private int mLeftIconId;
    private String mLeftIconUrl;

    public SimpleBean(int type) {
        this.mType = type;
    }

    public SimpleBean(int type, String title) {
        this.mType = type;
        this.mTitle = title;
    }

    public SimpleBean(int type, String title, String subTitle, String content) {
        this.mType = type;
        this.mTitle = title;
        this.mSubTitle = subTitle;
        this.mContent = content;
    }

    public int getType() {
        return mType;
    }

    public void setType(int type) {
        this.mType = type;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getSubTitle() {
        return mSubTitle;
    }

    public void setSubTitle(String subTitle) {
        this.mSubTitle = subTitle;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        this.mContent = content;
    }

    public int getLeftIconId() {
        return mLeftIconId;
    }

    public void setLeftIconId(int leftIconId) {
        this.mLeftIconId = leftIconId;
    }

    public String getLeftIconUrl() {
        return mLeftIconUrl;
    }

    public void setLeftIconUrl(String leftIconUrl) {
        this.mLeftIconUrl = leftIconUrl;
    }

    public void setRightIconId(int rightIconId) {
        this.mRightIconId = rightIconId;
    }

    public int getRightIconId() {
        return mRightIconId;
    }
}
