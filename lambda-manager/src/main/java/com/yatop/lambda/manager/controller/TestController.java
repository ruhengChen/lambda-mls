package com.yatop.lambda.manager.controller;

import com.yatop.lambda.manager.api.request.TestBody;
import com.yatop.lambda.manager.api.response.JsonResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(value = "/test")
    public JsonResponse testMethod(@RequestBody TestBody ztf) {
        return JsonResponse.build(ztf);
    }
}
