package com.example.exteraedgeassigment.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exteraedgeassigment.databinding.ActivityRocketDetailsBinding
import com.example.exteraedgeassigment.domain.network.domainmodel.RocketDetailsDomainModel
import com.example.exteraedgeassigment.utilities.Utils.Companion.getInchesFromMeters

class RocketDetailsActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityRocketDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityRocketDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        if (intent.extras != null) {
            var data = intent.extras!!.getSerializable("data") as RocketDetailsDomainModel
            viewBinding.nameValue.text = data.name
            viewBinding.rocketDetailsDescriptionValue.text = data.description
            viewBinding.rocketDetailsActiveStateValue.text =
                if (data.activeStatus) "Active" else "Not Active"
            viewBinding.rocketDetailsCostPerLaunchValue.text = data.costPerLaunch
            viewBinding.rocketDetailsSuccessRateValue.text = data.successRate + "%"
            viewBinding.rocketDetailsWikipediaValue.text = data.wikipediaLink
            viewBinding.rocketDetailsHeightValue.text =
                data.heightFeet + "ft. /" + getInchesFromMeters(data.heightInch.toDouble()) + " Inch."
            viewBinding.rocketDetailsDiameterValue.text =
                data.diameterFeet + "ft. /" + getInchesFromMeters(data.diameterInch.toDouble()) + "Inch."
            viewBinding.imagesRecycler.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            viewBinding.imagesRecycler.adapter = RocketImagesAdapter(this, data.image)
        }
    }

    override fun onResume() {
        super.onResume()
        viewBinding.rocketDetailsWikipediaValue.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(viewBinding.rocketDetailsWikipediaValue.text.toString())
            )
            startActivity(intent)
        }
    }

}