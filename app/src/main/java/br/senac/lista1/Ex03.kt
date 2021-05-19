package br.senac.lista1

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import br.senac.lista1.databinding.ActivityEx03Binding

class Ex03 : AppCompatActivity() {
    lateinit var binding: ActivityEx03Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEx03Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initSpinners()

        binding.buttonBack.setOnClickListener { finish() }
    }

    private fun initSpinners() {
        val itemsSpinnerEmail = resources.getStringArray(R.array.array_email_type)
        val itemsSpinnerApp = resources.getStringArray(R.array.array_app)
        setSpinnerAdapter(itemsSpinnerEmail, binding.spinnerEmail)
        setSpinnerAdapter(itemsSpinnerApp, binding.spinnerApp)
    }

    private fun setSpinnerAdapter(array: Array<String>, spinner: Spinner) {
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, array)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }
}