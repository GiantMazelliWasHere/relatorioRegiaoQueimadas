package br.com.relatorioqueimadasregiao.security;

import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;
import java.util.List;

public class JwtAuthenticationFilter extends GenericFilter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        String token = req.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            try {
                Claims claims = JwtUtil.validarToken(token.substring(7));
                String role = (String)claims.get("role", String.class);
                Authentication auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), (Object)null, List.of(new SimpleGrantedAuthority("ROLE_" + role)));
                SecurityContextHolder.getContext().setAuthentication(auth);
            } catch (Exception var9) {
                ((HttpServletResponse)response).sendError(403, "Token inválido ou expirado");
                return;
            }
        }

        chain.doFilter(request, response);
    }
}
