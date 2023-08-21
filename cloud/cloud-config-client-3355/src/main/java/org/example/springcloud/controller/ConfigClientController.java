package org.example.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${server.port}")
    public String serverPort;
    @Value("${config.info}")
    public String configInfo;
    @GetMapping("/configInfo")
    public String getConfig(){
        return "ServerPort:  "+serverPort+"  ConfigPort:"+configInfo;
    }
}
