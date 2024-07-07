package com.TaskarMall.Customer.Service.repository;

import com.TaskarMall.Customer.Service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
