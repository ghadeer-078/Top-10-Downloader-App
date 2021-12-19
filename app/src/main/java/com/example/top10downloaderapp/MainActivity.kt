package com.example.top10downloaderapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.top10downloaderapp.API.APIClient
import com.example.top10downloaderapp.API.APIInterface
import com.example.top10downloaderapp.Model.Entry
import com.example.top10downloaderapp.Resource.RVAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    lateinit var mainRV : RecyclerView
    lateinit var fetchButton: Button

    var apiInterface =  APIClient().getClient()?.create(APIInterface::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectView()

        fetchButton.setOnClickListener {
            getData()
        }

    }


    private fun connectView(){
        mainRV = findViewById(R.id.rvMain)
        fetchButton = findViewById(R.id.fetchBtn)
    }


    private fun getData() {
        CoroutineScope(IO).launch {
            val data = withContext(Dispatchers.Default) {
                apiInterface!!.getDataResponse()
            }
            if (data != null)
                updateRV(data.body()!!.entries)
            else
                updateRV(listOf())
        }
    }


    private suspend fun updateRV(list: List<Entry>?) {
        withContext(Main){
            mainRV.adapter = RVAdapter(list)
            mainRV.layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }


}