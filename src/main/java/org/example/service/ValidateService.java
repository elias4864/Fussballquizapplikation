package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.PlayerValidierung;
import org.springframework.stereotype.Service;

@Service
public class ValidateService {


    private final PlayerValidierung playerValidator;

    // MANUELLER KONSTRUKT
    public ValidateService(PlayerValidierung playerValidator) {
        this.playerValidator = playerValidator;
    }

    public void validateAll() {
        playerValidator.validatePlayer(10);
        playerValidator.validatePlayer(34);
    }
}
