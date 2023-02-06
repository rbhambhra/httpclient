package com.example;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import reactor.core.publisher.Mono;

@Client("httpstatus")
public interface HttpStatusClient {

  @Get("/200")
  Mono<String> get();
}
