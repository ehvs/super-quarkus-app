package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.inject.Inject;

import io.micrometer.core.instrument.MeterRegistry;

@Path("/hello")
public class GreetingsResource {

    @Inject
    MeterRegistry registry;

    @GET
    public String sayHello() {
        registry.counter("greeting_counter").increment();

        return "Hello!";
    }
}
