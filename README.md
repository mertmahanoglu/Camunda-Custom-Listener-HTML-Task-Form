# Camunda-Global-Listener-HTML-Task-Form

It is developed with Spring Boot, Maven.

This projects provides to run code with Listener for every process you have. At the same time, catches input values from HTML form in Listener to process values with any purpose.

# How it works?



Regardless of the process, all processes in Camunda Engine, which are raised through Application.class, will perform the operations in the notify() method in CamundaExecutionListener.

```Java
public class CamundaExecutionListener implements ExecutionListener {

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		System.out.println("++ custom execution listener executed...." + execution.getId() + "process yaratan : " +  execution.getProcessEngine().getIdentityService().getCurrentAuthentication().getUserId());
        execution.setVariable("token", "aaaaaaabbbbbbbb");
	}

}
```

The custom listener we created in the ParseListenerPlugin is defined in the engine with *processEngineConfiguration.setCustomPostBPMNParseListeners(preParseListeners);*

```Java
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
```
