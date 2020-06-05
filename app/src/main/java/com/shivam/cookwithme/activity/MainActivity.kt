package com.shivam.cookwithme.activity

import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.shivam.cookwithme.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressDialog = ProgressDialog(this)

        searchButton.setOnClickListener {
            progressDialog!!.setMessage("Web Searching...")
            progressDialog!!.show()

            var intent = Intent(this, RecipeList::class.java)
            var ingredients = IngredientId.text.toString().trim()

            intent.putExtra("ingredients", ingredients)

            Handler().postDelayed({
                progressDialog!!.cancel()
                startActivity(intent)
            }, 500)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        moveTaskToBack(true)
    }
}
