package Core;

import GoogleMailAuth.GoogleAuth;

public class GoogleAuthAdapter implements GoogleAuthService{
    @Override
    public boolean controlGoogleMail(String email) {
        GoogleAuth googleAuth = new GoogleAuth();
        return googleAuth.GoogleAuthManager(email);
    }
}
