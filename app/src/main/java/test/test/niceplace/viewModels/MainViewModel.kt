package test.test.niceplace.viewModels

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import test.test.niceplace.models.NicePlace
import test.test.niceplace.repositories.NicePlaceRepository

class MainViewModel : ViewModel() {
    private var mNicePlaces: MutableLiveData<List<NicePlace>>? = null
    private var mRepo: NicePlaceRepository? = null
    private var mIsUpdating = MutableLiveData<Boolean>()

    val nicePlaces: LiveData<List<NicePlace>>?
        get() = mNicePlaces


    fun addNewValue(nicePlace: NicePlace) {
        mIsUpdating.setValue(true)

        object : AsyncTask<Void, Void, Void>() {
            override fun onPostExecute(aVoid: Void) {
                super.onPostExecute(aVoid)
                val currentPlaces = mNicePlaces!!.value
                currentPlaces!!.toMutableList().add(nicePlace)
                mNicePlaces!!.postValue(currentPlaces)
                mIsUpdating.postValue(false)
            }

            override fun doInBackground(vararg voids: Void): Void? {

                try {
                    Thread.sleep(2000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

                return null
            }
        }.execute()
    }

    fun init() {

        if (mNicePlaces != null) {
            return
        }
        mRepo = NicePlaceRepository.getInstance()
        mNicePlaces = mRepo!!.nicePlaces
    }


    fun getIsUpdating(): LiveData<Boolean> {
        return mIsUpdating
    }
}