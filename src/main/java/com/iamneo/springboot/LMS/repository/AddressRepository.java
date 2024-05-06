package com.iamneo.springboot.LMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iamneo.springboot.LMS.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}

