package com.miu.mdp.ectronicapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.miu.mdp.ectronicapp.adapter.ProdRecycleViewAdapter
import com.miu.mdp.ectronicapp.model.Product
import com.miu.mdp.ectronicapp.ui.theme.EctronicAppTheme

class MainActivity : ComponentActivity() {

    private lateinit var products: List<Product>
    private lateinit var productImages: List<Int>
    private lateinit var brandLogos: List<Int>
    private lateinit var cart: HashMap<Int, Int>

    private lateinit var  viewCartBtn: Button
    private lateinit var  recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main)

        viewCartBtn = findViewById(R.id.view_cart_btn)
        recyclerView = findViewById(R.id.recycler_view)
        
     products = listOf(
            Product("iPad", "iPad Pro 11-inch", 500.0),
            Product("MacBook M3 Pro", "12-core CPU\n18-core GPU", 6000.00),
            Product("Dell Inspiron", "13th Gen Intel® Core™ i7", 1599.00),
            Product("Logitech Keyboard", "Logitech - PRO X\nTKL LIGHTSPEED Wireless", 199.00),
            Product("MacBook M3 Max", "14-core CPU\n30-core GPU", 3499.00)
        )

        productImages = listOf(
            R.drawable.ipad,
            R.drawable.mac,
            R.drawable.dell_laptop,
            R.drawable.keyboard,
            R.drawable.mac_2
        )

        brandLogos = listOf(
            R.drawable.apple_logo,
            R.drawable.apple_logo,
            R.drawable.dell_logo,
            R.drawable.logitech_logo,
            R.drawable.apple_logo
        )

        cart = HashMap()

        val adapter = ProdRecycleViewAdapter(products, productImages, brandLogos, cart)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewCartBtn.setOnClickListener{
           if (cart.size == 0) {
            Toast.makeText(this, "You have no items in your cart.", Toast.LENGTH_SHORT).show()
        } else {
            var cartItems = "";
            cart.keys.forEach { k -> run{
                if(cartItems.isNotEmpty()) cartItems+=", "
                cartItems += " ${products[k].productName}: ${cart[k]}"
            } }

            Toast.makeText(this, cartItems, Toast.LENGTH_SHORT).show()
        }
    }

    
    }
}

