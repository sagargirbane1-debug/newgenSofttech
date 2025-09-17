//package com.example.StudentManagement.configuration;
//
//
//import com.example.StudentManagement.repository.CourseRepository;
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class Course {
//
//    @Bean
//    CommandLineRunner  initCourses(CourseRepository courseRepository){
//        return args -> {
//            if (courseRepository.count()==0) {
//                courseRepository.save(new com.example.StudentManagement.entity.Course(null, "Java (Core, Advanced, Java 8+)","3 month", 10000));
//                courseRepository.save(new com.example.StudentManagement.entity.Course(null, "Spring boot","3 month", 12000));
//                courseRepository.save(new com.example.StudentManagement.entity.Course(null, "C/C++","3 month", 6000));
//                courseRepository.save(new com.example.StudentManagement.entity.Course(null, "Python","3 month", 5000));
//                courseRepository.save(new com.example.StudentManagement.entity.Course(null, "HTML, CSS, JavaScript","3 month", 8000));
//                courseRepository.save(new com.example.StudentManagement.entity.Course(null, "React.js / Angular / Vue.js","3 month", 13000));
//                courseRepository.save(new com.example.StudentManagement.entity.Course(null, "Node.js / Express.js","3 month", 5500));
//                courseRepository.save(new com.example.StudentManagement.entity.Course(null, "PHP / Laravel / CodeIgniter","3 month", 7000));
//                courseRepository.save(new com.example.StudentManagement.entity.Course(null, "Django / Flask","3 month", 9000));
//                courseRepository.save(new com.example.StudentManagement.entity.Course(null, "Data Science with Python / R","3 month", 4000));
//                courseRepository.save(new com.example.StudentManagement.entity.Course(null, "SQL / NoSQL Databases (MySQL, MongoDB, Cassandra)","3 month", 6500));
//            }
//        };
//    }
//}
