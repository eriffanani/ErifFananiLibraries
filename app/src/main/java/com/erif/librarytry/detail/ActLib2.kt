package com.erif.librarytry.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.erif.librarytry.R

class ActLib2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_lib2)
        setupToolbar()
    }

    private fun setupToolbar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        getToolbarTitle()?.let {
            supportActionBar?.title = it
        }
    }

    private fun getToolbarTitle(): String? {
        val bundle = intent.extras
        var mTitle: String? = null
        bundle?.let {
            if (it.containsKey("title"))
                mTitle = it.getString("title", null)
        }
        return mTitle
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}