package com.todolist.todolist;

import com.todolist.todolist.Model.Confession;
import com.todolist.todolist.Repository.ConfessionRepository;
import com.todolist.todolist.Service.ConfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    /*@Autowired
    ConfessionService confessionService;*/

    ConfessionRepository confessionrepos;

    public SeedData(ConfessionRepository confessionrepos)
    {
        this.confessionrepos=confessionrepos;

    }



    @Override
    public void run(String[] args) throws Exception
    {
      /*  Role r1 = new Role("admin");
        Role r2 = new Role("user");
        Role r3 = new Role("data");

        roleService.save(r1);
        roleService.save(r2);
        roleService.save(r3);

        // admin, data, user
        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));
        admins.add(new UserRoles(new User(), r3));
        User u1 = new User("admin", "password", admins);
        userService.save(u1);

        // data, user
        ArrayList<UserRoles> datas = new ArrayList<>();
        datas.add(new UserRoles(new User(), r3));
        datas.add(new UserRoles(new User(), r2));
        User u2 = new User("labs1", "password", datas);
        userService.save(u2);

        // user
        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u3 = new User("labs2", "password", users);
        userService.save(u3);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u4 = new User("labs3", "password", users);
        userService.save(u4);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u5 = new User("labs4", "password", users);
        userService.save(u5);

        for(var i = 7; i <= 50; i++) {
            users = new ArrayList<>();
            users.add(new UserRoles(new User(), r2));
            userService.save(new User("labs" + i, "password", users));
        }*/

        Confession c1=new Confession();

        ArrayList<Confession> confessions= new ArrayList<>();
        confessions.add(new Confession("I killed a man"));
        confessionrepos.save(c1);



    }
}