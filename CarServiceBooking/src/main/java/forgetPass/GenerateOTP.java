package forgetPass;
import java.util.Random;

public class GenerateOTP {
 
 
	    public static String generateRandomOTP( ) {
	        // Define the character set for the OTP (usually numeric)
	    	int length = 4;
	        String otpChars = "0123456789";

	        // Initialize the random number generator
	        Random random = new Random();

	        StringBuilder otp = new StringBuilder(length);

	        // Generate random OTP by selecting random characters from the character set
	        for (int i = 0; i < length; i++) {
	            int randomIndex = random.nextInt(otpChars.length());
	            otp.append(otpChars.charAt(randomIndex));
	        }

	        return otp.toString();
	    }
	 

}
