package com.raokui.testbase


import android.support.design.widget.FloatingActionButton
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem

import com.raokui.testbase.base.BaseActivity
import com.raokui.testbase.contract.MainContract
import com.raokui.testbase.presenter.MainPresenter

import butterknife.BindView


class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener, MainContract.View {


    @BindView(R.id.toolbar)
    internal var toolbar: Toolbar? = null
    @BindView(R.id.fab)
    internal var fab: FloatingActionButton? = null
    @BindView(R.id.nav_view)
    internal var navView: NavigationView? = null
    @BindView(R.id.drawer_layout)
    internal var drawerLayout: DrawerLayout? = null



    override val layoutId: Int
        get() = R.layout.activity_main

    override fun init() {

        setSupportActionBar(toolbar)

        fab!!.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout!!.setDrawerListener(toggle)
        toggle.syncState()

        navView!!.setNavigationItemSelectedListener(this)

    }

    override fun initData() {

    }

    override fun initListener() {

    }


    override fun onBackPressed() {
        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

}