/**
 *
 */
package com.payitezy.model.converters;

import com.payitezy.domain.Merchant;
import com.payitezy.model.MerchantModel;
import com.payitezy.model.TransactionModel;
import com.payitezy.util.CollectionTypeDescriptor;

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
 * @author arthvedi
 *
 */

@Component("marchantToMarchantModelConverter")
public class MarchantToMarchantModelConverter implements Converter<Merchant, MerchantModel> {

    @Autowired
    private ObjectFactory<MerchantModel> marchantModelFactory;
    private static final Logger LOGGER = Logger.getLogger(MarchantToMarchantModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */

    @Override
    public MerchantModel convert(final Merchant source) {
        // TODO Auto-generated method stub
        MerchantModel merchantModel = marchantModelFactory.getObject();
        BeanUtils.copyProperties(source, merchantModel);

        if (CollectionUtils.isNotEmpty(source.getTransactions())) {
            List<TransactionModel> converted = (List<TransactionModel>) conversionService.convert(source.getTransactions(),
                    TypeDescriptor.forObject(source.getTransactions()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), TransactionModel.class));
            merchantModel.getTransactionsModels().addAll(converted);
        }
        return merchantModel;

    }

    @Autowired
    public void setMarchantFactory(final ObjectFactory<MerchantModel> marchantModelFactory) {
        this.marchantModelFactory = marchantModelFactory;
    }

}
