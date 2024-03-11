package com.miu.mdp.ectronicapp.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.miu.mdp.ectronicapp.ProductDetailActivity
import com.miu.mdp.ectronicapp.R
import com.miu.mdp.ectronicapp.model.Product
import com.miu.mdp.ectronicapp.viewholder.ItemViewHolder

class ProdRecycleViewAdapter(
    private var products: List<Product>,
    private var images: List<Int>,
    private var logos: List<Int>,
    private var cart:HashMap<Int, Int>
) :
    RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.productImageView.setImageResource(images[position])
        holder.brandLogoImageView.setImageResource(logos[position])
        holder.productNameTextView.text = products[position].productName
        holder.priceTextView.text = "\$ ${products[position].cost}"
        holder.descriptionTextView.text = products[position].productDescription

        holder.addBtn.setOnClickListener{
            run{
                cart[position] = (cart[position] ?: 0) + 1
                Toast.makeText(holder.itemView.context, "Item added to cart!", Toast.LENGTH_SHORT).show()
            }}

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, ProductDetailActivity::class.java)
            intent.putExtra("product", products[position])
            intent.putExtra("image", images[position])

            holder.itemView.context.startActivity(intent)
        }
    }

}