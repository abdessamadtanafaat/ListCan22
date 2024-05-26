package com.android.can2022

import Equipe
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EquipeDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_equipe_details)

        // Retrieve the Equipe object from the intent
        val equipe = intent.getParcelableExtra<Equipe>("equipe")

        // Display equipe details
        findViewById<TextView>(R.id.txtPays).text = equipe?.pays
        findViewById<TextView>(R.id.txtGroupe).text = equipe?.groupe
        findViewById<TextView>(R.id.txtCoach).text = equipe?.coach
        findViewById<TextView>(R.id.txtStarPlayer).text = equipe?.starPlayer

        // Display images
        findViewById<ImageView>(R.id.imgCoach).setImageResource(getDrawableResourceId(equipe?.coachImage))
        findViewById<ImageView>(R.id.imgStarPlayer).setImageResource(getDrawableResourceId(equipe?.starPlayerImage))
        findViewById<ImageView>(R.id.imgLineup).setImageResource(getDrawableResourceId(equipe?.lineupImage))
    }

    private fun getDrawableResourceId(resourceName: String?): Int {
        return if (resourceName != null) {
            resources.getIdentifier(resourceName, "drawable", packageName)
        } else {
            // Return default image resource if the image name is not provided
            R.drawable.ic_launcher_foreground
        }
    }
}
