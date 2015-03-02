package hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class Index extends javax.servlet.http.HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Logger logger = Logger.getLogger(Index.class);
        logger.debug("do get");
        PrintWriter writer = resp.getWriter();
        MessageService service = WebApplicationContextUtils
                .getRequiredWebApplicationContext(this.getServletContext())
                .getBean("randomMessage", MessageService.class);
        writer.print(service.message());
    }

}
