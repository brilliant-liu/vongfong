package com.icop.vongfong.controller;

import com.icop.vongfong.entities.CommonResult;
import com.icop.vongfong.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

/**
 * @author: liukj
 * @date: 2020/5/14
 * @description：
 */
@RestController
@Slf4j
public class OrderController {

    public static final String paymentUrl = "http://PAYCENTER/payment/";

    @Resource
    private RestTemplate getRestTemplate;

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return  getRestTemplate.postForObject(paymentUrl+"/create",payment,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> create(@PathVariable("id") Long id){
        return  getRestTemplate.getForObject(paymentUrl+"/get/"+id,CommonResult.class);
    }

    @PostMapping(value = "/consumer/upload")
    public CommonResult create(@RequestBody MultipartFile file) throws IOException {

        String originalFilename = file.getOriginalFilename();
        System.out.println("文件名称："+originalFilename);

        /*File files = new File("E:\\Documents\\image\\icon\\cooperation.png");
        postForm("https://sm.ms/api/v2/upload",file,"","V0RLYj7PRasfMMLkm3Y1asELGs5QqgET");
        .field("smfile",resource,"multipart/form-data")
                .field("format","json")*/

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        //headers.add("Content-Type","multipart/form-data");
        headers.add("Authorization","V0RLYj7PRasfMMLkm3Y1asELGs5QqgET");

        File s = new File(originalFilename);
        file.transferTo(s);

        MultiValueMap<String,Object> multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("format","json");
        multiValueMap.add("smfile",s);

        HttpEntity httpEntity = new HttpEntity(multiValueMap,headers);

        ResponseEntity<String> str = getRestTemplate.postForEntity("https://sm.ms/api/v2/upload",httpEntity,String.class);
        System.out.println("结果："+str.getBody());

        return new CommonResult(str.getStatusCodeValue(),"..........",str.getBody());
    }

}
