package com.example.camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class RetProcess implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {


		String retSebebi = (String) execution.getVariable("retSebebi");
		
		execution.getProcessEngine().getRuntimeService()
		.createMessageCorrelation("SubBasvuruRetMessage")
		.setVariable("retSebebi", retSebebi)
		.correlate();

	}

}
