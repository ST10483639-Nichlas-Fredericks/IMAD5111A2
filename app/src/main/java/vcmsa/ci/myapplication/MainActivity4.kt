package vcmsa.ci.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import kotlin.system.exitProcess

class MainActivity4 : AppCompatActivity() {

    //Module Manual
    //Varsity College
    //Page 30 to 35
//https://advtechonline.sharepoint.com/:w:/r/sites/TertiaryStudents/_layouts/15/Doc.aspx?sourcedoc=%7BA1FF62F0-8E1A-47BC-99BD-CA07AE24427D%7D&file=IMAD5112_MM.docx&action=default&mobileredirect=true
    private lateinit var btnStart: Button
    private lateinit var btnExit: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)

        val displayResults = findViewById<TextView>(R.id.displayResults)

        val questions = intent.getStringArrayExtra("questions")
        val answers = intent.getBooleanArrayExtra("answers")

        btnStart = findViewById(R.id.btnMain)
        btnExit = findViewById(R.id.exitBtn)

        val reviewText = StringBuilder()
        if (questions != null && answers != null && questions.size == answers.size) {
            for (i in questions.indices) {
                reviewText.append("${i + 1}. ${questions[i]}\n")
                reviewText.append(" Answer: ${if (answers[i]) "True" else "False"}\n")
            }
            displayResults.text = reviewText.toString()

        } else {
            displayResults.text = "Error loading review data"
        }


        btnStart = findViewById(R.id.btnMain)
        btnExit = findViewById(R.id.exitBtn)
        val intent = Intent(this, MainActivity::class.java)


        btnStart.setOnClickListener {
            startActivity(intent)
        }

        btnExit.setOnClickListener {
            finishAffinity()
        }
    }
}

