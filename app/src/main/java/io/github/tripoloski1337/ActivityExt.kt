package io.github.tripoloski1337

import android.content.Intent
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.startActivityWithoutAnimation(intent: Intent) {
    overridePendingTransition(0, 0)
    startActivity(intent.apply {
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_NO_ANIMATION
    })
}


fun AppCompatActivity.startOtherApp(targetAppPackage: String) {
//    val username = findViewById<TextView>(R.id.editTextTextPersonName2)
//    val password = findViewById<TextView>(R.id.editTextTextPersonName3)
    val user: TextView = findViewById(R.id.username) as TextView
    val pass: TextView = findViewById(R.id.password) as TextView
    val userText: String = user.text.toString()
    val passText: String = pass.text.toString()
    packageManager.getLaunchIntentForPackage(targetAppPackage)?.let {
        startActivityWithoutAnimation(it)
//        sendBro(userText, passText)
    }
}
