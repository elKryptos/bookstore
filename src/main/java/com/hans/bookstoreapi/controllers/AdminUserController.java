package com.hans.bookstoreapi.controllers;

import com.hans.bookstoreapi.exception.ResourceNotFoundException;
import com.hans.bookstoreapi.model.dto.UserFormDTO;
import com.hans.bookstoreapi.model.entity.User;
import com.hans.bookstoreapi.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/admin/users")
public class AdminUserController {

    private UserRepository userRepository;

    @GetMapping
    Page<User> paginate(@PageableDefault(sort = "fullname", size = 5) Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    User get(@PathVariable int id) {
        return userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @PostMapping
    User create(@RequestBody @Validated UserFormDTO userFormDTO) {
        User user = new User();
        user.setFirstname(userFormDTO.getFirstname());
        user.setLastname(userFormDTO.getLastname());
        user.setFullname(userFormDTO.getFullname());
        user.setEmail(userFormDTO.getEmail());
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    User update(@PathVariable int id, @Validated @RequestBody UserFormDTO dto) {
        return null;
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        User user = userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        userRepository.delete(user);
    }
}
