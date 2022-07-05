package com.eebookhouse.servlet.manage.remark;

import com.eebookhouse.entity.User;
import com.eebookhouse.service.Impl.RemarkServiceImpl;
import com.eebookhouse.service.RemarkService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/remark/del")
public class DelRemarkServlet extends HttpServlet {

    private RemarkService service;

    @Override
    public void init() throws ServletException {
        service = new RemarkServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取发表某条评论的userid来对比当前user的id，如果相同才能进行删除操作
        Integer book_id = Integer.parseInt(req.getParameter("book_id"));
        Integer remark_id = Integer.parseInt(req.getParameter("remark_id"));
        Integer remark_user_id = Integer.parseInt(req.getParameter("remark_user_id"));
        User user = (User)req.getSession().getAttribute("user");
        if(user.getId() == remark_user_id){
            if(!service.deleteRemarkById(remark_id)){
                req.getSession().setAttribute("remark-delete-failure", new Object());
            }
        }else{
            req.getSession().setAttribute("remark-delete-failure", new Object());
        }
        resp.sendRedirect("/eebookhouse/remark?book_id=" + book_id);
    }
}
