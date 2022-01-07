package com.example.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.ToggleButton
import com.example.swoosh.Model.Player
import com.example.swoosh.R
import com.example.swoosh.Utilities.EXTRA_PLAYER


class SkillActivity : BaseActivity() {

    lateinit var player: Player
    lateinit var beginnerSkillBtn: ToggleButton
    lateinit var ballerSkillBtn: ToggleButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        beginnerSkillBtn = findViewById(R.id.beginnerSkillBtn)
        ballerSkillBtn = findViewById(R.id.ballerSkillBtn)

        player = intent.getParcelableExtra(EXTRA_PLAYER)!!

    }


    fun onBeginnerClick(view: View) {
        ballerSkillBtn.isChecked = false
        player.skill = "beginner"
    }

    fun onBallerClick(view: View) {
        beginnerSkillBtn.isChecked = false
        player.skill = "baller"

    }

    fun onSkillfinishClick(view: View) {
        if (player.skill != "") {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_PLAYER, player)

            startActivity(finishActivity)
        } else {
            Toast.makeText(this, "Please select a skill levvel", Toast.LENGTH_SHORT).show()
        }

    }
}