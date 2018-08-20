package com.fujl.study.mongo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @program: fujialongStudy
 * @description: 城市
 * @author: fujialong
 * @create: 2018-08-20 20:58
 **/
@Data
@Builder
@Document(collection = "city")
@NoArgsConstructor
@AllArgsConstructor
public class City {

    @Id
    private String id;

    /**
     * 省份编号
     */
    private String provinceCode;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 描述
     */
    private String description;
}
