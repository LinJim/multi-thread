package com.leafyun.jim;

import com.leafyun.jim.createThread.Thread1;
import com.leafyun.jim.createThread.Thread2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.HashMap;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiThreadApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testCreateThread1() {
        Thread1 thread1 = new Thread1();
        thread1.start();
        //thread1.start();
    }

    @Test
    public void testCreateThread2() {
        System.out.println(Math.pow(2,32));
    }

}

