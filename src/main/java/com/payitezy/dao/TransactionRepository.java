/**
 *
 */
package com.payitezy.dao;

import com.payitezy.domain.Transaction;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */
public interface TransactionRepository extends PagingAndSortingRepository<Transaction, Serializable> {

}
