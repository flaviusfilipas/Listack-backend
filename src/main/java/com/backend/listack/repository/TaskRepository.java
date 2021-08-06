package com.backend.listack.repository;

import com.backend.listack.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Modifying
    @Query("DELETE FROM Task t where t.list.id = :listId and t.completed = true")
    void deleteCompletedTasks(@Param("listId")Integer listId);
}
