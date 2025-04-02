/*By leah:18 Sept 2018
*https://www.leahitsines.com.au/collections/breakfast
* [30 March 2025]
*
* By  Abdalla: March 18, 2025
* https://cookingwithzahra.com/beef-lasagne/
* [30 March 2025]
*/


package vcmsa.ci.whattoeat

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

   private var editInput: EditText? = null
   private var textMenu: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        editInput=findViewById(R.id.editInput)
        textMenu=findViewById(R.id.textMenu)

        val checkBtn = findViewById<Button>(R.id.checkBtn)
        val exitButton = findViewById<Button>(R.id.exitButton)
        val clearButton = findViewById<Button>(R.id.clearButton)

        checkBtn.setOnClickListener {
            check()
        }

        exitButton.setOnClickListener{
            finishAffinity()
            exitProcess(1)
        }

        clearButton.setOnClickListener {
            editInput?.text?.clear()
            textMenu?.text=""
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun check(){ when (editInput?.text.toString().trim()){


          "morning" -> {
            textMenu?.text ="BREAKFAST:" + " Eggs and Toast |" + "Choc Raspberry Overnight Oats|" + " Hard-boiled eggs |" + " Oatmeal |" + " Pancakes |" + " French Toast |" + "  Cerenals | "
      }

          "mid morning" -> {
            textMenu?.text =
                "LIGHT SNACK:" + " Toast with Avovado |" + " Cookies |" + " Yogurt Toast |" + " Muffins |" + " Blueberry Smoothies |"
        }
          "afternoon" -> {
            textMenu?.text =
                "LUNCH:" + " Olive Salads |" + " Chicken Soup |" + " Hake and Chips/Rice |" + " Buffalo Wings |" + " Sushi  |" + " Apple Pie |" +" Ham Burger| "
        }
         "mid afternoon" -> {
           textMenu?.text =
               "QUICK BITES:" + " Nuts |" + " Yogurt |" + " Protein Balls |" + " Oat Muffins |" + " Smoothies |" + " Carrot Cake |" + "| Chocolate Muse |"
        }
         "dinner" -> {
             textMenu?.text =
                 "MAIN COURSE:" + " Beef Lasagne |" + "Roast Lamb with Gravy |" + " Roast Chicken |" +" Pap and Wors |" + " Spaghetti and Meatballs|"
         }




        else -> {
            textMenu?.text = "Enter time of day e.g (mid morning, afternoon)"
            editInput?.error="invalid time of day!!"
        }
    }}

}