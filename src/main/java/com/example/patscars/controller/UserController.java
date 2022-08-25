package com.example.patscars.controller;
import com.example.patscars.dto.ApiResponse;
import com.example.patscars.model.User;
import com.example.patscars.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    @GetMapping("/user")
    public ResponseEntity<List> getUsers(){
        return ResponseEntity.status(200).body(userService.getUsers());

    }
    @PostMapping("/register")
    private ResponseEntity addUser(@RequestBody @Valid User user){
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("user added",200));
    }
    @PutMapping("/update/{id}")
    private ResponseEntity updateUser(@RequestParam @Valid User user,@PathVariable Integer id){
        userService.updateUser(user,id);
        return ResponseEntity.status(200).body(new ApiResponse("user updated",200));
    }
    @DeleteMapping("/delete")
    private ResponseEntity deleteuser(@PathVariable @Valid Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.status(200).body(new ApiResponse("Uesr deleted ", 200));
    }

}