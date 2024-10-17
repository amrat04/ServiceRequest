package com.test.interview.ServiceRequest.service;

import com.test.interview.ServiceRequest.dto.SupportRequest;
import com.test.interview.ServiceRequest.entity.Support;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SupportService {

    String createNewSupport(Support support) throws Exception;

    Optional<Support> fetchSupportById(UUID id);

    List<Support> fetchAllSupports();

    void updateSupportById(UUID id, SupportRequest support);

    int deleteSupportById(UUID id);

}

