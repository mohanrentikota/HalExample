/**
 *
 */
package com.payitezy.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */

@Component("transactionModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TransactionModel extends AbstractModel {

    private String marchantId;
    private String usersId;
    private String source;
    private String channel;
    private String amountReceivedDate;
    private String status;
    private String marchantPercentage;
    private String orderId;

    /**
     * @return the amountReceivedDate
     */
    public String getAmountReceivedDate() {
        return amountReceivedDate;
    }

    /**
     * @return the channel
     */
    public String getChannel() {
        return channel;
    }

    /**
     * @return the marchantId
     */
    public String getMarchantId() {
        return marchantId;
    }

    /**
     * @return the marchantPercentage
     */
    public String getMarchantPercentage() {
        return marchantPercentage;
    }

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @return the source
     */
    public String getSource() {
        return source;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return the usersId
     */
    public String getUsersId() {
        return usersId;
    }

    /**
     * @param amountReceivedDate
     *            the amountReceivedDate to set
     */
    public void setAmountReceivedDate(final String amountReceivedDate) {
        this.amountReceivedDate = amountReceivedDate;
    }

    /**
     * @param channel
     *            the channel to set
     */
    public void setChannel(final String channel) {
        this.channel = channel;
    }

    /**
     * @param marchantId
     *            the marchantId to set
     */
    public void setMarchantId(final String marchantId) {
        this.marchantId = marchantId;
    }

    /**
     * @param marchantPercentage
     *            the marchantPercentage to set
     */
    public void setMarchantPercentage(final String marchantPercentage) {
        this.marchantPercentage = marchantPercentage;
    }

    /**
     * @param orderId
     *            the orderId to set
     */
    public void setOrderId(final String orderId) {
        this.orderId = orderId;
    }

    /**
     * @param source
     *            the source to set
     */
    public void setSource(final String source) {
        this.source = source;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(final String status) {
        this.status = status;
    }

    /**
     * @param usersId
     *            the usersId to set
     */
    public void setUsersId(final String usersId) {
        this.usersId = usersId;
    }

}
