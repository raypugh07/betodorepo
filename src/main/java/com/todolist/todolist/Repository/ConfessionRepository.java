package com.todolist.todolist.Repository;

import com.todolist.todolist.Model.Confession;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ConfessionRepository extends CrudRepository<Confession, Long> {

    ArrayList<Confession> findConfessionsByConfessionitemEquals(String confessionitem);

//    @Modifying
//    @Query(value = )
}
