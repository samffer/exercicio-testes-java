package test.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;
import test.factory.EntityFactory;

public class FinanceTest {

	@Test
	void constructorShouldCreateAnObjectWhenParametersAreValid() {
		double totalAmount = 100000.0; 
		double income = 2000.0; 
		int months = 80;
		
		Financing fin = EntityFactory.createInicializedFinance(totalAmount, income, months);
		Assertions.assertEquals(Financing.class, fin.getClass());
	}
	
	@Test
	void constructorShouldThrowIllegalArgumentExceptionWhenParamentersAreInvalid() {
		double totalAmount = 100000.0; 
		double income = 2000.0; 
		int months = 20;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing fin = EntityFactory.createInicializedFinance(totalAmount, income, months);
		});
	}
	
	@Test
	void amountShouldBeUpdatedWhenParamentersAreValid() {
		double totalAmount = 0.0; 
		double income = 2000.0; 
		int months = 80;
		
		Double newTotalAmount = 100000.0;
		
		Financing fin = EntityFactory.createInicializedFinance(totalAmount, income, months);
		
		fin.setTotalAmount(newTotalAmount);
		
		Assertions.assertEquals(newTotalAmount,fin.getTotalAmount());
	}
	
	@Test
	void amountShouldThrowExceptionWhenParamentersAreInvalid() {
		double totalAmount = 0.0; 
		double income = 2000.0; 
		int months = 80;
		
		Double newTotalAmount = 1000000.0;
		
		Financing fin = EntityFactory.createInicializedFinance(totalAmount, income, months);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			fin.setTotalAmount(newTotalAmount);
		});	}


@Test
void incomeShouldBeUpdatedWhenParamentersAreValid() {
	double totalAmount = 100000.0; 
	double income = 2000.0; 
	int months = 80;
	
	Double newIncome = 100000.0;
	
	Financing fin = EntityFactory.createInicializedFinance(totalAmount, income, months);
	
	fin.setIncome(newIncome);
	
	Assertions.assertEquals(newIncome,fin.getIncome());
}

@Test
void incomeShouldThrowExceptionWhenParamentersAreInvalid() {
	double totalAmount = 100000.0; 
	double income = 2000.0; 
	int months = 80;
	
	Double newIncome = 1000.0;
	
	Financing fin = EntityFactory.createInicializedFinance(totalAmount, income, months);
	
	Assertions.assertThrows(IllegalArgumentException.class, () -> {
		fin.setIncome(newIncome);
	});	}

@Test
void monthsShouldBeUpdatedWhenParamentersAreValid() {
	double totalAmount = 100000.0; 
	double income = 2000.0; 
	int months = 80;
	
	int newMonths = 100;
	
	Financing fin = EntityFactory.createInicializedFinance(totalAmount, income, months);
	
	fin.setMonths(newMonths);
	
	Assertions.assertEquals(newMonths,fin.getMonths());
}

@Test
void monthsShouldThrowExceptionWhenParamentersAreInvalid() {
	double totalAmount = 100000.0; 
	double income = 2000.0; 
	int months = 80;
	
	int newMonths = 10;
	
	Financing fin = EntityFactory.createInicializedFinance(totalAmount, income, months);
	
	Assertions.assertThrows(IllegalArgumentException.class, () -> {
		fin.setMonths(newMonths);
	});	}

@Test
void entryShouldCalcAmountEntry() {
	double totalAmount = 100000.0; 
	double income = 2000.0; 
	int months = 80;
	
		Financing fin = EntityFactory.createInicializedFinance(totalAmount, income, months);
		
		Assertions.assertTrue(totalAmount * 0.2 <= fin.entry());
}

@Test
void quotaShouldCalcAmountQuota() {
	double totalAmount = 100000.0; 
	double income = 2000.0; 
	int months = 80;
	
		Financing fin = EntityFactory.createInicializedFinance(totalAmount, income, months);
		
		Assertions.assertTrue((totalAmount - (totalAmount * 0.2))/months <= fin.quota());
}

}