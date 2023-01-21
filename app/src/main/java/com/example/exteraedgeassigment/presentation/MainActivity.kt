package com.example.exteraedgeassigment.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exteraedgeassigment.data.local.RocketDatabaseData
import com.example.exteraedgeassigment.data.network.mapper.mapToUi
import com.example.exteraedgeassigment.databinding.ActivityMainBinding
import com.example.exteraedgeassigment.domain.network.domainmodel.RocketDetailsDomainModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels<MainViewModel>()
    private lateinit var adapter: RocketListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        viewBinding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter = RocketListAdapter(this, emptyList(), viewModel.clickHandler)
        viewBinding.recyclerView.adapter = adapter


        viewModel.new.observe(this, Observer {
            if (it.data != null) {
                updateRecyclerData(it.data)
            }
        })

        viewModel.navigateToDetails.observe(this, Observer {
            if (it != null)
                navigateToDetailsActivity(it.mapToUi())
        })
        setContentView(viewBinding.root)
    }

    private fun navigateToDetailsActivity(data: RocketDetailsDomainModel) {
        val intent = Intent(this, RocketDetailsActivity::class.java)
        intent.putExtra("data", data)
        startActivity(intent)
    }

    private fun updateRecyclerData(list: List<RocketDatabaseData>) {
        adapter.adapterData = list
        adapter.notifyDataSetChanged()
    }
}