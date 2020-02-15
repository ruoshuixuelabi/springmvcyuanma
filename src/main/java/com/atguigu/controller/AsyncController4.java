package com.atguigu.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.AsyncRestTemplate;

/**
 * @author Administrator
 */
@Controller
public class AsyncController4 {
    @RequestMapping(value = "/listenable", produces = "text/plain; charset=UTF-8")
    public ListenableFuture<ResponseEntity<String>> listenableFuture() {
        return new AsyncRestTemplate().getForEntity(
                "http://localhost:8080/index", String.class);
    }
}
