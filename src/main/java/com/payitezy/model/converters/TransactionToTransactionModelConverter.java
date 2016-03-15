/**
 *
 */
package com.payitezy.model.converters;

import com.payitezy.domain.Merchant;
import com.payitezy.domain.Transaction;
import com.payitezy.model.MerchantModel;
import com.payitezy.model.TransactionModel;
import com.payitezy.util.CollectionTypeDescriptor;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
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

@Component("transactionToTransactionModelConverter")
public class TransactionToTransactionModelConverter implements Converter<Transaction, TransactionModel> {

    @Autowired
    private ObjectFactory<TransactionModel> transactionModelFactory;
    private static final Logger LOGGER = Logger.getLogger(TransactionToTransactionModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */

    @Override
    public TransactionModel convert(final Transaction source) {
        // TODO Auto-generated method stub
        TransactionModel transactionModel = transactionModelFactory.getObject();
        BeanUtils.copyProperties(source, transactionModel);
        if (source.getChannel() != null) {
            transactionModel.setChannel(source.getChannel());
        }
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        String ds1 = null;
        if (source.getAmountReceivedDate() != null) {
            ds1 = source.getAmountReceivedDate().toString();
        }
        else {
            ds1 = new DateTime().toString();
        }
        if (ds1 != null) {
            try {
                String ds2 = sdf2.format(sdf1.parse(ds1));
                transactionModel.setAmountReceivedDate(ds2);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return transactionModel;

    }

    @Autowired
    public void setTransactionFactory(final ObjectFactory<TransactionModel> transactionModelFactory) {
        this.transactionModelFactory = transactionModelFactory;
    }

}
