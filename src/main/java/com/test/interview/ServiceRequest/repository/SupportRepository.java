package com.test.interview.ServiceRequest.repository;

import com.test.interview.ServiceRequest.entity.Support;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.UUID;

@Repository
public interface SupportRepository extends JpaRepository<Support, UUID> {

    @Transactional
    @Modifying
    @Query("update Support Set buildingCode=:buildingCode, description = :description, currentStatus=:currentStatus, createdBy= :createdBy, createdDate=:createdDate, lastModifiedBy= :lastModifiedBy, lastModifiedDate = :lastModifiedDate where id = :id")
    int updateSupportById(UUID id, String buildingCode, String description, String currentStatus, String createdBy, LocalDateTime createdDate, String lastModifiedBy, LocalDateTime lastModifiedDate);

}
