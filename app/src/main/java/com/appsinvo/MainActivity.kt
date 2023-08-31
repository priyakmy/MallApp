package com.appsinvo

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.appsinvo.adapter.CategoryAdapter
import com.appsinvo.databinding.ActivityMainBinding
import com.appsinvo.ui.home.HomeFragment
import com.appsinvo.utils.DataHolder
import com.appsinvo.utils.NewsActivity
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationSettingsRequest
import com.google.android.gms.location.LocationSettingsResponse
import com.google.android.gms.location.SettingsClient


class MainActivity : AppCompatActivity()
{

    private var mfusedLocationClient: FusedLocationProviderClient? = null
    private var mLocationCallback: LocationCallback? = null
    private var mSettingsClient: SettingsClient? = null
    private var mLocationRequest: LocationRequest? = null
    private var mLocationSettingsRequest: LocationSettingsRequest? = null
    private var lastLocation: Location? = null
    private var mLocationSettingsResponse: LocationSettingsResponse? = null
    private var fadd = "fetched_address"
    private val homeFragment = openHome()
    private val booking= openHome()
    private val scanQr= openHome()


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setData()
        checklocationPermission()
        startLocationUpdates()
        openHome()

        binding.bottomBar.bottomNavigationView.background = null
        binding.bottomBar.bottomNavigationView.setOnItemReselectedListener {
            when (it.itemId) {
                R.id.miPlaceholder -> openHome()
                 R.id.miScanQr->openHome()
                 R.id.miBooking->openHome()

            }
        }
       true


    }


    private fun setData() {
        binding.rvCategory.adapter = CategoryAdapter { name, icon ->
            openNews(name, icon)
        }.apply {
            submitList(DataHolder.categories)
        }
    }

    private fun openNews(name: String, @DrawableRes icon: Int = 0) {
        val intent = Intent(this, NewsActivity::class.java)
        intent.putExtra("Name", name)
        intent.putExtra("image", icon)
        startActivity(intent)
    }


    // Location Permission code
    private fun checklocationPermission() {
        val d = Log.d(TAG, "inside check location")
        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) !== PackageManager.PERMISSION_GRANTED
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                )
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                    1
                )
            } else {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                    1
                )
            }
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray,
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1 ->
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(
                            this,
                            android.Manifest.permission.ACCESS_FINE_LOCATION
                        ) !== PackageManager.PERMISSION_GRANTED
                    ) {
                        Toast.makeText(this, "shit", Toast.LENGTH_SHORT).show()
                    }

                }
        }
    }

    @SuppressLint("MissingPermission")
   private fun startLocationUpdates()
    {
        val locationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(10000)
                .setFastestInterval(5000)

        val locationCallback = object : LocationCallback()
        {
            override fun onLocationResult(locationResult: LocationResult?)
            {
                if (locationResult != null)
                {
                    val location = locationResult.lastLocation
                    // Handle the new location data
                }
            }
        }

        mfusedLocationClient?.requestLocationUpdates(locationRequest , locationCallback , null)


    }


    // Stop location updates
        private fun stopLocationUpdates() {
            mfusedLocationClient?.removeLocationUpdates(mLocationCallback)
                ?.addOnCompleteListener { Log.d(TAG , "stop location updates");};

        }


    public fun openHome()
    {
        val f = HomeFragment()
        supportFragmentManager.beginTransaction().replace(binding.container.id,f).commit()
    }

        }





