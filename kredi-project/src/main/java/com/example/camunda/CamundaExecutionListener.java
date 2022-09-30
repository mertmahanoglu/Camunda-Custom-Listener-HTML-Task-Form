package com.example.camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

public class CamundaExecutionListener implements ExecutionListener {

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		System.out.println("++ custom execution listener executed...." + execution.getId() + "process yaratan : " +  execution.getProcessEngine().getIdentityService().getCurrentAuthentication().getUserId());
        execution.setVariable("token", "aaaaaaabbbbbbbb");
	}

}
