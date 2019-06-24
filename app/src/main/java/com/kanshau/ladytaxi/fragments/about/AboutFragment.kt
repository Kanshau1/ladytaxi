package com.kanshau.ladytaxi.fragments.about

import android.content.Intent
import android.net.Uri
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
import kotlinx.android.synthetic.main.fragment_about.*
import kotlinx.android.synthetic.main.fragment_settings_profile.back_button
import kotlinx.android.synthetic.main.view_bottombar.*


class AboutFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        back_button.setOnClickListener {
            activity!!.supportFragmentManager.popBackStack()
        }

        terms.setOnClickListener {
            showLink("terms.com")
        }

        privacy.setOnClickListener {
            showLink("privacy.com")
        }

        service.setOnClickListener {
            showLink("service.com")
        }

        initBottomBar()
    }

    private fun showLink(link: String) {
        var url = link
        if (!link.startsWith("http://") && !link.startsWith("https://"))
            url = "http://$link"
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
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