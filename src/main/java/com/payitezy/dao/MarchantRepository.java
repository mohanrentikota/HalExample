/**
 *
 */
package com.payitezy.dao;

import com.payitezy.domain.Merchant;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */

public interface MarchantRepository extends PagingAndSortingRepository<Merchant, Serializable> {

}
