package com.casa.azul.rocketboy.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

import com.casa.azul.rocketboy.R
import kotlinx.android.synthetic.main.fragment_main.*

private const val TAG = "MainFragment"

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        buttonDetail.setOnClickListener {
            val action = MainFragmentDirections.actionGoDetail()
            Navigation.findNavController(it).navigate(action)
        }

    }


}
