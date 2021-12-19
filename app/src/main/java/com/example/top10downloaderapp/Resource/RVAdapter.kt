package com.example.top10downloaderapp.Resource

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.top10downloaderapp.Model.Entry
import com.example.top10downloaderapp.databinding.ItemRowBinding
import com.squareup.picasso.Picasso


class RVAdapter(val list: List<Entry>?): RecyclerView.Adapter<RVAdapter.ViewHolder>() {
    class ViewHolder (val binding: ItemRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemRowBinding.inflate(
             LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list!![position]

        holder.binding.apply {
            tvAppName.text = item.name
            Picasso.get().load(item.images!![2].link).into(ivIcon)
            cvApp.setOnClickListener {
                holder.itemView.context.startActivity(
                    Intent(Intent.ACTION_VIEW).setData(
                        Uri.parse(
                            item.links!![0].href
                         )
                     )
                )
            }
        }
    }



    override fun getItemCount() = list!!.size

}