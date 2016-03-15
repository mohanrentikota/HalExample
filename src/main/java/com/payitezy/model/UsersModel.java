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
 * @author arthvedi1
 *
 */
@Component("usersModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UsersModel extends AbstractModel {

    private String userName;
    private String userType;
    private String emailId;
    private String phoneNo;
    private String dob;
    private String gender;
    private String password;
    private String status;
    private String userCode;
    private String authenticateStatus;
    private String userCount;
    private String createdDate;
    private String emailStatus;
    private String confirmPassword;
    private String newPassword;
    private String userEmailIdStatus;
    private String source;
    private List<TransactionModel> transactionsModels = new ArrayList<TransactionModel>(0);

    /**
     * @return the authenticateStatus
     */
    public String getAuthenticateStatus() {
        return authenticateStatus;
    }

    /**
     * @return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @return the createdDate
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * @return the dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @return the emailId
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * @return the emailStatus
     */
    public String getEmailStatus() {
        return emailStatus;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    public String getPassword() {
        return password;
    }

    /**
     * @return the phoneNo
     */
    public String getPhoneNo() {
        return phoneNo;
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
     * @return the transactionsModels
     */
    /*public List<TransactionModel> getTransactionsModels() {
        return transactionsModels;
    }
*/
    /**
     * @return the userCode
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * @return the userCount
     */
    public String getUserCount() {
        return userCount;
    }

    /**
     * @return the userEmailIdStatus
     */
    public String getUserEmailIdStatus() {
        return userEmailIdStatus;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @return the userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     * @return the subOrderModels
     */

    /**
     * @param authenticateStatus
     *            the authenticateStatus to set
     */
    public void setAuthenticateStatus(final String authenticateStatus) {
        this.authenticateStatus = authenticateStatus;
    }

    /**
     * @param confirmPassword
     *            the confirmPassword to set
     */
    public void setConfirmPassword(final String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    /**
     * @return the userImagesModels
     */

    /**
     * @param createdDate
     *            the createdDate to set
     */
    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * /**
     *
     * @return the usersOfferModels
     */

    /**
     * @param dob
     *            the dob to set
     */
    public void setDob(final String dob) {
        this.dob = dob;
    }

    /**
     * @param emailId
     *            the emailId to set
     */
    public void setEmailId(final String emailId) {
        this.emailId = emailId;
    }

    /**
     * @param emailStatus
     *            the emailStatus to set
     */
    public void setEmailStatus(final String emailStatus) {
        this.emailStatus = emailStatus;
    }

    /**
     * @param gender
     *            the gender to set
     */
    public void setGender(final String gender) {
        this.gender = gender;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * @param phoneNo
     *            the phoneNo to set
     */
    public void setPhoneNo(final String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * @param source
     *            the source to set
     */
    public void setSource(final String source) {
        this.source = source;
    }

    /**
     * @param ordersModels
     *            the ordersModels to set
     */

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(final String status) {
        this.status = status;
    }

    /**
     * @param transactionsModels
     *            the transactionsModels to set
     */
   /* public void setTransactionsModels(final List<TransactionModel> transactionsModels) {
        this.transactionsModels = transactionsModels;
    }
*/
    /**
     * @param rolesModels
     *            the rolesModels to set
     */

    /**
     * @param sellerUserModels
     *            the sellerUserModels to set
     */

    /**
     * @param userCode
     *            the userCode to set
     */
    public void setUserCode(final String userCode) {
        this.userCode = userCode;
    }

    /**
     * @param userCount
     *            the userCount to set
     */
    public void setUserCount(final String userCount) {
        this.userCount = userCount;
    }

    /**
     * @param userEmailIdStatus
     *            the userEmailIdStatus to set
     */
    public void setUserEmailIdStatus(final String userEmailIdStatus) {
        this.userEmailIdStatus = userEmailIdStatus;
    }

    /**
     * @param userImagesModels
     *            the userImagesModels to set
     */

    /**
     * @param userName
     *            the userName to set
     */
    public void setUserName(final String userName) {
        this.userName = userName;
    }

    /**
     * @param userSearchModels
     *            the userSearchModels to set
     */
    /**
     * @param userSellerItemRatingModels
     *            the userSellerItemRatingModels to set
     */

    /**
     * @param userType
     *            the userType to set
     */
    public void setUserType(final String userType) {
        this.userType = userType;
    }

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public List<TransactionModel> getTransactionsModels() {
		return transactionsModels;
	}

	public void setTransactionsModels(List<TransactionModel> transactionsModels) {
		this.transactionsModels = transactionsModels;
	}

    /**
     * @param userWishListModels
     *            the userWishListModels to set
     */

}
