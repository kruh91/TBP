package hr.foi.tbp;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Password {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode(args[0]));
	}

}
