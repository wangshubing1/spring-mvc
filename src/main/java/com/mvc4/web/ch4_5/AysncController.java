package com.mvc4.web.ch4_5;

import com.mvc4.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @Author: king
 * @Datetime: 2018/10/31
 * @Desc: TODO
 */
@Controller
public class AysncController {
    @Autowired
    PushService pushService;

    @RequestMapping(value="/defer")
    @ResponseBody
    public DeferredResult<String> deferredCall() {
        // 通过Service Bean获取异步更新的DeferredReuslt<String>
        return pushService.getAyncUpdateDeferredResult();
    }

}
