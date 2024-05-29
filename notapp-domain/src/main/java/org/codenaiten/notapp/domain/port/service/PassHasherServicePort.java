package org.codenaiten.notapp.domain.port.service;

public interface PassHasherServicePort {

    String hash(String password, String salt );

    String createSalt();

}
