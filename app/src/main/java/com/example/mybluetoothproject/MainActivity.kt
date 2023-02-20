package com.example.mybluetoothproject

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.mybluetoothproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()


        binding.btnOff.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.BLUETOOTH_CONNECT
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation

            }
            bluetoothAdapter.disable()
            Toast.makeText(this, "Bluetooth Turned OFF", Toast.LENGTH_SHORT).show()
        }


        binding.btnOn.setOnClickListener {
            if (bluetoothAdapter==null){
                Toast.makeText(this, "Bluetooth Not Supported", Toast.LENGTH_SHORT).show()
            }else if (!bluetoothAdapter.isEnabled){
                startActivityForResult(Intent (BluetoothAdapter.ACTION_REQUEST_ENABLE),1);

                Toast.makeText(this, "Bluetooth Turned ON", Toast.LENGTH_SHORT).show()
            }
        }

    }
}