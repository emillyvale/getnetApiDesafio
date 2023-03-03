package com.emilly.testesdbc;

import com.emilly.pojo.Usuario;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ApiTesteContrato {

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
                    .body(matchesJsonSchemaInClasspath("schemas/contrato.json"))
        ;
    }
}
