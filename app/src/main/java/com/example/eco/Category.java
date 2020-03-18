package com.example.eco;

public class Category {

    private int mImageView;

    private  int mTextViewCategory;

    public Category(int vImageView, int vTextViewCategory){

        mImageView = vImageView;
        mTextViewCategory = vTextViewCategory;
    }

    public int getImage() {
        return mImageView;
    }

    public int getCategory() {
        return mTextViewCategory;
    }
}
