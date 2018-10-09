package cn.mobilemart.demo.service.common;

import java.io.Serializable;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class KeyDTO implements Serializable{

	private static final long serialVersionUID = 223152544410831068L;
	
	private RSAPublicKey publicKey;
	private RSAPrivateKey privateKey;
	
	public RSAPublicKey getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(RSAPublicKey publicKey) {
		this.publicKey = publicKey;
	}
	public RSAPrivateKey getPrivateKey() {
		return privateKey;
	}
	public void setPrivateKey(RSAPrivateKey privateKey) {
		this.privateKey = privateKey;
	}
}
