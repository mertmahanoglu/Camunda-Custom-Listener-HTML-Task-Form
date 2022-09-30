package com.example.kart;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

public class CardInfo implements ExecutionListener {

	@Override
	public void notify(DelegateExecution execution) throws Exception {

		execution.setVariable("kartNo", "3651 5471 8471 1111");
		execution.setVariable("CVV", "300");
		execution.setVariable("tarih", "01/2030");

	}

}
