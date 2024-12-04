import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginAppTest {

    private LoginApp loginApp;

    // This method will set up a new instance of LoginApp before each test.
    @BeforeEach
    public void setup() {
        loginApp = new LoginApp();  // Create an instance of the LoginApp class before each test.
    }

    // Test case 1: Test Empty Fields (Email and Password)
    @Test
    public void testEmptyFields() {
        String email = "";
        String password = "";

        // Attempt authentication with empty email and password
        String result = loginApp.authenticateUser(email, password);

        // Assert that the result is null (login should fail)
        assertNull(result, "Authentication should fail when both email and password are empty.");

        
    }

    // Test case 2: Test Valid Login Credentials
    @Test
    public void testValidLogin() {
        String email = "john.doe@example.com";
        String password = "correctPassword";

        // Simulate a valid user in the database (this user should exist in your test DB)
        String expectedUserName = "John Doe";
        
        // Perform authentication
        String result = loginApp.authenticateUser(email, password);

        // Assert that the user is authenticated and the correct username is returned
        assertNotNull(result, "Authentication should succeed for valid credentials.");
        assertEquals(expectedUserName, result, "Authentication should return the correct user name.");
    }

    // Test case 3: Test Invalid Login (Incorrect Email/Password)
    @Test
    public void testInvalidLogin() {
        String email = "wrong.email@example.com";
        String password = "wrongPassword";

        // Attempt authentication with incorrect credentials
        String result = loginApp.authenticateUser(email, password);

        // Assert that the result is null because the credentials are incorrect
        assertNull(result, "Authentication should fail for incorrect email or password.");

        
    }

    // Test case 4: Test Empty Email (Password Provided)
    @Test
    public void testEmptyEmail() {
        String email = ""; // Empty email
        String password = "password123"; // Valid password

        // Attempt authentication with an empty email
        String result = loginApp.authenticateUser(email, password);

        // Assert that the result is null because the email is required
        assertNull(result, "Authentication should fail when email is empty.");
        assertNotEquals(password, result, "Password should not be used if email is empty.");

       
    }

    // Test case 5: Test Empty Password (Email Provided)
    @Test
    public void testEmptyPassword() {
        String email = "john.doe@example.com"; // Valid email
        String password = ""; // Empty password

        // Attempt authentication with an empty password
        String result = loginApp.authenticateUser(email, password);

        // Assert that the result is null because the password is required
        assertNull(result, "Authentication should fail when password is empty.");
        assertNotEquals(email, result, "Email should not be used for authentication without password.");

        
    }
}
