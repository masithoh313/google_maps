package com.example.maps

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import android.graphics.drawable.DrawableContainer as DrawableContainer1

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val latitude = -7.747033
        val longitude= 110.355398
        val zoomLevel=17f
        val overlaysize = 115f

       val uty= LatLng(latitude,longitude)
        mMap.addMarker(MarkerOptions().position(uty)
            .title("Universitas Teknologi Yogyakarta")
            .snippet("terletak di Jl Ring Road Utara")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(uty, zoomLevel))
        val googleOverLay=GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.study))
            .position(uty,overlaysize)
        mMap.addGroundOverlay(googleOverLay)

        val latitude1=-7.732197
        val longitude1=110.373100

        val rumah= LatLng(latitude1,longitude1)
        mMap.addMarker(MarkerOptions().position(rumah)
            .title("Home")
            .snippet("It is my home")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rumah,zoomLevel))
        googleOverLay.image(BitmapDescriptorFactory.fromResource(R.drawable.home))
            .position(rumah,overlaysize)
        mMap.addGroundOverlay(googleOverLay)


    }

}


