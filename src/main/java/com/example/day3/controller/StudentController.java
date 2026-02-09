package com.example.day3.controller;

import com.example.day3.dto.StudentPatchDto;
import com.example.day3.dto.StudentRequestDto;
import com.example.day3.dto.StudentResponseDto;
import com.example.day3.model.StudentModel;
import com.example.day3.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }
//    Create Function API

    @PostMapping("/students")
    public StudentResponseDto addStudent(@Valid @RequestBody StudentRequestDto student){
        return service.addStudent(student);
    }
    // display students

//    @GetMapping("/students")
//    public List<StudentModel> getStudents(){
//        return service.getStudents();
//    }

    @GetMapping("/students")
    public List<StudentResponseDto> getStudents(){
        return service.getStudents();
    }


//    @PutMapping("/update/{id}")
//    public StudentModel updateStudent(@PathVariable String id, @RequestBody StudentModel student){
//        return service.updateStudent(id, student);
//    }


    @PutMapping("/update/{id}")
    public StudentResponseDto updateStudent(@PathVariable String id, @Valid @RequestBody StudentRequestDto student){
        return service.updateStudent(id, student);
    }
    // delete
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable String id){
        service.deleteStudent(id);
        return "Student delete successfully";
    }

    @PatchMapping("/students/{id}")
    public StudentResponseDto patchStudent(
            @PathVariable String id,
            @RequestBody StudentPatchDto student
    ) {
        return service.patchStudent(id, student);
    }

}
