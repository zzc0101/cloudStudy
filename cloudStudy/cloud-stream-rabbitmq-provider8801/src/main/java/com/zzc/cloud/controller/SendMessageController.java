package com.zzc.cloud.controller;

import com.zzc.cloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : zzc0101
 * @date : 2022-10-22 15:15
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider ;

    @GetMapping(value = "/sendMessage" )
    public String sendMessage() {
        return messageProvider.send();
    }

}
