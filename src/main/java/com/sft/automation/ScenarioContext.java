package com.sft.automation;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    Map<String, String> data = new HashMap<>();

    public void setContext(String key, String value){
        data.put(key, value);
    }

    public String getContext(String key){
        return data.get(key);
    }

}
