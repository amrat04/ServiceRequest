package com.test.interview.ServiceRequest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "support_tbl")
public class Support {

        @Id
        @Column(name = "id", nullable = false)
        private UUID id;

        @Column(name = "building_code")
        String buildingCode;
        @Column(name = "description")

        String description;
        @Column(name = "currentstatus")

        String currentStatus;

        @Column(name = "created_by")

        String createdBy;
        @Column(name = "created_date")

        LocalDateTime createdDate;

        @Column(name = "last_modified_by")
        String lastModifiedBy;

        @Column(name = "last_modified_date")

        LocalDateTime lastModifiedDate;

        public UUID getId() {
                return id;
        }

        public void setId(UUID id) {
                this.id = id;
        }

        public String getBuildingCode() {
                return buildingCode;
        }

        public void setBuildingCode(String buildingCode) {
                this.buildingCode = buildingCode;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public String getCurrentStatus() {
                return currentStatus;
        }

        public void setCurrentStatus(String currentStatus) {
                this.currentStatus = currentStatus;
        }

        public String getCreatedBy() {
                return createdBy;
        }

        public void setCreatedBy(String createdBy) {
                this.createdBy = createdBy;
        }

        public LocalDateTime getCreatedDate() {
                return createdDate;
        }

        public void setCreatedDate(LocalDateTime createdDate) {
                this.createdDate = createdDate;
        }

        public String getLastModifiedBy() {
                return lastModifiedBy;
        }

        public void setLastModifiedBy(String lastModifiedBy) {
                this.lastModifiedBy = lastModifiedBy;
        }

        public LocalDateTime getLastModifiedDate() {
                return lastModifiedDate;
        }

        public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
                this.lastModifiedDate = lastModifiedDate;
        }
}
