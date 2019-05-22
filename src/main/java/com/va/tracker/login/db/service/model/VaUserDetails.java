package com.va.tracker.login.db.service.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.va.tracker.login.db.entity.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VaUserDetails implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8860793798601205744L;

	private User user;

	public VaUserDetails(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		// TODO - handle roles
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return authorities;
	}

	public int getId() {
		return user.getUserno();
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUserid();
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
		return true;
	}

	public User getUserDetails() {
		return user;
	}
}