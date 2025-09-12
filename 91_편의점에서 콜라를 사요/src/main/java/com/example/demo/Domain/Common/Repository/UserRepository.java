package com.example.demo.Domain.Common.Repository;

import com.example.demo.Domain.Common.Emtity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<user,Long> {

}
