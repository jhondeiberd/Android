package com.reza.day06.recyclerview

import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.reza.day06.R
import com.reza.day06.entities.Nature

class NatureAdapter : RecyclerView.Adapter<NatureAdapter.NatureItemViewHolder>() {
    private val dataSet = mutableListOf<Nature>()

    class NatureItemViewHolder(private val parentAdapter: NatureAdapter, private val containerView: View) : RecyclerView.ViewHolder(containerView) {
        var nature: Nature? = null
        val backgroundImage: ImageView = containerView.findViewById(R.id.listItem_image)
        val title: TextView = containerView.findViewById(R.id.listItem_title)
        val delete: Button = containerView.findViewById(R.id.listItem_delete)

        init {
            //Click Listeners and whatever else to manage View
            delete.setOnClickListener {
                if (nature != null)
                    parentAdapter.removeData(nature as Nature)
            }
        }
    }

    public fun changeData(dataSet: List<Nature>) {
        this.dataSet.clear()
        this.dataSet.addAll(dataSet)
        notifyDataSetChanged()
    }

    public fun addData(nature: Nature){
        dataSet.add(nature)
        notifyDataSetChanged()
    }

    public fun removeData(nature: Nature){
        dataSet.remove(nature)
        notifyDataSetChanged()
    }

    //inflate the customView
    override fun onCreateViewHolder(parent: ViewGroup, customViewType: Int): NatureItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(customViewType,parent, false) //false because the recycler will add to the view hierarchy when it is time
        return NatureItemViewHolder(this, view)
    }

    //Called by the layoutManager to replace the content(data) of the CustomView
    override fun onBindViewHolder(holder: NatureItemViewHolder, positionInDataSet: Int) {
        val currentData = dataSet[positionInDataSet]
        holder.nature = currentData
        holder.title.text = currentData.title
        holder.backgroundImage.setImageResource(currentData.image)
    }

    override fun getItemCount() = dataSet.size

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0)
            R.layout.item_list
        else
            R.layout.item_list_2
    }
}











