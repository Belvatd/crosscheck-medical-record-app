package com.app.architecture.controller;

import com.app.architecture.entity.User;
import com.app.architecture.exception.core.ArchitectureException;
import com.app.architecture.facade.UserFacade;
import com.app.architecture.model.common.ResponseHandler;
import com.app.architecture.model.user.UserModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.app.architecture.util.Constants.UserPaths.USER_PATH;

@RestController
@RequiredArgsConstructor
@RequestMapping(USER_PATH)
@Api(value = USER_PATH, tags = "User APIs")
public class UserController {

    //region
    private final UserFacade facade;
    //endregion

    /**
     * Save user
     *
     * @param model as UserModel
     * @return User
     * @throws ArchitectureException
     */
    @PostMapping
    @ApiOperation(value = "Save User", response = User.class)
    public ResponseEntity<Object> saveUser(@RequestBody UserModel model) throws ArchitectureException {
        return ResponseHandler.response(HttpStatus.OK, facade.saveUser(model), true);
    }

    /**
     * Get user by id
     *
     * @param citizensId as String
     * @return User
     * @throws ArchitectureException
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "Get User", response = User.class)

    public ResponseEntity<Object> getUser(@RequestHeader String citizensId) throws ArchitectureException {
        return ResponseHandler.response(HttpStatus.OK, facade.getUser(citizensId), true);
    }
    @GetMapping
    @ApiOperation(value = "Get All Users", response = User.class)
    public ResponseEntity<Object> getAllUsers() throws ArchitectureException {
        return ResponseHandler.response(HttpStatus.OK, facade.getAllUsers(), true);
    }
}
