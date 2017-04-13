package org.projectX.user.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity(name = "user_account")
public class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@NotNull
	@Size(min = 4, max = 45)
	private String username;
	
	@NotNull
	@Size(min = 6, max = 100)
	private String password;
	
	@NotNull
	@Size(min = 5, max = 45)
	private String e_mail;
	
	@NotNull
	@Size(min = 4, max = 45)
	private String country;
	
	@NotNull
	@Size(min = 4, max =25)
	private String nick;

	private String authorities;

	@Column(name = "is_filled")
	private Boolean isFilled;
	@Column(name = "is_Verified")
	private Boolean isVerified;
	
	public UserAccount(){
		
	}
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public Boolean getIsFilled() {
		return isFilled;
	}
	public void setIsFilled(Boolean isFilled) {
		this.isFilled = isFilled;
	}
	public Boolean getIsVerified() {
		return isVerified;
	}
	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}
	public String getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}
}
