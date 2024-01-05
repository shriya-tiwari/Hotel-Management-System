package com.example.demo.security;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Component
public class JwtFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final CustomerDetailsServiceImpl customerDetailsService;

    public JwtFilter(JwtUtil jwtUtil, CustomerDetailsServiceImpl customerDetailsService) {
        this.jwtUtil = jwtUtil;
        this.customerDetailsService = customerDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin","http://localhost:8080");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials","true");
        try {
            System.out.println(request);
            String jwtToken = request.getHeader(AUTHORIZATION);
            System.out.println(jwtToken);
            String token = null;

            if (StringUtils.hasText(jwtToken) && jwtToken.startsWith("Bearer ")) {
                token = jwtToken.substring(7, jwtToken.length());
            }

            if (token != null && jwtUtil.validateToken(token)) {
                String pEmail = jwtUtil.getEmailFromToken(token);
                System.out.println(pEmail);
                if (pEmail != null) {
                    UserDetails customerDetails = customerDetailsService.loadUserByUsername(pEmail);

                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(customerDetails, null, customerDetails.getAuthorities());
                    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        filterChain.doFilter(request,response);
    }

//    @Override
//    protected void doFilterInternal(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, jakarta.servlet.FilterChain filterChain) throws jakarta.servlet.ServletException, IOException {
//
//    }
}
