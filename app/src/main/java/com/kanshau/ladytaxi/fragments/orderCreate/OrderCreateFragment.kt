package com.kanshau.ladytaxi.fragments.orderCreate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.kanshau.ladytaxi.R
import com.kanshau.ladytaxi.fragments.actionList.ActionListFragment
import com.kanshau.ladytaxi.fragments.addressSelect.AddressSelectFragment
import com.kanshau.ladytaxi.fragments.orderList.OrderListFragment
import com.kanshau.ladytaxi.fragments.settings.SettingsFragment
import kotlinx.android.synthetic.main.fragment_order_create.*
import kotlinx.android.synthetic.main.view_bottombar.*

class OrderCreateFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_order_create, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        from_address.setOnClickListener {
            showAddressSelect(from_address_text)
        }

        to_address.setOnClickListener {
            showAddressSelect(to_address_text)
        }

        initBottomBar()
    }

    private fun showAddressSelect(textView: TextView) {
        val fragment = AddressSelectFragment()
        fragment.selectListener = {address ->
            textView.text = address
        }
        val data = Bundle()
        data.putString("address", textView.text.toString())
        fragment.arguments = data
        activity!!.supportFragmentManager.beginTransaction()
            .add(R.id.content, fragment)
            .addToBackStack("address_select")
            .commit()
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