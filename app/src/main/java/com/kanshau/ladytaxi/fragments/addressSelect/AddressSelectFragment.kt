package com.kanshau.ladytaxi.fragments.addressSelect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.kanshau.ladytaxi.R
import com.kanshau.ladytaxi.fragments.actionList.ActionListFragment
import com.kanshau.ladytaxi.fragments.orderList.OrderListFragment
import com.kanshau.ladytaxi.fragments.settings.SettingsFragment
import kotlinx.android.synthetic.main.fragment_address_select.*
import kotlinx.android.synthetic.main.view_bottombar.*


class AddressSelectFragment: Fragment(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    var selectListener: ((String) -> Unit)? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_address_select, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        back_button.setOnClickListener {
            activity!!.supportFragmentManager.popBackStack()
        }

        select_address.setOnClickListener {
            selectListener?.invoke(address.text.toString())
            activity!!.supportFragmentManager.popBackStack()
        }

        address.setText(arguments?.getString("address", ""))

        initBottomBar()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val currentLocation = LatLng(44.225481, 42.048877)
        mMap.addMarker(MarkerOptions().position(currentLocation).title("Выбранный вами адрес"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(currentLocation))
        mMap.animateCamera(
            CameraUpdateFactory.newLatLngZoom(currentLocation, 14.0f)
        )
    }

    private fun initBottomBar() {
        order_list.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction()
                .replace(R.id.content, OrderListFragment())
                .commit()
        }

        order_actions.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction()
                .replace(R.id.content, ActionListFragment())
                .commit()
        }

        settings.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction()
                .replace(R.id.content, SettingsFragment())
                .commit()
        }
    }
}