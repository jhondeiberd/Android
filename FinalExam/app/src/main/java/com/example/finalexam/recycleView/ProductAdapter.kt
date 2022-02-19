package com.example.finalexam.recycleView

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalexam.R
import com.example.finalexam.entities.Product

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ScoreItemViewHolder>() {
    private val dataSet = mutableListOf<Product>()

    class ScoreItemViewHolder (private val parentAdapter: ProductAdapter, private val containerView: View):RecyclerView.ViewHolder(containerView) {
        var product: Product? = null
        val listProductName: TextView =  containerView.findViewById(R.id.list_product_name)
        val listProductDescrip: TextView =  containerView.findViewById(R.id.list_product_description)
        val listProductPrice: TextView =  containerView.findViewById(R.id.list_product_price)
        val listProductImage: ImageView =  containerView.findViewById(R.id.list_product_image)

        val subtract: Button =  containerView.findViewById(R.id.main_subtract)
        val listQuantity: TextView =  containerView.findViewById(R.id.list_product_quantity)
        val add: Button =  containerView.findViewById(R.id.main_add)

        init {
            add.setOnClickListener {
                if (product != null)
                    parentAdapter.addQuantity(product as Product)
            }
            subtract.setOnClickListener {
                if (product != null)
                    parentAdapter.subtractQuantity(product as Product)
            }
        }
    }

    public fun changeData(dataSet: List<Product>) {
        this.dataSet.clear()
        this.dataSet.addAll(dataSet)
        notifyDataSetChanged()
    }

    public fun addData(product: Product){
        dataSet.add(product)
        notifyDataSetChanged()
    }

    public fun removeData(product: Product){
        dataSet.remove(product)
        notifyDataSetChanged()
    }

    private fun addQuantity(product: Product) {
//        dataSet += score.scoreText
        notifyDataSetChanged()
    }

    private fun subtractQuantity(product: Product) {
//        dataSet -= score.scoreText
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, customViewType: Int): ScoreItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(customViewType,parent,false)
        return ScoreItemViewHolder(this, view)
    }

    @SuppressLint("ResourceType")
    override fun onBindViewHolder(holder: ScoreItemViewHolder, position: Int) {
        val currentData = dataSet[position]
        holder.product = currentData
        holder.listProductName.text = currentData.productName
        holder.listProductDescrip.text = currentData.productDescription
        holder.listProductPrice.text = currentData.productPrice.toString()
        holder.listProductImage.setImageResource(currentData.productImage)
    }

    override fun getItemCount() = dataSet.size

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_list
    }
}
