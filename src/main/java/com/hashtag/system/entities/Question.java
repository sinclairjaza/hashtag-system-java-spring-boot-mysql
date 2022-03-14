package com.hashtag.system.entities;

import com.hashtag.system.repositories.Hashtagable;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sinclairjaza
 * @Date 3/13/22 - 11:33 PM
 * @Project hashtag_system
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "questions")
@DynamicUpdate
public class Question implements Serializable, Hashtagable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String question;

    @ManyToOne(optional = false)
    private User user;

    @CollectionTable(name = "questions_hashtags", joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "hashtag")
    @ElementCollection(fetch = FetchType.EAGER)
    @BatchSize(size = 20)
    private Set<String> hashtags = new HashSet<>();

    public Question(User user, String question){
        this.user = user;
        this.question = question;
    }

    @PrePersist
    @PreUpdate
    private void populateHashtags() {
        hashtags.clear();
        hashtags.addAll(extractHashtags());
    }

    @Override
    public String provideStringWithHashtags() {
        return question;
    }
}
