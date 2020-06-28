package com.ironhack.midtermprojectbank.controller.impl;

import com.ironhack.midtermprojectbank.controller.interfaces.StudentCheckingControllerInterface;
import com.ironhack.midtermprojectbank.controller.interfaces.ThirdPartyControllerInterface;
import com.ironhack.midtermprojectbank.dto.StudentGetDTO;
import com.ironhack.midtermprojectbank.dto.ThirdPartyPostDTO;
import com.ironhack.midtermprojectbank.model.users.ThirdParty;
import com.ironhack.midtermprojectbank.service.StudentCheckingService;
import com.ironhack.midtermprojectbank.service.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ThirdPartyController implements ThirdPartyControllerInterface {
    @Autowired
    ThirdPartyService thirdPartyService;

    @PostMapping("/third-party/debit/{hashKey}")
    @ResponseStatus(HttpStatus.OK)
    public String debit(@PathVariable String hashKey, @RequestBody ThirdPartyPostDTO thirdPartyPostDTO) {
        return thirdPartyService.debit(hashKey, thirdPartyPostDTO);
    }

    @PostMapping("/third-party/credit/{hashKey}")
    @ResponseStatus(HttpStatus.OK)
    public String credit(@PathVariable String hashKey, @RequestBody ThirdPartyPostDTO thirdPartyPostDTO) {
        return thirdPartyService.credit(hashKey, thirdPartyPostDTO);
    }
}
