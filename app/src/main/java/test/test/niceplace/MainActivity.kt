package test.test.niceplace

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import test.test.niceplace.adapter.NicePlaceAdapter
import test.test.niceplace.viewModels.MainViewModel

class MainActivity : AppCompatActivity() {


    lateinit var fab: FloatingActionButton
    lateinit var rvNicePlace: RecyclerView
    lateinit var nicePlaceAdapter: NicePlaceAdapter
    lateinit var progressBar: ProgressBar

    lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab = fab_nice_place
        rvNicePlace = rv_nice_place

        progressBar = progress_circular

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        mainViewModel.init()

        mainViewModel.nicePlaces!!.observe(this, Observer {
            nicePlaceAdapter.notifyDataSetChanged()

        })
        initRecyclerView()


    }

    private fun initRecyclerView() {
         nicePlaceAdapter = NicePlaceAdapter(mainViewModel.nicePlaces!!.value!!)
        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvNicePlace.layoutManager = linearLayoutManager
        rvNicePlace.adapter = nicePlaceAdapter
    }

    fun showDialog() {
        progressBar.visibility = View.VISIBLE
    }

    fun hideDialog() {
        progressBar.visibility = View.GONE
    }
}
