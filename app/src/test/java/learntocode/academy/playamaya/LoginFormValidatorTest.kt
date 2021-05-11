package learntocode.academy.playamaya

//import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import com.google.common.truth.Truth.assertThat

@RunWith(JUnit4::class)
class loginFormValidatorTest{

    @Test
    fun `Username y password validos`() {
        val username = "thelegend27"
        val password = "bOrati5a!Mazin*"
        val validatedResult = loginFormValidator.validateInput(username, password)
        assertThat(validatedResult).isEqualTo(true)
    }

}