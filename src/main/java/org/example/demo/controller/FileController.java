package org.example.demo.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.example.demo.entity.AttachmentContent;
import org.example.demo.repo.AttachmentContentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/file")
public class FileController {

    private final AttachmentContentRepository attachmentContentRepository;

    public FileController(AttachmentContentRepository attachmentContentRepository) {
        this.attachmentContentRepository = attachmentContentRepository;
    }

    @GetMapping("/{attachmentId}")
    public void getFile(@PathVariable Integer attachmentId, HttpServletResponse response) throws IOException {
        AttachmentContent byAttachmentId = attachmentContentRepository.findByAttachmentId(attachmentId);
        response.getOutputStream().write(byAttachmentId.getContent());
    }

}