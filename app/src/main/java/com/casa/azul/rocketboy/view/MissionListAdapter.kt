package com.casa.azul.dogs.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.casa.azul.rocketboy.R
import com.casa.azul.rocketboy.model.Mission
import com.casa.azul.rocketboy.util.getProgressDrawable
import com.casa.azul.rocketboy.util.loadImage
import com.casa.azul.rocketboy.view.MainFragmentDirections

import kotlinx.android.synthetic.main.mission_item.view.*


private const val TAG = "MissionListAdapter"

class MissionListAdapter(val missionList: ArrayList<Mission>) :
    RecyclerView.Adapter<MissionListAdapter.PhotoViewHolder>() {

    fun updateMissionlist(newPhotosList: List<Mission>) {
        Log.d(TAG, "updatePhotoList count = ${newPhotosList.size}")
        missionList.clear()
        missionList.addAll(newPhotosList)
        notifyDataSetChanged()
//        for (photo in photoList) {
//            val a = (photo.img_src).toString().substring(4)
//            val b = "https$a"
//            Log.d(TAG, "url= ${b}")
//        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(
            R.layout.mission_item
            , parent, false
        )
        return PhotoViewHolder(view)
    }

    override fun getItemCount() = missionList.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {

        //holder.view.photo_id.text = missionList[position].id.toString()
        holder.view.setOnClickListener {
            //val uuid = it.photo_id.text.toString().toInt()
            val action = MainFragmentDirections.actionGoDetail()

            Navigation.findNavController(it)
                .navigate(action)
        }
        holder.view.imageView.loadImage(
            missionList[position].links.mission_patch,
            getProgressDrawable(holder.view.imageView.context)
        )

        holder.view.missionName.text = missionList[position].mission_name

    }

    class PhotoViewHolder(var view: View) : RecyclerView.ViewHolder(view)
}