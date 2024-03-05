package com.example.juros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class ResultadoJuros : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_juros)
        setSupportActionBar(findViewById(R.id.toolbar))
        val montante = findViewById<EditText>(R.id.Montante)
        val juros = findViewById<EditText>(R.id.TotalJuros)
        val parcela = findViewById<EditText>(R.id.Parcela)
        val valormont = intent.getDoubleExtra("calcmont", 0.0)
        val valortotal = intent.getDoubleExtra("calcvalor", 0.0)
        val valorparcela = intent.getDoubleExtra("calcparcela", 0.0)
        montante.text = valormont.toString()
        juros.text = valortotal.toString()
        parcela.text = valorparcela.toString()
    }
}