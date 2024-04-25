package com.example.practico2ingredientes.ui.thirdPage

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practico2ingredientes.R
import com.example.practico2ingredientes.databinding.ActivityThirdPageBinding

class ThirdPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityThirdPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val textoRecibido = intent.getStringExtra("texto")
        setupEvenListener(textoRecibido)
    }

    private fun setupEvenListener(textoRecibido: String?) {
        binding.scrollView.smoothScrollTo(0, 0)
        binding.lblTexto.text = textoRecibido
        //binding.scrollView.addView(binding.lblTexto)
    }
}