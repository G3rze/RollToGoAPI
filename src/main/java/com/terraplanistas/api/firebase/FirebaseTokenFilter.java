//package com.terraplanistas.api.firebase;
//
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseAuthException;
//import com.google.firebase.auth.FirebaseToken;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Component
//public class FirebaseTokenFilter extends OncePerRequestFilter {
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//
//        String header = request.getHeader("Authorization");
//
//        if (header == null || !header.startsWith("Bearer ")) {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            return;
//        }
//
//        String token = header.replace("Bearer ", "");
//
//        try {
//            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
//            request.setAttribute("firebaseUser", decodedToken); // Puedes acceder al usuario en los controladores
//            filterChain.doFilter(request, response);
//        } catch (FirebaseAuthException e) {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        }
//    }
//}
