package com.udemy.monitoring.boundary;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rene on 28/01/16.
 */

@RefreshScope
@RestController
@RequestMapping("/metadata")
public class MetadataController {

    @Value("${metadata.timeOut}")
    private int timeOut;

    @Value("${configuration.domain}")
    private String domain;

    @RequestMapping("/timeout")
    public int getTimeOut() {
        return this.timeOut;
    }

    @RequestMapping("/domain")
    public String getDomain() {
        return this.domain;
    }

}
