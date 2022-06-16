package com.ishmam.DhrubokPracticeProject1.ServicesImpl;

import com.ishmam.DhrubokPracticeProject1.ExceptionManagement.CustomError;
import com.ishmam.DhrubokPracticeProject1.Model.User;
import com.ishmam.DhrubokPracticeProject1.Repositories.UserRepo;
import com.ishmam.DhrubokPracticeProject1.Services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UserRepo userRepo;


    @Override
    public User addUser(User user) throws CustomError {

        User savedUser = userRepo.save(user);

        if(savedUser != null){
            return savedUser;
        }else{
            logger.error("User is NULL!!");
            throw new CustomError(HttpStatus.BAD_REQUEST,"Operation Failed! Please Try again..");
        }
    }

    @Override
    public String addAllUser(List<User> user) throws CustomError {

        try{
            userRepo.saveAll(user);
        }catch (Exception ex){
            logger.error(ex.getMessage());
            throw new CustomError(HttpStatus.BAD_REQUEST,"Operation Failed! Please Try again..");
        }
        return "All Users Saved Successfully!";
    }

    @Override
    public User getUserbyId(BigInteger id) throws CustomError {

        User user = userRepo.findById(id).orElse(null);

        if(user == null){
            logger.error("User is NULL!");
            throw new CustomError(HttpStatus.NOT_FOUND,"User with id: "+id+" not found!");
        }

        return user;
    }

    @Override
    public User getUserbyEmail(String email) throws CustomError {

        User user = userRepo.findByemail(email).orElse(null);

        if(user == null){
            logger.error("User is NULL!");
            throw new CustomError(HttpStatus.NOT_FOUND,"User with email: "+email+" not found!");
        }

        return user;
    }

    @Override
    public List<User> getAllUser() throws CustomError {
        return userRepo.findAll();
    }

    @Override
    public List<User> getUserbyBloodGroup(String bloodGroup) throws CustomError {

        List<User> user = userRepo.findBybloodGroup(bloodGroup);

        return user;
    }

    @Override
    public List<User> getUserbyDivision(String division) throws CustomError {
        List<User> users = userRepo.findAll();

        List<User> usersOfDivision = users.stream()
                .filter(user -> user.getAddress().getDivision().equals(division))
                .collect(Collectors.toList());


        return usersOfDivision;
    }

    @Override
    public List<User> getUserbyZipCode(long zipCode) throws CustomError {
        List<User> users = userRepo.findAll();

        List<User> usersOfZipcode = users.stream()
                .filter(user -> user.getAddress().getZipCode() == zipCode)
                .collect(Collectors.toList());

        return usersOfZipcode;
    }


    @Override
    public String deleteUserbyId(BigInteger id) throws CustomError {

        User user = getUserbyId(id);

        userRepo.deleteById(user.getId());

        return "Successfully Deleted User!";
    }

    @Override
    public User updateUser(User updatedUser) throws CustomError {

        User user = getUserbyId(updatedUser.getId());

        if(user == null){
            logger.error("User is NULL!");
            throw new CustomError(HttpStatus.NOT_FOUND,"User with id: "+updatedUser.getId()+" not found!");
        }

        user.setAddress(updatedUser.getAddress() != null ? updatedUser.getAddress() : user.getAddress());
        user.setCourses(updatedUser.getCourses() != null ? updatedUser.getCourses() : user.getCourses());
        user.setBloodGroup(updatedUser.getBloodGroup() != null ? updatedUser.getBloodGroup() : user.getBloodGroup());
        user.setDateOfBirth(updatedUser.getDateOfBirth() != null ? updatedUser.getDateOfBirth() : user.getDateOfBirth());
        user.setName(updatedUser.getName() != null ? updatedUser.getName() : user.getName());
        user.setEmail(updatedUser.getEmail() != null ? updatedUser.getEmail() : user.getEmail());

        return userRepo.save(user);
    }
}
