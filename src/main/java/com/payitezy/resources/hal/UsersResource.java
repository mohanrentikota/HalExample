package com.payitezy.resources.hal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.core.Relation;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.payitezy.model.TransactionModel;

@Relation(value="user", collectionRelation="users")
public class UsersResource extends ResourceWithEmbeddeds {

	private String productId; 
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
	  //  private List<TransactionResource> transactions= new ArrayList<TransactionResource>(0);
	    
	    
	    @JsonCreator
		public UsersResource(String productId,String userName, String userType, String emailId,
				String phoneNo, String dob, String gender, String password,
				String status, String userCode, String authenticateStatus,
				String userCount, String createdDate, String emailStatus,
				String confirmPassword, String newPassword,
				String userEmailIdStatus, String source/*,List<TransactionResource> transactions*/) {
			super();
			this.userName = userName;
			this.userType = userType;
			this.emailId = emailId;
			this.phoneNo = phoneNo;
			this.dob = dob;
			this.gender = gender;
			this.password = password;
			this.status = status;
			this.userCode = userCode;
			this.authenticateStatus = authenticateStatus;
			this.userCount = userCount;
			this.createdDate = createdDate;
			this.emailStatus = emailStatus;
			this.confirmPassword = confirmPassword;
			this.newPassword = newPassword;
			this.userEmailIdStatus = userEmailIdStatus;
			this.source = source;
			//this.transactions  = transactions; 
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getUserType() {
			return userType;
		}
		public void setUserType(String userType) {
			this.userType = userType;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public String getPhoneNo() {
			return phoneNo;
		}
		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getUserCode() {
			return userCode;
		}
		public void setUserCode(String userCode) {
			this.userCode = userCode;
		}
		public String getAuthenticateStatus() {
			return authenticateStatus;
		}
		public void setAuthenticateStatus(String authenticateStatus) {
			this.authenticateStatus = authenticateStatus;
		}
		public String getUserCount() {
			return userCount;
		}
		public void setUserCount(String userCount) {
			this.userCount = userCount;
		}
		public String getCreatedDate() {
			return createdDate;
		}
		public void setCreatedDate(String createdDate) {
			this.createdDate = createdDate;
		}
		public String getEmailStatus() {
			return emailStatus;
		}
		public void setEmailStatus(String emailStatus) {
			this.emailStatus = emailStatus;
		}
		public String getConfirmPassword() {
			return confirmPassword;
		}
		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
		}
		public String getNewPassword() {
			return newPassword;
		}
		public void setNewPassword(String newPassword) {
			this.newPassword = newPassword;
		}
		public String getUserEmailIdStatus() {
			return userEmailIdStatus;
		}
		public void setUserEmailIdStatus(String userEmailIdStatus) {
			this.userEmailIdStatus = userEmailIdStatus;
		}
		public String getSource() {
			return source;
		}
		public void setSource(String source) {
			this.source = source;
		}
		public String getProductId() {
			return productId;
		}
		public void setProductId(String productId) {
			this.productId = productId;
		}
		/*public List<TransactionResource> getTransactions() {
			return transactions;
		}
		public void setTransactions(List<TransactionResource> transactions) {
			this.transactions = transactions;
		}*/
	    
	    
}
