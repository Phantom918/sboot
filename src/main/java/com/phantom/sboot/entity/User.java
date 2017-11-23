package com.phantom.sboot.entity;


import com.phantom.sboot.enums.UserSexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	private Long id;
	private String userName;
	private String passWord;
	private UserSexEnum userSex;
	private String nickName;

	public User(String userName, String passWord, UserSexEnum userSex) {
		super();
		this.passWord = passWord;
		this.userName = userName;
		this.userSex = userSex;
	}


}