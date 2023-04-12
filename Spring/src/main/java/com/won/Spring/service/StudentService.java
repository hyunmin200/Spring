package com.won.Spring.service;

import com.won.Spring.domain.Student;
import com.won.Spring.repository.MemoryStudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final MemoryStudentRepository repository;

    public StudentService(MemoryStudentRepository repository) {
        this.repository = repository;
    }

    //학생등록
    public Long edit(Student student){
        //1. 학번이 중복되진않앗는지?
        //2. 학생등록
        Student saveStudent = repository.save(student);
        System.out.println(saveStudent.getId());
        return saveStudent.getId();
    }
}
