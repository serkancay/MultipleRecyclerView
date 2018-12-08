package com.serkancay.multiplerecyclerview;

/**
 * Created by S.Serkan Cay on 5.12.2018
 */

public class Book {

    private String mName;

    private String mDescription;

    private String mAuthor;

    private String mPublisher;

    private double mPrice;

    private double mDiscountedPrice;

    private int mImageResId;

    private Type mType;

    public Book(String name, String description, String author, String publisher, double price,
            double discountedPrice, int imageResId, Type type) {
        mName = name;
        mDescription = description;
        mAuthor = author;
        mPublisher = publisher;
        mPrice = price;
        mDiscountedPrice = discountedPrice;
        mImageResId = imageResId;
        mType = type;
    }

    public String getName() {
        return mName;
    }

    public void setName(final String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(final String description) {
        mDescription = description;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(final String author) {
        mAuthor = author;
    }

    public String getPublisher() {
        return mPublisher;
    }

    public void setPublisher(final String publisher) {
        mPublisher = publisher;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(final double price) {
        mPrice = price;
    }

    public double getDiscountedPrice() {
        return mDiscountedPrice;
    }

    public void setDiscountedPrice(final double discountedPrice) {
        mDiscountedPrice = discountedPrice;
    }

    public int getImageResId() {
        return mImageResId;
    }

    public void setImageResId(final int imageResId) {
        mImageResId = imageResId;
    }

    public Type getType() {
        return mType;
    }

    public void setType(final Type type) {
        mType = type;
    }

    public enum Type {

        NORMAL, DISCOUNTED

    }
}
