package com.example.ecommercsapp;

import static android.view.View.GONE;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressbar;

    GridView productsView;

    ArrayList <HashMap<String, String>> arrayList = new ArrayList<>();

    HashMap<String, String> hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        progressbar = findViewById(R.id.progressbar);
        productsView = findViewById(R.id.productsView);


        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "https://dummyjson.com/products";

        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressbar.setVisibility(GONE);

                try {
                    JSONArray jsonArray = response.getJSONArray("products");

                    for (int x = 0; x<jsonArray.length() ; x++){

                        JSONObject jsonObject = jsonArray.getJSONObject(x);

                        String title = jsonObject.getString("title");
                        String description = jsonObject.getString("description");

                        String price = jsonObject.getString("price");
                        String discountPercentage = jsonObject.getString("discountPercentage");
                        String rating = jsonObject.getString("rating");
                        String stock = jsonObject.getString("stock");


                        JSONArray dimensionsarray = jsonObject.getJSONArray("dimensions");

//      problem Ai Jaiga Theke Suru hoiyeche

//                        for (int y=0; y<dimensionsarray.length();y++){
//                            JSONObject dimArray = dimensionsarray.getJSONObject(y);
//
//                            String width = dimArray.getString("width");
//                        String height = dimArray.getString("height");
//                        String depth = dimArray.getString("depth");

//                            hashMap = new HashMap<>();
//                            hashMap.put("width", width);
//                        hashMap.put("height", height);
//                        hashMap.put("depth", depth);
//                            arrayList.add(hashMap);
//
//                        }


//                        String brand = jsonObject.getString("brand");
                        String sku = jsonObject.getString("sku");
                        String weight = jsonObject.getString("weight");
//



                        String warrantyInformation = jsonObject.getString("warrantyInformation");
                        String shippingInformation = jsonObject.getString("shippingInformation");
                        String availabilityStatus = jsonObject.getString("availabilityStatus");
                        String returnPolicy = jsonObject.getString("returnPolicy");
                        String minimumOrderQuantity = jsonObject.getString("minimumOrderQuantity");
                        String images = jsonObject.getString("images");
                        String thumbnail = jsonObject.getString("thumbnail");




                        hashMap = new HashMap<>();

                        hashMap.put("title", title);
                        hashMap.put("description", description);

                        hashMap.put("price", price);
                        hashMap.put("discountPercentage", discountPercentage);
                        hashMap.put("rating", rating);
                        hashMap.put("stock", stock);


//                        hashMap.put("brand", brand);
                        hashMap.put("sku", sku);
                        hashMap.put("weight", weight);


                        hashMap.put("warrantyInformation", warrantyInformation);
                        hashMap.put("shippingInformation", shippingInformation);
                        hashMap.put("availabilityStatus", availabilityStatus);
                        hashMap.put("returnPolicy", returnPolicy);
                        hashMap.put("minimumOrderQuantity", minimumOrderQuantity);
                        hashMap.put("images", images);
                        hashMap.put("thumbnail", thumbnail);

                        arrayList.add(hashMap);





                    }

                    Products allproducts = new Products();
                    productsView.setAdapter(allproducts);


                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressbar.setVisibility(GONE);

            }
        });

        queue.add(objectRequest);



    }



    //===============================
    private class Products extends BaseAdapter {

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View Productsview = layoutInflater.inflate(R.layout.products_list, viewGroup, false);

            LinearLayout product = Productsview.findViewById(R.id.product);

            TextView title = Productsview.findViewById(R.id.title);
            TextView price = Productsview.findViewById(R.id.price);
            TextView discountPercentage = Productsview.findViewById(R.id.discountPercentage);
            TextView rating = Productsview.findViewById(R.id.rating);
            TextView stock = Productsview.findViewById(R.id.stock);
            ImageView thumbnail = Productsview.findViewById(R.id.thumbnail);


            HashMap<String, String> hashMap = arrayList.get(i);





            String Title = hashMap.get("title");
            String Description = hashMap.get("description");

            String Price = hashMap.get("price");
            String DiscountPercentage = hashMap.get("discountPercentage");
            String Rating = hashMap.get("rating");
            String Stock = hashMap.get("stock");


//            String Brand = hashMap.get("brand");
            String Sku = hashMap.get("sku");
            String Weight = hashMap.get("weight");
//            String Width = hashMap.get("width");
//            String Height = hashMap.get("height");
//            String Depth = hashMap.get("depth");

            String WarrantyInformation = hashMap.get("warrantyInformation");
            String ShippingInformation = hashMap.get("shippingInformation");
            String AvailabilityStatus = hashMap.get("availabilityStatus");
            String ReturnPolicy = hashMap.get("returnPolicy");
            String MinimumOrderQuantity = hashMap.get("minimumOrderQuantity");
            String Images = hashMap.get("images");

            String Thumbnail = hashMap.get("thumbnail");


            title.setText(Title);
            price.setText("$"+Price);
            discountPercentage.setText(DiscountPercentage +"%");
            rating.setText(Rating);
            stock.setText(Stock+" in Stock");
            Glide.with(MainActivity.this).load(Thumbnail).into(thumbnail);



            product.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ProductsDetails.TITle = Title;
                    ProductsDetails.DEScription= Description;
                    ProductsDetails.PRIce= Price;
                    ProductsDetails.DIScountPercentage= DiscountPercentage;
                    ProductsDetails.RATing= Rating;
                    ProductsDetails.STOck= Stock;

//                    ProductsDetails.BRAnd= Brand;
                    ProductsDetails.SKU= Sku;
                    ProductsDetails.WEIght= Weight;
//                    ProductsDetails.WIDth= Width;
//                    ProductsDetails.HEIght= Height;
//                    ProductsDetails.DEPth= Depth;

                    ProductsDetails.WARrantyInformation= WarrantyInformation;
                    ProductsDetails.SHIppingInformation= ShippingInformation;
                    ProductsDetails.AVAilabilityStatus= AvailabilityStatus;
                    ProductsDetails.RETurnPolicy= ReturnPolicy;
                    ProductsDetails.MINimumOrderQuantity= MinimumOrderQuantity;
                    ProductsDetails.IMAges= Images;



                    startActivity(new Intent(MainActivity.this, ProductsDetails.class));

                }
            });


            return Productsview;
        }
    }
    //===============================
}