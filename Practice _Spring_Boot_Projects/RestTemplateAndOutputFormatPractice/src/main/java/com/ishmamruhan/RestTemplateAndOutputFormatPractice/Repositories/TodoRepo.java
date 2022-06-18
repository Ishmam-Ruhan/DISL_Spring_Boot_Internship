package com.ishmamruhan.RestTemplateAndOutputFormatPractice.Repositories;

import com.ishmamruhan.RestTemplateAndOutputFormatPractice.Model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepo extends JpaRepository<ToDo, Long> {
    @Query(value = "SELECT t FROM ToDo t WHERE t.userId = :userId")
    List<ToDo> getToDoByUserId(@Param("userId") Long userId);

    @Query(value = "SELECT t FROM ToDo t WHERE t.userId = :userId AND t.completed = :status")
    List<ToDo> getToDoByUserIdAndCompleteStatus(@Param("status") Boolean status,@Param("userId") Long userId);

}
