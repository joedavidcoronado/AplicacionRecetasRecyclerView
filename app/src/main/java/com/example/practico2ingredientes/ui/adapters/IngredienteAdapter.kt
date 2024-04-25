package com.example.practico2ingredientes.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.practico2ingredientes.databinding.IngredienteItemListBinding
import com.example.practico2ingredientes.model.Ingrediente

class IngredienteAdapter(
    private val ingredientes: ArrayList<Ingrediente>,
    private val listener: OnIngredienteClickListener
) : RecyclerView.Adapter<IngredienteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredienteViewHolder {
        val binding =
            IngredienteItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return IngredienteViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return ingredientes.size
    }

    override fun onBindViewHolder(holder: IngredienteViewHolder, position: Int) {
        val ingrediente = ingredientes[position]
        holder.bind(ingrediente, listener)
    }
}

class IngredienteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(ingrediente: Ingrediente, listener: OnIngredienteClickListener) {
        IngredienteItemListBinding.bind(itemView).apply {
            txtNombre.setText(ingrediente.nombre)
            Glide.with(itemView.context)
                .load(ingrediente.imagenUrl)
                .into(imgIngrediente);

            root.setOnClickListener {
                listener.onIngredienteClick(ingrediente)
            }
            vwView.setOnClickListener{
                val alpha = (255 * 0.38).toInt() // Calcula el valor alfa para el 51% de translucidez
                val color = Color.argb(alpha, Color.red(Color.GREEN), Color.green(Color.GREEN), Color.blue(Color.GREEN))
                vwView.setBackgroundColor(color)
                listener.onIngredienteClick(ingrediente)
            }
            vwView.setOnLongClickListener{
                true
            }
        }
    }
}

interface OnIngredienteClickListener {
    fun onIngredienteClick(ingrediente: Ingrediente)
}