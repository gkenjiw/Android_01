package br.senac.lista1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import br.senac.lista1.databinding.ActivityEx06Binding

class Ex06 : AppCompatActivity() {
    lateinit var binding: ActivityEx06Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEx06Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageButtonEd.setOnClickListener { sendImage(0) }
        binding.imageButtonAl.setOnClickListener { sendImage(1) }
        binding.imageButtonRoy.setOnClickListener { sendImage(2) }
        binding.imageButtonHughes.setOnClickListener { sendImage(3) }
        binding.imageButtonScar.setOnClickListener { sendImage(4) }
        binding.imageButtonWinry.setOnClickListener { sendImage(5) }
        binding.buttonBack.setOnClickListener { finish() }
    }

    private fun sendImage(int: Int) {
        val intent = Intent(this, Ex06Image::class.java)
        when (int) {
            0 -> {
                intent.putExtra("image", R.drawable.ed)
                startActivity(intent)
            }
            1 -> {
                intent.putExtra("image", R.drawable.al)
                startActivity(intent)
            }
            2 -> {
                intent.putExtra("image", R.drawable.roy)
                startActivity(intent)
            }
            3 -> {
                intent.putExtra("image", R.drawable.hughes)
                startActivity(intent)
            }
            4 -> {
                intent.putExtra("image", R.drawable.scar)
                startActivity(intent)
            }
            5 -> {
                intent.putExtra("image", R.drawable.winry)
                startActivity(intent)
            }
        }

    }
}