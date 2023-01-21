package com.example.exteraedgeassigment.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.exteraedgeassigment.data.MainRepositoryImp
import com.example.exteraedgeassigment.data.local.RocketDatabaseData
import com.example.exteraedgeassigment.domain.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) :
    ViewModel() {

    var new = mainRepository.getRockets().asLiveData()

    var data = ArrayList<RocketDatabaseData>()

    var navigateToDetails = MutableLiveData<RocketDatabaseData?>(null)


    private fun getRocketDetails(id: String) {
        viewModelScope.launch {
            navigateToDetails.value = mainRepository.getRocketDetails(id).first().data
        }
    }

    val clickHandler = object : OnItemClicked {
        override fun onClick(id: String) {
            getRocketDetails(id)
        }

    }


}