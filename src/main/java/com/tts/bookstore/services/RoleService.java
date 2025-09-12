package com.tts.bookstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.bookstore.models.Role;
import com.tts.bookstore.repos.RoleRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoleService {
    @Autowired
    private final RoleRepo roleRepo;

    public void add(String name) {
        Role role = new Role();
        role.setName(name);
        roleRepo.save(role);
    }

    public Role getById(Integer id) {
        Role role = roleRepo.findById(id).orElseThrow(() -> new RuntimeException("No role with that id!"));
        return role;
    }

    public List<Role> all() {
        List<Role> roles = roleRepo.findAll();
        return roles;
    }

    public void edit(Integer id, String name) {
        Role role = roleRepo.findById(id).orElseThrow(() -> new RuntimeException("No role with that id!"));
        role.setName(name);
        roleRepo.save(role);
    }

    public void drop(Integer id) {
        Role role = roleRepo.findById(id).orElseThrow(() -> new RuntimeException("No Role with that id!"));
        roleRepo.delete(role);
    }
}
