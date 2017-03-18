package com.example.dee.listviewpractice;

/**
 * Created by Dee on 18/03/2017.
 */

public class Products {

    private int _id; // primary key, auto increment
    private String _productName;

    public Products(String productName) {
        this._productName = productName;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_productName(String _productName) {
        this._productName = _productName;
    }
}
