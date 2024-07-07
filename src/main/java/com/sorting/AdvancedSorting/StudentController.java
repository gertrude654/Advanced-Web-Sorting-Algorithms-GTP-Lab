package com.sorting.AdvancedSorting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/students")
public class StudentController {


    private final StudentService StudentService;

    @Autowired
    public StudentController(StudentService studentService) {
        StudentService = studentService;
    }

    @GetMapping
    public List<EntityModel<Student>> getAllStudents() {
        return StudentService.getAllStudents().stream().map(student -> EntityModel.of(student,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).getStudent(student.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).getAllStudents()).withRel("Students")
        )).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EntityModel<Student> getStudent(@PathVariable int id) {
        Student student = StudentService.getStudent(id);
        if (student == null) throw new RuntimeException("Student not found");
        return EntityModel.of(student,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).getStudent(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).getAllStudents()).withRel("Students")
        );
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        StudentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable int id, @RequestBody Student newStudent) {
        StudentService.updateStudent(id, newStudent);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        StudentService.deleteStudent(id);
    }

    @GetMapping("/sort/heap")
    public List<EntityModel<Student>> heapSort() {
        return StudentService.sortStudentsByNameHeapSort().stream().map(student -> EntityModel.of(student,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).getStudent(student.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).getAllStudents()).withRel("Students")
        )).collect(Collectors.toList());
    }

    @GetMapping("/sort/quick")
    public List<EntityModel<Student>> quickSort() {
        return StudentService.sortStudentsByNameQuickSort().stream().map(student -> EntityModel.of(student,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).getStudent(student.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).getAllStudents()).withRel("Students")
        )).collect(Collectors.toList());
    }

    @GetMapping("/sort/merge")
    public List<EntityModel<Student>> mergeSort() {
        return StudentService.sortStudentsByNameMergeSort().stream().map(student -> EntityModel.of(student,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).getStudent(student.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).getAllStudents()).withRel("Students")
        )).collect(Collectors.toList());
    }

    @GetMapping("/sort/radix")
    public List<EntityModel<Student>> radixSort() {
        return StudentService.sortStudentsByNameRadixSort().stream().map(student -> EntityModel.of(student,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).getStudent(student.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).getAllStudents()).withRel("Students")
        )).collect(Collectors.toList());
    }

    @GetMapping("/sort/bucket")
    public List<EntityModel<Student>> bucketSort() {
        return StudentService.sortStudentsByNameBucketSort().stream().map(student -> EntityModel.of(student,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).getStudent(student.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).getAllStudents()).withRel("Students")
        )).collect(Collectors.toList());
    }
}
