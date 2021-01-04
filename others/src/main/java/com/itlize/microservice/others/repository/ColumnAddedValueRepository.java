package com.itlize.microservice.others.repository;


import com.itlize.microservice.others.entity.ColumnAddedValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ColumnAddedValueRepository extends JpaRepository<ColumnAddedValue, Integer> {

    @Modifying
    @Query(value="update column_added_value set value= ? where resource_id=? and column_id=? ", nativeQuery = true)
    @Transactional
    void update(String value, int resourse_id, int column_id);

    @Modifying
    @Query(value="delete from column_added_value where resource_id=? ", nativeQuery = true)
    @Transactional
    void deleteByResouce(int resource_id);

    @Modifying
    @Query(value="delete from column_added_value where column_id=? ", nativeQuery = true)
    @Transactional
    void deleteByColumn(int column_id);


    @Modifying
    @Query(value="insert into column_added_value(resource_id,column_id) values(:resource_id,:column_id) ", nativeQuery = true)
    @Transactional
    void addRow(@Param("resource_id") int resourse_id, @Param("column_id") int column_id);

    @Modifying
    @Query(value="insert into column_added_value(resource_id,column_id,value) values(:resource_id,:column_id,:celValue) ", nativeQuery = true)
    @Transactional
    void addRow(@Param("resource_id") int resourse_id, @Param("column_id") int column_id, @Param("celValue") String celValue);

    @Query(value = "SELECT * FROM column_added_value WHERE column_id=? and resource_id = ?", nativeQuery = true)
    ColumnAddedValue get(int column_id, int resource_id);
}
