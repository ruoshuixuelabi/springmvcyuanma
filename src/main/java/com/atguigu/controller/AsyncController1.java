package com.atguigu.controller;

import java.util.concurrent.Callable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.WebAsyncTask;

/**
 * @author Administrator
 */
@Controller
public class AsyncController1 {
    /**
     * 这里新建了WebAsyncTask,并使用匿名类建了Callable进行异步处理,
     * 实际使用中可以在其中写数据库请求等耗时的业务,这里直接等了5秒来模拟。
     * 处理器注释了@ResponseBody,其返回值会直接返回给浏览器。
     * 当调用"http://localhost:8080/webasynctask"时,会在等待大约5秒后返回给浏览器"久等了"三个字。
     */
    @ResponseBody
    @RequestMapping(value = "/webasynctask", produces = "text/plain; charset=UTF-8")
    public WebAsyncTask<String> webAsyncTask() {
        System.out.println("WebAsyncTask处理器主线程进入");
        WebAsyncTask<String> task = new WebAsyncTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5 * 1000L);
                System.out.println("WebAsyncTask处理执行中。。。");
                return "久等了";
            }
        });
        System.out.println("WebAsyncTask处理器主线程退出");
        return task;
    }
}
