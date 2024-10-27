package com.example.springboot.service;

import com.example.springboot.ApiResult.ZooRequest;
import com.example.springboot.ApiResult.ZooResponse;
import java.util.List;

public interface ZooService {

    ZooResponse create(ZooRequest zooRequest);

    ZooResponse update(Integer id, ZooRequest zooRequest);

    ZooResponse updateTelephone(Integer id, String telephone);

    ZooResponse detail(Integer id);

    List<ZooResponse> list();

    void delete(Integer id);
}
