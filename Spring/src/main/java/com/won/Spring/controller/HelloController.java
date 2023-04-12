package com.won.Spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @GetMapping("/hi")
    public String hi() {
        return "hi";
    }

    @GetMapping("/hi/data")
    public String hiData(Model model) {
        model.addAttribute("data", "역시 킹왕짱드래곤 200won!");
        return "hiData";
    }

    //localhost:200/param?data=qwre
    @GetMapping("/hi/param")
    public String hiParam(@RequestParam("data") String data, Model model) {
        model.addAttribute("data", data);
        return "hiData";
    }

    @GetMapping("/hello/param")
    @ResponseBody
    public String helloParam(@RequestParam("data") String data) {
        return "hello " + data;
    }

    @GetMapping("/hello/api")
    @ResponseBody
    public Person helloApi() {
        Person person = new Person();
        person.setAge(18);
        person.setName("200원");
        return person;
    }

    static class Person {
        private int age;

        private String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
