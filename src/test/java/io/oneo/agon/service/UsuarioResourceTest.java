package io.oneo.agon.service;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

@QuarkusTest
public class UsuarioResourceTest
{

    @Test
    public void stringTest()
    {
        var p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        var m = p.matcher("I am a string");
        var b = m.find();

        if (b)
            System.out.println("EHNOIZ");
    }

}