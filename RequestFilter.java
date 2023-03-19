package com.schoolmanagement.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.schoolmanagement.exceptions.InvalidTokenException;
import com.schoolmanagement.exceptions.UnknownError;
import com.schoolmanagement.util.JwtUtility;
import com.schoolmanagement.util.constant.Constants;

@Component
public class RequestFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtility jwtUtil;

	@Autowired
	private UserDetailsService UserDetails;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		final String tokenWithBearer = request.getHeader("Authorization");
		final String userName;
		final String actualJwtToken;
		final UserDetails userDetails;
		if (tokenWithBearer == null || !tokenWithBearer.startsWith("Bearer "))
			throw new InvalidTokenException(Constants.INVALID_TOKEN, HttpStatus.UNAUTHORIZED);

		actualJwtToken = tokenWithBearer.substring(7);

		userName = jwtUtil.extractUsername(actualJwtToken);

		userDetails = UserDetails.loadUserByUsername(userName);

		if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
					userDetails, userDetails.getAuthorities(), null);

			usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

		} else
			throw new UnknownError(Constants.UNKNOWN_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);

		filterChain.doFilter(request, response);
	}

//
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		return isResourceUrl(request.getRequestURL().toString());

	}

	private boolean isResourceUrl(String url) {
		boolean isResourceUrl = false;
		List<String> resourceRequests = Arrays.asList("/api/v1/authenticate", "/api/v1/signUp","/api/v1/user/forgotPasswordGenerateOtp","/api/v1/forgotPasswordValidateOtp","/api/v1/upload");
		for (String resourceRequest : resourceRequests) {
			if (url.contains(resourceRequest)) {
				isResourceUrl = true;
			}
		} 
		return isResourceUrl;
	}

}
