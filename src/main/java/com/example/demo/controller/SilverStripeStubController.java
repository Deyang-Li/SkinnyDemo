package com.example.demo.controller;

import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

@RestController
public class SilverStripeStubController
{
    @GetMapping("/v1/identity/users/migration/skinny-mobile/stevenli00106@gmail.com/byemail")
    public String fetchIdentityByEmail(@RequestHeader("x-silverstripe-api-key") String key)
    {
        ClassLoader classLoader = getClass().getClassLoader();
        String json = "";
        try(InputStream stream = classLoader.getResourceAsStream("static/getSilverstripeIdentitySuccess.json")) {
            json = StreamUtils.copyToString(stream, Charset.forName("UTF-8"));
        } catch (IOException ioe) {
        }
        return json;
    }
}
