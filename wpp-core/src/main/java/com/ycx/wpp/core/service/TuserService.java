package com.ycx.wpp.core.service;

import com.google.common.collect.Lists;
import com.ycx.wpp.core.dao.TUserMapper;
import com.ycx.wpp.core.domain.dataobject.TUser;
import com.ycx.wpp.core.hystrix.command.BaseHystrix;
import com.ycx.wpp.core.hystrix.command.HystrixCommandGroupKeyEnum;
import org.springframework.stereotype.Service;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
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

    public TUser queryUserByObserve() throws ExecutionException, InterruptedException {
        Observable<List<TUser>> userObservable = observableGetUser();
        final List<TUser> userList = new ArrayList<TUser>();
        userObservable.subscribe(new Subscriber<List<TUser>>(){
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<TUser> t){
                userList.addAll(t);
            };
        });
        return userList.get(0);
    }




    public Observable<List<TUser>> observableGetUser () {
        TUser result = tUserMapper.selectByPrimaryKey(8);
        return Observable.just(Lists.newArrayList(result));
    }
}
