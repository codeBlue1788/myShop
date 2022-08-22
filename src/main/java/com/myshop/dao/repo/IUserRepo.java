package com.myshop.dao.repo;

import com.myshop.dao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IUserRepo extends JpaRepository<User,String>, JpaSpecificationExecutor<User> {
}
