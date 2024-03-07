package com.example.juros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultadoJuros : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_juros)
        setSupportActionBar(findViewById(R.id.toolbar))
        val montante = findViewById<TextView>(R.id.Montante)
        val juros = findViewById<TextView>(R.id.TotalJuros)
        val parcela = findViewById<TextView>(R.id.Parcela)
        val valormont = intent.getDoubleExtra("calcmont", 0.0)
        val valortotal = intent.getDoubleExtra("calcjuros", 0.0)
        val valorparcela = intent.getDoubleExtra("calcparcela", 0.0)
        montante.text = valormont.toString()
        juros.text = valortotal.toString()
        parcela.text = valorparcela.toString()
    }
}