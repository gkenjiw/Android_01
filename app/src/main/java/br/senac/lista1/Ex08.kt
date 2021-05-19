package br.senac.lista1

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.browser.customtabs.CustomTabsIntent
import br.senac.lista1.databinding.ActivityEx08Binding

class Ex08 : AppCompatActivity() {
    lateinit var binding: ActivityEx08Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEx08Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonOpen.setOnClickListener {
            val uri = Uri.parse(binding.editTextUri.text.toString())

            CustomTabsIntent.Builder()
                .build()
                .launchUrl(this, uri)
        }

        binding.buttonBack.setOnClickListener { finish() }
    }
}