package com.mongocrud.service;

import com.mongocrud.model.Student;
import com.mongocrud.pojo.StudentDTO;
import com.mongocrud.repo.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SequenceGenerationSequence generationSequence;

    @Autowired
    private ModelMapper modelMapper;

    public Student saveStudent(StudentDTO studentDTO)
    {
        studentDTO.setId(generationSequence.generateSequence(Student.SEQUENCE_NAME));
        Student std = modelMapper.map(studentDTO, Student.class);
        return this.studentRepository.save(std);
    }


    public List<Student> getAllStudents()
    {
        return studentRepository.findAll();
    }

    public Student getStudentById(long id)
    {
       return studentRepository.findById(id).get();
    }

    public void deleteStudent(Student std)
    {
        studentRepository.delete(std);
    }
}
