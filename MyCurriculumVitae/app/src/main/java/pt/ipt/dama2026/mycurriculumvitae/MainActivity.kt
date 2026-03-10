package pt.ipt.dama2026.mycurriculumvitae

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.inputmethod.InputMethodManager


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

        // se o utilizador 'clicou' no botão, avalia se se pode mostrar o Currículo
        findViewById<Button>(R.id.button).setOnClickListener {
            mostraCurriculum(it)
        }


    }

    /**
     * Mostra o Currículo do utilizador,
     * se o utilizador cumprir com as condições para apresentação
     */
    fun mostraCurriculum(view: View) {
        /*
         * Condições para apresentar o Currículo:
         * se (foi escrita a palavra SIM na textbox), mostra Currículo
         *    torna visível o Currículo
         *    torna invisível a textbox
         *    torna invisível o botão
         *    esconder o teclado
         * senão, nada faz
         */

        // criar 'ponteiro' para a textbox
        val txt=findViewById<EditText>(R.id.editTextText)

        // avaliar o conteúdo
        if (txt.text.toString().uppercase().equals("SIM")) {
            // mostrar Currículo
            findViewById<TextView>(R.id.curriculum).visibility= View.VISIBLE
            // esconder textbox
            txt.visibility=View.GONE
            // esconder o botão
            findViewById<Button>(R.id.button).visibility=View.GONE

            // esconder o teclado
            val imm=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken,0)
        }



    }
}