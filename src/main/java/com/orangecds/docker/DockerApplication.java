package com.orangecds.docker;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@SpringBootApplication
@Slf4j
public class DockerApplication {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DockerApplication.class, args);
    }

    @RequestMapping("index")
    public String index() {
        return "Hello World!";
    }

    @RequestMapping("userList")
    public String userList() {
        log.info("com.orangecds.docker.DockerApplication.userList：查询用户列表");
        String sql = "select * from users";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        log.info("com.orangecds.docker.DockerApplication.userList：" + JSONObject.toJSONString(list));
        return list.toString();
    }
}
