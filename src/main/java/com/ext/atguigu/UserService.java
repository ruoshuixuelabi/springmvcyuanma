package com.ext.atguigu;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 */
@Service
public class UserService {
    /**
     * 我们想让一个普通的Bean组件来监听ApplicationEvent发送的事件
     */
    @EventListener(classes = {ApplicationEvent.class})
    public void listen(ApplicationEvent event) {
        System.out.println("UserService。。监听到的事件：" + event);
    }
}
