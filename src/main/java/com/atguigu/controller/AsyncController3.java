package com.atguigu.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * (1)DeferredResult是Spring提供的一种用于保存延迟处理结果的类,
 * 当一个处理器返回DeferredResult类型的返回值时将启动异步处理。
 * (2)不过DeferredResult和WebAsyncTask的使用方法完全不同,DeferredResult并不是用于处理请求的,
 * 而且也不包含请求的处理过程,它是用来封装处理结果的,有点像Java中的Future,但不完全一样。
 * (3)使用DeferredResult的难点就在理解其含义,对其含义理解了之后就会觉得非常简单,而且使用起来也很方便。
 * 在返回WebAsyncTask时是因为处理的时间过长所以使用了异步处理,但其实还是自己来处理的(因为WebAsyncTask
 * 需要提供Callable),而返回DeferredResult表示要将处理交个别人了,什么时候处理完、怎么处理的自己并不需要知道,
 * 这就好像在单位经常用到的"妥否，请批示"的请示报告,自己并不知道什么时候能批下来,而且也不需要知道具体批示过程,
 * 只需要知道最后的结果就可以了,DeferredResult就是来保存结果的,当处理完之后调用它的setResult方法将结果设置给它就可以了。
 * (4)DeferredResult还提供了一些别的属性,如resultHandler可以在设置了结果之后对结果进行处理、
 * timeout设置超时时间、timeoutCallback设置超时处理方法、
 * completionCallback设置处理完成后的处理方法、timeoutResult设置超时后返回的结果等。
 *
 * @author dep
 */
@Controller
public class AsyncController3 {
    /**
     * (1)在处理器方法中直接新建了个DeferredResult类型的result代表处理结果,
     * 构造方法的两个参数分别表示超时时间和超时后返回的结果,建出来后将其交给approve方法进行处理(审批),
     * 当approve方法给result使用setResult方法设置了值后异步处理就完成了。
     * (2)approve方法启动了一个新线程,然后在里面等待5秒后给result设置值。
     * 因为这里的处理器有@ResponseBody注释,所以返回值会直接显示到浏览器,当调用"http://localhost:8080/deferred"时,
     * 浏览器会在过大约5秒后显示“同意2015-04-02”。
     */
    @ResponseBody
    @RequestMapping(value = "/deferred", produces = "text/plain; charset=UTF-8")
    public DeferredResult<String> deferredResultExam() {
        final DeferredResult<String> result = new DeferredResult<String>(7 * 1000L, "超时了");
        approve(result);
        return result;
    }

    private void approve(DeferredResult<String> result) {
        Runnable r = () -> {
            try {
                Thread.sleep(5 * 1000L);
                result.setResult("同意 " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        new Thread(r).start();
    }
}
