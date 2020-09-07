package com.project.offer.services;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import static org.apache.commons.codec.digest.MessageDigestAlgorithms.SHA3_256;

@Service
public class HashingPasswordService {

    public String getSHA256HashOfString(String password){
        String hashPassword = new DigestUtils(SHA3_256).digestAsHex(password);

        return hashPassword;
    }
}
