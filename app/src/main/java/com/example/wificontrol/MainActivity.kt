@file:Suppress("DEPRECATION")

package com.example.wificontrol

import android.annotation.SuppressLint
import android.content.Context
import android.net.wifi.WifiConfiguration
import android.net.wifi.WifiManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val wifiControl: Button = findViewById(R.id.button)
        val networkSSID = "mFinity"
        val networkPass = "mf1n1tywifi"

        val conf = WifiConfiguration()
        conf.SSID = "\"" + networkSSID + "\""
        conf.preSharedKey = "\""+ networkPass +"\"";
        //conf.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);

        wifiControl.setOnClickListener {
            val wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
            val iD = wifiManager.addNetwork(conf)
            wifiManager.isWifiEnabled = true
            Log.d("Wifi","buttonclick")

                    wifiManager.disconnect()
                    wifiManager.enableNetwork(iD, true)
                    wifiManager.reconnect()
        }
    }
}