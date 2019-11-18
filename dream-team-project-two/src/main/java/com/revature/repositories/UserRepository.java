package com.revature.repositories;


import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.persistence.EntityManager;

import org.apache.commons.codec.binary.Hex;
import org.hibernate.Session;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Users;



@Repository
public class UserRepository {

	@Autowired(required = true)
	EntityManager em;
	
	
	public Users create(Users user) {
		Session session = em.unwrap(Session.class);
		session.save(user);
		return user;
	}

	public String returnSaltIfUserExist(String username) {
		Session session = em.unwrap(Session.class);
		System.out.println("Checking if Username exist: " + username);
		String saltValue = "0";
		// check for username, if exist, return salt
		try {
			String hql = "from Users where username like :username";
			Users user = session.createQuery(hql, Users.class).setParameter("username", username, StringType.INSTANCE)
					.getSingleResult();
			saltValue = user.getSalt();
			return saltValue;
		} catch (Exception e) {
			System.out.println("Invalid Username");
			// e.printStackTrace();
		}
		return saltValue;
	}
	

	

	public int verifyPassword(Users user, String salt) {
		Session session = em.unwrap(Session.class);
		String hql = "from Users where username like :username and hashpass like :password";
		Users ValidUser = null;

		String InputPasswordHashed = passwordHasher(user.getHashpass(), salt);

		// check if password matches username, returns valid user if valid
		try {
			ValidUser = session.createQuery(hql, Users.class)
					.setParameter("username", user.getUsername(), StringType.INSTANCE)
					.setParameter("password", InputPasswordHashed, StringType.INSTANCE).getSingleResult();
			System.out.println("Returned ID of "+ValidUser.getId());
			return ValidUser.getId();
			
		} catch (Exception e) {
			System.out.println("Invalid Password");
			// e.printStackTrace();
		}

		// return ID of zero if password is invalid
		return 0;
	}

	public static String passwordHasher(String passwordToHash, String salt) {
		int iterations = 100;
		int keyLength = 512;
		char[] passwordChars = passwordToHash.toCharArray();
		byte[] saltBytes = salt.getBytes();

		byte[] hashedBytes = hashPassword(passwordChars, saltBytes, iterations, keyLength);
		String hashedPassword = Hex.encodeHexString(hashedBytes);

		return hashedPassword;

	}

	public static byte[] hashPassword(final char[] password, final byte[] salt, final int iterations,
			final int keyLength) {

		try {
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
			PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keyLength);
			SecretKey key = skf.generateSecret(spec);
			byte[] res = key.getEncoded();
			return res;
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new RuntimeException(e);
		}
	}

}
