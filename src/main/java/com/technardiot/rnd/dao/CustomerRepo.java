package com.technardiot.rnd.dao;

import org.springframework.data.repository.CrudRepository;

import com.technardiot.rnd.model.Customer;

public interface CustomerRepo  extends CrudRepository<Customer, Integer>
{
	
}
