package hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class Index extends javax.servlet.http.HttpServlet {

    private ApplicationContext context;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Logger logger = Logger.getLogger(Index.class);
        logger.debug("do get");
        
        PrintWriter writer = resp.getWriter();
        context = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
        MessageService service = context
                .getBean("randomMessage", MessageService.class);
        writer.print(service.message());

        ObjOne objOne = context.getBean("objOne", ObjOne.class);
        ObjTwo objTwo = context.getBean("objTwo", ObjTwo.class);
        
        objOne.setStr("one");
        objTwo.setStr("two");
        
    }
}
