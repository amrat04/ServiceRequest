package com.test.interview.ServiceRequest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.interview.ServiceRequest.dto.SupportRequest;
import com.test.interview.ServiceRequest.entity.CurrentStatus;
import com.test.interview.ServiceRequest.entity.Support;
import com.test.interview.ServiceRequest.repository.SupportRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class SupportServiceImpl implements SupportService {

    @Autowired
    SupportRepository supportRepository;

    @Override
    public String createNewSupport(Support supportrequest) throws Exception {

        try {
            supportrequest.setId(UUID.randomUUID());
            if (Stream.of(CurrentStatus.values()).anyMatch(v -> v.name().equals(supportrequest.getCurrentStatus()))) {
                Support supportResponse = supportRepository.save(supportrequest);
                return "support has been created with id : " + supportResponse.getId();
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception();
        }

    }


    @Override
    public Optional<Support> fetchSupportById(UUID id) {
        Optional<Support> supportResponse = null;
        try {
            supportResponse = supportRepository.findById(id);
        } catch (Exception e) {
            e.getMessage();
        }
        return supportResponse;

    }

    @Override
    public List<Support> fetchAllSupports() {

        List<Support> allSupports = supportRepository.findAll();
        return allSupports;
    }

    @Override
    public void updateSupportById(UUID id, SupportRequest support) {

        Optional<Support> supportRequest = supportRepository.findById(id);
        if(supportRequest.isPresent()){
            Support supportResponse = supportRequest.get();
            BeanUtils.copyProperties(supportResponse,support);
            supportRepository.save(supportResponse);
        }else {

        }

    }

    @Override
    public int deleteSupportById(UUID id) {
        int success=0;
        try {
            Optional<Support> supportOptional = supportRepository.findById(id);
            if(supportOptional.isPresent()) {
                supportRepository.deleteById(id);
                success=1;
            }
        } catch(Exception e ){
            e.getMessage();
        }
        return success;
    }
}
