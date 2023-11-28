package com.xayappz.matchmania.utils

import android.app.ProgressDialog
import android.content.Context

object UIHelper {
    private var progressDialog: ProgressDialog? = null
    fun progressUI(context: Context) {
        progressDialog = ProgressDialog(context)
        progressDialog!!.setTitle("Please Wait")
        progressDialog!!.setMessage("Loading ...")
        progressDialog!!.setCancelable(false)

    }

    fun showProgress() {
        progressDialog?.show()
    }

    fun hideProgress() {
        progressDialog?.hide()
    }
}