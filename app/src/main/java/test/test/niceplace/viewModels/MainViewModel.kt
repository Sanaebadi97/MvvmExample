package test.test.niceplace.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import test.test.niceplace.models.NicePlace
import test.test.niceplace.repositories.NicePlaceRepository

class MainViewModel : ViewModel() {
    private val _nicePlaces = MutableLiveData<List<NicePlace>>()
    private lateinit var repository: NicePlaceRepository

    var nicePlaces: LiveData<List<NicePlace>>? = null
        get() = _nicePlaces

    fun init() {

        if (nicePlaces != null) {
            return
        }
        repository = NicePlaceRepository().getInstance()
        nicePlaces = repository.getNicePlaces()
    }

}