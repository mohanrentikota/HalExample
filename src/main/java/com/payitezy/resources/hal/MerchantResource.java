package com.payitezy.resources.hal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.core.Relation;

import com.payitezy.model.TransactionModel;

@Relation(value="user", collectionRelation="users")
public class MerchantResource extends ResourceWithEmbeddeds {
	private String merchantName;
	private String merchantId;
   // private List<TransactionResource> transactions = new ArrayList<TransactionResource>(0);
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
}
