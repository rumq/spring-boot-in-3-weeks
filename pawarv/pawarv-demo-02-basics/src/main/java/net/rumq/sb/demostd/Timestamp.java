package net.rumq.sb.demostd;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class Timestamp {
    private LocalDateTime timestamp;

    public Timestamp() {
        this.timestamp = LocalDateTime.now();
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

}
