package com.example.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import com.example.swoosh.Model.Player
import com.example.swoosh.R
import com.example.swoosh.Utilities.EXTRA_PLAYER

class LeagueActivity : AppCompatActivity() {

    //Initializing

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(
            EXTRA_PLAYER,
            player
        )
    }

    var player = Player("", "")
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

            player.league = "mens"
        }

        //Women's Button
        womensLeagueBtn.setOnClickListener {
            mensLeagueBtn.isChecked = false
            coedLeagueBtn.isChecked = false

            player.league = "womens"
        }

        //Co-Ed Button
        coedLeagueBtn.setOnClickListener {
            mensLeagueBtn.isChecked = false
            womensLeagueBtn.isChecked = false

            player.league = "co-ed"
        }


    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null){
            player = savedInstanceState.getParcelable<Player>(EXTRA_PLAYER)!!
        }
    }

    //Next Button
    fun leagueNextClicked(view: View) {

        if (player.league != "") {
            //Going from LeagueActivity to SkillActivity
            val skillActivity = Intent(this, SkillActivity::class.java)
            // sending data to SkillActivity
            skillActivity.putExtra(EXTRA_PLAYER, player)

            startActivity(skillActivity)
        } else {
            Toast.makeText(this, "Please select a league.", Toast.LENGTH_SHORT).show()
        }

    }


}