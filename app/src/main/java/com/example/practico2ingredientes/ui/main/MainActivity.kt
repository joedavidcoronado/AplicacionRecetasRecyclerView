package com.example.practico2ingredientes.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practico2ingredientes.R
import com.example.practico2ingredientes.databinding.ActivityMainBinding
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.practico2ingredientes.model.Ingrediente
import com.example.practico2ingredientes.ui.adapters.IngredienteAdapter
import com.example.practico2ingredientes.ui.adapters.OnIngredienteClickListener
import com.example.practico2ingredientes.ui.secondPage.SegundaPaginaActivity


class MainActivity : AppCompatActivity(), OnIngredienteClickListener{
    private lateinit var binding: ActivityMainBinding
    private val model: MainViewModel by viewModels()
    var coordenadas = StringBuilder()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //aca van los Setups
        setupRecyclerView()
        setupEventListener()
    }

    private fun setupEventListener() {
        binding.btnRecetas.setOnClickListener {
            val nuevoString = coordenadas.toString()
            val intent = Intent(this, SegundaPaginaActivity::class.java)
            intent.putExtra("LISTA_EXTRA", nuevoString)
            if(nuevoString.length > 0){
                startActivity(intent)
                this.recreate()
            }else{
                Toast.makeText(this, "No hay selecionados", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupRecyclerView() {
        binding.lstIngredientes.apply {
            adapter = IngredienteAdapter(
                arrayListOf(
                    Ingrediente(
                        false,
                        1,
                        "Pollo",
                        "https://thefoodtech.com/wp-content/uploads/2020/09/maduracion-de-carne-de-pollo-828x548.jpg"
                    ),
                    Ingrediente(
                        false,
                        2,
                        "Arroz",
                        "https://www.brillante.es/wp-content/uploads/2023/05/uncooked-white-rice-on-wooden-spoon-2022-08-11-15-41-47-utc-2-1-1080x675.jpg"
                    ),
                    Ingrediente(
                        false,
                        3,
                        "Tomate",
                        "https://estaticos-cdn.prensaiberica.es/clip/eb9b9565-22cc-4922-bd33-755d96b033a9_16-9-discover-aspect-ratio_default_0.jpg"
                    ),
                    Ingrediente(
                        false,
                        4,
                        "Platano",
                        "https://statics-cuidateplus.marca.com/cms/platanos_0.jpg"
                    ),
                    Ingrediente(
                        false,
                        5,
                        "Carne",
                        "https://s2.ppllstatics.com/diariovasco/www/multimedia/201906/03/media/cortadas/carne-roja-kS1C-R5uqUSGFlSqj84mn1I9bQuN-624x385@Diario%20Vasco.jpg"
                    ),
                    Ingrediente(false, 6, "Zanahoria", "https://www.cuerpomente.com/medio/2020/10/21/zanahoria_b6b4af96_1200x630.jpg"),
                    Ingrediente(false, 7, "Espinacas", "https://i.blogs.es/5ee30a/istock-522189977/650_1200.jpg"),
                    Ingrediente(false, 8, "Queso", "https://s1.ppllstatics.com/diariovasco/www/multimedia/2023/04/27/brie-cheese-R7OwrZaSYtc4LgVDsFRrVTP-1200x840@DiarioVasco.jpg"),
                    Ingrediente(false, 9, "Pasta", "https://media.istockphoto.com/id/185065945/es/foto/pasta-de-variaci%C3%B3n.jpg?s=612x612&w=0&k=20&c=40iJaiMARmLy26XBL0eUCtDvKXEdphj0R2bcOMLKJgY="),
                    Ingrediente(false, 0, "Harina", "https://mandolina.co/wp-content/uploads/2023/03/648366622-1024x683.jpg")
                ),
                this@MainActivity
            )
            layoutManager = GridLayoutManager(this@MainActivity, 2)
        }
    }

    override fun onIngredienteClick(ingrediente: Ingrediente) {

        coordenadas.append(ingrediente.id.toString())
    }
}
