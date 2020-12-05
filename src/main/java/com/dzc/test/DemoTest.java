package com.dzc.test;

import com.dzc.controller.UserController;
import com.dzc.service.UserService;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DemoTest {
    public static void main(String[] args) throws Exception {
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();

        UserService userService = new UserService();
        Field userServiceField = clazz.getDeclaredField("userService");
        // 设置Field对象的Accessible的访问标志位为Ture，就可以通过反射获取私有变量的值，在访问时会忽略访问修饰符的检查
        userServiceField.setAccessible(true);
//        System.out.println(userServiceField);
        String name = userServiceField.getName();
        name = name.substring(0,1).toUpperCase()+ name.substring(1);
        System.out.println("get"+name);
        String methodName = "set" + name;
        Method method = clazz.getMethod(methodName, UserService.class);
        Object invoke = method.invoke(userController, userService);
//        userServiceField.set(userController,userService);
        System.out.println(userController.getUserService());
    }
}
