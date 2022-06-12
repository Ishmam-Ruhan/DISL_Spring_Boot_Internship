package com.ishmam.DhrubokPracticeProject1.Services;

import com.ishmam.DhrubokPracticeProject1.ExceptionManagement.CustomError;
import com.ishmam.DhrubokPracticeProject1.Model.User;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Service
public interface UserService {

    // Create Operation
    User addUser(User user) throws CustomError;

    String addAllUser(List<User> user) throws CustomError;

    //Read Operation
    User getUserbyId(BigInteger id) throws CustomError;

    User getUserbyEmail(String email) throws CustomError;

    List<User> getAllUser() throws CustomError;

    List<User> getUserbyBloodGroup(String bloodGroup) throws CustomError;

    List<User> getUserbyDivision(String division) throws CustomError;

    List<User> getUserbyZipCode(long zipCode) throws CustomError;

    //Delete Operation
    String deleteUserbyId(BigInteger id) throws CustomError;

    //Update Operation
    User updateUser(User user) throws CustomError;

}
