package uzdeveloper.store_income_expense.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uzdeveloper.store_income_expense.Response;

import javax.servlet.http.HttpServletResponse;

@Service
public interface AttachmentService {

    Response uploadFile(MultipartHttpServletRequest request);


    Response downloadFile(Integer id, HttpServletResponse response);

}
