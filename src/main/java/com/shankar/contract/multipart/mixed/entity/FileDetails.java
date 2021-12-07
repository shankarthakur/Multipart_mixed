package com.shankar.contract.multipart.mixed.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.InputStream;

@Getter
@Setter
@NoArgsConstructor
public class FileDetails {

        UserDetails userDetails;
        InputStream inputStream;
        boolean statusFailed;
}
