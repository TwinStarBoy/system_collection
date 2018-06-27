package com.blackjade.crm.dao;

import com.blackjade.crm.model.Wallet;

public interface WalletDao {
	
	int updateBalancePlus(Wallet wallet);

	int updateBalanceMinus(Wallet wallet);

	Wallet getCacc(Wallet wallet);

	int saveCacc(Wallet wallet);

	int countCacc(Wallet wallet);
}
