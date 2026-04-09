package com.example.bailliemaweu

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        fetch 8 buttons by their Ids
        val recipebutton = findViewById<Button>(R.id.recipe)
        val advicebutton = findViewById<Button>(R.id.advice)
        val meditationbutton = findViewById<Button>(R.id.meditation)
        val hydrationbutton = findViewById<Button>(R.id.hydration)
        val exercisebutton = findViewById<Button>(R.id.exercise)
        val goalsbutton = findViewById<Button>(R.id.goals)
        val progressbutton = findViewById<Button>(R.id.progress)

        recipebutton.setOnClickListener {
            val intent = Intent(applicationContext, HealthActivity::class.java)
            startActivity(intent)
        }
//        ==============================================================================
        advicebutton.setOnClickListener {
            val intent = Intent(applicationContext, NutritionActivity::class.java)
            startActivity(intent)
        }
        meditationbutton.setOnClickListener {
            val intent = Intent( applicationContext, MeditationActivity::class.java )
        startActivity(intent)
        }
        hydrationbutton.setOnClickListener {
            val intent = Intent(applicationContext, HydrationActivity::class.java)
            startActivity(intent)
        }
        exercisebutton.setOnClickListener {
            val intent = Intent(applicationContext, ExerciseActivity::class.java)
            startActivity(intent)
        }
        goalsbutton.setOnClickListener {
            val intent = Intent(applicationContext, WeeklyActivity::class.java)
            startActivity(intent)
        }
        progressbutton.setOnClickListener {
            val intent = Intent(applicationContext, ProgressActivity::class.java)
            startActivity(intent)
        }
    }
}