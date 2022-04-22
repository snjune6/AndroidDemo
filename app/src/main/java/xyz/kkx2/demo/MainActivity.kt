package xyz.kkx2.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jdc = JsonDataComm();
        var jsonData: List<Map<String, Object>>? = null;
        jsonData = jdc.getJson("https://jsonplaceholder.typicode.com/");
    }
}