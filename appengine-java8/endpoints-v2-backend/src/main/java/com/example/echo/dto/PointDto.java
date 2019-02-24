package com.example.echo.dto;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document(collection="point")
@Component
public class PointDto {
	@Id
    private String _id;
    private Map<String, Integer> lstPoint;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public Map<String, Integer> getLstPoint() {
		return lstPoint;
	}
	public void setLstPoint(Map<String, Integer> lstPoint) {
		this.lstPoint = lstPoint;
	}
    public void setPoint(String key, Integer value) {
    	if (lstPoint == null) {
    		lstPoint = new HashMap<>();
    	}
    	lstPoint.put(key, value);
    }
    public Integer getValue(String key) {
    	if (lstPoint == null || !lstPoint.containsKey(key)) {
    		return 0;
    	}
    	return lstPoint.get(key);
    }
}
