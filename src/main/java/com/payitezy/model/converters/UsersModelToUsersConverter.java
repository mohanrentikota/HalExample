/**
 *
 */
package com.payitezy.model.converters;


import com.payitezy.domain.Users;
import com.payitezy.model.UsersModel;
import com.payitezy.util.CollectionTypeDescriptor;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author sankar
 *
 */
@Component("usersModelToUsersConverter")
public class UsersModelToUsersConverter implements Converter<UsersModel, Users> {
    @Autowired
    private ObjectFactory<Users> usersFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public Users convert(final UsersModel source) {
        Users users = usersFactory.getObject();
        BeanUtils.copyProperties(source, users);

      /*  if (CollectionUtils.isNotEmpty(source.getTransactionsModels())) {
            List<Transaction> converted = (List<Transaction>) conversionService.convert(source.getTransactionsModels(),
                    TypeDescriptor.forObject(source.getTransactionsModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), Transaction.class));
            users.getTransactions().addAll(converted);
        }*/
        return users;
    }

    @Autowired
    public void setUsersFactory(final ObjectFactory<Users> usersFactory) {
        this.usersFactory = usersFactory;
    }

}
