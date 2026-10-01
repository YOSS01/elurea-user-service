package com.elurea.user_service.repository;

import com.elurea.user_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    List<User> findAll();

    Optional<User> findByEmail(String email);

    User save(User user);

    @Override
    void deleteById(UUID uuid);
}
