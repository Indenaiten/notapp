package org.codenaiten.notapp.domain.port.manager;

public interface PasswordManagerPort {

    String hash(String password, String salt );

    String createSalt();

}
