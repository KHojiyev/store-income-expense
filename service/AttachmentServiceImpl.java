package uzdeveloper.store_income_expense.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uzdeveloper.store_income_expense.Response;
import uzdeveloper.store_income_expense.entity.Attachment;
import uzdeveloper.store_income_expense.entity.AttachmentContent;
import uzdeveloper.store_income_expense.repository.AttachmentContentRepository;
import uzdeveloper.store_income_expense.repository.AttachmentRepository;

import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Optional;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    final AttachmentRepository attachmentRepository;
    final AttachmentContentRepository attachmentContentRepository;

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository, AttachmentContentRepository attachmentContentRepository) {
        this.attachmentRepository = attachmentRepository;
        this.attachmentContentRepository = attachmentContentRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    @SneakyThrows
    @Override
    public Response uploadFile(MultipartHttpServletRequest request) {
        Iterator<String> fileNames = request.getFileNames();
        if (fileNames.hasNext()) {
            MultipartFile file = request.getFile(fileNames.next());

            if (file != null) {

                String originalFilename = file.getOriginalFilename();
                String contentType = file.getContentType();
                long size = file.getSize();

                Attachment attachment = new Attachment(
                        originalFilename,
                        size,
                        contentType);

                Attachment save = attachmentRepository.save(attachment);
                AttachmentContent attachmentContent = new AttachmentContent(
                        save,
                        file.getBytes());
                AttachmentContent attachmentContent1 = attachmentContentRepository.saveAndFlush(attachmentContent);
                return new Response("file was saved", true, attachmentContent1.getId());
            }
        }
        return new Response("anything went wrong ", false, null);

    }

    @SneakyThrows
    @Override
    public Response downloadFile(Integer id, HttpServletResponse response) {

        Optional<Attachment> byId = attachmentRepository.findById(id);
        if (byId.isEmpty())
            return new Response("anything went wrong", false, null);
        Attachment attachment = byId.get();

        Optional<AttachmentContent> byAttachment_id = attachmentContentRepository.findByAttachment_Id(id);
        if (byAttachment_id.isEmpty())
            return new Response("anything went wrong", false, null);
        AttachmentContent attachmentContent = byAttachment_id.get();

        response.setContentType(attachment.getContentType());
        response.setHeader("Content type: " + attachment.getContentType(), "  File: " + attachment.getFileOriginalName());

        FileCopyUtils.copy(attachmentContent.getMainContent(), response.getOutputStream());

        return new Response("anything went wrong", false, false);
    }
}
