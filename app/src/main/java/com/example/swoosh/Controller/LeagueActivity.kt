package com.example.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import com.example.swoosh.Utilities.EXTRA_LEAGUE
import com.example.swoosh.R

class LeagueActivity : AppCompatActivity() {

    //Initializing Variables
    private var selectedLeague = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

        val mensLeagueBtn: ToggleButton = findViewById(R.id.mensLeagueBtn)
        val womensLeagueBtn: ToggleButton = findViewById(R.id.womensLeagueBtn)
        val coedLeagueBtn: ToggleButton = findViewById(R.id.coedLeagueBtn)


        //Men's Button
        mensLeagueBtn.setOnClickListener {
            womensLeagueBtn.isChecked = false
            coedLeagueBtn.isChecked = false

            selectedLeague = "mens"
        }

        //Women's Button
        womensLeagueBtn.setOnClickListener {
            mensLeagueBtn.isChecked = false
            coedLeagueBtn.isChecked = false

            selectedLeague = "womens"
        }

        //Co-Ed Button
        coedLeagueBtn.setOnClickListener {
            mensLeagueBtn.isChecked = false
            womensLeagueBtn.isChecked = false

            selectedLeague = "co-ed"
        }


    }

    //Next Button
    fun leagueNextClicked(view: View) {

        if (selectedLeague != "") {
            //Going from LeagueActivity to SkillActivity
            val skillActivity = Intent(this, SkillActivity::class.java)
            // sending data to SkillActivity
            skillActivity.putExtra(EXTRA_LEAGUE, selectedLeague)

            startActivity(skillActivity)
        } else {
            Toast.makeText(this, "Please select a league.", Toast.LENGTH_SHORT).show()
        }

    }


}