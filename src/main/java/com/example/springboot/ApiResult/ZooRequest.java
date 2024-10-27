package com.example.springboot.ApiResult;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Data
@NoArgsConstructor
public class ZooRequest implements Serializable {
    @Getter
    @Setter
    @NotEmpty(message = "zoo name not empty")
    @Size(max = 32)
    private String name;
    @NotEmpty
    @Getter
    @Setter
    @Size(max = 255)
    private String address;
    @NotEmpty
    @Getter
    @Setter
    @Size(max = 20)
    private String telephone;

}
