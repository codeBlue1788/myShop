package com.myshop.dao.repo;

import com.myshop.dao.model.SysParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ISysParamRepo extends JpaRepository<SysParam, String>,
    JpaSpecificationExecutor<SysParam> {

}
