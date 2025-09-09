package com.example.demo.Domain.Common.Repository;

import com.example.demo.Domain.Common.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String> {
//    SELECT * FROM testdb.user where role='ROLE_USER'; //원래 SQL 쿼리 문
    @Query("SELECT u FROM User as u where u.role=?1") //JAP 쿼리문
    List<User> selectAllByRole(String role); //role이 첫번째 물음표에 들어감

    //SELECT * FROM testdb.user where role='ROLE_USER' and password ='1111';
    @Query("SELECT u FROM User as u where u.role=?1 and u.password=?2")
    List<User> selectAllByRoleAndPwd(String role, String password);

    @Query("SELECT u FROM User as u where u.role=:role")
    List<User> selectAllByRole_2(@Param("role") String r);

    //SELECT * FROM user where username like '%user%';
    //SELECT * FROM user where username like concat('%','user','%');
    @Query("SELECT u FROM User as u where u.username like concat('%',':user','%')")
    List<User> selectAllLikeUsername(@Param("user") String username);

}
