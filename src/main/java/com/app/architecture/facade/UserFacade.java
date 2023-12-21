package com.app.architecture.facade;

import com.app.architecture.entity.User;
import com.app.architecture.exception.common.InvalidParamException;
import com.app.architecture.exception.core.ArchitectureException;
import com.app.architecture.exception.user.UserAlreadyExistException;
import com.app.architecture.exception.user.UserNotFoundException;
import com.app.architecture.model.user.UserModel;
import com.app.architecture.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserFacade {

    //region
    private final UserService userService;
    //endregion

    /**
     * Get user by id
     *
     * @param citizensId as String
     * @return User
     * @throws ArchitectureException
     */
    public Object getUser(String citizensId) throws ArchitectureException {
        try {
            //Checking params
            if (citizensId.isEmpty())
                throw new InvalidParamException();
            //Checking user
            User user = userService.getUserById(citizensId);
            if (user == null)
                throw new UserNotFoundException();
            return user;
        } catch (ArchitectureException exception) {
            throw exception;
        }
    }

    public Object getAllUsers() throws ArchitectureException {
        List<User> user;
        user = userService.getAllUsers();
        return user;
    }

    /**
     * Save user
     *
     * @param model as UserModel
     * @return User
     * @throws ArchitectureException
     */
    public Object saveUser(UserModel model) throws ArchitectureException {
        try {
            //Checking params
            if (model == null ||
                    model.getFullName().isEmpty() || model.getNik().isEmpty()
                    || model.getAddress().isEmpty()
//                    || model.getDateOfBirth().equals("")
                    )
                throw new InvalidParamException();
            //Checking if user is already exist
            User existUser = userService.getUserById(model.getCitizensId());
            if (existUser != null)
                throw new UserAlreadyExistException();
            //Mapping model UserModel -> User
            User user = new ModelMapper().map(model, User.class);
            return userService.saveUser(user);
        } catch (ArchitectureException exception) {
            throw exception;
        }
    }
}
