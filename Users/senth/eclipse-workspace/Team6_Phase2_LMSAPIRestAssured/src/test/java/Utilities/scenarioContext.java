package Utilities;
import java.util.HashMap;
import java.util.Map;


public class scenarioContext {

	    private Map<String, Object> context;

	    public scenarioContext() {
	        context = new HashMap<>();
	    }

	    public Object setContext(String key, Object value) {
	        return context.put(key, value);
	    }

	    public Object getContext(String key) {
	        return context.get(key);
	    }

	    public boolean isContextContains(String key) {
	        return context.containsKey(key);
	    }
	}


