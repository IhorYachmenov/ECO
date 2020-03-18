package com.example.eco;

public class Category {

    private int mImageView;

    private  String mTextViewCategory;

    public Category(int vImageView, String vTextViewCategory){

        mImageView = vImageView;
        mTextViewCategory = vTextViewCategory;
    }

    public int getImage() {
        return mImageView;
    }

    public String getCategory() {
        return mTextViewCategory;
    }
}
