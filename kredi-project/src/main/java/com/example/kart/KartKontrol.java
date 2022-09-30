package com.example.kart;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;

public class KartKontrol implements JavaDelegate {

	
	static String taskId;
	@Override
	public void execute(DelegateExecution execution) throws Exception {

	
		try {
			
			//Test etmek için hata oluşturduk
			boolean  tcNo = (boolean) execution.getVariable("TC");
			String  isim = (String) execution.getVariable("name");
			String  email = (String) execution.getVariable("email");
			String  adres = (String) execution.getVariable("adres");
			
			System.out.println(tcNo);
			System.out.println(isim);
			System.out.println(email);
			System.out.println(adres);
			
		} catch (Exception e) {
			throw new BpmnError("KartHata", e.getMessage());
		}
	

		
		
	


	}


}
