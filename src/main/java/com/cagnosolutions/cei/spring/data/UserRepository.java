package com.cagnosolutions.cei.spring.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.cagnosolutions.cei.spring.domain.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Long> {
	User findByEmail( String email );
}
