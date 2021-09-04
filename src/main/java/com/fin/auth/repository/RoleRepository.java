package com.fin.auth.repository;

import com.fin.auth.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<Role,Long> {

 }
