package com.payitezy.service;

import com.payitezy.domain.Users;

import java.util.List;

public interface IUsersService {

    /**
     * @param email
     * @return
     */
   /* boolean checkEmailExists(String email);*/

    /*Users create(Users users);*/

   /* void deleteUsers(String usersId);*/

    /**
     * @param userId
     * @param confirmPassword
     * @param newPassword
     * @param password
     * @return
     */
   /* Users findByChangePassword(String userId, String confirmPassword, String newPassword, String password);*/

    /**
     * @param emailId
     * @param password
     * @return
     */
/*    Users findByEmailIdAndPassword(String emailId, String password);*/

    List<Users> getAll();

	Users create(Users users);

	Integer getMaxCode();

    /**
     * @param userType
     * @return
     */
  /*  List<Users> getByUserType(String userType);*/

    /**
     * @return
     */
    /*Integer getMaxCode();*/

   /* Users getUsers(String usersId);*/

    /**
     * @return
     */
    /*List<Users> getUsersOnly();

    Users updateUsers(Users users);*/

}
