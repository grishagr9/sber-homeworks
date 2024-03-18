package com.example.hw20.task2;

import com.example.hw20.task2.errs.NotEnoughMoneyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/terminal")
public class TerminalController {
    private Terminal terminal = new TerminalImpl(1000);

    @GetMapping("/balance")
    public ResponseEntity<Integer> getBalance() {
        return ResponseEntity.ok(terminal.check());
    }

    @PostMapping("/deposit/{amount}")
    public ResponseEntity<String> deposit(@PathVariable int amount) {
        terminal.putMoney(amount);
        return ResponseEntity.ok("Операция выполнена успешно");
    }

    @PostMapping("/withdraw/{amount}")
    public ResponseEntity<String> withdraw(@PathVariable int amount) {
        try {
            terminal.getMoney(amount);
            return ResponseEntity.ok("Операция выполнена успешно");
        } catch (NotEnoughMoneyException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
