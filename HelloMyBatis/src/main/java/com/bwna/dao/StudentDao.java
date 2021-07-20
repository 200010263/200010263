package com.bwna.dao;

import com.bwna.domian.Student;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
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

    //用map来当返回值类型
    HashMap<Object, Object> selectStudentByMap(Integer id);

    //用resultMap定义对应关系
    List<Student> selectAllStudent();

    //模糊查询
    List<Student> selectLikeStudent(String name);

    //动态if
    List<Student> selectDongIf(Student student);

    //动态where
    List<Student> selectDongWhere(Student student);

    //分页查询
    List<Student> selectAllStudentsPageHelper();
}