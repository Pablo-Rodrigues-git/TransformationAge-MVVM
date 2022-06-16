package com.training.ui.transformationage.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.training.ui.transformationage.R
import com.training.ui.transformationage.data.Dog
import kotlinx.android.synthetic.main.item_dog.view.*

class DogsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bindView(item: Dog) {
        with(view) {
            tv_dog.text = item.text
        }
    }
}

class DogsAdapter(val data: MutableList<Dog> = mutableListOf()) :
    RecyclerView.Adapter<DogsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dog, parent, false)
        return DogsViewHolder(view)
    }

    override fun onBindViewHolder(holder: DogsViewHolder, position: Int) =
        holder.bindView(data[position])

    override fun getItemCount(): Int = data.size

    fun add(item: Dog) {
        data.add(item)
        notifyDataSetChanged()
    }

    fun add(itens: List<Dog>) {
        data.clear()
        data.addAll(itens)
        notifyDataSetChanged()
    }

    fun remove(item: Dog) {
        data.remove(item)
        notifyDataSetChanged()
    }
}