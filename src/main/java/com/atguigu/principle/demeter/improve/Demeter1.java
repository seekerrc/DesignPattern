package com.atguigu.principle.demeter.improve;

import java.util.ArrayList;
import java.util.List;

//客户端
public class Demeter1 {
    
    public static void main(String[] args) {
        System.out.println("~~~使用迪米特法则的改进~~~");
        //创建了一个 SchoolManager 对象
        SchoolManager schoolManager = new SchoolManager();
        //输出学院的员工id 和  学校总部的员工信息
        schoolManager.printAllEmployee(new CollegeManager());
        
    }
    
}


//学校总部员工类
class Employee {
    private String id;
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }
}


//学院的员工类
class CollegeEmployee {
    private String id;
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }
}

//学院
class CollegeManager {
    public List<CollegeEmployee> getAllEmployee() {
        List<CollegeEmployee> list = new ArrayList<CollegeEmployee>();
        for (int i = 0; i < 10; i++) {
            CollegeEmployee emp = new CollegeEmployee();
            emp.setId("学院员工id= " + i);
            list.add(emp);
        }
        return list;
    }
    
    public void printEmployee() {
        //CollegeEmployee实现封装，不对外暴露
        List<CollegeEmployee> list1 = getAllEmployee();
        System.out.println("------------学院员工------------");
        for (CollegeEmployee e : list1) {
            System.out.println(e.getId());
        }
    }
}

//学校
//分析 SchoolManager 类的直接朋友类有哪些 Employee、CollegeManager
//优化后，代码中不出现 CollegeEmployee 这样的陌生类
class SchoolManager {
    public List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<Employee>();
        
        for (int i = 0; i < 5; i++) {
            Employee emp = new Employee();
            emp.setId("学校总部员工id= " + i);
            list.add(emp);
        }
        return list;
    }
    
    void printAllEmployee(CollegeManager sub) {
        //1. 将输出学院的员工方法，封装到CollegeManager
        sub.printEmployee();
        
        List<Employee> list2 = this.getAllEmployee();
        System.out.println("------------学校总部员工------------");
        for (Employee e : list2) {
            System.out.println(e.getId());
        }
    }
}
