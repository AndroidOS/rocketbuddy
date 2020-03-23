package com.casa.azul.rocketboy.view


import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.casa.azul.rocketboy.R
import com.casa.azul.rocketboy.model.Mission
import com.casa.azul.rocketboy.viewmodel.RocketViewModel
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment : Fragment() {

    private lateinit var viewModel: RocketViewModel
    private var missionNumber = 0
    private lateinit var mission: Mission

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            missionNumber = DetailFragmentArgs.fromBundle(it).uuid
        }

        viewModel = activity?.run {
            ViewModelProvider(this).get(RocketViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        mission = viewModel.getDetailMission(missionNumber)

        detail_web_view.webViewClient = object : WebViewClient(){
        }

        tv_detail.text = mission.details
        tv_detail.movementMethod = ScrollingMovementMethod()
        detail_web_view.loadUrl(mission.links.wikipedia)
    }


}
