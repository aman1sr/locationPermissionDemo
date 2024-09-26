package com.example.locationpermissiondemo

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.locationpermissiondemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var sharedPrefManger: SharedPrefManger
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        sharedPrefManger = SharedPrefManger(this)
        sharedPrefManger.getPermissionStatus()?.let {
            setTextStatus(it)
        }

        binding.btnAsk.setOnClickListener {
            if (!LocationPermissionHelper.hasAccessFinePermission(this)) {
                LocationPermissionHelper.requestFineLocationPermission(this)
            } else {
                // PERMISSION is Already granted ((navigate to Next Screen...))
                Toast.makeText(this,
                    getString(R.string.location_permission_granted), Toast.LENGTH_SHORT).show()
                 setTextStatus(getString(R.string.location_permission_granted))
            }
        }

    }

   fun setTextStatus(str:String){
       sharedPrefManger.updatePermissionStatus(str)
       binding.txtShowStatus.text = str
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            LocationPermissionHelper.BASIC_PERMISSION_REQUESTCODE -> {
                if (!LocationPermissionHelper.hasAccessFinePermission(this)) {
                    Toast.makeText(
                        this,
                        "Location permission is needed to run this application",
                        Toast.LENGTH_LONG
                    ).show();

                    if (!LocationPermissionHelper.shouldShowRequestPermissionRationale(this)) {  // checking if don't show Again box checked and denied
                        // Location permission denied with Do not ask again
                        LocationPermissionHelper.launchPermissionSettings(this)   // redirect user to Setting screen
                        setTextStatus("Denied 2x, Now No longer Location Dialog will prompt")
//                        finish()
                    }else{
                        showAlertDialog()   // shown 1st time user select Deny
                        setTextStatus("Denied once, Showed Alert")
                    }
                }else {
                    Toast.makeText(this, "Woola!!! Location permission is granted", Toast.LENGTH_SHORT).show()
                    setTextStatus(getString(R.string.location_permission_granted))
                }
            }
        }
    }

    private fun showAlertDialog() {
        // Create the AlertDialog builder
        val builder = AlertDialog.Builder(this)

        // Set the title and message
        builder.setTitle("Permissions Required")
            .setMessage("Location permissions need to be granted ")

            // Set the positive button
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss() // Dismiss the dialog when user presses OK
            }

            // Optional: Set a negative button (if needed)
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss() // Dismiss the dialog if user chooses to cancel
            }

        // Create and show the AlertDialog
        builder.create().show()
    }
}