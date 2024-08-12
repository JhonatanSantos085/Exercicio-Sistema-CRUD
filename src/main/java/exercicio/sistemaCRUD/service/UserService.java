package exercicio.sistemaCRUD.service;

import exercicio.sistemaCRUD.model.User;
import exercicio.sistemaCRUD.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

}
