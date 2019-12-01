package com.casa.azul.rocketboy.util

import android.content.Context
import android.content.DialogInterface
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.casa.azul.rocketboy.R
import com.casa.azul.rocketboy.model.Mission

var detailMission: Mission? = null

fun getProgressDrawable(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 3f
        centerRadius = 20f
        start()
    }
}

fun ImageView.loadImage(uri: String?, progressDrawable: CircularProgressDrawable){
    val options = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.mipmap.ic_launcher_round)
    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(uri)
        .into(this)
}

fun showAlert(context: Context){
    val dialogBuilder = AlertDialog.Builder(context)

    // set message of alert dialog
    dialogBuilder.setMessage("This app was developed by Manuel Carvalho")
        // if the dialog is cancelable
        .setCancelable(true)
        // positive button text and action
//            .setPositiveButton("Proceed", DialogInterface.OnClickListener {
//                    dialog, id -> finish()
//            })
        // negative button text and action
        .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                dialog, id -> dialog.cancel()
        })

    // create dialog box
    val alert = dialogBuilder.create()
    // set title for alert dialog box
    alert.setTitle("Rocket Buddy")
    // show alert dialog
    alert.show()
}
