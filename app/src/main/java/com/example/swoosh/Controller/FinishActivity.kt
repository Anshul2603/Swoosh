package com.example.swoosh.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.swoosh.R
import com.example.swoosh.Utilities.EXTRA_LEAGUE
import com.example.swoosh.Utilities.EXTRA_SKILL

class FinishActivity : AppCompatActivity() {

    lateinit var searchLeaguesText : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        searchLeaguesText = findViewById(R.id.searchLeaguesText)
        val league = intent.getStringExtra(EXTRA_LEAGUE)
        val skill = intent.getStringExtra(EXTRA_SKILL)

        searchLeaguesText.text = "Looking for $league $skill league near you..."


    }
}