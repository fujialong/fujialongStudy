package com.test.city;

import com.base.TestBase;
import com.fujl.study.mongo.domain.City;
import com.fujl.study.mongo.repository.CityRepository;
import com.github.jsonzou.jmockdata.JMockData;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: fujialongStudy
 * @description: 城市测试
 * @author: fujialong
 * @create: 2018-08-20 21:27
 **/
public class CityTest extends TestBase {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void test() {
        City city = JMockData.mock(City.class);
        System.out.println(city.getId());
        cityRepository.insert(city);
    }

    @Test
    public void testFind() {
        System.out.println(cityRepository.findById(1013L));
        mongoTemplate.findAll(City.class);
    }

    @Test
    public void testAdd() {
        List<City> cities = buildCitys(10000);
        cityRepository.insert(cities);
    }

    public List<City> buildCitys(int size) {
        List<City> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            City city = JMockData.mock(City.class);
            city.setId(new ObjectId().toString());
            city.setDescription("fujl");
            list.add(city);
        }
        return list;
    }

    @Test
    public void testFindPage() {
        Pageable pageable = new PageRequest(1,
                10, Sort.Direction.ASC, "id");
        Example example = Example.of(City.builder().description("fujl").build());
        Page<City> page = cityRepository.findAll(example, pageable);
        System.out.println(page.getContent().size());

    }

    @Test
    public void testFindPageOf() {
        Pageable pageable = new PageRequest(1,
                10, Sort.Direction.ASC, "id");
        //这种方法实现不了
        List<City> list = cityRepository.findByPage("fujl", pageable);
        System.out.println(list.size());
    }

}
