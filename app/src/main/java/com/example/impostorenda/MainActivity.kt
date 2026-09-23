package com.example.impostorenda

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.impostorenda.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //enableEdgeToEdge()
        var binding : ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        binding.btnCalculoImp.setOnClickListener {


            val salarioStr = binding.salarioTextInput.text.toString()
            val gastosStr = binding.gastosTextInput.text.toString()
            val dependStr = binding.dependTextInput.text.toString()

            val salario = salarioStr.toFloat()
            val gastos = gastosStr.toFloat()
            val dependentes = dependStr.toInt()

            val impostoCalculado = calculaImposto(salario, gastos, dependentes)


            binding.valorCalculadoImposto.text = String.format("%.2f", impostoCalculado)


            Toast.makeText(this, getString(R.string.msgToastCalculo), Toast.LENGTH_SHORT).show()

        }
    }

    fun calculaImposto(salario: Float, gastos: Float, dependentes: Int): Float{
        if(salario <= 5000f) return 0f


        return 0.275f * salario
    }

}