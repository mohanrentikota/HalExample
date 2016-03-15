package com.payitezy.service;

import com.payitezy.dao.UsersRepository;
import com.payitezy.domain.Users;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
//import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;*/
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UsersService implements IUsersService {
    @Autowired
    private UsersRepository usersRepository;

	@Override
	public List<Users> getAll() {
		// TODO Auto-generated method stub
		return (List<Users>) usersRepository.findAll();
	}

	@Override
	public Users create(Users users) {
		// TODO Auto-generated method stub
		return usersRepository.save(users);
	}

	@Override
	public Integer getMaxCode() {
		// TODO Auto-generated method stub
		return usersRepository.getMaxCode();
	}

    

}
