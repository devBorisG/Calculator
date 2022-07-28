package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var operacion: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*Mejor forma de cargar una vista usando BINDING (modificado en build.gradle(Module: app))*/
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.numero0.setOnClickListener{numeroPresionado("0",binding)}
        binding.numero1.setOnClickListener{numeroPresionado("1",binding)}
        binding.numero2.setOnClickListener{numeroPresionado("2",binding)}
        binding.numero3.setOnClickListener{numeroPresionado("3",binding)}
        binding.numero4.setOnClickListener{numeroPresionado("4",binding)}
        binding.numero5.setOnClickListener{numeroPresionado("5",binding)}
        binding.numero6.setOnClickListener{numeroPresionado("6",binding)}
        binding.numero7.setOnClickListener{numeroPresionado("7",binding)}
        binding.numero8.setOnClickListener{numeroPresionado("8",binding)}
        binding.numero9.setOnClickListener{numeroPresionado("9",binding)}
        binding.punto.setOnClickListener { numeroPresionado(".",binding) }

        binding.signoMas.setOnClickListener { operacionPresionada(sumar, binding) }
        binding.signoMenos.setOnClickListener { operacionPresionada(resta, binding) }
        binding.signoMult.setOnClickListener { operacionPresionada(mult, binding) }
        binding.signoDivision.setOnClickListener { operacionPresionada(divid, binding) }

        binding.limpiar.setOnClickListener { limpiarCalculadora(binding) }

        binding.signoIgual.setOnClickListener { totalOperacion(binding) }
    }

    @SuppressLint("SetTextI18n")
    private  fun numeroPresionado(digito: String, binding: ActivityMainBinding){
        if(binding.textView2.text == "0" && digito != "."){
            binding.textView2.text = "$digito"
        }else{
            binding.textView2.text = "${binding.textView2.text}$digito"
        }


        if(operacion == sinOperacion){
            num1 = binding.textView2.text.toString().toDouble()
        }else{
            num2 = binding.textView2.text.toString().toDouble()
        }

    }

    private fun operacionPresionada(operacion: Int, binding: ActivityMainBinding){
        this.operacion = operacion
        binding.textView2.text = "0"
    }

    private fun limpiarCalculadora(binding: ActivityMainBinding){
        num1 = 0.0
        num2 = 0.0
        binding.textView2.text = "0"
        operacion = sinOperacion
    }

    private fun totalOperacion(binding: ActivityMainBinding){
        val resultado = when(operacion){
            sumar -> num1+num2
            resta -> num1-num2
            mult -> num1*num2
            divid -> num1/num2
            else -> 0
        }
        binding.textView2.text = resultado.toString()
    }

    companion object{
        const val sumar = 1
        const val resta = 2
        const val mult = 3
        const val divid = 4
        const val sinOperacion = 0
    }
}