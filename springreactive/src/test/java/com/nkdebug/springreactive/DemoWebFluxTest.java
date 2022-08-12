package com.nkdebug.springreactive;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class
DemoWebFluxTest {

    // mono (single) and flux (multiple)

    @Test
    public void testMono() {
        Mono<?> stringMono = Mono.just("nitesh")
                .then(Mono.error(new Exception("Mono Exception")))
                .log();
        stringMono.subscribe(System.out::println,(data) -> System.out.println(data.getMessage()));
    }

    @Test
    public void testFlux() {
        Flux<String> stringFlux = Flux.just("nkdebug","nitesh","blr")
                .concatWithValues("axis bank")
                .concatWith(Flux.error(new Exception("new Flux Error")))
                .concatWithValues("hdfc bank")
                .log();
        stringFlux.subscribe(System.out::println);
    }


}
