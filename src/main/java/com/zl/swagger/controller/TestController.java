package com.zl.swagger.controller;

import com.zl.swagger.controller.data.AuthBodyRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/hello")
@Api("台风主页")
public class TestController {

    @Value("#{'${platform.packages}'.split(',')}")
    ArrayList<String> packages;

    @ApiOperation(value = "验证平台是否授权", notes = "备注")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "packageName", paramType = "query",
                    dataType = "String", value = "包名", required = true),
            @ApiImplicitParam(name = "macAddress", paramType = "query",
                    dataType = "String", value = "mac地址")})
    @RequestMapping(value = "/isAuth", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    public String isAuth(AuthBodyRequest auth) {
        if(auth.getPackageName().isBlank()) {
            return "包名不能为空";
        }
        if(!(packages.contains(auth.getPackageName()))) {
            System.out.println("用户没有权限");
            return "用户没有权限";
        }
        return "true";
    }
}
