package Business.concretes;

import Business.abstracts.UserService;
import Business.abstracts.VerificationService;
import Core.GoogleAuthService;
import DataAccess.abstracts.UserRepository;
import Entities.concretes.User;

public class UserManager implements UserService {
    private VerificationService verificationService;
    private UserRepository userRepository;
    private GoogleAuthService googleAuthService;

    public UserManager(VerificationService verificationService, UserRepository userRepository, GoogleAuthService googleAuthService) {
        this.verificationService = verificationService;
        this.userRepository = userRepository;
        this.googleAuthService = googleAuthService;
    }

    @Override
    public void add(User user) {
        if (!verificationService.isEmpty(user.getEmail(), user.getPassword())) {
            if (!verificationService.checkMailPattern(user.getEmail())) {
                System.out.println("E-posta formatı yanlış.");
                return;
            }
            if (!verificationService.checkName(user.getFirstName(), user.getLastName())) {
                System.out.println("İsim ve soyisim en az 2 karakter olmalı.");
                return;
            }
            if (!verificationService.checkPassword(user.getPassword())) {
                System.out.println("Parola en az 6 karakter olmalı.");
                return;
            }
            if (!googleAuthService.controlGoogleMail(user.getEmail())) {
                System.out.println("Google doğrulama başarısız. Mailinizi kontrol edin. " + user.getEmail());
                return;
            }
            if (userRepository.isEmailUsing(user.getEmail())) {
                System.out.println("E-posta zaten kullanılıyor.");
                return;
            }
            userRepository.add(user);
            verificationService.sendEmail(user.getEmail());
        } else {
            System.out.println("E-posta ve şifre boş bırakılamaz.");
        }
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    public void login(String email, String password) {
        if (verificationService.isEmpty(email, password)) {
            System.out.println("E-posta ve şifre boş bırakılamaz.");
        } else if (userRepository.checkLogin(email, password)) {
            for (User user : userRepository.getAllUser()) {
                if (user.getEmail().equals(email))
                    System.out.println("Giriş başarılı. Hoşgeldiniz " + user.getFirstName() + " " + user.getLastName());
            }
        } else
            System.out.println("Giriş başarısız. E-posta ve şifreniniz kontrol edin.");
    }

}
