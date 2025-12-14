package com.portfolio.mail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.mail.entity.UserForm;

public interface UserFormRepository extends JpaRepository<UserForm, Long>
{

}
