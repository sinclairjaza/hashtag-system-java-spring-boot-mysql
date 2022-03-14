package com.hashtag.system.repositories;

import com.hashtag.system.entities.Question;
import com.hashtag.system.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * @author sinclairjaza
 * @Date 3/14/22 - 12:20 AM
 * @Project hashtag_system
 */
public interface UserRepository extends JpaRepository<User, Long> {

    @RestResource(path = "by_hashtags", rel = "by_hashtags")
    @Query("select distinct u from Question q join q.user u join q.hashtags h where h in (?1)")
    List<User> getUsersByHashtags(@Param("hashtags") String hashtags);
}
