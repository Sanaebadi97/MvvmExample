package test.test.niceplace.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.widget.TextViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.list_item.view.*
import test.test.niceplace.R
import test.test.niceplace.models.NicePlace

class NicePlaceAdapter(val nicePlaceList: List<NicePlace>) :
    RecyclerView.Adapter<NicePlaceAdapter.NicePlaceViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NicePlaceViewHolder {


        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return NicePlaceViewHolder(view)
    }

    override fun getItemCount() = nicePlaceList.size

    override fun onBindViewHolder(holder: NicePlaceViewHolder, position: Int) {
        holder.txtNicePLace.text = nicePlaceList[position].title
        Glide.with(holder.itemView.context)
            .apply { RequestOptions.circleCropTransform().error(R.drawable.ic_launcher_background) }
            .load(nicePlaceList[position].imageUrl)
            .into(holder.imgNicePlace)

    }

    inner class NicePlaceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNicePLace: AppCompatTextView = itemView.txt_nice_place
        val imgNicePlace: AppCompatImageView = itemView.img_nice_place

    }
}