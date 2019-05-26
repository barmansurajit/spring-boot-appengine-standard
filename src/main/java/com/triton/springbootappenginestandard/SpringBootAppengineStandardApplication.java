package com.triton.springbootappenginestandard;

import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.StorageOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.google.cloud.storage.StorageClass.COLDLINE;

@SpringBootApplication
public class SpringBootAppengineStandardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAppengineStandardApplication.class, args);
    }

    @Bean
    public Bucket createStorageBucket() {
        return StorageOptions.getDefaultInstance()
                .getService()
                .create(BucketInfo.newBuilder("bookshelf-238313")
                        .setStorageClass(COLDLINE)
                        .build());
    }
}