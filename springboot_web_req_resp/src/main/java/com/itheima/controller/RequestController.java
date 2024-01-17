package com.itheima.controller;

import com.itheima.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.buf.UEncoder;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/*
* 测试请求数据接受
*
* */
@RestController
public class RequestController {
    //加注解指定请求路径

//    @RequestMapping("/simpleParam")
//    public String simpleParam(HttpServletRequest request){
//        //通过request获取参数
//        String name = request.getParameter("name");
//        String agestr = request.getParameter("age");
//        int age =Integer.parseInt(agestr);
//        System.out.println(name+":"+age);
//        return "ok";
//    }

    //springboot启动方式
    @RequestMapping("/simpleParam")
    public String simpleParam(@RequestParam(name="name",required = false) String username, Integer age){//自动类型转换
        //@requestParam中的require属性默认为true，代表该请求参数必须传递，如果不传递将报错，如果该参数是可选的，可以将required属性设置为false
        System.out.println(username +":"+age);
        return "ok";
    }
    //实体参数
    @RequestMapping("/simplePojo")
    public  String simplePojo(User user){
        System.out.println(user);
        return "ok";
    }
    @RequestMapping("/complexPojo")
    public  String complexPojo(User user){
        System.out.println(user);
        return "ok";
    }
    //数组封装
    @RequestMapping("/arrayParam")
    public  String arrayParam(String[] hobby){
        System.out.println(Arrays.toString(hobby));
        return "ok";
    }
    //集合封装 形参保持一直 需要加注解@requestParam绑定参数关系
    @RequestMapping("/listParam")
    public  String listParam(@RequestParam List<String> hobby){
        System.out.println(hobby );
        return "ok";
    }
    //日期参数：使用@DateTimeFormat注解完成日期参数格式转换
    @RequestMapping("/dateParam")
    public  String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")LocalDateTime updatetime){
        System.out.println(updatetime);
        return "ok";
    }
    //json参数，json数据键名与形参对象属性名相同，定义Pojo类型形参即可接受参数，需要使用@RequestBody标识
    @RequestMapping("/jsonParam")
    public  String jsonParam(@RequestBody User user){
        System.out.println(user);
        return "ok";
    }
    //路径参数：通过请求URL直接传递参数。使用{...}来标识该路径参数,需要使用@PathVariable获取路径参数
    @RequestMapping("/path/{id}")
    public String pathParam(@PathVariable Integer id){
        System.out.println(id);
        return "ok";
    }
    @RequestMapping("/path/{id}/{name}")
    public String pathParam(@PathVariable Integer id,@PathVariable String name){
        System.out.println(name+":"+id);
        return "ok";
    }

}
