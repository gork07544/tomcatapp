package com.tvsconsult.model;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authorities  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_role_id")
	private int user_role_id;
	
	@ManyToOne
	@JoinColumn(name = "username")
	private Users user;

	@Column(name = "authority")	
	private String authority;
	
	public Authorities( Users user, String authority){
		this.user = user;
		this.authority = authority;
	}
	
	public Authorities() {
		// TODO Auto-generated constructor stub
	}
	
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
}
