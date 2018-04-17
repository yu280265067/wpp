package com.ycx.wpp.web;
import com.ycx.wpp.core.domain.dataobject.TUser;
import com.ycx.wpp.core.service.TuserService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;


/**
 * Created by apple on 2018/3/3.
 */
@RestController
@ComponentScan(basePackages = "com.ycx")
public class HelloController {
    @Resource
    TuserService helloService;

    @RequestMapping("/")
    @ResponseBody
    public String index() throws ExecutionException, InterruptedException {
        TUser user = helloService.queryUser();
        return user.toString();
    }

}
