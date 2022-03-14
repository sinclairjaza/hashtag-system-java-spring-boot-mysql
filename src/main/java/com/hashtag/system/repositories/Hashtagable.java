package com.hashtag.system.repositories;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author sinclairjaza
 * @Date 3/14/22 - 12:09 AM
 * @Project hashtag_system
 */
public interface Hashtagable {

    String provideStringWithHashtags();

    default Collection<String> extractHashtags(){
        return Stream.of(provideStringWithHashtags()
                .split("[\"'`()\\[\\]{},.?!:;*+/|\\\\<=>_\\-~@$%^&\\s]"))
                .filter(w -> w.startsWith("#"))
                .map(String::toLowerCase)
                .collect(Collectors.toSet());
    }
}
