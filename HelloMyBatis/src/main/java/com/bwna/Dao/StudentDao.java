package com.bwna.Dao;

import com.bwna.domian.Student;

import java.util.List;

public interface StudentDao {

    //查询所有学生信息
    List<Student> selectStudents();

    //根据id查学生信息
    Student selectStudentById(int id);

    //插入学生信息
    int insertStudent(Student student);
}
