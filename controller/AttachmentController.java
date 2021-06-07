package uzdeveloper.store_income_expense.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uzdeveloper.store_income_expense.Response;
import uzdeveloper.store_income_expense.service.AttachmentService;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/attachment")
public class AttachmentController {


    final AttachmentService attachmentService;


    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }


    @PostMapping
    public Response uploadFile(MultipartHttpServletRequest request){
        return  attachmentService.uploadFile(request);
    }

    @GetMapping("/download/{id}")
    public Response getFile(@PathVariable Integer id, HttpServletResponse response){
        return attachmentService.downloadFile(id,response);

    }




}
