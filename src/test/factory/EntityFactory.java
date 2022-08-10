package test.factory;

import entities.Financing;

public class EntityFactory {

	public static Financing createInicializedFinance(Double totalAmount, Double income, int months) {
		return new Financing(totalAmount, income, months);
	}
}
