package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.calculator.databinding.ActivityHistoricalBinding
import com.example.calculator.databinding.ActivityMainBinding

class HistoricalActivity : AppCompatActivity() {

    private lateinit var binding:ActivityHistoricalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoricalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val dato = bundle?.getString("direccion")
        val dato2 = bundle?.getString("direccion2")
        val dato3 = bundle?.getString("direccion3")
        val dato4 = bundle?.getString("direccion4")
        val dato5 = bundle?.getString("direccion5")
        Toast.makeText(this,dato,Toast.LENGTH_LONG).show()

        binding.resultadoH.text = dato
        binding.resultadoH2.text = dato2
        binding.resultadoH3.text = dato3
        binding.resultadoH4.text = dato4
        binding.resultadoH5.text = dato5
    }

}