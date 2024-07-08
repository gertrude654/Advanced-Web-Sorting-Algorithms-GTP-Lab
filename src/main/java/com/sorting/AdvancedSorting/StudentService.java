package com.sorting.AdvancedSorting;

import org.springframework.stereotype.Component;


import java.util.LinkedList;
import java.util.List;

@Component
public class StudentService implements StudentDao{

    private final LinkedList<Student> Students = new LinkedList<>();

    @Override
    public List<Student>getAllStudents() {
        return Students;
    }

    @Override
    public Student getStudent(int id) {

        return Students.stream() //convert Students collection to stream
                .filter(Student -> Student.getId() == id) //filter id to if it matches with the specific id
                .findFirst().orElse(null); //get the first id found or else not found
    }
    
    @Override
    public void addStudent(Student Student) {
        Students.add(Student);
    }

    @Override
    public void updateStudent(int id, Student newStudent) {
        Student Student = getStudent(id);
        if (Student != null) {
            Student.setName(newStudent.getName());
            Student.setAge(newStudent.getAge());
        }
    }

    @Override
    public void deleteStudent(int id) {
        Students.removeIf(Student -> Student.getId() == id);
    }

    @Override
    public List<Student> sortStudentsByNameHeapSort() {
        List<Student> sortedStudents = new LinkedList<>(Students);
        SortingAlgorithms.heapSort(sortedStudents);
        return sortedStudents;
    }

    @Override
    public List<Student> sortStudentsByNameQuickSort() {
        List<Student> sortedStudents = new LinkedList<>(Students);
        SortingAlgorithms.quickSort(sortedStudents, 0, sortedStudents.size() - 1);
        return sortedStudents;
    }

    @Override
    public List<Student> sortStudentsByNameMergeSort() {
        List<Student> sortedStudents = new LinkedList<>(Students);
        SortingAlgorithms.mergeSort(sortedStudents, 0, sortedStudents.size() - 1);
        return sortedStudents;
    }

    @Override
    public List<Student> sortStudentsByNameRadixSort() {
        List<Student> sortedStudents = new LinkedList<>(Students);
        SortingAlgorithms.radixSort(sortedStudents);
        return sortedStudents;
    }

    @Override
    public List<Student> sortStudentsByNameBucketSort() {
        List<Student> sortedStudents = new LinkedList<>(Students);
        int maxVal = Students.stream().mapToInt(Student -> Student.getName().length()).max().orElse(0);
        SortingAlgorithms.bucketSort(sortedStudents, maxVal);
        return sortedStudents;
    }
}
