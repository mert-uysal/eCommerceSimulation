package Business.concretes;

import Business.abstracts.VerificationService;
import Entities.concretes.User;

import java.util.regex.Pattern;

public class VerificationManager implements VerificationService {

    public Pattern mailPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    @Override
    public boolean checkPassword(String password) {
        if (password.length() < 6)
            return false;
        else
            return true;
    }

    @Override
    public boolean checkMailPattern(String email) {
        return mailPattern.matcher(email).find();
    }

    @Override
    public boolean checkName(String firstName, String lastName) {
        if (firstName.length() < 2 || lastName.length() < 2)
            return false;
        else
            return true;
    }

    @Override
    public boolean isEmpty(String email, String password) {
        if(email.equals("") || password.equals("")) {
            return true;
        }
        return false;
    }

    @Override
    public void sendEmail(String email) {
        System.out.println("Üyeliğinizin tamamlanması için " + email + " mail adresini doğrulayınız.");
    }
}
