package com.bwna.Dao;

import com.bwna.domian.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Iterator;
import java.util.List;

public interface StudentDao {

    //查询所有学生信息
    List<Student> selectStudents();

    //根据id查学生信息
    Student selectStudentById(int id);

    //插入学生信息
    int insertStudent(Student student);

    //根据多参数查询学生信息
    List<Student> selectStudentByMultiParam(@Param("id") Integer id,
                                             @Param("name") String name);
    //用student对象来查询学生信息
    List<Student> selectStudentByStudent(Student student);
}
