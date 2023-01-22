package com.sp.fc.web.teacher;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Set;

@Component
public class TeacherManager implements AuthenticationProvider, InitializingBean {

    private HashMap<String, Teacher> studentDB = new HashMap<>();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        if(studentDB.containsKey(token.getName())){
            Teacher teacher = studentDB.get(token.getName());
            return TeacherAuthenticationToken.builder()
                    .principal(teacher)
                    .details(teacher.getUsername())
                    .authenticated(true)
                    .build();
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication == UsernamePasswordAuthenticationToken.class;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Set.of(
                new Teacher("lee", "이영교", Set.of(new SimpleGrantedAuthority("ROLE_TEACHER")), null)
        ).forEach(
                s -> studentDB.put(s.getId(), s)
        );
    }
}
