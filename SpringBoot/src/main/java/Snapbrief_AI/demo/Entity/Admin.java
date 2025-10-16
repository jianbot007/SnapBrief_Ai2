package Snapbrief_AI.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "admins")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;

    private String name;

    @Column(unique = true)
    private String email;

    private String passwordHash;

    private String role; // e.g., SUPER_ADMIN, MODERATOR, EDITOR

    private LocalDateTime createdAt = LocalDateTime.now();
}

