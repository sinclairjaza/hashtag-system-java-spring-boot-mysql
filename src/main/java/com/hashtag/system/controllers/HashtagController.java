package com.hashtag.system.controllers;

import com.hashtag.system.entities.Question;
import com.hashtag.system.entities.User;
import com.hashtag.system.exceptions.ApiResponse;
import com.hashtag.system.repositories.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author sinclairjaza
 * @Date 3/14/22 - 12:26 AM
 * @Project hashtag_system
 */

@RequiredArgsConstructor
@RestController
public class HashtagController {

    private final QuestionRepository questionRepository;

    @GetMapping("/hashtags")
    public List<QuestionRepository.Hashtag> getAllHastags() {
        return questionRepository.getAllHashtags();
    }

    @GetMapping("/questions/byHashtag")
    public List<Question> getQuestionsByHashtag(@RequestParam("hash") String hashtag) {
        return questionRepository.getQuestionsByHashtag(hashtag);
    }

    @GetMapping("/questions/byHashtags")
    public List<Question> getQuestionsByListHashtag(@RequestParam("hashs") Set<String> hashtags) {
        return questionRepository.getQuestionsByHashtags(hashtags);
    }

    @GetMapping("/users/byHashtags")
    public List<User> getUserByListHashtag(@RequestParam("hashs") Set<String> hashtags) {
        System.out.println("SET OF HASHS " + hashtags);
        return questionRepository.getUsersByHashtags(hashtags);
    }

    @PostMapping("/addQuestion")
    public Object addQuestion(@RequestBody Question question) {
        questionRepository.save(question);

        return ResponseEntity.status(HttpStatus.CREATED);
    }
}
