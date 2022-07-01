package com.example.onlineaplication;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Application;

@Path("hello")
public class HelloResorce {

    @GET
    public String sayHello(){
        return "Pozdrav";
    };
}
