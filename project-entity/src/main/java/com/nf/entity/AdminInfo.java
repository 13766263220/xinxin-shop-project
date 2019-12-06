package com.nf.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class AdminInfo {
    private Integer id;
    @NotEmpty
    private String userName;
    @NotEmpty
    private String passWord;

}
