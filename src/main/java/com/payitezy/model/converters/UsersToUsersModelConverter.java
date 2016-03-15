/**
 *
 */
package com.payitezy.model.converters;

import com.payitezy.domain.Users;
/*import com.PayitEzy.model.TransactionModel;*/
import com.payitezy.model.UsersModel;
import com.payitezy.util.CollectionTypeDescriptor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
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
@Component("usersToUsersModelConverter")
public class UsersToUsersModelConverter implements Converter<Users, UsersModel> {

    @Autowired
    private ObjectFactory<UsersModel> usersModelFactory;
    private static final Logger LOGGER = Logger.getLogger(UsersToUsersModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */

    @Override
    public UsersModel convert(final Users source) {
        // TODO Auto-generated method stub
        UsersModel usersModel = usersModelFactory.getObject();
        BeanUtils.copyProperties(source, usersModel);

        String ds1 = null;
        if (source.getCreatedDate() != null) {
            ds1 = source.getCreatedDate().toString();
        }
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        if (ds1 != null) {
            try {
                String ds2 = sdf2.format(sdf1.parse(ds1));
                usersModel.setCreatedDate(ds2);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }

        usersModel.setUserCount(Long.toString(source.getUserCount()));

        String ds2 = null;
        if (source.getDob() != null) {
            ds2 = source.getDob().toString();
        }
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf4 = new SimpleDateFormat("dd/MM/yyyy");
        if (ds2 != null) {
            try {

                String ds5 = sdf4.format(sdf3.parse(ds2));
                usersModel.setDob(ds5);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }
       /* if (CollectionUtils.isNotEmpty(source.getTransactions())) {
            List<TransactionModel> converted = (List<TransactionModel>) conversionService.convert(source.getTransactions(),
                    TypeDescriptor.forObject(source.getTransactions()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), TransactionModel.class));
            usersModel.getTransactionsModels().addAll(converted);
        }*/

        return usersModel;

    }

    @Autowired
    public void setUsersFactory(final ObjectFactory<UsersModel> usersModelFactory) {
        this.usersModelFactory = usersModelFactory;
    }

}
