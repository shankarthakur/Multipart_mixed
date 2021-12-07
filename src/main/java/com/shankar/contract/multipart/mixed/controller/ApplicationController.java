package com.shankar.contract.multipart.mixed.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.shankar.contract.multipart.mixed.entity.FileDetails;
import com.shankar.contract.multipart.mixed.entity.UserDetails;
import com.shankar.contract.multipart.mixed.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

@RestController
public class ApplicationController {

    private final int PART = 2;

    UserDetails userDetails;

    @Autowired
     ApplicationService applicationService;


    @RequestMapping(value = "/test",
            method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_MIXED_VALUE)
    public String multipartRequest(HttpServletRequest request) throws ServletException, IOException {

                FileDetails fileDetails = multipartReq(request);
                String result = applicationService.saveFile(fileDetails);
        return result;
    }


    public FileDetails multipartReq(HttpServletRequest request) throws ServletException, IOException {

        StandardMultipartHttpServletRequest myrequest = new StandardMultipartHttpServletRequest(request);
        FileDetails file_Details_details = new FileDetails();
        Collection<Part> requestParts = myrequest.getParts();
        System.out.println("inside the part"+myrequest.getParts().size());
        if (requestParts.size() != PART){
            file_Details_details.setStatusFailed(true);
            return file_Details_details;
        }
        requestParts.forEach((a) -> {

            if (a.getContentType().contains("application/json")) {
                try {
                    UserDetails userDetails = new ObjectMapper().readValue(a.getInputStream(), UserDetails.class);
                    file_Details_details.setUserDetails(userDetails);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (a.getContentType().contains("application/octet-stream")) {
                try {
                    InputStream fileStream = a.getInputStream();
                    file_Details_details.setInputStream(fileStream);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        });
        return file_Details_details;
    }
}