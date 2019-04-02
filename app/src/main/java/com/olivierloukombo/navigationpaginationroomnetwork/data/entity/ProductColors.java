package com.olivierloukombo.navigationpaginationroomnetwork.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import androidx.room.Entity;

//@Entity(tableName = "table_product")
public class ProductColors implements Parcelable {
    @SerializedName("hex_value")
    private String hexaDecimal;
    @SerializedName("colour_name")
    private String colorName;

    public ProductColors(String hexaDecimal, String colorName) {
        this.hexaDecimal = hexaDecimal;
        this.colorName = colorName;
    }

    protected ProductColors(Parcel in) {
        hexaDecimal = in.readString();
        colorName = in.readString();
    }

    public static final Creator<ProductColors> CREATOR = new Creator<ProductColors>() {
        @Override
        public ProductColors createFromParcel(Parcel in) {
            return new ProductColors(in);
        }

        @Override
        public ProductColors[] newArray(int size) {
            return new ProductColors[size];
        }
    };

    public String getHexaDecimal() {
        return hexaDecimal;
    }

    public void setHexaDecimal(String hexaDecimal) {
        this.hexaDecimal = hexaDecimal;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(hexaDecimal);
        dest.writeString(colorName);
    }
}
