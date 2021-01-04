package com.itlize.microservice.others.repository;

import com.itlize.microservice.others.entity.ColumnAdded;
import com.itlize.microservice.others.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ColumnAddedRepository extends JpaRepository<ColumnAdded, Integer> {
//    @Modifying
//    @Query(value="insert into column_added (column_added_name) values(:column_name)", nativeQuery=true)
//    @Transactional
//    int addColumn(String column_name);



    @Modifying
    @Query(value = "insert into column_added(column_name, project_id) values(:coloumName,:projectId) ", nativeQuery = true)
    @Transactional
    void addColumn(@Param("coloumName") String coloumName, @Param("projectId") int projectId);


    @Query(value = "SELECT * FROM column_added WHERE project_id = ?", nativeQuery = true)
    List<ColumnAdded> getAllColumnByProject(int project_id);

    @Query(value = "SELECT * FROM column_added WHERE column_name =? and project_id = ? ", nativeQuery = true)
    ColumnAdded get(String column_name, int project_id);

    List<ColumnAdded> findByProject(Project project);

    @Modifying
    @Query(value = "delete from column_added where column_id=?",nativeQuery = true)
    @Transactional
    void deleteColumn(int column_id);

}