package com.example.ecommercsapp;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class ProductsDetails extends AppCompatActivity {

    ImageView images;
    TextView title, description, price, discountPercentage, rating, stock, brand, sku, weight, width, height, depth, warrantyInformation, shippingInformation, availabilityStatus, returnPolicy, minimumOrderQuantity;

    public static String IMAges = "";
    public static String TITle = "";
    public static String DEScription = "";
    public static String PRIce = "";
    public static String DIScountPercentage = "";
    public static String RATing = "";
    public static String STOck = "";
//    public static String BRAnd = "";
    public static String SKU = "";
    public static String WEIght = "";
    public static String WIDth = "";
//    public static String HEIght = "";
    public static String DEPth = "";
    public static String WARrantyInformation = "";
    public static String SHIppingInformation = "";
    public static String AVAilabilityStatus = "";
    public static String RETurnPolicy = "";
    public static String MINimumOrderQuantity = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_products_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        images = findViewById(R.id.images);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        price = findViewById(R.id.price);
        discountPercentage = findViewById(R.id.discountPercentage);
        rating = findViewById(R.id.rating);
        stock = findViewById(R.id.stock);
        brand = findViewById(R.id.brand);
        sku = findViewById(R.id.sku);
        weight = findViewById(R.id.weight);
        width = findViewById(R.id.width);
        height = findViewById(R.id.height);
        depth = findViewById(R.id.depth);
        warrantyInformation = findViewById(R.id.warrantyInformation);
        shippingInformation = findViewById(R.id.shippingInformation);
        availabilityStatus = findViewById(R.id.availabilityStatus);
        returnPolicy = findViewById(R.id.returnPolicy);
        minimumOrderQuantity = findViewById(R.id.minimumOrderQuantity);


        title.setText(TITle);
        description.setText(DEScription);
        price.setText("$"+PRIce);
        discountPercentage.setText(DIScountPercentage+"%");
        rating.setText(RATing);
        stock.setText(STOck+" in Stock");
//        brand.setText(BRAnd);
        sku.setText(SKU);
        weight.setText(WEIght);
//        width.setText(WIDth);
//        height.setText(HEIght);
//        depth.setText(DEPth);
        warrantyInformation.setText(WARrantyInformation);
        shippingInformation.setText(SHIppingInformation);
        availabilityStatus.setText(AVAilabilityStatus);
        returnPolicy.setText(RETurnPolicy);
        minimumOrderQuantity.setText("Minimum Order Quantity is "+MINimumOrderQuantity);
        Glide.with(ProductsDetails.this).load(IMAges).into(images);

    }
}