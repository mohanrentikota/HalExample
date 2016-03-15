/**
 *
 */
package com.payitezy.model.converters;

import com.payitezy.domain.Merchant;
import com.payitezy.domain.Transaction;
import com.payitezy.model.MerchantModel;
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
 * @author arthvedi
 *
 */
@Component("marchantModelToMarchantConverter")
public class MarchantModelToMarchantConverter implements Converter<MerchantModel, Merchant> {
    @Autowired
    private ObjectFactory<Merchant> marchantFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public Merchant convert(final MerchantModel source) {
        Merchant marchant = marchantFactory.getObject();
        BeanUtils.copyProperties(source, marchant);

        if (CollectionUtils.isNotEmpty(source.getTransactionsModels())) {
            List<Transaction> converted = (List<Transaction>) conversionService.convert(source.getTransactionsModels(),
                    TypeDescriptor.forObject(source.getTransactionsModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), Transaction.class));
            marchant.getTransactions().addAll(converted);
        }
        return marchant;
    }

    @Autowired
    public void setUsersFactory(final ObjectFactory<Merchant> marchantFactory) {
        this.marchantFactory = marchantFactory;
    }

}
