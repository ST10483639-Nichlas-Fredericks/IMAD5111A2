package vcmsa.ci.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.pdf.PdfDocument.Page
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


@SuppressLint("ParcelCreator")
class MainActivity2 : AppCompatActivity() {


    private lateinit var userText1: TextView
    private lateinit var btnTrue: Button
    private lateinit var btnFalse: Button
    private lateinit var btnNext: Button
    private lateinit var resultText: TextView


    private var scorecount = 0
    private var score = 0
    private lateinit var scorepage:Intent

    companion object {

        val questions: Array<String> = arrayOf(
            "Mercury is the first planet in the solar system",
            "Earth is 90% water",
            "Jupiter is the biggest planet in the solar system",
            "The Sun is at the centre of the solar system",
            "The MilkyWay is the name of our galaxy"
        )
        val answers: BooleanArray = booleanArrayOf(true, false, true, true, true)
    }


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialise UI Elements
        userText1 = findViewById(R.id.userText1)
        btnTrue = findViewById(R.id.btnTrue)
        btnFalse = findViewById(R.id.btnFalse)
        btnNext = findViewById(R.id.btnNext)
        resultText = findViewById(R.id.resultText)
        scorepage = Intent(this, MainActivity3::class.java)

        //Display First Question
        resultText.text = questions[scorecount]

        btnTrue.setOnClickListener { checkAnswer(true) }
        btnFalse.setOnClickListener { checkAnswer(false) }

        btnNext.setOnClickListener {
            scorecount++
            if (scorecount < questions.size) {
                resultText.text = questions[scorecount]
                btnTrue.isEnabled = true
                btnFalse.isEnabled = true
                btnNext.isEnabled = false
            } else {
                scorepage.putExtra("score", score)
                scorepage.putExtra("questions", questions)
                scorepage.putExtra("answers", answers)
                startActivity(scorepage)
                finish()
            }
        }


        btnNext.isEnabled = false
    }

    private fun checkAnswer(userAnswer: Boolean){
        val correctAnswer = answers[scorecount]

        if (userAnswer == correctAnswer){
            resultText.text = "Correct!"
            resultText.setTextColor(Color.GREEN)
            score++

        }else{
            resultText.text = "Incorrect :("
            resultText.setTextColor(Color.RED)
        }
    btnTrue.isEnabled = false
    btnFalse.isEnabled = false
    btnNext.isEnabled = true
    }
}