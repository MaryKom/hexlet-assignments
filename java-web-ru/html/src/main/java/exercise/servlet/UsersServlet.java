package exercise.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.ArrayUtils;

public class UsersServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            showUsers(request, response);
            return;
        }

        String[] pathParts = pathInfo.split("/");
        String id = ArrayUtils.get(pathParts, 1, "");

        showUser(request, response, id);
    }

    private List<Map<String, String>> getUsers() throws JsonProcessingException, IOException {
        // BEGIN
        String content = Files.readString(Path.of("./src/main/resources/users.json"));
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, String>> listUser = objectMapper.readValue(content, new TypeReference<>(){});
        return listUser;
        // END
    }

    private void showUsers(HttpServletRequest request,
                          HttpServletResponse response)
                throws IOException {

        // BEGIN
        List<Map<String, String>> listUser = getUsers();
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");

        StringBuilder body = new StringBuilder();
        body.append("""
                <!DOCTYPE html>
                <html lang="ru">
                    <head>
                        <meta charset="UTF-8">
                        <title>Example application</title>
                        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
                              rel="stylesheet"
                              integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
                              crossorigin="anonymous">
                    </head>
                    <style>
                    table, th, td {
                      border: 3px solid blue;
                    }
                    </style>
                    <body>
                    <div class="container">
                        <table style="width:50%">
                            <tr>
                                <th>id</th>
                                <th>full name</th>
                            </tr>
                """);
        for (var user : listUser) {
            body.append("<tr>"
                    + "<td>" + user.get("id") + "</td>"
                    + "<td>" + "<a href=\"/users/" + user.get("id") + "\">"
                    + user.get("firstName") + " " + user.get("lastName") + "</a></td>"
                    + "</tr>");
        }

        body.append("""
                            </table>
                        </div>
                    </body>
                </html>
                """);
        out.println(body);
        // END
    }

    private void showUser(HttpServletRequest request,
                         HttpServletResponse response,
                         String id)
                 throws IOException {

        // BEGIN
        Map <String, String> user = getUsers(getUsers(), id);
        if (user == null) {
            response.sendError(404, "Not found");
        } else {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html;charset=UTF-8");

            StringBuilder body = new StringBuilder();
            body.append("""
                <!DOCTYPE html>
                    <html lang="ru">
                        <head>
                            <meta charset="UTF-8">
                            <title>Example application</title>
                            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
                                  rel="stylesheet"
                                  integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
                                  crossorigin="anonymous">
                        </head>
                        <style>
                        table, th, td {
                          border: 3px solid blue;
                        }
                        </style>
                        <body>
                        <div class="container">
                            <table style="width:50%">
                                <tr>
                                    <th>id</th>
                                    <th>full name</th>
                                    <th>email</th>
                                </tr>
                    """);
            body.append( "<tr>"
                    + "<td>" + user.get("id") + "</td>"
                    + "<td>" + user.get("firstName") + " " + user.get("lastName") + "</td>"
                    + "<td>" + user.get("email") + "</td>" + "</a></td>"
                    + "</tr>");
            body.append("""
                                        </table>
                                    </div>
                                </body>
                            </html>
                            """);
            out.println(body);
        }
        // END
    }

    private Map<String, String> getUsers(List<Map<String, String>> users, String id) throws JsonProcessingException, IOException {
        // BEGIN
        return users.stream()
                .filter(u -> u.get("id").equals(id))
                .findFirst()
                .orElse(null);
        // END
    }
}
