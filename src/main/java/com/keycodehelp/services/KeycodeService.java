package com.keycodehelp.services;

import com.keycodehelp.entities.Keycode;
import com.keycodehelp.entities.KeycodeRequest;
import com.keycodehelp.entities.User;
import com.keycodehelp.repositories.KeycodeRepository;
import com.keycodehelp.repositories.KeycodeRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class KeycodeService {

    @Autowired
    private KeycodeRepository keycodeRepository;

    @Autowired
    private KeycodeRequestRepository keycodeRequestRepository;

    // Convert VIN to Keycode
    public Keycode convertVinToKeycode(String vin, User user) {
        String generatedKeycode = "KEY-" + vin.toUpperCase();
        Keycode keycode = new Keycode(vin, generatedKeycode, new Date(), user);
        keycodeRepository.save(keycode);

        // Log the request
        KeycodeRequest request = new KeycodeRequest(vin, new Date(), user);
        keycodeRequestRepository.save(request);

        return keycode;
    }

    // Get keycode request history for user
    public List<KeycodeRequest> getKeycodeHistory(User user) {
        return keycodeRequestRepository.findByUserId(user.getId());
    }
}
