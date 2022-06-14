package com.ishmam.DhrubokPracticeProject1.Controller;

import com.ishmam.DhrubokPracticeProject1.Annotations.DeleteAPI;
import com.ishmam.DhrubokPracticeProject1.Annotations.GetAPI;
import com.ishmam.DhrubokPracticeProject1.Annotations.PostAPI;
import com.ishmam.DhrubokPracticeProject1.Annotations.PutAPI;
import com.ishmam.DhrubokPracticeProject1.Model.User;
import com.ishmam.DhrubokPracticeProject1.Output.Response;
import com.ishmam.DhrubokPracticeProject1.Services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(
            summary = "Welcome Message",
            description = "It'll Show Just An Welcome Message!")
    @GetAPI("/")
    public ResponseEntity<Response<String>> sayWelcome(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(new Response<>(
                        HttpStatus.OK,
                        "Simple Welcome Message!",
                        true,
                        "Welcome Abroad!! How's other API's??"
                ));
    }


    @Operation(
            summary = "Add User",
            description = "Take a user object as parameter.")
    @PostAPI("/add")
    public ResponseEntity<Response<User>> addUser(@Valid @RequestBody User user1){
        User user = userService.addUser(user1);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new Response<User>(
                        HttpStatus.CREATED,
                        "User Created Successfully!",
                        true,
                        user
                ));
    }

    @Operation(
            summary = "Add Multiple User",
            description = "Take a list of Users as parameter.")
    @PostAPI("/add/all")
    public ResponseEntity<Response<String>> addAllUser(@Valid @RequestBody List<User> users){
        String output = userService.addAllUser(users);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new Response<String>(
                        HttpStatus.CREATED,
                        "All User Created Successfully!",
                        true,
                        output
                ));
    }

    @Operation(summary = "Get User By user ID",
                description = "We have to pass id as parameter.")
    @GetAPI("/get/id/{id}")
    public ResponseEntity<Response<User>> getUserbyId(@PathVariable BigInteger id){
        User user = userService.getUserbyId(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new Response<>(
                        HttpStatus.OK,
                        "Result Found with ID: "+id,
                        true,
                        user
                ));
    }

    @Operation(summary = "Get User By user Email",
            description = "We have to pass user email as parameter.")
    @GetAPI("/get/email/{email}")
    public ResponseEntity<Response<User>> getUserbyEmail(@PathVariable String email) {
        User user = userService.getUserbyEmail(email);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new Response<>(
                        HttpStatus.OK,
                        "Result Found with ID: " + email,
                        true,
                        user));
    }


    @Operation(summary = "Get All Users",
            description = "Nothing to pass. Fetch All Users!")
    @GetAPI("/get/all")
    public ResponseEntity<Response<List<User>>> getAllUsers(){
        List<User> userList = userService.getAllUser();

        return ResponseEntity.status(HttpStatus.OK)
                .body(new Response<>(
                        HttpStatus.OK,
                        "Result fetched!",
                        true,
                        userList
                ));
    }


    @Operation(summary = "Get All Users by Blood Group",
            description = "Pass Blood Group as Argument. Then, Fetch All Users!")
    @GetAPI("/get/all/type/blood-group/{bloodGroup}")
    public ResponseEntity<Response<List<User>>> getUsersByBloodGroup(@PathVariable String bloodGroup){
        List<User> userList = userService.getUserbyBloodGroup(bloodGroup);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new Response<>(
                        HttpStatus.OK,
                        "Result fetched!",
                        true,
                        userList
                ));
    }

    @Operation(summary = "Get All Users by Division",
            description = "Pass Division as Argument. Then, Fetch All Users!")
    @GetAPI("/get/all/type/division/{division}")
    public ResponseEntity<Response<List<User>>> getUsersByDivision(@PathVariable String division){
        List<User> userList = userService.getUserbyDivision(division);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new Response<>(
                        HttpStatus.OK,
                        "Result fetched!",
                        true,
                        userList
                ));
    }

    @Operation(summary = "Get All Users by ZipCode",
              description = "Pass ZipCode as Argument. Then, Fetch All Users!")
    @GetAPI("/get/all/type/zipcode/{zipcode}")
    public ResponseEntity<Response<List<User>>> getUsersByZipcode(@PathVariable long zipcode){
        List<User> userList = userService.getUserbyZipCode(zipcode);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new Response<>(
                        HttpStatus.OK,
                        "Result fetched!",
                        true,
                        userList
                ));
    }

    @Operation(summary = "Delete an User By user ID",
            description = "We have to pass user id as parameter.")
    @DeleteAPI("/delete/{id}")
    public ResponseEntity<Response<String>> deleteUserbyId(@PathVariable BigInteger id){
        String message= userService.deleteUserbyId(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new Response<>(
                        HttpStatus.OK,
                        "User deleted with id: "+id,
                        true,
                        message
                ));
    }

    @Operation(
            summary = "Update an User",
            description = "Take a user object as parameter.")
    @PutAPI("/update")
    public ResponseEntity<Response<User>> upateUser(@Valid @RequestBody User user1){
        User user = userService.updateUser(user1);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new Response<>(
                        HttpStatus.OK,
                        "User Updated Successfully!",
                        true,
                        user
                ));
    }
}
