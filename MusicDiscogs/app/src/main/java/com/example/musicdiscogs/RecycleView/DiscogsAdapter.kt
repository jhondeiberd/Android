package com.example.musicdiscogs.RecycleView

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.musicdiscogs.MainAlbumDetails
import com.example.musicdiscogs.R
import com.example.musicdiscogs.entities.Album
import com.squareup.picasso.Picasso


class DiscogsAdapter() : RecyclerView.Adapter<DiscogsAdapter.DiscogsItemViewHolder>() {
    private val dataSet = mutableListOf<Album>()


    class DiscogsItemViewHolder(private val parent: DiscogsAdapter, private val containerView: View) :
        RecyclerView.ViewHolder(containerView) {

        companion object {
            const val EXTRA_VALUE = "name"
        }

        var discogs: Album? = null
        val backgroundImage: ImageView = containerView.findViewById(R.id.listItem_image)
        val title: TextView = containerView.findViewById(R.id.listItem_title)
        val type: TextView = containerView.findViewById(R.id.listItem_genre)
        val detail: CardView = containerView.findViewById(R.id.item_list)
        val listContext: Context = title.context

        init {
            detail.setOnClickListener {
                val intent = Intent(listContext, MainAlbumDetails::class.java)
                intent.putExtra(EXTRA_VALUE, discogs)
                listContext.startActivity(intent)
            }

        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, customViewType: Int): DiscogsItemViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(customViewType, parent, false)
        return DiscogsItemViewHolder(this, view)
    }


    override fun onBindViewHolder(holder: DiscogsItemViewHolder, positionInDataSet: Int) {
        val currentData = dataSet[positionInDataSet]
        holder.title.setText(currentData.title)
        holder.type.setText(currentData.type)
        holder.discogs = dataSet[positionInDataSet]



        if (currentData.image == "") {
            holder.backgroundImage.setImageResource(R.drawable.ic_launcher_foreground)
        } else {
            Picasso.get()
                .load(currentData.image)
                .into(holder.backgroundImage)
        }

    }

    fun addData(data: List<Album>) {
        this.dataSet.clear()
        this.dataSet.addAll(data)
        notifyDataSetChanged()
    }

    fun changeData(data: MutableList<Album>) {
        this.dataSet.clear()
        this.dataSet.addAll(data)
        notifyDataSetChanged()
    }

    fun removeData() {
        this.dataSet.clear()
        notifyDataSetChanged()
    }


    override fun getItemCount() = dataSet.count()

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_list
    }

}