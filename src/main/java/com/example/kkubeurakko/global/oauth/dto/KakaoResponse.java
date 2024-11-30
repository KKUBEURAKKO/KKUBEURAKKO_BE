package com.example.kkubeurakko.global.oauth.dto;

import java.util.Map;

public class KakaoResponse implements OAuth2Response{
	private final Map<String, Object> attribute;
	public KakaoResponse(Map<String, Object> attribute){
		this.attribute = attribute;
	}
	@Override
	public String getProvider(){
		return "kakao";
	}

	@Override
	public String getProviderId() {
		return attribute.get("id").toString();
	}

	@Override
	public String getEmail() {
		// kakao_account를 추출하고 email 값을 가져옴
		Map<String, Object> kakaoAccount = (Map<String, Object>) attribute.get("kakao_account");
		if (kakaoAccount != null && kakaoAccount.containsKey("email")) {
			return kakaoAccount.get("email").toString();
		}
		return null; // 이메일이 없는 경우 null 반환
	}

	@Override
	public String getNickname() {
		// properties를 추출하고 nickname 값을 가져옴
		Map<String, Object> properties = (Map<String, Object>) attribute.get("properties");
		if (properties != null && properties.containsKey("nickname")) {
			return properties.get("nickname").toString();
		}
		return null; // 닉네임이 없는 경우 null 반환
	}
}
