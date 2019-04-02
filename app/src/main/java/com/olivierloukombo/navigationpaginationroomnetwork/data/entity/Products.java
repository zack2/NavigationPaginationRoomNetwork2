package com.olivierloukombo.navigationpaginationroomnetwork.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_product")
public class Products implements Parcelable {

    @SerializedName("id")
    @PrimaryKey
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("image_link")
    private String image;
    @SerializedName("price")
    private String price;
    @SerializedName("price_sign")
    private String priceSign;
    @SerializedName("description")
    private String description;
    @SerializedName("rating")
    private float rating;
    @SerializedName("category")
    private String category;
    @SerializedName("product_colors")
    @Ignore
    private ArrayList <ProductColors> productColors = new ArrayList<>();

    public Products(int id, String name, String image, String price, String priceSign, String description, float rating, String category) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.priceSign = priceSign;
        this.description = description;
        this.rating = rating;
        this.category = category;
    }

    protected Products(Parcel in) {
        id = in.readInt();
        name = in.readString();
        image = in.readString();
        price = in.readString();
        priceSign = in.readString();
        description = in.readString();
        rating = in.readFloat();
        category = in.readString();
        productColors = in.createTypedArrayList(ProductColors.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(image);
        dest.writeString(price);
        dest.writeString(priceSign);
        dest.writeString(description);
        dest.writeFloat(rating);
        dest.writeString(category);
        dest.writeTypedList(productColors);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Products> CREATOR = new Creator<Products>() {
        @Override
        public Products createFromParcel(Parcel in) {
            return new Products(in);
        }

        @Override
        public Products[] newArray(int size) {
            return new Products[size];
        }
    };

    public void add(ProductColors productColor){
        productColors.add(productColor);
    }
    @Ignore
    public Products() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPriceSign() {
        return priceSign;
    }

    public void setPriceSign(String priceSign) {
        this.priceSign = priceSign;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getColorName(int position){
        return productColors.get(position).getColorName();
    }

    public void setColorName(int position, String colorName){
        productColors.get(position).setColorName(colorName);
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getHexaDecimal(int position){
        return productColors.get(position).getColorName();
    }

    public void setHexaDecimal(int position, String hexaDecimal){
        productColors.get(position).setColorName(hexaDecimal);
    }

    public ArrayList<ProductColors> getProductColors() {
        return productColors;
    }

    public void setProductColors(ArrayList<ProductColors> productColors) {
        this.productColors = productColors;
    }



    public static class Builder{
        private int id;
        private String name;
        private String image;
        private String price;
        private String priceSign;
        private String description;
        private String category;
        private float rating;
        private ArrayList <ProductColors> productColors;

        public Builder setId(int id){
            this.id = id;
            return this;
        }

        public Builder setName(String name){
            this.name = name;
            return this;
        }
        public Builder setImage(String image){
            this.image = image;
            return this;
        }

        public Builder setPrice(String price){
            this.price = price;
            return this;
        } public Builder setPriceSign(String priceSign){
            this.priceSign = priceSign;
            return this;
        }
        public Builder setDescription(String description){
            this.description = description;
            return this;
        }
        public Builder setCategory(String category){
            this.category = category;
            return this;
        }
        public Builder setRating( float rating){
            this.rating = rating;
            return this;
        }

        public Builder setProductColor( ArrayList <ProductColors> productColors){
            this.productColors = productColors;
            return this;
        }

        public Products builder(){
            return new Products(id,name, image, price, priceSign,description,rating,category);
        }
    }
}
