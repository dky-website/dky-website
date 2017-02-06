package com.dky.web.config;

import com.dky.common.constats.GlobConts;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * Created by wonpera on 2017/1/3.
 */
@Configuration
public class WebConfig {

    @Bean(name = "gsonFormatter")
    public Gson getFormatterGson(){
        return new GsonBuilder().setDateFormat(GlobConts.DEFAULT_FORMATTER_YYYYMMDDHHMMSS).create();
    }

    public static void main(String[] args) {
        Date date = new Date();
        Gson gson = new GsonBuilder().setDateFormat(GlobConts.DEFAULT_FORMATTER_YYYYMMDDHHMMSS).create();
        System.out.println(gson.toJson(date));
    }
}
