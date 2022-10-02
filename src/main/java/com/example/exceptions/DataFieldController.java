package com.example.exceptions;

import com.example.exceptions.WrongLoginException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DataFieldController {
    private final DataFieldServiceImpl dataFieldServiceImpl;

    public DataFieldController(DataFieldServiceImpl dataFieldServiceImpl) {
        this.dataFieldServiceImpl = dataFieldServiceImpl;
    }

    @GetMapping("/dataField")
    public boolean dataField(@RequestParam String login, @RequestParam String password, @RequestParam String confirmPassword) {
        try {
            return dataFieldServiceImpl.field(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}