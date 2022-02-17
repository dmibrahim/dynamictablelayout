package com.dmi.dynamictablelayouts

import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        add_button.setOnClickListener {addTableRow()}

    }

    private fun addTableRow() {
        if(versionTxt.text.isEmpty() || codeTtx.text.isEmpty()){
            if(versionTxt.text.isEmpty()){
                versionTxt.requestFocus()
            }
            else{
                codeTtx.requestFocus()
            }
            Toast.makeText(applicationContext,"Please enter all required android information", Toast.LENGTH_LONG).show()
            return
           }

        val code = codeTtx.text.toString()
        val version = versionTxt.text.toString()
        codeTtx.text.clear()
        versionTxt.text.clear()

        val tableRow = TableRow(this)
        var layoutParams = TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
         layoutParams.setMargins(0,10,0,0)
        layoutParams.gravity = Gravity.CENTER
        tableRow.layoutParams = layoutParams
        tableRow.setBackgroundColor(getColor(R.color.grey_200))

        val versionTxtView = TextView(this)
        versionTxtView.setText("$version")
        versionTxtView.gravity = Gravity.CENTER
        versionTxtView.setTextSize(TypedValue.COMPLEX_UNIT_SP,18f)

        val versionCodeTxt = TextView(this)
        versionCodeTxt.setText("$code")
        versionCodeTxt.gravity = Gravity.CENTER
        versionCodeTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,18f)

        tableRow.addView(versionTxtView)
        tableRow.addView(versionCodeTxt)

        tblLayout.addView(tableRow, layoutParams )

    }


}