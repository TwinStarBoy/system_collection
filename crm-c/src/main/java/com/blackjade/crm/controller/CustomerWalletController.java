package com.blackjade.crm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blackjade.crm.apis.wallet.CDeposit;
import com.blackjade.crm.apis.wallet.CDepositAns;
import com.blackjade.crm.apis.wallet.CSaveCacc;
import com.blackjade.crm.apis.wallet.CSaveCaccAns;
import com.blackjade.crm.apis.wallet.CWithdraw;
import com.blackjade.crm.apis.wallet.CWithdrawAns;
import com.blackjade.crm.apis.wallet.WalletStatus;
import com.blackjade.crm.exception.MyException;
import com.blackjade.crm.service.WalletService;

@RestController
public class CustomerWalletController {
	private static Logger logger = LoggerFactory.getLogger(CustomerWalletController.class);
	
	@Autowired
	WalletService walletService;
	
	@RequestMapping(value = "/cDeposit" )
	@ResponseBody
	public CDepositAns deposit(@RequestBody CDeposit cDeposit){

		CDepositAns cRechargeAns = new CDepositAns();
		cRechargeAns.setRequestid(cDeposit.getRequestid());
		cRechargeAns.setQuantity(cDeposit.getQuantity());
		cRechargeAns.setClientId(cDeposit.getClientid());
		cRechargeAns.setPnsgid(cDeposit.getPnsgid());
		cRechargeAns.setPnsid(cDeposit.getPnsid());
		
		WalletStatus.DepositEnum plusBalance = cDeposit.reviewData();
		
		if (plusBalance != WalletStatus.DepositEnum.SUCCESS){
			cRechargeAns.setStatus(plusBalance);
			return cRechargeAns;
		}

		try {
			walletService.deposit(cDeposit);
			cRechargeAns.setStatus(WalletStatus.DepositEnum.SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			cRechargeAns.setStatus(WalletStatus.DepositEnum.FAILED);
		}
		
		
		return cRechargeAns ;
		
	}
	
	@RequestMapping(value = "/cWithdraw" ,method = RequestMethod.POST)
	@ResponseBody
	public CWithdrawAns withdraw(@RequestBody CWithdraw cWithdraw){
		
		CWithdrawAns enchashmentResp = new CWithdrawAns();
		enchashmentResp.setRequestid(cWithdraw.getRequestid());
		enchashmentResp.setQuantity(cWithdraw.getQuantity());
		enchashmentResp.setClientId(cWithdraw.getClientid());
		enchashmentResp.setPnsgid(cWithdraw.getPnsgid());
		enchashmentResp.setPnsid(cWithdraw.getPnsid());
		
		WalletStatus.WithdrawEnum minusBalance = cWithdraw.reviewData();
		
		if (minusBalance != WalletStatus.WithdrawEnum.SUCCESS){
			enchashmentResp.setStatus(minusBalance);
			return enchashmentResp;
		}
		
		try {
			walletService.withdraw(cWithdraw);
			enchashmentResp.setStatus(WalletStatus.WithdrawEnum.SUCCESS);
		} catch (MyException e) {
			logger.error(e.getMessage(), e);
			enchashmentResp.setStatus(e.getStatusEnum());
		}
		
		return enchashmentResp ;
		
	}
	
	@RequestMapping(value = "/cSaveCacc" )
	@ResponseBody
	public CSaveCaccAns saveCacc(@RequestBody CSaveCacc cSaveCacc){
		
		CSaveCaccAns cSaveCaccAns = new CSaveCaccAns();
		cSaveCaccAns.setRequestid(cSaveCacc.getRequestid());
		cSaveCaccAns.setPnsgid(cSaveCacc.getPnsgid());
		cSaveCaccAns.setPnsid(cSaveCacc.getPnsid());
		cSaveCaccAns.setClientid(cSaveCacc.getClientid());
		cSaveCaccAns.setCgid(WalletStatus.CUSTOMER_GROUP_ID);//默认分组，为1

		
		WalletStatus.SaveCaccEnum saveCacc = cSaveCacc.reviewData();
		
		if (saveCacc != WalletStatus.SaveCaccEnum.SUCCESS){
			cSaveCaccAns.setStatus(saveCacc);
			return cSaveCaccAns;
		}
		
		try {
			walletService.saveCacc(cSaveCacc);
			cSaveCaccAns.setStatus(WalletStatus.DepositEnum.SUCCESS);
		} catch (MyException e) {
			logger.error(e.getMessage(), e);
			cSaveCaccAns.setStatus(e.getStatusEnum());
		}
		
		return cSaveCaccAns ;
		
	}
	
}
