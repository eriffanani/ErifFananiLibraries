package com.erif.librarytry.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import com.erif.librarytry.R
import com.erif.snackbar.SnackBarQuick
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ActSnackBarQuick : AppCompatActivity() {

    private lateinit var snackBar: SnackBarQuick
    private lateinit var fabAdd: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_snack_bar_quick)
        setupToolbar()

        val parent: LinearLayout = findViewById(R.id.act_snack_bar_quick_parent)
        fabAdd = findViewById(R.id.act_snack_bar_quick_fabAdd)

        val buttonPositive: Button = findViewById(R.id.act_snack_bar_quick_buttonPositive)
        buttonPositive.setOnClickListener {
            snackBarPositive(parent)
            snackBar.show()
        }

        val buttonNegative: Button = findViewById(R.id.act_snack_bar_quick_buttonNegative)
        buttonNegative.setOnClickListener {
            snackBarNegative(parent)
            snackBar.show()
        }

        val buttonWarning: Button = findViewById(R.id.act_snack_bar_quick_buttonWarning)
        buttonWarning.setOnClickListener {
            snackBarWarning(parent)
            snackBar.show()
        }

        val buttonAction: Button = findViewById(R.id.act_snack_bar_quick_buttonAction)
        buttonAction.setOnClickListener {
            snackBarAction(parent)
            snackBar.show()
        }

        val buttonIcon: Button = findViewById(R.id.act_snack_bar_quick_buttonCustomIcon)
        buttonIcon.setOnClickListener {
            snackBarCustomIcon(parent)
            snackBar.show()
        }

        val buttonAnchor: Button = findViewById(R.id.act_snack_bar_quick_buttonAnchor)
        buttonAnchor.setOnClickListener {
            snackBarAnchor(parent)
            snackBar.show()
        }

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

    private fun snackBarPositive(parent: View) {
        snackBar = SnackBarQuick(
            parent,
            "Lorem ipsum dolor sit amet bla bla bla",
            SnackBarQuick.Style.POSITIVE
        )
    }

    private fun snackBarNegative(parent: View) {
        snackBar = SnackBarQuick(
            parent,
            "Lorem ipsum dolor sit amet bla bla bla",
            SnackBarQuick.Style.NEGATIVE
        )
    }

    private fun snackBarWarning(parent: View) {
        snackBar = SnackBarQuick(
            parent,
            "Lorem ipsum dolor sit amet bla bla bla",
            SnackBarQuick.Style.WARNING
        )
    }

    private fun snackBarAction(parent: View) {
        snackBar = SnackBarQuick(
            parent,
            "Lorem ipsum dolor sit amet bla bla bla",
            SnackBarQuick.Style.NEGATIVE
        )
        snackBar.setAction("OK", object : SnackBarQuick.Callback {
            override fun onActionClick() {

            }
        }, true)
    }

    private fun snackBarCustomIcon(parent: View) {
        snackBar = SnackBarQuick(
            parent,
            "Sit amet bla bla bla lorem ipsum dolor",
            SnackBarQuick.LENGTH_SHORT,
            SnackBarQuick.Style.POSITIVE
        )
        snackBar.setIcon(R.drawable.ic_add_white_snack_bar)
    }

    private fun snackBarAnchor(parent: View) {
        snackBar = SnackBarQuick(
            parent,
            "Sit amet bla bla bla lorem ipsum dolor",
            SnackBarQuick.LENGTH_SHORT,
            SnackBarQuick.Style.WARNING
        )
        snackBar.setAnchor(fabAdd)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}