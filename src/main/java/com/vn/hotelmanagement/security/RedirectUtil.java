package com.vn.hotelmanagement.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
@Slf4j
public class RedirectUtil {

    public static String getRedirectUrl(Authentication authentication) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
                return "admin/dashboard";
            } else if (grantedAuthority.getAuthority().equals("ROLE_CUSTOMER")) {
                return "/search";
            } else if (grantedAuthority.getAuthority().equals("ROLE_HOTEL_MANAGER")) {
                return "/manager/dashboard";
            }
        }
        return null;
    }

}
