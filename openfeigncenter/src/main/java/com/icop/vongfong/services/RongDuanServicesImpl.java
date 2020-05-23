package com.icop.vongfong.services;

import com.icop.vongfong.entities.CommonResult;

/**
 * @author: liukj
 * @date: 2020/5/21
 * @description：
 */
public class RongDuanServicesImpl implements RongDuanServices {

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
