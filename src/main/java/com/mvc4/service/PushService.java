package com.mvc4.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @Author: king
 * @Datetime: 2018/10/31
 * @Desc: TODO
 */
@Service
public class PushService {
    private DeferredResult<String> deferredResult ;

    public DeferredResult<String> getAyncUpdateDeferredResult() {
        this.deferredResult = new DeferredResult<>();
        return deferredResult;
    }

    /**以下说明通过查看@Scheduled注解获得。
     * 由于@Scheduled注解的处理是通过注册一个ScheduledAnnotationBeanPostProcessor完成的，
     * 而后者是对方法被@Scheduled注解了的Bean，按照该注解的要求，
     * 通过调用一个TaskScheduler进行post process。
     * 因此对于实例化的Bean，必须完成@Scheduled注解的方法后才能被调用。
     */
    @Scheduled(fixedDelay=5000)
    public void refresh() {
        if (this.deferredResult != null) {
            this.deferredResult.setResult(String.valueOf(System.currentTimeMillis()));
        }
    }

}
