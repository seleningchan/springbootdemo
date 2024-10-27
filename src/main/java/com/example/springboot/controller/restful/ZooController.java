package com.example.springboot.controller.restful;

import com.example.springboot.ApiResult.AnimalRequest;
import com.example.springboot.ApiResult.AnimalResponse;
import com.example.springboot.ApiResult.ZooRequest;
import com.example.springboot.ApiResult.ZooResponse;
import com.example.springboot.service.AnimalService;
import com.example.springboot.service.ZooService;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zoos")
public class ZooController {

    private ZooService zooService;

    private AnimalService animalService;

    public ZooController(ZooService zooService, AnimalService animalService) {
        this.zooService = zooService;
        this.animalService = animalService;
    }

    /**
     * 查询所有动物园
     *
     * @return ZooResponse
     */
    @GetMapping()
    public ResponseEntity<List<ZooResponse>> list() {
        return ResponseEntity.ok(zooService.list());
    }

    /**
     * 获取动物园详情
     *
     * @param id 动物园id
     * @return ZooResponse
     */
    @SneakyThrows
    @GetMapping(value = "/{id}")
    public ResponseEntity<ZooResponse> detail(@PathVariable("id") Integer id) {

        return ResponseEntity.ok(zooService.detail(id));
    }

    /**
     * 新增一个动物园
     *
     * @param zooRequest 动物园信息
     * @return ZooResponse
     */
    @PostMapping
    public ResponseEntity<ZooResponse> create(@RequestBody @Validated ZooRequest zooRequest) {
        return ResponseEntity.ok(zooService.create(zooRequest));
    }

    /**
     * 删除指定动物园
     *
     * @param id 动物园id
     */
    @SneakyThrows
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id) {
        zooService.delete(id);
    }

    /**
     * 更新动物园信息，整个对象信息
     *
     * @param id         动物园id
     * @param zooRequest 动物园全部信息
     * @return ZooResponse
     */
    @SneakyThrows
    @PutMapping(value = "/{id}")
    public ResponseEntity<ZooResponse> update(@PathVariable("id") Integer id, @RequestBody @Validated ZooRequest zooRequest) {
        return ResponseEntity.ok(zooService.update(id, zooRequest));
    }

    /**
     * 更新动物园信息，部分对象信息
     *
     * @param id        动物园id
     * @param telephone 手机号
     * @return ZooResponse
     */
    @SneakyThrows
    @PatchMapping(value = "/{id}")
    public ResponseEntity<ZooResponse> updatePart(@PathVariable("id") Integer id, @RequestParam(value = "telephone", required = true) String telephone) {
        return ResponseEntity.ok(zooService.updateTelephone(id, telephone));
    }

    /**
     * 指定动物园新增动物
     *
     * @param zooId 动物园id
     * @return 动物信息
     */
    @SneakyThrows
    @PostMapping(value = "/{zooId}/animals")
    public ResponseEntity<AnimalResponse> createAnimal(@PathVariable("zooId") Integer zooId, @RequestBody AnimalRequest animalRequest) {
        return ResponseEntity.ok(animalService.create(zooId, animalRequest));
    }

    /**
     * 查询指定动物园下所有动物
     *
     * @param zooId 动物园id
     * @return
     */
    @GetMapping(value = "/{zooId}/animals")
    public ResponseEntity<List<AnimalResponse>> listAnimals(@PathVariable("zooId") Integer zooId) {

        return ResponseEntity.ok(animalService.listZooAnimals(zooId));
    }
}
