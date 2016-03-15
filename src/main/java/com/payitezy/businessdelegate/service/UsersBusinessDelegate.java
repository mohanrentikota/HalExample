/**
 *
 */
package com.payitezy.businessdelegate.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;






import com.payitezy.DBSequences;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.payitezy.businessdelegate.domain.IKeyBuilder;
/*import com.payitezy.constants.DBSequences;*/
import com.payitezy.domain.Users;
/*import com.PayitEzy.mail.Mail;*/
import com.payitezy.model.UsersModel;
import com.payitezy.service.IUsersService;

/**
 * @author arthvedi
 *
 */

@Service
/*@PropertySource("classpath:mail.properties")*/
@PropertySource("classpath:application.properties")
/*@ImportResource("classpath:spring-thymeleaf.xml")*/
public class UsersBusinessDelegate implements IBusinessDelegate<UsersModel, UsersContext, com.payitezy.businessdelegate.domain.IKeyBuilder<String>, String> {
/*@Autowired
private ThymeleafExtension thyeleafExtension;*/
    @Autowired
    private IUsersService usersService;
    @Autowired
    private ConversionService conversionService;
   
    /**
     * {@inheritDoc}
     *
     * @see com.payitEzy.businessdelegate.service.IBusinessDelegate#create(com.payitEzy.businessdelegate.domain.IModel)
     */
    @Override
    public UsersModel create(final UsersModel model) {
    	   Users users = new Users();
           users.setId(model.getId());
           users.setUserName(model.getUserName());
           users.setUserType(model.getUserType());
           users.setEmailId(model.getEmailId());
           users.setPhoneNo(model.getPhoneNo());
           users.setSource(model.getSource());
           SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
           String dateInString = model.getDob();
           if (dateInString != null && dateInString != "") {
               try {
                   Date date = format.parse(dateInString);
                   users.setDob(date);
               }
               catch (ParseException e) {
                   e.printStackTrace();
               }
           }
           users.setGender(model.getGender());
           users.setPassword(model.getPassword());
           users.setStatus(model.getStatus());

           Integer i = usersService.getMaxCode();
           if (i == null || i == 0) {
               i = 9999;
               long bi = (i + 1);
               users.setUserCount(bi);
           }
           else {
               long bi = (i + 1);
               users.setUserCount(bi);
           }
           Integer ca = i + 1;
           String m = DBSequences.USERS.getSequenceName();
           String mc = m.concat(ca.toString());
           users.setUserCode(mc);

           users.setAuthenticateStatus(model.getAuthenticateStatus());
           users.setCreatedDate(new Date());
           users.setEmailStatus(model.getEmailStatus());

           if (model.getPassword() != null && model.getConfirmPassword() != null) {
               if (model.getPassword().equals(model.getConfirmPassword())) {
                   model.setEmailStatus("SUCCESS");
                   users = usersService.create(users);
               }
               else {
                   model.setEmailStatus("Password and ConfirmPassword Not Match");
               }
           }

           if (users.getEmailStatus() != null) {
               if (users.getEmailStatus().equals("Duplicate")) {
                   model.setEmailStatus("DUPLICATE");
                   model.setUserEmailIdStatus("You are Already Registered. Please Login !");
               }
           }
           
      
           
           model.setId(users.getId());

           return model;
    	

       
    }


	/**
     * {@inheritDoc}
     *
     * @see com.payitEzy.businessdelegate.service.IBusinessDelegate#delete(com.payitEzy.businessdelegate.domain.IKeyBuilder,
     *      com.payitEzy.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final UsersContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.payitEzy.businessdelegate.service.IBusinessDelegate#edit(com.payitEzy.businessdelegate.domain.IKeyBuilder,
     *      com.payitEzy.businessdelegate.domain.IModel)
     */
    @Override
    public UsersModel edit(final IKeyBuilder<String> keyBuilder, final UsersModel model) {
     
    	return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.payitEzy.businessdelegate.service.IBusinessDelegate#getByKey(com.payitEzy.businessdelegate.domain.IKeyBuilder,
     *      com.payitEzy.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public UsersModel getByKey(final IKeyBuilder<String> keyBuilder, final UsersContext context) {
      /*  Users users = usersService.getUsers(keyBuilder.build().toString());
        UsersModel usersModel = conversionService.convert(users, UsersModel.class);*/

        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.payitEzy.businessdelegate.service.IBusinessDelegate#getCollection(com.payitEzy.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Iterable<UsersModel> getCollection(final UsersContext context) {
        List<Users> users = new ArrayList<Users>();

        if (context.getAll() != null) {
            users = usersService.getAll();
        }
       
        
    

        List<UsersModel> usersModels = (List<UsersModel>) conversionService.convert(users, TypeDescriptor.forObject(users),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UsersModel.class)));
        return usersModels;
    }

}
