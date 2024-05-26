package com.android.can2022

import Equipe
import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Read JSON data from equipes.json file
        val jsonString = resources.openRawResource(R.raw.equipes).bufferedReader().use { it.readText() }

        // Convert JSON data to list of Equipe objects
        val equipesType = object : TypeToken<List<Equipe>>() {}.type
        val equipes: List<Equipe> = Gson().fromJson(jsonString, equipesType)

        // Set up ListView and adapter
        val listView = findViewById<ListView>(R.id.listView)
        val adapter = EquipeAdapter(this, equipes)
        listView.adapter = adapter

        // Set item click listener to open EquipeDetailsActivity
        listView.setOnItemClickListener { parent, view, position, id ->
            val equipe = equipes[position]

            val intent = Intent(this, EquipeDetailsActivity::class.java).apply {
                putExtra("equipe", equipe)
            }
            startActivity(intent)
        }
    }
}
