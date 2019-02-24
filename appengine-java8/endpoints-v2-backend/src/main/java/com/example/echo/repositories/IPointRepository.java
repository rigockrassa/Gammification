package com.example.echo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.echo.model.Point;


@Repository("pointRepository")
public interface IPointRepository extends MongoRepository<Point, String>{
	public Point findBy_id(String id);

	@Query(value="{\"_id\":{$in :?0}}")
	public List<Point> findbyLst(List<String> lstid);
}
