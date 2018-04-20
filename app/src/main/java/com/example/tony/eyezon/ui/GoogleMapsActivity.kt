package com.example.tony.eyezon.ui

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import com.arellomobile.mvp.MvpAppCompatActivity
import com.example.tony.eyezon.R
import com.example.tony.eyezon.mvp.model.Pins
import com.example.tony.eyezon.mvp.model.Request
import com.example.tony.eyezon.mvp.presenter.GoogleMapPresenter
import com.example.tony.eyezon.mvp.view.GoogleMapsView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.PolygonOptions
import com.google.android.gms.maps.model.LatLngBounds









class GoogleMapsActivity : MvpAppCompatActivity(),OnMapReadyCallback,GoogleMapsView {



    var pins:ArrayList<Request>? = null;
    var mapFragment: SupportMapFragment?=null

    override fun onMapReady(googleMap: GoogleMap?) {
        if (googleMap != null && pins !=null) {

            //Добавляем маркер
            for (k in pins!!.indices) {
                var polygonPointsArrayList: ArrayList<LatLng> = ArrayList();


                //Вычиляем центральную координату от полигона
                for(i in pins!![k]?.position?.coordinates?.indices!!) {
                    var latLng = LatLng(pins!![k].position!!.coordinates!![0][i][0].toDouble(), pins!![k].position!!.coordinates!![0][i][1].toDouble())
                    polygonPointsArrayList.add(latLng)
                }

                googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID)
                        googleMap.addMarker(MarkerOptions().position(getPolygonCenterPoint(polygonPointsArrayList))
                        .title(pins!![k].user?.firstName + " " + pins!![k].user?.lastName)
                        .snippet(pins!![k].message))
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_maps)
        // Get the SupportMapFragment and request notification
        // when the map is ready to be used.
        mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment

        var googleMapPresenter = GoogleMapPresenter(this);
        googleMapPresenter.getPins()
    }


   public fun setPinsInActivity(pinsFromServer: Pins){
       pins = ArrayList<Request>()
       for (item:Request in pinsFromServer.requests!!) pins?.add(item)
       mapFragment?.getMapAsync(this)
       Log.d("Kek", pins?.size.toString())
    }


    private fun getPolygonCenterPoint(polygonPointsList: ArrayList<LatLng>): LatLng {
        var centerLatLng: LatLng? = null
        val builder = LatLngBounds.Builder()
        for (i in 0 until polygonPointsList.size) {
            builder.include(polygonPointsList[i])
        }
        val bounds = builder.build()
        centerLatLng = bounds.center
        return centerLatLng
    }
}

