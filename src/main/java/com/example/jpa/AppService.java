package com.example.jpa;

import com.example.jpa.dto.StudentDto;
import com.example.jpa.entities.StudentEntity;
import com.example.jpa.repos.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppService {
    // 주된 비즈니스 로직이 구현되는 공간
    // 컨트롤러는 서비스에게 요청
    // 서비스는 레퍼지토리로
    // 1. 서비스는 데이터베이스 조회
    // 2. 컴포넌트를 사용
    // 3. 모은 데이터를 가지고 응답
    private final AppRepository repository;



    // JpaRepository
    private final StudentRepository studentRepository;

    public AppService(AppRepository repository,
                      StudentRepository studentRepository
    ) {
        this.repository = repository;
        this.studentRepository = studentRepository;
    }

    // creat
    public void createStudent(
            String name,
            Integer age,
            String phone,
            String email
    ) {
        StudentEntity newEntity = new StudentEntity();
        newEntity.setName(name);
        newEntity.setAge(age);
        newEntity.setEmail(email);
        newEntity.setPhone(phone);
        this.studentRepository.save(newEntity);
    }
    // read all
//    public List<StudentEntity> readStudentAll() {
        public List<StudentDto> readStudentAll() {
        System.out.println(this.studentRepository.findAll());
        List<StudentEntity> studentEntityList = this.studentRepository.findAll();
        List<StudentDto> studentDtoList = new ArrayList<>();
        for (StudentEntity studentEntity: this.studentRepository.findAll()) {
            StudentDto studentDto = new StudentDto();
            studentDto.setId(studentEntity.getId());
            studentDto.setName(studentEntity.getName());
            studentDto.setEmail(studentEntity.getEmail());
            studentDtoList.add(studentDto);
        }
//        return studentEntityList;
            return studentDtoList;
    }

    // read
    public void readStudent(Long id) {
        // Optional은 객체가 반환값이 있을 수 도 있고 없을 수 도있다
        Optional<StudentEntity> optionalStudentEntity =
                this.studentRepository.findById(id);
        // 1. 실제 데이터가 있을 때만
        if (optionalStudentEntity.isPresent()){
            System.out.println(optionalStudentEntity.get());
        }
        // 2. 결과가 null 이 되었을 경우
        else{
            System.out.println("no result");
        }

        System.out.println(this.studentRepository.findById(id));
    }
    // update
    public void updateStudent(
            Long id,
            String name
    ) {
        // 수정할 Entity호ㅣ수
        Optional<StudentEntity> optionalEntity =
                this.studentRepository.findById(id);
        if (optionalEntity.isPresent()) {
            StudentEntity target = optionalEntity.get();
            target.setName(name);
            this.studentRepository.save(target);
        }
        else{
            System.out.println("could not find");
        }
    }

    // delete
    public void deleteStudent(Long id) {
        Optional<StudentEntity> optionalEntity =
                this.studentRepository.findById(id);
        if(optionalEntity.isPresent()){
            StudentEntity studentEntity =
                    optionalEntity.get();
            this.studentRepository.delete(studentEntity);
        }
        else{
            System.out.println("could not find");
        }
    }

    // findByAll
    public void findAllByTest() {
        System.out.println("findAllByOrderByName");
        List<StudentEntity> studentEntities =
                this.studentRepository.findAllByOrderByName();
        for (int i = 0; i < 5; i++) {
            System.out.println(studentEntities.get(i));
        }
        System.out.println("...");

        System.out.println("findAllByOrderByAgeDesc");
        studentEntities =
                this.studentRepository.findAllByOrderByAgeDesc();
        for (int i = 0; i < 5; i++) {
            System.out.println(studentEntities.get(i));
        }
        System.out.println("...");

        System.out.println("findAllByAgeLessThan");
        studentEntities =
                this.studentRepository.findAllByAgeLessThan(21);
        for (int i = 0; i < 5; i++) {
            System.out.println(studentEntities.get(i));
        }
        System.out.println("...");

        System.out.println("findAllByPhoneStartingWith");
        studentEntities =
                this.studentRepository.findAllByPhoneStartingWith("010-");
        for (int i = 0; i < 5; i++) {
            System.out.println(studentEntities.get(i));
        }
        System.out.println("...");
    }

//    public List<Object> readStudentAll() {
//        List<Object> queryResult = repository.selectStudentAll();
//        return queryResult;
//    }


}
