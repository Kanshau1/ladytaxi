package com.kanshau.ladytaxi.fragments.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kanshau.ladytaxi.R
import com.kanshau.ladytaxi.fragments.about.AboutFragment
import com.kanshau.ladytaxi.fragments.actionList.ActionListFragment
import com.kanshau.ladytaxi.fragments.orderCreate.OrderCreateFragment
import com.kanshau.ladytaxi.fragments.orderList.OrderListFragment
import com.kanshau.ladytaxi.fragments.profileSettings.ProfileSettingsFragment
import kotlinx.android.synthetic.main.fragment_settings.*
import kotlinx.android.synthetic.main.view_bottombar.*
import android.content.Intent
import android.net.Uri


class SettingsFragment: Fragment() {

    private val phone = "+79889187359"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        call.setOnClickListener {
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone")))
        }

        profile_settings.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction()
                .add(R.id.content, ProfileSettingsFragment())
                .addToBackStack("profile_settings")
                .commit()
        }

        about.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction()
                .add(R.id.content, AboutFragment())
                .addToBackStack("profile_settings")
                .commit()
        }

        exit.setOnClickListener {
            activity!!.finish()
        }

        initBottomBar()
    }


    private fun initBottomBar() {
        add_order.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction()
                .replace(R.id.content, OrderCreateFragment())
                .commit()
        }

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