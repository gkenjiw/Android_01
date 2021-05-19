package br.senac.lista1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senac.lista1.databinding.ActivityEx06ImageBinding

class Ex06Image : AppCompatActivity() {
    lateinit var binding: ActivityEx06ImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEx06ImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pic = intent.getIntExtra("image", 0)
        binding.imageView.setImageResource(pic)

        binding.buttonBack.setOnClickListener { finish() }
    }
}