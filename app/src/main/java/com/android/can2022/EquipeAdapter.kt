package com.android.can2022

import Equipe
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class EquipeAdapter(context: Context, private val equipes: List<Equipe>) : BaseAdapter() {
    override fun getCount(): Int {
        return equipes.size
    }

    override fun getItem(position: Int): Any {
        return equipes[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(parent?.context).inflate(R.layout.item_equipe, parent, false)
        val equipe = equipes[position]

        view.findViewById<TextView>(R.id.txtPays).text = equipe.pays
        if (parent != null) {
            view.findViewById<ImageView>(R.id.imgDrapeau).setImageResource(parent.context.resources.getIdentifier(equipe.drapeau, "drawable", parent.context.packageName))
        }

        return view
    }


}
