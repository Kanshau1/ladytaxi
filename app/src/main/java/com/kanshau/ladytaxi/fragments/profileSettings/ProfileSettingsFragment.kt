package com.kanshau.ladytaxi.fragments.profileSettings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kanshau.ladytaxi.R
import com.kanshau.ladytaxi.fragments.actionList.ActionListFragment
import com.kanshau.ladytaxi.fragments.orderCreate.OrderCreateFragment
import com.kanshau.ladytaxi.fragments.orderList.OrderListFragment
import com.kanshau.ladytaxi.fragments.settings.SettingsFragment
import kotlinx.android.synthetic.main.fragment_settings_profile.*
import kotlinx.android.synthetic.main.view_bottombar.*

class ProfileSettingsFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_settings_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        back_button.setOnClickListener {
            activity!!.supportFragmentManager.popBackStack()
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