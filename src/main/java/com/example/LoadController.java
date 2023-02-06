package com.example;

import io.micronaut.context.annotation.Context;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@Context
public class LoadController {

  private final HttpStatusClient client;

  public LoadController(HttpStatusClient client)
  {
    this.client = client;
  }


  @Get("/load")
  public Mono<String> load(@QueryValue(value = "attempts", defaultValue = "1") int attempts) {

    return Flux.range(0, attempts)
        .flatMap(x->client.get())
        .collectList().map(results-> results.stream().findAny().orElse("nothing"));

  }
}
