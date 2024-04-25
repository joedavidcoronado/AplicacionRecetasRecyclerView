package com.example.practico2ingredientes.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practico2ingredientes.databinding.RecetaItemListBinding
import com.example.practico2ingredientes.model.Receta

class RecetaAdapter(
    private val recetas: MutableList<Receta>,
    private val listener: OnRecetasClickListener
) : RecyclerView.Adapter<RecetasViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecetasViewHolder {
        val binding =
            RecetaItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return RecetasViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: RecetasViewHolder, position: Int) {
        val receta = recetas[position]
        holder.bind(receta, listener)
    }

    override fun getItemCount(): Int {
        return recetas.size
    }
}
class RecetasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(receta: Receta, listener: OnRecetasClickListener) {
        RecetaItemListBinding.bind(itemView).apply {
            lblNombreReceta.setText(receta.nombre)
            btnImagen.setOnClickListener {
                listener.onRecetasClick(receta)
            }
            btnImagen.setOnClickListener{
                listener.onRecetasClick(receta)
            }
            btnImagen.setOnLongClickListener{
                true
            }
        }
    }
}

interface OnRecetasClickListener {
    fun onRecetasClick(receta: Receta)
}