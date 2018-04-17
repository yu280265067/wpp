package com.ycx.wpp.core.service;

import com.ycx.wpp.core.dao.TUserMapper;
import com.ycx.wpp.core.domain.dataobject.TUser;
import com.ycx.wpp.core.hystrix.command.BaseHystrix;
import com.ycx.wpp.core.hystrix.command.HystrixCommandGroupKeyEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.*;

/**
 * Created by apple on 2018/4/12.
 */
@Service
public class TuserService {
    @Resource
    private TUserMapper tUserMapper;

    public TUser queryUser() throws ExecutionException, InterruptedException {

        Future<TUser> t = new BaseHystrix.WmHystrixCommand<TUser>(HystrixCommandGroupKeyEnum.SENSITIVE_WORD_VALIDATE_COMMAND){
            @Override
            protected void doBiz() throws Exception {
                result = tUserMapper.selectByPrimaryKey(8);
            }

            @Override
            protected TUser getFallback(){
                System.out.println("fallback");
                return new TUser();
            }
        }.queue();


        return t.get();
    }
}
