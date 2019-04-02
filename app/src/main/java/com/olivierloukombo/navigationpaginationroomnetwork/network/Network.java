package com.olivierloukombo.navigationpaginationroomnetwork.network;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.google.gson.Gson;
import com.olivierloukombo.navigationpaginationroomnetwork.data.entity.ProductColors;
import com.olivierloukombo.navigationpaginationroomnetwork.data.entity.Products;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class Network {
    private static final String TAG = Network.class.getSimpleName();
    private void downloadData(Context context) {
        AndroidNetworking.get("http://makeup-api.herokuapp.com/api/v1/products.json")
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.e(TAG, "onResponse: " + response);
                        parse(context);
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.e(TAG, "Download erreur : " + anError.getMessage());
                    }
                });
    }

    private static String AssetJSONFile(String filename, Context context) throws IOException {
        AssetManager manager = context.getAssets();
        InputStream file = manager.open(filename);
        byte[] formArray = new byte[file.available()];
        file.read(formArray);
        file.close();

        return new String(formArray);
    }

    public static ArrayList<Products> parse(Context context) {
        String jsonLocation;
        JSONArray jsonArray;

        ArrayList<Products> productsArrayList = new ArrayList<>();
        try {
            jsonLocation = AssetJSONFile("products.json", context);
            jsonArray = new JSONArray(jsonLocation);


            for (int i = 0; i < jsonArray.length(); i++) {
                try {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    Gson gson = new Gson();

                    Products product = gson.fromJson(jsonObject.toString(), Products.class);
                    Log.e(TAG, "parse for: Name: " + product.getName() + " price : " + product.getPrice());
                    for (int k = i; k < jsonObject.getJSONArray("product_colors").length(); k++) {
                        JSONArray colorProdArray = jsonObject.getJSONArray("product_colors");
                        JSONObject jsonObject1 = colorProdArray.getJSONObject(k);
                        ProductColors productColor = gson.fromJson(jsonObject1.toString(), ProductColors.class);
                        Log.e(TAG, "parse for: colorName: " + productColor.getColorName() + " hexa : " + productColor.getHexaDecimal());
                        product.add(productColor);
                    }

                    productsArrayList.add(product);
                } catch (JSONException e) {
                    Log.e(TAG, "JSONException : " + e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return productsArrayList;
    }

}
