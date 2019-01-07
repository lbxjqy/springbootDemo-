package com.example.demo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class BlogProperties {
    @Value("${com.didispace.blog.name}")
    private String name;
    @Value("${com.didispace.blog.title}")
    private String title;
    @Value("${com.didispace.blog.desc}")
    private String desc;

    public String getDesc() {
        return desc;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }
}

