package org.example.demo.repo;

import org.example.demo.entity.AttachmentContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent,Integer> {
    AttachmentContent findByAttachmentId(Integer id);

}
