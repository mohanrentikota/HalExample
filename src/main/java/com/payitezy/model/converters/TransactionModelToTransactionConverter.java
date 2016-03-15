/**
 *
 */
package com.payitezy.model.converters;

import com.payitezy.domain.Merchant;
import com.payitezy.domain.Transaction;
import com.payitezy.model.MerchantModel;
import com.payitezy.model.TransactionModel;
import com.payitezy.util.CollectionTypeDescriptor;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */

@Component("transactionModelToTransactionConverter")
public class TransactionModelToTransactionConverter implements Converter<TransactionModel, Transaction> {
    @Autowired
    private ObjectFactory<Transaction> transactionFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public Transaction convert(final TransactionModel source) {
        Transaction transaction = transactionFactory.getObject();
        BeanUtils.copyProperties(source, transaction);

        return transaction;
    }

    @Autowired
    public void setUsersFactory(final ObjectFactory<Transaction> transactionFactory) {
        this.transactionFactory = transactionFactory;
    }
}
