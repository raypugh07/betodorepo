package com.todolist.todolist.Service;


import com.todolist.todolist.Model.Confession;
import com.todolist.todolist.Repository.ConfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;


public class ConfessionServiceImpl implements ConfessionService {

    @Autowired
    private ConfessionRepository confessionrepos;

    @Override
    public ArrayList<Confession> findAll(Pageable pageable){

        ArrayList<Confession> list= new ArrayList<>();
        confessionrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Transactional
    @Override
    public Confession save(Confession confession){

        Confession newConfession=new Confession();

        newConfession.setConfessionitem(confession.getConfessionitem());

        return confessionrepos.save(newConfession);
    }

    @Transactional
    @Override
    public void delete(long confessionid) throws EntityNotFoundException{

        if (confessionrepos.findById(confessionid).isPresent()){
            confessionrepos.deleteById(confessionid);
        } else{
            throw new EntityNotFoundException(Long.toString(confessionid));
        }
    }


}
