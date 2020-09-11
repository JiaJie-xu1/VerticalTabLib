package com.partner.verticaltabdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.partner.verticaltabdemo.R
import kotlinx.android.synthetic.main.fragment_test.*

class TestFragment : Fragment(){

    var type = "页面"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_test,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = arguments
        if (bundle != null) {
            if (bundle.containsKey("_type")) {
                type = bundle.getString("_type").toString()
            }
        }
        tvTag.text = type
    }
}