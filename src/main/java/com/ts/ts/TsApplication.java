package com.ts.ts;

import com.ts.ts.task2.HashTableOpenAdress;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Optional;

@SpringBootApplication
public class TsApplication {

    public static void main(String[] args) {
//        SpringApplication.run(TsApplication.class, args);
        HashTableOpenAdress<String>  hashTableOpenAdress=new HashTableOpenAdress(29);
        hashTableOpenAdress.insert("w");
    }

}
