package com.ycx.wpp.web;
import com.ycx.wpp.core.domain.dataobject.TUser;
import com.ycx.wpp.core.process.WppProcess;
import com.ycx.wpp.core.service.TuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutionException;


/**
 * Created by apple on 2018/3/3.
 */
@RestController("/")
public class HelloController {
    @Resource
    TuserService helloService;

    @Value("${spring.datasource.url}")
    private String datasource;

    @Autowired(required = false)
    private List<WppProcess> wppProcesses;

    @RequestMapping("getUserV1")
    @ResponseBody
    public String index() throws ExecutionException, InterruptedException {
        TUser user = helloService.queryUser();
        System.out.println(datasource);
        return user.toString();
    }


    @RequestMapping("getUserV2")
    @ResponseBody
    public String queryUserByObserve() throws ExecutionException, InterruptedException {
        TUser user = helloService.queryUserByObserve();
        return user.toString();
    }

    @RequestMapping("testBean")
    @ResponseBody
    public String testBeanInit() throws ExecutionException, InterruptedException {
        System.out.println(wppProcesses);
        wppProcesses.stream().forEach(e->{e.process(1);});
        return "";
    }

    @RequestMapping("testBeanV2")
    @ResponseBody
    public String testBeanReplace() throws ExecutionException, InterruptedException {
        System.out.println(helloService);
        TuserService tuserServiceTemp = new TuserService();
        this.helloService = tuserServiceTemp;
        TuserService tuserService = this.helloService;
        System.out.println(tuserService);
        TUser user = helloService.queryUserByObserve();
        return user.toString();

    }
}
