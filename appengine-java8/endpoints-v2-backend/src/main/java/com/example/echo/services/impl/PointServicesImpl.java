package com.example.echo.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.echo.dto.PointDto;
import com.example.echo.model.Point;
import com.example.echo.repositories.IPointRepository;
import com.example.echo.services.IPointServices;

@Service("pointServices")
public class PointServicesImpl implements IPointServices {

	@Autowired
	@Qualifier("pointRepository")
	private IPointRepository pointRepository;
	
	@SuppressWarnings("unchecked")
	@Override
	public void savePoint(PointDto pointDto) {
		Point point = pointRepository.findBy_id(pointDto.get_id());
		if (point == null) {
			point = new Point();
			point.set_id(pointDto.get_id());
			point.setLstPoint(pointDto.getLstPoint());
		} else {
			Iterator<?> it = pointDto.getLstPoint().entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry<String, Integer> pair = (Entry<String, Integer>)it.next();
		        System.out.println(pair.getKey() + " = " + pair.getValue());
		        point.setPoint(pair.getKey(), pair.getValue());
		    }
		}
		pointRepository.save(point);
	}

	@Override
	public List<PointDto> getPoint(List<String> lstid, String key) {
		List<Point> lstPoint = pointRepository.findbyLst(lstid);
		List<PointDto> lstPointDto = new ArrayList<>();
		for (Point p:lstPoint) {
			PointDto pDto = new PointDto();
			pDto.set_id(p.get_id());
			pDto.setPoint(key, p.getValue(key));
			lstPointDto.add(pDto);
		}
		return lstPointDto;
	}

}
