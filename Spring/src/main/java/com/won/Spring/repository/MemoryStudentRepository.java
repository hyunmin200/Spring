package com.won.Spring.repository;

import com.won.Spring.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemoryStudentRepository {
    private static Map<Long, Student> store = new HashMap<>();

    public Student save(Student student){
        store.put(student.getId(), student);
        return student;//store.get(student.getId());
    }
}
