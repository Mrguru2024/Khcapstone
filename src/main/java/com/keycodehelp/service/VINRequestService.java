package com.keycodehelp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keycodehelp.entities.VINRequest;
import com.keycodehelp.exception.ResourceNotFoundException;
import com.keycodehelp.repositories.VINRequestRepository;

@Service
public class VINRequestService {

    private final VINRequestRepository vinRequestRepository;

    @Autowired
    public VINRequestService(VINRequestRepository vinRequestRepository) {
        this.vinRequestRepository = vinRequestRepository;
    }

    public List<VINRequest> getAllVINRequests() {
        return vinRequestRepository.findAll();
    }

    public VINRequest getVINRequestById(Long id) {
        return vinRequestRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("VINRequest not found with id: " + id));
    }

    public VINRequest createVINRequest(VINRequest vinRequest) {
        return vinRequestRepository.save(vinRequest);
    }

    public VINRequest updateVINRequest(Long id, VINRequest vinRequestDetails) {
        VINRequest vinRequest = vinRequestRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("VINRequest not found with id: " + id));
        
        // Update fields based on vinRequestDetails
        vinRequest.setVin(vinRequestDetails.getVin());
        vinRequest.setKeycodeResponse(vinRequestDetails.getKeycodeResponse());
        vinRequest.setRequestTime(vinRequestDetails.getRequestTime());

        return vinRequestRepository.save(vinRequest);
    }

    public void deleteVINRequest(Long id) {
        VINRequest vinRequest = vinRequestRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("VINRequest not found with id: " + id));
        vinRequestRepository.delete(vinRequest);
    }
}
