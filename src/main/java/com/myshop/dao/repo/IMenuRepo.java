package com.myshop.dao.repo;

import com.myshop.dao.model.Menu;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IMenuRepo extends JpaRepository<Menu,String>, JpaSpecificationExecutor<Menu> {

  List<Menu> findAllByType(String type);
}
