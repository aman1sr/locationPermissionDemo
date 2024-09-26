package com.example.locationpermissiondemo

import android.app.Activity
import android.content.Context

class SharedPrefManger(private val activity: Activity) {
    private val sharedPref = activity.getPreferences(Context.MODE_PRIVATE)

    fun updatePermissionStatus(message: String) {
        sharedPref.edit().apply {
            putString(activity.getString(R.string.shared_pref_location_status), message)
            apply()
        }
    }

    fun getPermissionStatus(): String? {
        return sharedPref.getString(activity.getString(R.string.shared_pref_location_status), null)
    }
}