/**
 *
 */
package com.payitezy.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("marchantModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MerchantModel extends AbstractModel {

    private String marchantName;
    private List<TransactionModel> transactionsModels = new ArrayList<TransactionModel>(0);

    /**
     * @return the marchantName
     */
    public String getMarchantName() {
        return marchantName;
    }

    /**
     * @return the transactionsModels
     */
    public List<TransactionModel> getTransactionsModels() {
        return transactionsModels;
    }

    /**
     * @param marchantName
     *            the marchantName to set
     */
    public void setMarchantName(final String marchantName) {
        this.marchantName = marchantName;
    }

    /**
     * @param transactionsModels
     *            the transactionsModels to set
     */
    public void setTransactionsModels(final List<TransactionModel> transactionsModels) {
        this.transactionsModels = transactionsModels;
    }

}
