package com.partner.verticaltabdemo

import android.app.Application
import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager
import android.widget.Toast
import androidx.multidex.MultiDex
import com.partner.tabtools.verticalTab.DisplayUtil

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)

        val windowManager =
            getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = windowManager.defaultDisplay

        if (DisplayUtil.SCREEN_INFO == null) {
            DisplayUtil.SCREEN_INFO = DisplayMetrics()
            windowManager.defaultDisplay.getMetrics(DisplayUtil.SCREEN_INFO)
        }
    }
}
fun showToast(context: Context,info: String?) {
    showToast(context,info, Toast.LENGTH_SHORT)
}

fun showToast(context: Context,info: String?, toastTime: Int) {
    if (toastTime == Toast.LENGTH_LONG){
        Toast.makeText(context, info, Toast.LENGTH_LONG).show()
    }else{
        Toast.makeText(context, info, Toast.LENGTH_SHORT).show()
    }
}