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

    @Value("response.timeout=60}")
    private int timeout;


    @RequestMapping("/")
    public int queryTimeOut() {
        return this.timeout;
    }

}
