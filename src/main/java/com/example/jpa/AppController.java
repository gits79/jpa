package com.example.jpa;

import com.example.jpa.dto.StudentDto;
import com.example.jpa.entities.StudentEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller
// 모든 메소드에 @ResponseBody를 붙이는 용도
@RestController
public class AppController {
    private final AppService service;

    public AppController(AppService service) {
        this.service = service;
    }

    @GetMapping("create")
    public @ResponseBody String create() {
        this.service.createStudent(
                "alex",
                35,
                "010-1233-1233",
                "alex@gmail.com"
        );
        return "done";
    }

    @GetMapping("read-all")
    public @ResponseBody List<StudentDto> readAll() {
//        this.service.readStudentAll();
//        return "done-read-all";
        return this.service.readStudentAll();
    }

    @GetMapping("read")
    public @ResponseBody String readOne() {
        this.service.readStudent(1L);
        return "done-read-one";
    }

    @GetMapping("update")
    public @ResponseBody String update() {
        this.service.updateStudent(1L,"alexander");
        return "done-update";
    }

    @GetMapping("delete")
    public @ResponseBody String delete() {
        this.service.deleteStudent(1L);
        return "done-delete";
    }

    @GetMapping("find")
    public @ResponseBody String find() {
        this.service.findAllByTest();
        return "done-find";
    }




//    @RequestMapping("students")
//    public void students() {
//        List<Object> result = service.readStudentAll();
//    }

    // 사용자의 입력을 받는 요소
    @RequestMapping("student")
    public void student(){

    }

    @GetMapping("home")
    public String home(){
        return "home";
    }

    @GetMapping("body")
    public @ResponseBody String body(){
        return "body";
    }

}
