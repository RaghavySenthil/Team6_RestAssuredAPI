package Utilities;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.gherkin.model.Scenario;

public class ScenarioContext {
	
	private Map<String, Object> scenarioData;
	private Scenario scenario;

	    public ScenarioContext() {
	        scenarioData = new HashMap<String, Object>();
	    }

	    public Object setContext(String key, Object value) {
	        scenarioData.put(key, value);
			return value;
	    }

	    public Object getContext(String key, String token) {
	         return scenarioData.get(key);
	    }

	    public void setScenario(Scenario scenario) {
	        this.scenario = scenario;
	    }

		public Object getContext(String string) {
			// TODO Auto-generated method stub
			return scenarioData.get(string);
		}

}
