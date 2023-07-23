package com.icin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.icin.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

	//JPQL 
	@Query("select acc from Account acc where accno.emailid = :emailid")
	public Account findAccountByEmailId(@Param("emailid") String emailid);
}
