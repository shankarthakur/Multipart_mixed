package com.shankar.contract.multipart.mixed.service;

import com.shankar.contract.multipart.mixed.entity.FileDetails;
import com.shankar.contract.multipart.mixed.entity.UserDetails;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class ApplicationService {



    public String saveFile(FileDetails fileDetails) throws IOException {
        UserDetails user_Details_details = fileDetails.getUserDetails();
        InputStream wavStream = fileDetails.getInputStream();
        return "Successfully Processed!!!";
    }
}
