package com.example.Ticketing.Repository;

import com.example.Ticketing.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GetUsersRepository extends JpaRepository<User, Integer> {

}
