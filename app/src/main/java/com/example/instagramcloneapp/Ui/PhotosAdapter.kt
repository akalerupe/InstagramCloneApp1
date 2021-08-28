package com.example.instagramcloneapp.Ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramcloneapp.Models.Photos
import com.example.instagramcloneapp.R
import com.squareup.picasso.Picasso

class PhotosAdapter(var photosList:List<Photos>):RecyclerView.Adapter<PhotosViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.photos_list_item,parent,false)
        return PhotosViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        var currentPhotos=photosList.get(position)
        holder.tvcaption.text=currentPhotos.caption
        holder.tvid.text=currentPhotos.id
        holder.cvphotos.setOnClickListener {

        }
        Picasso.get().load(currentPhotos.imageUrl).resize(80,80).centerCrop().into(holder.ivphotos)

    }

    override fun getItemCount(): Int {
        return photosList.size
    }
}
class PhotosViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var ivphotos=itemView.findViewById<ImageView>(R.id.ivphotos)
    var tvid=itemView.findViewById<TextView>(R.id.tvid)
    var tvcaption=itemView.findViewById<TextView>(R.id.tvcaption)
    var cvphotos=itemView.findViewById<CardView>(R.id.cvphotos)
}