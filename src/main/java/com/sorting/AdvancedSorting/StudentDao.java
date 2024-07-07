package com.sorting.AdvancedSorting;


import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentDao {
    
    List<Student> getAllStudents();
    Student getStudent(int id);
    void addStudent(Student student);
    void updateStudent(int id, Student newStudent);
    void deleteStudent(int id);

    List<Student> sortStudentsByNameHeapSort();
    List<Student> sortStudentsByNameQuickSort();
    List<Student> sortStudentsByNameMergeSort();
    List<Student> sortStudentsByNameRadixSort();
    List<Student> sortStudentsByNameBucketSort();
}
