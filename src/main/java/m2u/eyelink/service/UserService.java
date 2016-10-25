/*
 * @(#)UserService.java  2013. 7. 23.
 *
 * Copyright 2013 Wingko All rights reserved.
 */
package m2u.eyelink.service;

import java.util.List;
import java.util.Map;

import m2u.eyelink.domain.Login;
import m2u.eyelink.domain.User;

/**
 * TODO
 *
 * @author  ysh
 * @version 1.0,  2013. 7. 23.
 */
public interface UserService {

	User login(Login login);

	void loginUpdate(int user_no);
}