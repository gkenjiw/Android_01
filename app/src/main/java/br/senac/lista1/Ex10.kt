package br.senac.lista1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senac.lista1.databinding.ActivityEx10Binding

class Ex10 : AppCompatActivity() {
    lateinit var binding: ActivityEx10Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEx10Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonEx1.setOnClickListener { openExercise(1) }
        binding.buttonEx3.setOnClickListener { openExercise(3) }
        binding.buttonEx4.setOnClickListener { openExercise(4) }
        binding.buttonEx5.setOnClickListener { openExercise(5) }
        binding.buttonEx6.setOnClickListener { openExercise(6) }
        binding.buttonEx7.setOnClickListener { openExercise(7) }
        binding.buttonEx8.setOnClickListener { openExercise(8) }
        binding.buttonEx9.setOnClickListener { openExercise(9) }

    }

    private fun openExercise(int: Int) {
        when (int) {
            1 -> {
                val intent = Intent(this, Ex01::class.java)
                startActivity(intent)
            }
            3 -> {
                val intent = Intent(this, Ex03::class.java)
                startActivity(intent)
            }
            4 -> {
                val intent = Intent(this, Ex04::class.java)
                startActivity(intent)
            }
            5 -> {
                val intent = Intent(this, Ex05::class.java)
                startActivity(intent)
            }
            6 -> {
                val intent = Intent(this, Ex06::class.java)
                startActivity(intent)
            }
            7 -> {
                val intent = Intent(this, Ex07::class.java)
                startActivity(intent)
            }
            8 -> {
                val intent = Intent(this, Ex07::class.java)
                startActivity(intent)
            }
            9 -> {
                val intent = Intent(this, Ex07::class.java)
                startActivity(intent)
            }
        }
    }
}