package learntocode.academy.playamaya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var helpTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usernameEditText: EditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText: EditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton: Button = findViewById<Button>(R.id.loginButton)
        val registerButton: Button = findViewById<Button>(R.id.registerButton)
        helpTextView = findViewById<TextView>(R.id.helpTextView)

        helpTextView?.text = ""

        loginButton.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                if (LoginFormValidator.validateInput(usernameEditText as Any, passwordEditText as Any)) {
                    helpTextView?.text = "Validando password y username!"
                } else {
                    helpTextView?.text = "Nombre de usuario o password incorrectos"
                }
            }
        })
    }
}