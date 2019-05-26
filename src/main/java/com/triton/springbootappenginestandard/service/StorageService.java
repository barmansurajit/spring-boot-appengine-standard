package com.triton.springbootappenginestandard.service;

import com.google.cloud.storage.Bucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.google.api.client.util.Charsets.UTF_8;

@Service
public class StorageService {

    private Bucket bucket;

    @Autowired
    public StorageService(Bucket bucket) {
        this.bucket = bucket;
    }

    public void generateFile(){
        bucket.create("blob_name", "Hello, Cloud Storage!".getBytes(UTF_8), "text/plain");
    }
}