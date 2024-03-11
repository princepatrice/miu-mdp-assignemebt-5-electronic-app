package com.miu.mdp.ectronicapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.miu.mdp.ectronicapp.model.Product

class ProductDetailActivity : ComponentActivity() {
    private lateinit var productImage: ImageView
    private lateinit var productNameTextview: TextView
    private lateinit var descriptionTextview: TextView
    private lateinit var priceTextview: TextView
    private lateinit var homeBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_product_detail)
        val product = intent.getSerializableExtra("product") as Product
        val imageId = intent.getIntExtra("image", -1);

        productImage = findViewById(R.id.product_image)
        productNameTextview = findViewById(R.id.product_name_textview)
        descriptionTextview = findViewById(R.id.description_textview)
        priceTextview = findViewById(R.id.price_textview)
        homeBtn = findViewById(R.id.home_btn)

        productImage.setImageResource(imageId)
        productNameTextview.setText(product.productName)
        descriptionTextview.setText(product.productDescription)
        priceTextview.setText( "$ " + product.cost.toString())

        homeBtn.setOnClickListener{
            finish()
        }
    }
}
