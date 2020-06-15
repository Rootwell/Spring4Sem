package com.example.sole_shifter.service;

import org.springframework.stereotype.Service;

@Service
public class FileStorageService {

    public String getSOURSE_PATH() {
        return SOURSE_PATH;
    }

    private final String SOURSE_PATH = "http://127.0.0.1:8887";

}
