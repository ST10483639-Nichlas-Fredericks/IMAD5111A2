package vcmsa.ci.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity3 : AppCompatActivity() {


    private lateinit var btnRestart: Button
    private lateinit var resultsView: TextView
    private lateinit var btnCheck: Button

    private var score = 0


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)


        //Module Manual
        //Varsity College
        //Page 30 to 35
//https://advtechonline.sharepoint.com/:w:/r/sites/TertiaryStudents/_layouts/15/Doc.aspx?sourcedoc=%7BA1FF62F0-8E1A-47BC-99BD-CA07AE24427D%7D&file=IMAD5112_MM.docx&action=default&mobileredirect=true
        val resultsView = findViewById<TextView>(R.id.resultsView)
        val userFeedback = findViewById<TextView>(R.id.userFeedback)
        val btnCheck = findViewById<Button>(R.id.btnCheck)
        val btnRestart = findViewById<Button>(R.id.btnRestart)
        val btnExit = findViewById<Button>(R.id.btnExit)
        val score = intent.getIntExtra("score", 0)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        // Get all data from QuizActivity
        val total = intent.getIntExtra("TOTAL", 5)
        val questions = intent.getStringArrayExtra("questions") ?: emptyArray()
        val answers = intent.getBooleanArrayExtra("answers") ?: booleanArrayOf()
        val category = intent.getStringExtra("CATEGORY") ?: "GENERAL_KNOWLEDGE"

        // Display score and feedback

            // Show score
            resultsView.text = "You got $score out of $total correct!"
            userFeedback.text = when {
                score == total -> "Perfect!"
                score >= total * 0.75 -> "Excellent!"
                score >= total * 0.5 -> "Good job!"
                else -> "Keep practicing!"
            }


            btnCheck.setOnClickListener {
                // Optionally go to review screen
                val intent = Intent(this, MainActivity4::class.java)
                intent.putExtra("questions", questions)
                intent.putExtra("answers", answers)
                intent.putExtra("CATEGORY", category)
                intent.putExtra("score", score)
                intent.putExtra("TOTAL", total)
                startActivity(intent)
            }

            // Restart Button - Go to MainActivity
            btnRestart.setOnClickListener {
                startActivity(Intent(this, MainActivity2::class.java))
                finish()
            }

            // Exit Button - Close app
            btnExit.setOnClickListener {
                Toast.makeText(this, "Exit clicked", Toast.LENGTH_SHORT).show()
                finishAffinity()
            }
    }
}


