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
        recuperarDados()

        btnVoltar.setOnClickListener{
            finish()
        }

    }
    private fun recuperarDados() {
        inicializarComponentesInterface()

        if (intent.hasExtra("gasolina") && intent.hasExtra("alcool")) {
            try {
                val gasolina = intent.getStringExtra("gasolina").toString()
                val gasolinaNumber = gasolina.toDouble()
                textResultGasolina.text = gasolinaNumber.toString()

                val alcool = intent.getStringExtra("alcool").toString()
                val alcoolNumber = alcool.toDouble()
                textResultAlcool.text = alcoolNumber.toString()

                val resultado = intent.getStringExtra("resultado")
                textResultado.text = resultado
            } catch (e: NumberFormatException) {
                // Lidar com a exceção (formato inválido da string)
                // Pode ser útil exibir uma mensagem de erro ou tomar outra ação apropriada.
            }
        } else {
            // Lida com o caso em que os extras não estão presentes
            // Pode ser útil exibir uma mensagem de erro ou tomar outra ação apropriada.
        }
    }
    private fun inicializarComponentesInterface() {
        textResultado = findViewById( R.id.text_resultado )
        textResultGasolina = findViewById( R.id.text_preco_gasolina )
        textResultAlcool = findViewById( R.id.text_preco_alcool )
        btnVoltar = findViewById( R.id.btn_voltar )

    }
}