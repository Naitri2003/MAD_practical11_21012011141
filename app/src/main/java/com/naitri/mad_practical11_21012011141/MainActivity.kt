package com.naitri.mad_practical11_21012011141

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.recyclerview.widget.RecyclerView
import com.example.mad_practical11_21012011032.databinding.ActivityMainBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.util.jar.Attributes.Name

class MainActivity : AppCompatActivity() {
    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fab: FloatingActionButton = findViewById(R.id.floatingBt)
        fab.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val data = HttpRequest().makeServiceCall(
                        " https://api.json-generator.com/templates/qjeKFdjkXCdK/data",
                        "rbn0rerl1k0d3mcwgw7dva2xuwk780z1hxvyvrb1"
                    )
                    withContext(Dispatchers.Main) {
                        try {
                            if (data != null)
                                runOnUiThread { getPersonDetailsFromJson(data) }
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
    private fun getPersonDetailsFromJson(sJson: String?) {
        val personList = ArrayList<Person>()
        try {
            val jsonArray = JSONArray(sJson)
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray[i] as JSONObject
                val person = Person(jsonObject)
                personList.add(person)
            }
            val personlistView = findViewById<RecyclerView>(R.id.recycleview)
            personlistView.adapter = PersonAdapter(this, personList)
        } catch (ee: JSONException) {
            ee.printStackTrace()
        }
    }
}