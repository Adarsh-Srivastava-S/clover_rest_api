package com.cloverleaf.clover_api.model.auth;

import com.cloverleaf.clover_api.model.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.io.StringReader;
@Data
public class Authority implements GrantedAuthority {
    private String authority;

    public Authority(String authority)
    {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

}
