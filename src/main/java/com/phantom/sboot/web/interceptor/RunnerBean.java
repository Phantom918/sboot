package com.phantom.sboot.web.interceptor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class RunnerBean implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作<<<<<<<<<<<<<");
        System.out.println("strings====" + Arrays.toString(strings));
    }
}
