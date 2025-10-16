package Snapbrief_AI.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPreferenceId implements Serializable {
    private Long user;
    private Long category;
}
