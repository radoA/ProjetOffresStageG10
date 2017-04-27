package metiers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerificationFormulaire {
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	public static final Pattern VALID_PHONE_NUMBER_REGEX = Pattern.compile("^[0-9]{10}$");
	public static final Pattern VALID_PHONE_POSTAL_CODE = Pattern.compile("^[0-9]{5}$");
	public static boolean validateMail(String emailStr){
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
		return matcher.find();
	}
	public static boolean validatePhone(String phoneNumber){
		Matcher matcher = VALID_PHONE_NUMBER_REGEX .matcher(phoneNumber);
		return matcher.find();
	}
	public static boolean validatePostalCode(String postalCode){
		Matcher matcher = VALID_PHONE_POSTAL_CODE .matcher(postalCode);
		return matcher.find();
	}
	public static void main(String[] args) {
		System.out.println(validatePostalCode("06587"));
	}
}

//pull

//commit

//push