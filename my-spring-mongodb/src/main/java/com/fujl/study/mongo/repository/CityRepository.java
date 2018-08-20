package com.fujl.study.mongo.repository;

import com.fujl.study.mongo.domain.City;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * @program: fujialongStudy
 * @description: 城市接口
 * @author: fujialong
 * @create: 2018-08-20 21:16
 **/
public interface CityRepository extends MongoRepository<City, Long> {

    @Query("{'cityName':?0}")
    List<City> findByPage(String cityName, Pageable pageable);
}
