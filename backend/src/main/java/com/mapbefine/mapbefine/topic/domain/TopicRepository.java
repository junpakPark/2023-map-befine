package com.mapbefine.mapbefine.topic.domain;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

    List<Topic> findByIdIn(List<Long> ids);

    @Modifying(clearAutomatically = true)
    @Query("update Topic t set t.isDeleted = true where t.id = :topicId")
    void deleteById(@Param("topicId") Long topicId);

    boolean existsById(Long id);

    List<Topic> findByCreatorId(Long creatorId);

}
