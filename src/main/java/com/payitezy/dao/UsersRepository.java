/**
 *
 */
package com.payitezy.dao;

import com.payitezy.domain.Users;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */

public interface UsersRepository extends PagingAndSortingRepository<Users, Serializable> {

    @Query("select u from Users u where u.emailId=?1")
    Users findByEmailId(String username);

    /**
     * @param e
     * @return
     */
    @Query("select u from Users u where u.emailId=?1")
    Users findByEmailIdAndPassword(String e);

    /**
     * @param userType
     * @return
     */
    @Query("select u from Users u where u.userType=?1")
    List<Users> getByUserType(String userType);

    @Query("select MAX(userCount) from  Users u")
    Integer getMaxCode();
    @Query("select u from Users u where u.emailId=?1 and status='ACTIVE'")
	Users findByEmailIdStatus(String username);
    @Query("select distinct u from Users u where u.id=?1")
	Users findByUserId(String usersId);
}
