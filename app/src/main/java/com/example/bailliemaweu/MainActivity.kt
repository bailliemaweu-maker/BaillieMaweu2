package com.example.bailliemaweu

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback


class MainActivity : AppCompatActivity() {
    private var mInterstitialAd: InterstitialAd? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

//        initialize the advert
        MobileAds.initialize(applicationContext)
//        fetch the adview by id
        val adView = findViewById<AdView>(R.id.adview)
//        load the advert
        adView.loadAd(AdRequest.Builder().build())
        loadInterstitialAd()

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
            showInterstitialAd()
        }
//        ==============================================================================
        advicebutton.setOnClickListener {
            val intent = Intent(applicationContext, NutritionActivity::class.java)
            startActivity(intent)
            showInterstitialAd()
        }
//        ==============================================================================

        meditationbutton.setOnClickListener {
            val intent = Intent( applicationContext, MeditationActivity::class.java )
        startActivity(intent)
            showInterstitialAd()
        }
//        ==============================================================================

        hydrationbutton.setOnClickListener {
            val intent = Intent(applicationContext, HydrationActivity::class.java)
            startActivity(intent)
            showInterstitialAd()
        }
//        ==============================================================================

        exercisebutton.setOnClickListener {
            val intent = Intent(applicationContext, ExerciseActivity::class.java)
            startActivity(intent)
            showInterstitialAd()
        }
//        ==============================================================================

        goalsbutton.setOnClickListener {
            val intent = Intent(applicationContext, WeeklyActivity::class.java)
            startActivity(intent)
            showInterstitialAd()
        }
//        ==============================================================================

        progressbutton.setOnClickListener {
            val intent = Intent(applicationContext, ProgressActivity::class.java)
            startActivity(intent)
            showInterstitialAd()
        }

    }
    fun loadInterstitialAd() {
        val adRequest = AdRequest.Builder().build()
        //Requests interstitial ads
        InterstitialAd.load(
            this,
            "ca-app-pub-3940256099942544/1033173712", // Test ID
            adRequest,
            object : InterstitialAdLoadCallback() {

                override fun onAdLoaded(ad: InterstitialAd) {
                    mInterstitialAd = ad
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    mInterstitialAd = null
                }
            }
        )
    }
    //Function checks if ad already running not to run another one and overlap - which is wrong
    fun showInterstitialAd() {
        if (mInterstitialAd != null) {
            mInterstitialAd?.show(this)
        }
    }

}