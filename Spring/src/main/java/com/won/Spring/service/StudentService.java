package com.won.Spring.service;

import com.won.Spring.domain.Student;
import com.won.Spring.repository.MemoryStudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final MemoryStudentRepository repository;

    public StudentService(MemoryStudentRepository repository) {
        this.repository = repository;
    }

    //학생등록
    public Long edit(Student student){
        //1. 학번이 중복되진않앗는지?
        validateDuplicateStudent(student);
        //2. 학생등록
        Student saveStudent = repository.save(student);
        System.out.println(saveStudent.getId());
        return saveStudent.getId();
    }

    private void validateDuplicateStudent(Student student) {
        if(repository.findById(student.getId()) != null){
            throw new IllegalStateException("already sign student");
        }
    }

    public List<Student> findStudents() {
        return repository.findAll();
    }

    public Student findOne(Long id) {
        return repository.findById(id);
    }

    public Long updateScore(Student student) {
        Student updateStudent = repository.findById(student.getId());
        updateStudent.setScore(student.getScore());
        return updateStudent.getId();
    }
}
