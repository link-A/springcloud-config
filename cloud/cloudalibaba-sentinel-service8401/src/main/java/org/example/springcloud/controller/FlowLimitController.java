package org.example.springcloud.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String getTestA(){
        try {
            TimeUnit.MILLISECONDS.sleep(800);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "--->testA";
    }

    @GetMapping("/testB")
    public String getTestB(){
//        nihao();
        log.info(Thread.currentThread().getName()+"-->testB");
        return "--->testB";
    }

    @GetMapping("/testC")
    public String getTestC(){
        nihao();
        return "--->testC";
    }
//    @SentinelResource("nihao")
    public static void nihao(){
        System.out.println("已调用静态方法nihao");
    }
    @GetMapping("/testD")
    public String testD()
    {
        //暂停几秒钟线程  测试熔断规则：慢调用比例
//        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
//        log.info("testD 测试RT");
//        return "------testD";
        //测试熔断规则：异常比例，异常数
        log.info("testD 测试RT");
        int age = 10/0;
        return "------testD";
    }
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "dealHandler_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        return "------testHotKey";
    }
    public  String dealHandler_testHotkey(String p1,String p2,BlockException exception){
        return "-----dealHandler_testHotKey";
    }
}
