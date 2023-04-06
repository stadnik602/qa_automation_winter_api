package api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.reqres.config.RegisterHttpRequest;
import org.reqres.dto.request.Register;
import org.reqres.dto.response.SuccessRegisterResponseDto;

public class RegisterTest {
    private static SuccessRegisterResponseDto successRegisterResponseDto;
    private static RegisterHttpRequest registerHttpRequest;

    private static String testEmail;
    private static String testPassword;

    @BeforeAll
    public static void setUp() {
        successRegisterResponseDto = new SuccessRegisterResponseDto();
        registerHttpRequest = new RegisterHttpRequest();
        testEmail = "eve.holt@reqres.in";
        testPassword =  "pistol";
    }
    @Test
    public void successfulRegister() {
        Register newUser = new Register(testEmail, testPassword);
        successRegisterResponseDto = registerHttpRequest.registerNewClient(newUser)
                .then()
                .statusCode(200)
                .extract().as(SuccessRegisterResponseDto.class);
        int actualId = successRegisterResponseDto.getId();
        String actualToken = successRegisterResponseDto.getToken();
        Assertions.assertTrue(!actualToken.isEmpty());
        Assertions.assertTrue(actualId != 0);
    }

    @Test
    public void unsuccessfulRegister() {
        int statusCode = registerHttpRequest.registerNewClient(new Register(testEmail, ""))
                .then()
                .statusCode(400)
                .extract().statusCode();
        Assertions.assertEquals(400, statusCode);
    }
}
