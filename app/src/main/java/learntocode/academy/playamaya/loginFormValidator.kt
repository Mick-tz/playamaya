package learntocode.academy.playamaya

import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

object LoginFormValidator {
    // Default validation messages
    private val PASSWORD_POLICY = """La contraseña debe tener al menos 8 caracteres,
            |debe contener al menos una letra mayúscula,
            |debe contener al menos una letra minúscula,
            |debe contener al menos un número,
            |y al menos uno de los siguientes caracteres especiales ~!@#$%^&*()-_=+|[]{};:'\",<.>/?""".trimMargin()


    /**
     * Retrieve string data from the parameter.
     * @param data - can be EditText or String
     * @return - String extracted from EditText or data if its data type is Strin.
     */
    private fun getText(data: Any): String {
        var str = ""
        if (data is EditText) {
            str = data.text.toString()
        } else if (data is String) {
            str = data
        }
        return str
    }

    /**
     * Sets error on EditText or TextInputLayout of the EditText.
     * @param data - Should be EditText
     * @param error - Message to be shown as error, can be null if no error is to be set
     */
    private fun setError(data: Any, error: String?) {
        if (data is EditText) {
            if (data.parent.parent is TextInputLayout) {
                (data.parent.parent as TextInputLayout).setError(error)
            } else {
                data.setError(error)
            }
        }
    }


    /**
     * Checks if the username is valid as per the following policy.
     * Should be minimum minimum 6 characters long.
     * @param username - can be EditText or String
     * @return - true if the username is valid as per the username policy.
     */
    fun isValidUsername(username: Any): Boolean {
        val userStr = getText(username)
        return userStr.length > 5
    }

    /**
     * Checks if the password is valid as per the following password policy.
     * Password should be minimum minimum 8 characters long.
     * Password should contain at least one number.
     * Password should contain at least one capital letter.
     * Password should contain at least one small letter.
     * Password should contain at least one special character.
     * Allowed special characters: "~!@#$%^&*()-_=+|/,."';:{}[]<>?"
     *
     * @param pwd - can be EditText or String
     * @return - true if the password is valid as per the password policy.
     */
    fun isValidPwd(pwd: Any): Boolean {
        val str = getText(pwd)
        if (str.length < 8) {
            return false
        }
        // se valida que la contraseña tenga al menos un número
        var exp = ".*[0-9].*"
        var pattern = Pattern.compile(exp, Pattern.CASE_INSENSITIVE)
        var matcher = pattern.matcher(str)
        if (!matcher.matches()) {
            return false
        }

        // se valida que la contraseña tenga al menos una letra mayuscula
        exp = ".*[A-Z].*"
        pattern = Pattern.compile(exp)
        matcher = pattern.matcher(str)
        if (!matcher.matches()) {
            return false
        }

        // se valida que la contraseña tenga al menos una letra minúscula
        exp = ".*[a-z].*"
        pattern = Pattern.compile(exp)
        matcher = pattern.matcher(str)
        if (!matcher.matches()) {
            return false
        }

        // se valida que la contraseña tenga al menos un caracter especial
        exp = ".*[~!@#\$%\\^&*()\\-_=+\\|\\[{\\]};:'\",<.>/?].*"
        pattern = Pattern.compile(exp)
        matcher = pattern.matcher(str)
        if (!matcher.matches()) {
            return false
        }
        return true
    }

    /**
     * Checks if the password and username are valid as per the aforementioned policies.
     *
     * @param username - can be EditText or String
     * @param pwd - can be EditText or String
     * @return - true if both the password and username are valid as per the aforementioned policies.
     */
    fun validateInput(username: Any, pwd: Any, updateUI: Boolean = false): Boolean {
        // Set error if required
        if (updateUI) {
            val error: String? = if (isValidPwd(pwd) && isValidUsername(username)) null else PASSWORD_POLICY
            setError(username, error)
        }
        return isValidPwd(pwd) && isValidUsername(username)
    }
}