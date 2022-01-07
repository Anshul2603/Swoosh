package com.example.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.ToggleButton
import com.example.swoosh.R
import com.example.swoosh.Utilities.EXTRA_LEAGUE
import com.example.swoosh.Utilities.EXTRA_SKILL

class SkillActivity : BaseActivity() {

    var league = ""
    var skill = ""
    lateinit var beginnerSkillBtn: ToggleButton
    lateinit var ballerSkillBtn: ToggleButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        beginnerSkillBtn = findViewById(R.id.beginnerSkillBtn)
        ballerSkillBtn = findViewById(R.id.ballerSkillBtn)

        league = intent.getStringExtra(EXTRA_LEAGUE).toString()

    }


    fun onBeginnerClick(view: View) {
        ballerSkillBtn.isChecked = false
        skill = "beginner"
    }

    fun onBallerClick(view: View) {
        beginnerSkillBtn.isChecked = false
        skill = "baller"

    }

    fun onSkillfinishClick(view: View) {
        if (skill != "") {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_LEAGUE, league)
            finishActivity.putExtra(EXTRA_SKILL, skill)

            startActivity(finishActivity)
        } else {
            Toast.makeText(this, "Please select a skill levvel", Toast.LENGTH_SHORT).show()
        }

    }
}