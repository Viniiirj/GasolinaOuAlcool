package com.viniramos.gasolinaoualcool

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DetalhesActivity : AppCompatActivity() {
    private lateinit var textResultado: TextView
    private lateinit var textResultGasolina: TextView
    private lateinit var textResultAlcool: TextView
    private lateinit var btnVoltar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        inicializarComponentesInterface()
        btnVoltar.setOnClickListener{
            finish()
        }

//        val bundle = intent.extras
//        if (bundle != null){
//            val calculadora = if (Build.VERSION.SDK_INT >= 33) {
//                bundle.getParcelable("calcularMelhorPreco", calcularMelhorPreco::class.java)
//            } else {
//                bundle.getParcelable("calcularMelhorPreco")
//
//            }
//        }
    }

    private fun inicializarComponentesInterface() {
        textResultado = findViewById( R.id.text_resultado )
        textResultGasolina = findViewById( R.id.text_result_gasolina )
        textResultAlcool = findViewById( R.id.text_result_alcool )
        btnVoltar = findViewById( R.id.btn_voltar )

    }
}