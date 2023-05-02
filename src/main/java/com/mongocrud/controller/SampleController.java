package com.mongocrud.controller;

import com.mongocrud.model.Student;
import com.mongocrud.pojo.StudentDTO;
import com.mongocrud.repo.StudentRepository;
import com.mongocrud.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SampleController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ModelMapper modelMapper;
    @PostMapping("/student")
    public ResponseEntity<?> addStudent(@RequestBody StudentDTO student)
    {
       Student savedStudent = this.studentService.saveStudent(student);
       return ResponseEntity.ok(savedStudent);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") int id) throws Exception
    {
        Student student = studentService.getStudentById(id);
        if(student == null)
            throw new Exception("Student does not exists exception");
        else
        {studentService.deleteStudent(student);
        }

        return new ResponseEntity<>(null,HttpStatus.OK);
    }


    @PutMapping("/student")
    public ResponseEntity<?> updateStudent(@RequestBody StudentDTO studentDTO)
    {
        Student std = studentService.getStudentById(studentDTO.getId());
        studentDTO.setId(std.getId());
        studentService.saveStudent(studentDTO);
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @GetMapping("/students")
    public ResponseEntity<?> getStudents()
    {
        List<Student> allStudents = studentService.getAllStudents();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }


    @GetMapping("/student/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") int id)
    {
        Student student = studentService.getStudentById(id);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

}
