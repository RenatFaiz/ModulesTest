package ru.itpark.servlet;

import ru.itpark.Helper;
import ru.itpark.repository.DemoRepository;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;


public class FrontServlet extends HttpServlet {
    private DemoRepository repository;

    @Override
    public void init() throws ServletException {
        System.out.println("init servlet");
        try {
            final InitialContext context = new InitialContext();
            final DataSource dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/db");
            final String uploadPath = System.getenv("UPLOAD PATH");
            repository = new DemoRepository(dataSource);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(new Helper().generate());
        resp.getWriter().write(repository.getAll().toString());
    }
}
