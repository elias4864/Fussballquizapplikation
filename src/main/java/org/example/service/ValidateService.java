package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.PlayerValidierung;
import org.springframework.stereotype.Service;

/**
 * The type Validate service.
 */
@Service
public class ValidateService {


    private final PlayerValidierung playerValidator;

    /**
     * Instantiates a new Validate service.
     *
     * @param playerValidator the player validator
     */
// MANUELLER KONSTRUKT
    public ValidateService(PlayerValidierung playerValidator) {
        this.playerValidator = playerValidator;
    }

    /**
     * Validate all.
     */
    public void validateAll() {
        playerValidator.validatePlayer(10);
        playerValidator.validatePlayer(34);
    }
}
