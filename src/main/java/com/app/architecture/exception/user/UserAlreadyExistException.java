package com.app.architecture.exception.user;

import com.app.architecture.exception.core.ArchitectureException;
import org.springframework.http.HttpStatus;

import static com.app.architecture.util.Constants.Exception.User.USER_ALREADY_EXIST;
import static com.app.architecture.util.Constants.Exception.User.USER_ALREADY_EXIST_CODE;

public class UserAlreadyExistException extends ArchitectureException {

    //region
    private static final long serialVersionUID = 1L;
    //endregion

    public UserAlreadyExistException() {
        super();
        this.code = USER_ALREADY_EXIST_CODE;
        this.msg = USER_ALREADY_EXIST;
        this.status = HttpStatus.BAD_REQUEST;
    }
}