package com.ewelina.recipes.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService{
    @Override
    public void saveImageFile(Long valueOf, MultipartFile file) {

        log.debug("Received a file");
    }
}