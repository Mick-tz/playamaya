package learntocode.academy.playamaya

//import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import com.google.common.truth.Truth.assertThat

@RunWith(JUnit4::class)
class LoginFormValidatorTest{

    @Test
    fun `Username valido isValidUsername`() {
        val username = "thelegend27"
        val validatedResult = LoginFormValidator.isValidUsername(username)
        assertThat(validatedResult).isEqualTo(true)
    }

    @Test
    fun `Password valido isValidPassword`() {
        val password = "bOrati5a!Mazin*"
        val validatedResult = LoginFormValidator.isValidPwd(password)
        assertThat(validatedResult).isEqualTo(true)
    }

    @Test
    fun `Username y password validos`() {
        val username = "thelegend27"
        val password = "bOrati5a!Mazin*"
        val validatedResult = LoginFormValidator.validateInput(username, password)
        assertThat(validatedResult).isEqualTo(true)
    }


    @Test
    fun `Username invalido isValidUsername`() {
        val username = "lege"
        val validatedResult = LoginFormValidator.isValidUsername(username)
        assertThat(validatedResult).isEqualTo(false)
    }


    @Test
    fun `Password invalido, no tiene mayusculas isValidPassword`() {
        val password = "borati5a!mazin*"
        val validatedResult = LoginFormValidator.isValidPwd(password)
        assertThat(validatedResult).isEqualTo(false)
    }

    @Test
    fun `Password invalido, no tiene minusculas isValidPassword`() {
        val password = "BORATI5A!MAZIN*"
        val validatedResult = LoginFormValidator.isValidPwd(password)
        assertThat(validatedResult).isEqualTo(false)
    }

    @Test
    fun `Password invalido, no tiene caracteres especiales isValidPassword`() {
        val password = "bOrati5aMazin"
        val validatedResult = LoginFormValidator.isValidPwd(password)
        assertThat(validatedResult).isEqualTo(false)
    }

    @Test
    fun `Password invaldio, no tiene numeros isValidPassword`() {
        val password = "bOratia!Mazin*"
        val validatedResult = LoginFormValidator.isValidPwd(password)
        assertThat(validatedResult).isEqualTo(false)
    }

    @Test
    fun `Password invaldio, tiene menos de 8 caracteres isValidPassword`() {
        val password = "bO!M4n*"
        val validatedResult = LoginFormValidator.isValidPwd(password)
        assertThat(validatedResult).isEqualTo(false)
    }

    @Test
    fun `Username y password invalidos`() {
        val username = "lege"
        val password = "password"
        val validatedResult = LoginFormValidator.validateInput(username, password)
        assertThat(validatedResult).isEqualTo(false)
    }
}