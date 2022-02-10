package com.dio.simuladordepartidas.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.dio.simuladordepartidas.databinding.ActivityDetailBinding
import com.dio.simuladordepartidas.domain.Match

class DetailActivity : AppCompatActivity() {
    object Extras {
        const val MATCH = "EXTRA_MATCH"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        loadMatchFromExtra()
    }

    private fun loadMatchFromExtra(){
        intent?.extras?.getParcelable<Match>(Extras.MATCH)?.let {
            Glide.with(this).load(it.local.image).into(binding.ivPlace)
            supportActionBar?.title = it.local.name
            binding.tvDescription.text = it.description

            Glide.with(this).load(it.homeTime.image).into(binding.ivHomeTeam)
            binding.tvHomeTeamName.text = it.homeTime.name
            binding.rbHomeTeamStars.rating = it.homeTime.stars.toFloat();

            Glide.with(this).load(it.awayTeam.image).into(binding.ivAwayTeam)
            binding.tvAwayTeamName.text = it.awayTeam.name
            binding.rbAwayTeamStars.rating = it.awayTeam.stars.toFloat();

            if(it.homeTime.score!=null){
                binding.tvHomeTeamScore.text = it.homeTime.score.toString()
                binding.tvAwayTeamScore.text = it.awayTeam.score.toString()
            }
        }
    }
}