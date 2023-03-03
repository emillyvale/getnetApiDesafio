



package com.emilly.testesdbc;

import com.emilly.pojo.Usuario;
import io.restassured.http.ContentType;
import org.junit.Test;
//import static io.restassured.module.jsv.JsonSchemaValidator.*
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.equalToPath;

public class ApiTests {

    @Test
    public void testApi(){
        baseURI = "https://reqres.in";
        basePath = "/api";

        Usuario usuario = new Usuario();
        usuario.setName("morpheus");
        usuario.setJob("leader");

        given()
                .contentType(ContentType.JSON)
                    .body(usuario)
            .when()
                .post("/users")
            .then()
                .assertThat()
                .statusCode(201)
                .body("data.name", equalToPath("morpheus"))
                .body("data.job", equalToPath("leader"));
    }
}