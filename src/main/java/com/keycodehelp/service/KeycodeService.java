package com.keycodehelp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keycodehelp.entities.Keycode;
import com.keycodehelp.repositories.KeycodeRepository;



@Service
public class KeycodeService {

    @Autowired
    private KeycodeRepository keycodeRepository;

    public List<Keycode> getAllKeycodes() {
        return keycodeRepository.findAll();
    }

    public Optional<Keycode> getKeycodeById(Long id) {
        return keycodeRepository.findById(id);
    }

    public Keycode saveKeycode(Keycode keycode) {
        return keycodeRepository.save(keycode);
    }

    public void deleteKeycode(Long id) {
        keycodeRepository.deleteById(id);
    }
}
