package com.example.tony.eyezon.ui

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.tony.eyezon.R
import com.google.android.gms.maps.MapFragment

class GoogleMapsFragment : MapFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {






        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_google_maps, container, false)
    }


}
