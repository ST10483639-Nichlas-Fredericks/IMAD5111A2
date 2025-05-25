package vcmsa.ci.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineStart
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val userText = findViewById<TextView>(R.id.userText)
        val btnStart = findViewById<Button?>(R.id.btnStart)
        val intent = Intent(this, MainActivity2::class.java)
       val btnExit = findViewById<Button>(R.id.btnExit)


        btnStart?.setOnClickListener{
            startActivity(intent)
        }

        btnExit.setOnClickListener{
            finishAffinity()
            exitProcess(0)
        }
    }
}