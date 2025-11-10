package BookerAPIAuto;

import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import utils.jsonDataReader;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class validateGetBooking{
    @Test
    public void getBookingwith_single_id() throws IOException, ParseException {
        String FirstName = jsonDataReader.getJsonData("firstname");
        String lastname = jsonDataReader.getJsonData("lastname");
        //String totalprice = jsonDataReader.getJsonData("totalprice");
        //String depositpaid = jsonDataReader.getJsonData("depositpaid");
        Response resp = given()
                .header("Content-Type", "application/json")
                .pathParam("id",1)
                .when()
                .get("https://restful-booker.herokuapp.com/booking/{id}");
        System.out.println(resp.getBody().asString());

        assertThat(FirstName, equalTo("Sally"));
        assertThat(lastname, equalTo("Brown"));
        //assertThat(totalprice, equalTo("111"));
        //assertThat(depositpaid, equalTo("true"));
        System.out.println("Working dir: " + new File(".").getAbsolutePath());
        System.out.println("firstname => " + utils.jsonDataReader.getJsonData("firstname"));
    }
    @Test
    public void getBookingwith_multiple_id(){
        Response resp = given()
                .header("Content-Type", "application/json")
                .pathParam("id",1)
                .pathParam("id",4)
                .when()
                .get("https://restful-booker.herokuapp.com/booking/{id}");

    }
}