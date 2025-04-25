package ru.gb;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserRepository repository;
  private final UserService userService; // Внедрение UserService

  public UserController(UserRepository repository, UserService userService) {
    this.repository = repository;
    this.userService = userService; // Инициализация UserService
  }

  @GetMapping(value = "/test", consumes = MediaType.IMAGE_JPEG_VALUE)
  public String test() {
    return """
          <h1>Title</h1>
          """;
  }

  @GetMapping("/all")
  public List<User> getUsers() {
    return repository.getAll();
  }

  @GetMapping(value = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
  public User getUser(@PathVariable long id) {
    return repository.getById(id);
  }

  @GetMapping
  public User getUserByName(@RequestParam String name) {
    return repository.getByName(name);
  }

  @PatchMapping("/{id}")
  public User updateUser(@PathVariable long id, @RequestBody User user) {
    User existsUser = repository.getById(id);
    if (existsUser == null) { // 404
      throw new IllegalArgumentException();
    }

    existsUser.setName(user.getName());
    return existsUser;
  }

  // Новый метод для удаления пользователя
  @GetMapping("user-delete/{id}")
  public String deleteUser(@PathVariable("id") int id) {
    userService.deleteById(id);
    return "User with ID " + id + " has been deleted.";
  }
}
