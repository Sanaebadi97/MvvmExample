package test.test.niceplace.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import test.test.niceplace.models.NicePlace
import test.test.niceplace.repositories.NicePlaceRepository

class MainViewModel : ViewModel() {
    private var mNicePlaces: MutableLiveData<List<NicePlace>>? = null
    private var mRepo: NicePlaceRepository? = null

    val nicePlaces: LiveData<List<NicePlace>>?
        get() = mNicePlaces



    fun init() {

        if (mNicePlaces != null) {
            return
        }
        mRepo = NicePlaceRepository.getInstance()
        mNicePlaces = mRepo!!.nicePlaces
    }

}