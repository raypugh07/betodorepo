package com.todolist.todolist.Service;

import com.todolist.todolist.Model.Confession;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

public interface ConfessionService {

    ArrayList<Confession> findAll(Pageable pageable);

    void delete(long confessionid);

    Confession save (Confession confession);
}
