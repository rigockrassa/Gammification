package com.example.echo.services;

import java.util.List;

import com.example.echo.dto.PointDto;

public interface IPointServices {
	public void savePoint(PointDto pointDto);
	List<PointDto> getPoint(List<String> lstid, String key);
}
