package com.ishmamruhan.JpaAndEntityManagerPractice.Dao;

import com.ishmamruhan.JpaAndEntityManagerPractice.Entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<MyUser,Long>, JpaSpecificationExecutor<MyUser> {
}
