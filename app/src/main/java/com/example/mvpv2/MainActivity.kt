package com.example.mvpv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.mvpv2.contract.ContractInterface
import com.example.mvp.presenter.MainActivityPresenter
import com.example.mvpv2.views.home
import com.example.mvpv2.views.hotels
import com.example.mvpv2.views.tours
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.drawer_layout.*
import kotlinx.android.synthetic.main.toolbar.view.*


class MainActivity : AppCompatActivity(), ContractInterface.View {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarToggle: ActionBarDrawerToggle
    private lateinit var navView: NavigationView
    private val homeFragment= home()
    private val hotelsFragment = hotels()
    private val toursFragment = tours()
    private var presenter: MainActivityPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        replaceFragment(homeFragment)
        drawerLayout = findViewById(R.id.drawerLayout)
        actionBarToggle = ActionBarDrawerToggle(this, drawerLayout, 0, 0)
        drawerLayout.addDrawerListener(actionBarToggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        actionBarToggle.syncState()
        navView = findViewById(R.id.navView)
        bottom_navigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> {replaceFragment(homeFragment)}
                R.id.hotel->{replaceFragment(hotelsFragment)}
                R.id.tours->{replaceFragment(toursFragment)}
            }
            true
        }

        presenter = MainActivityPresenter(this)
    }
    override fun initView() {
    }
    override fun updateViewData() {
    }
    private fun replaceFragment(fragment: Fragment){
        if(fragment!=null){
            val transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame, fragment)
            transaction.commit()
        }
    }
}