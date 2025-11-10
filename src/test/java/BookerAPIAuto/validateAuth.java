package BookerAPIAuto;

import core.StatusCode;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.credRequest;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class validateAuth {
    @Test
    public void validateAuthwithValidCred (){
        credRequest cr =  new credRequest();
        cr.setUsername("admin");
        cr.setPassword("password123");
        Response resp = given()
                .header("Content-Type","application/json")
                .body(cr)
                .when()
                .post("https://restful-booker.herokuapp.com/auth");
        assertEquals(201, StatusCode.CREATED.code);
    }
    @Test
    public void validateAuthwithIncorrectUserName(){
        credRequest cr =  new credRequest();
        cr.setUsername("admin1");
        cr.setPassword("password123");
        Response resp = given()
                .header("Content-Type","application/json")
                .body(cr)
                .when()
                .post("https://restful-booker.herokuapp.com/auth");
        assertEquals(401, StatusCode.UNAUTHORIZED.code);
    }
    @Test
    public void validateAuthwithBlankUserName(){
        credRequest cr =  new credRequest();
        cr.setUsername("");
        cr.setPassword("password123");
        Response resp = given()
                .header("Content-Type","application/json")
                .body(cr)
                .when()
                .post("https://restful-booker.herokuapp.com/auth");
        assertEquals(400, StatusCode.BAD_REQUEST.code);
    }
    @Test
    public void validateAuthwithBlankPassword(){
        credRequest cr =  new credRequest();
        cr.setUsername("admin");
        cr.setPassword("");
        Response resp = given()
                .header("Content-Type","application/json")
                .body(cr)
                .when()
                .post("https://restful-booker.herokuapp.com/auth");
        assertEquals(400, StatusCode.BAD_REQUEST.code);
    }
    @Test
    public void validateAuthwithIncorrectPassword(){
        credRequest cr =  new credRequest();
        cr.setUsername("admin");
        cr.setPassword("password1234");
        Response resp = given()
                .header("Content-Type","application/json")
                .body(cr)
                .when()
                .post("https://restful-booker.herokuapp.com/auth");
        assertEquals(401, StatusCode.UNAUTHORIZED.code);
    }
    @Test
    public void validateAuthwithInvalidPassword(){
        credRequest cr =  new credRequest();
        cr.setUsername("admin");
        cr.setPassword("@#$");
        Response resp = given()
                .header("Content-Type","application/json")
                .body(cr)
                .when()
                .post("https://restful-booker.herokuapp.com/auth");
        assertEquals(400, StatusCode.BAD_REQUEST.code);
    }
    @Test
    public void validateAuthwithForbidden(){
        credRequest cr =  new credRequest();
        cr.setUsername("admin");
        cr.setPassword("password123");
        Response resp = given()
                .header("Content-Type","application/json")
                .body(cr)
                .when()
                .post("https://restful-booker.herokuapp.com/auth");
        assertEquals(403, StatusCode.FORBIDDEN.code);
    }
}
