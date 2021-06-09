package Business.abstracts;

public interface VerificationService {
    boolean checkPassword(String password);
    boolean checkMailPattern (String email);
    boolean checkName(String firstName, String lastName);
    boolean isEmpty(String email, String password);
    void sendEmail(String email);
}
