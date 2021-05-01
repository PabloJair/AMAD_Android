package com.s10plus.core_application.ui.social_network

import android.content.Context
import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.s10plus.core_application.R
import com.s10plus.core_application.models.SocialNetWorkModel

class GridAdapterSocialNetwork(private val mContext: Context, val logoList: List<SocialNetWorkModel>) :
        RecyclerView.Adapter<GridAdapterSocialNetwork.ViewHolder>() {
    var onClick:
            ((SocialNetWorkModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.grid_item, null))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getLogo(position)
        holder.txtItem.text = item.nombre
        holder.imageView.setImageResource(item.imgId)
        holder.open(item)

    }

    private fun getLogo(position: Int): SocialNetWorkModel {
        return logoList[position]
    }

    override fun getItemCount(): Int {
        return logoList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var txtItem: TextView
        var imageView: ImageView
        var menuModel: SocialNetWorkModel? = null
        fun open(menuModel: SocialNetWorkModel?) {
            this.menuModel = menuModel
        }

        override fun onClick(view: View) {
           onClick?.invoke(menuModel!!)
        }

        init {
            // get logo view
            itemView.setOnClickListener(this)
            imageView = itemView.findViewById<View>(R.id.item_img) as ImageView
            txtItem = itemView.findViewById(R.id.item_txt)
        }
    }
}