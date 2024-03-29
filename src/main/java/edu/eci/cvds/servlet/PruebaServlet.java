/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.servlet;

import edu.eci.cvds.servlet.model.Todo;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daniel.alfonso-b
 */
@WebServlet(
        urlPatterns = "/AlfonsoServlet"
)

public class PruebaServlet extends HttpServlet {
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter responseWriter = resp.getWriter();
        Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
        String param = optName.isPresent() && !optName.get().isEmpty() ? optName.get() : "";        
        if(param != "" ){
            try{
                int paramInt = Integer.parseInt(param);
                if(paramInt<=200 && paramInt >=1 ){
                    Todo todo = Service.getTodo(paramInt);
                    List<Todo> todoList = new ArrayList<>();
                    todoList.add(todo);
                    responseWriter.write(Service.todosToHTMLTable(todoList));
                    resp.setStatus(HttpServletResponse.SC_OK);
                    resp.setContentType("text/html");
                    responseWriter.flush();
                }else{
                    resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    responseWriter.write("No existe un item con el identificador dado.");
                    responseWriter.flush();
                }
            }catch(MalformedURLException e){
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                responseWriter.write("Error interno del servidor.");
                responseWriter.flush();
            }catch (Exception e){
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                responseWriter.write("Requerimiento inválido.");
                responseWriter.flush();
            }
            
        }else{
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            responseWriter.write("Requerimiento inválido.");
            responseWriter.flush();
        }   
    }
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter responseWriter = resp.getWriter();
        Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
        String param = optName.isPresent() && !optName.get().isEmpty() ? optName.get() : "";
        
        if(param != "" ){
            try{
                int paramInt = Integer.parseInt(param);
                if(paramInt<=200 && paramInt >=1 ){
                    Todo todo = Service.getTodo(paramInt);
                    List<Todo> todoList = new ArrayList<>();
                    todoList.add(todo);
                    responseWriter.write(Service.todosToHTMLTable(todoList));
                    resp.setStatus(HttpServletResponse.SC_OK);
                    resp.setContentType("text/html");
                    responseWriter.flush();
                }else{
                    resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    responseWriter.write("No existe un item con el identificador dado.");
                    responseWriter.flush();
                }
            }catch(MalformedURLException e){
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                responseWriter.write("Error interno del servidor.");
                responseWriter.flush();
            }catch (Exception e){
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                responseWriter.write("Requerimiento inválido.");
                responseWriter.flush();
            }
            
        }else{
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            responseWriter.write("Requerimiento inválido.");
            responseWriter.flush();
        }     
    }
}
