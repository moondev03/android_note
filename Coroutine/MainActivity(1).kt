package com.example.stt;

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.stt.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.fetchDataButton.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE

            /*
            Dispatchers.Main
            : Android 메인 스레드에서 코루틴을 실행하는 디스페처로 UI와 상호작용하는 작업을 실행하기 위해서만 사용해야함
            Dispatchers.IO
            : 디스크 또는 네트워크 I/O 작업을 실행하는데 최적화되어 있는 디스패처
            Dispatchers.Default
            : CPU를 많이 사용하는 작업을 기본 스레드 외부에서 실행하도록 최적화되어 있는 디스패치로 정렬, Json 파싱 작업 등에 최적화
            */

            GlobalScope.launch(Dispatchers.IO) {
                val data = fetchDataFromNetwork()

                withContext(Dispatchers.Main) {
                    binding.progressBar.visibility = View.GONE
                    binding.resultTextView.text = data
                }
            }
            // launch() 결과를 반환 X (Job이 반환됨)
            // async()는 Defered<T> 타입의 결과를 반환
        }
    }

    private fun fetchDataFromNetwork(): String {
        val url = URL("https://developer.android.com/kotlin/coroutines?hl=ko")
        val connection = url.openConnection() as HttpURLConnection
        try {
            val inputStream = connection.inputStream
            val reader = BufferedReader(InputStreamReader(inputStream))
            val result = StringBuilder()
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                result.append(line).append("\n")
            }
            return result.toString()
        } finally {
            connection.disconnect()
        }
    }
}
