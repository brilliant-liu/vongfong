package com.icop.vongfong.services;

import com.icop.vongfong.entities.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @author: liukj
 * @date: 2020/5/26
 * @description：
 */
@Component
public class ServicesHandler implements ServicesInterface{
    @Override
    public CommonResult services_ok() {
        return null;
    }

    @Override
    public CommonResult services_error() {
        return new CommonResult(200,"服务运行异常！",null);
    }

    @Override
    public CommonResult services_timeout(Long id) {
        return new CommonResult(200,"服务连接超时！超时时间(ms)：" + id,null);
    }

}
