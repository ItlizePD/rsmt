package com.itlize.microservice.resource.repository;

import com.itlize.microservice.resource.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer> {


    @Modifying
    @Query(value="insert into Resource where projeect_id=?", nativeQuery = true)
    @Transactional
    Resource addResource(int project_id);

//    @Query(value = "select * from Resource where project_id=?",
//            countQuery = "SELECT count(*) Resource r WHERE r.project_id = ?",
//            nativeQuery = true)
//    List<Resource> getResourceByProject(int project_id, Pageable pageable);

    @Query(value = "select * from Resource where project_id=?",
            nativeQuery = true)
    List<Resource> getResourceByProject(int project_id);

//    @Modifying
//    @Query(value="delete from Resource where project_id=?", nativeQuery = true)
//    @Transactional
//    void deleteByProject(int project_id);

//    @Modifying
//    @Query(value="insert into Resource where resource_name = ? and resouurce_code = ? and projeect_id=?", nativeQuery = true)
//    @Transactional
//    void addResource(String name, String code, int projectId);

    @Modifying
    @Query(value="delete from Resource where resource_id=?", nativeQuery = true)
    @Transactional
    void deleteOneResource(int resourceId);

    @Modifying
    @Query(value="delete from Resource where project_id=?", nativeQuery = true)
    @Transactional
    void deleteResourceByProject(int projectId);

//    @Modifying
//    @Query(value="update Resource set resource_name=? where resource_id=? ", nativeQuery = true)
//    @Transactional
//    void updateResourceName( String celValue,int resourceId);
//
//    @Modifying
//    @Query(value="update Resource set resource_code=? where resource_id=? ", nativeQuery = true)
//    @Transactional
//    void updateResourceCode(String celValue,int resourceId);

//    @Query(value = "select resource.resource_id, resource.resource_name, resource.resource_code, column_added_row_value_id, column_added_name, row_value from resource left outer join column_added_row_value carv on resource.resource_id = carv.resource_id", nativeQuery = true)
//    Page<Resource> getAll(Pageable pageable);
//
//    @Query("select c from Resource c where c.resource_name like %:keyword% or c.resource_code like %:keyword%")
//    Page<Resource> findByKeyword(Pageable pageable, String keyword);
//
//    @Query("update Resource r set r.resource_name = :resource_name, r.resource_code = :resource_code where r.resource_id = :resource_id")
//    @Modifying
//    @Transactional
//    int updateResource(int resource_id, int resource_code, String resource_name);
}

