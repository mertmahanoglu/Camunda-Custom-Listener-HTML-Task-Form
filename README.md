# Camunda-Global-Listener-HTML-Task-Form

Spring Boot ve Maven kullanılarak oluşturulmuştur.

Oluşturulan bu demo proje, Camunda BPMN Engine üzerinde bulunan tüm processler için bir Listener içerisinde istenilen kodun çalıştırılmasını sağlamaktadır. Aynı zamanda process içerisinde bir HTML dosyası üzerinden girilen değerler Camunda üzerinde işlenmektedir.

# Nasıl Çalışır?

Process fark etmeksizin Application.class üzerinden ayağa kaldırılan Camunda Engine içerisindeki tüm processler CamundaExecutionListener içerisindeki notify() metodunda bulunan işlemleri gerçekleştirecektir.

```Java
public class CamundaExecutionListener implements ExecutionListener {

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		System.out.println("++ custom execution listener executed...." + execution.getId() + "process yaratan : " +  execution.getProcessEngine().getIdentityService().getCurrentAuthentication().getUserId());
        execution.setVariable("token", "aaaaaaabbbbbbbb");
	}

}
```

ParseListenerPlugin içerisinde oluşturduğumuz custom listener, engine içerisine tanımlanır.

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
