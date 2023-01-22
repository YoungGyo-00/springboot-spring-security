package com.cos.security1.config.auth;

import com.cos.security1.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

// 시큐리티가 /login 주소 요청 오면 낚아채서 로그인을 진행시켜준다.
// 로그인을 진행이 완료가 되면 시큐리티 세션을 만들어준다.
// Security Session => Authenticaion => UserDetails(PrincipalDetails)
public class PrincipalDetils implements UserDetails {

    private User user; // composition

    public PrincipalDetils(User user) {
        this.user = user;
    }

    // 해당 User의 권한을 리턴하는 곳
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });

        return collect;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {

        // 우리 사이트에서 1년동안 로그인을 안하면
        // 현재시간 - 로그인시간 => 1년 초과면 false

        return true;
    }
}
