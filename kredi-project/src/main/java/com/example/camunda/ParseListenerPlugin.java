package com.example.camunda;


import org.camunda.bpm.engine.impl.bpmn.parser.BpmnParseListener;
import org.camunda.bpm.engine.impl.cfg.AbstractProcessEnginePlugin;
import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.camunda.bpm.spring.boot.starter.configuration.Ordering;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ParseListenerPlugin extends AbstractProcessEnginePlugin {
	
	    @Override
	    public void preInit(ProcessEngineConfigurationImpl processEngineConfiguration) {

	       

	        // get all existing preParseListeners
	        List<BpmnParseListener> preParseListeners = processEngineConfiguration.getCustomPostBPMNParseListeners();

	        if (preParseListeners == null) {
	            preParseListeners = new ArrayList<>();
	        }

	        // add our new custom BPMN Parse Listener
	        preParseListeners.add(new ParseListener());
	        processEngineConfiguration.setCustomPostBPMNParseListeners(preParseListeners);
	    }

	
	
}
