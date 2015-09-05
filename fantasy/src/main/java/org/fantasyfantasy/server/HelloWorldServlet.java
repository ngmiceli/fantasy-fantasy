package org.fantasyfantasy.server;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fantasyfantasy.server.model.Hello;

import com.googlecode.objectify.ObjectifyService;

@SuppressWarnings("serial")
public class HelloWorldServlet extends HttpServlet {
    
    static {
        ObjectifyService.register(Hello.class);
    }
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        
        writer.println("Your message: " + req.getQueryString());
        
        Hello newH = new Hello(req.getQueryString());
        ofy().save().entity(newH);
        
        List<Hello> hs = ofy().load().type(Hello.class).list();
        for (Hello h : hs) {
          writer.println("> " + h.getMessage());    
        }
    }
    
    
}