package com.example.swoosh.Controller

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.swoosh.Model.Player
import com.example.swoosh.R
import com.example.swoosh.Utilities.EXTRA_PLAYER

class FinishActivity : AppCompatActivity() {

    lateinit var searchLeaguesText: TextView
    lateinit var player: Player


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        searchLeaguesText = findViewById(R.id.searchLeaguesText)
        player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)!!

        searchLeaguesText.text = "Looking for ${player.league} ${player.skill} league near you..."


    }
}