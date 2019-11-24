package com.casa.azul.rocketboy.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

import com.casa.azul.rocketboy.R
import com.casa.azul.rocketboy.util.detailMission
import com.casa.azul.rocketboy.util.getProgressDrawable
import com.casa.azul.rocketboy.util.loadImage
import com.casa.azul.rocketboy.viewmodel.RocketViewModel
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.mission_item.view.*


class DetailFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        detailImageView.loadImage(detailMission?.links!!.flickr_images[0],
//            getProgressDrawable(detailImageView.context))

        detail_web_view.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return super.shouldOverrideUrlLoading(view, request)
            }
        }
        detail_web_view.loadUrl(detailMission?.links!!.wikipedia)
        tv_detail.text = detailMission?.details
    }


}
