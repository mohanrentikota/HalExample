package com.payitezy.resources.hal;

import org.springframework.hateoas.core.Relation;

@Relation(value="transaction",collectionRelation="users")
public class TransactionResource extends ResourceWithEmbeddeds {
	  private String marchantId;
	    private String usersId;
	    private String source;
	    private String channel;
	    private String amountReceivedDate;
	    private String status;
	    private String marchantPercentage;
	    private String orderId;
		public String getMarchantId() {
			return marchantId;
		}
		public void setMarchantId(String marchantId) {
			this.marchantId = marchantId;
		}
		public String getUsersId() {
			return usersId;
		}
		public void setUsersId(String usersId) {
			this.usersId = usersId;
		}
		public String getSource() {
			return source;
		}
		public void setSource(String source) {
			this.source = source;
		}
		public String getChannel() {
			return channel;
		}
		public void setChannel(String channel) {
			this.channel = channel;
		}
		public String getAmountReceivedDate() {
			return amountReceivedDate;
		}
		public void setAmountReceivedDate(String amountReceivedDate) {
			this.amountReceivedDate = amountReceivedDate;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getMarchantPercentage() {
			return marchantPercentage;
		}
		public void setMarchantPercentage(String marchantPercentage) {
			this.marchantPercentage = marchantPercentage;
		}
		public String getOrderId() {
			return orderId;
		}
		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}
}
