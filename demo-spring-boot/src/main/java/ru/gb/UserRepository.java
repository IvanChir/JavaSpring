package ru.gb;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component // userRepository
public class UserRepository {

  private final List<User> users;
  private JdbcTemplate jdbcTemplate; // Добавляем JdbcTemplate

  public UserRepository() {
    this.jdbcTemplate = jdbcTemplate; // Инициализируем JdbcTemplate
    this.users = new ArrayList<>();
    users.add(new User("Igor"));
    users.add(new User("User #2"));
    users.add(new User("User #3"));
    users.add(new User("User #4"));
    users.add(new User("User #5"));
  }

  public List<User> getAll() {
    return List.copyOf(users);
  }

  public User getByName(String name) {
    return users.stream()
            .filter(it -> Objects.equals(it.getName(), name))
            .findFirst()
            .orElse(null);
  }

  public User getById(long id) {
    return users.stream()
            .filter(it -> Objects.equals(it.getId(), id))
            .findFirst()
            .orElse(null);
  }

  // Новый метод для удаления пользователя по ID
  public void deleteById(int id) {
    String sql = "DELETE FROM userTable WHERE id = ?";
    jdbcTemplate.update(sql, id);
  }
}
