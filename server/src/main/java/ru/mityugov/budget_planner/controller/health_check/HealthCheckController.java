package ru.mityugov.budget_planner.controller.health_check;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/health-check")
public class HealthCheckController {

    @GetMapping
    public String checkHealth() {
        log.info("Health check start.");
        return "All fine!";
    }
}
