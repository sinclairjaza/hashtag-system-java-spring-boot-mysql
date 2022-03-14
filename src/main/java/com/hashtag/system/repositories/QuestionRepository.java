package com.hashtag.system.repositories;

import com.hashtag.system.entities.Question;
import com.hashtag.system.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
import java.util.Set;

/**
 * @author sinclairjaza
 * @Date 3/14/22 - 12:11 AM
 * @Project hashtag_system
 */
public interface QuestionRepository extends JpaRepository<Question, Long> {

    @RestResource(exported = false)
    @Query("select distinct h as hashtag from Question q join q.hashtags h") //select distinct (hashtag) from questions q join questions_hashtags hashtag
    List<Hashtag> getAllHashtags();

    @RestResource(path = "by_hashtag", rel = "by_hashtag")
    @Query("select q from Question q join q.hashtags h where h = ?1")
    List<Question> getQuestionsByHashtag(@Param("hashtag") String hashtag);

    @RestResource(path = "by_hashtags", rel = "by_hashtags")
    @Query("select q from Question q join q.hashtags h where h in (?1)")
    List<Question> getQuestionsByHashtags(@Param("hashtags") Set<String> hashtags);

    @Query("select distinct u from Question q join q.user u join q.hashtags h where h in (?1)")
    List<User> getUsersByHashtags(Set<String> hashtags);

    interface Hashtag {
        String getHashtag();
    }
}
