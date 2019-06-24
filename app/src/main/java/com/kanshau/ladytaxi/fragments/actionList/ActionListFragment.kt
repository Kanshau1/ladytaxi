package com.kanshau.ladytaxi.fragments.actionList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kanshau.ladytaxi.R
import com.kanshau.ladytaxi.fragments.orderCreate.OrderCreateFragment
import com.kanshau.ladytaxi.fragments.orderList.OrderListFragment
import com.kanshau.ladytaxi.fragments.settings.SettingsFragment
import kotlinx.android.synthetic.main.view_bottombar.*

class ActionListFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_action_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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

        settings.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction()
                .replace(R.id.content, SettingsFragment())
                .commit()
        }
    }
}