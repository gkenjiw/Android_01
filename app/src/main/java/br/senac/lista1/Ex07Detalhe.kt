package br.senac.lista1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senac.lista1.databinding.ActivityEx07DetalheBinding

class Ex07Detalhe : AppCompatActivity() {
    lateinit var binding: ActivityEx07DetalheBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEx07DetalheBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var msg = intent.getStringExtra("text1") + " " + intent.getStringExtra("text2")
        binding.textViewShow.text = msg

        binding.buttonBack.setOnClickListener { finish() }
    }
}