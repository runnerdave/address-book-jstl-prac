package net.runnerdave.controller;

import net.runnerdave.model.Contact;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.time.Month;
import java.time.MonthDay;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by David A. Jiménez (e67997) on 30/05/2017.
 */
@WebServlet(
        name = "listServlet",
        urlPatterns = "/list"
)
public class ListServlet extends HttpServlet {
    private static final SortedSet<Contact> contacts = new TreeSet<>();

    static {


        contacts.add(new Contact("Bernardo", "O'Higgins", "555-1593", "Santiago de Chile",
                MonthDay.of(Month.JANUARY, 5),
                Instant.parse("1780-02-01T21:22:23Z")
        ));
        contacts.add(new Contact("José", "de San Martin", "555-0712", "Buenos Aires",
                null, Instant.parse("1770-10-15T15:31:17Z")
        ));
        contacts.add(new Contact("Simón", "Bolívar", "555-9834", "Caracas",
                MonthDay.of(Month.NOVEMBER, 17),
                Instant.parse("1783-12-17T01:45:01Z")
        ));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("empty") != null)
            request.setAttribute("contacts", Collections.<Contact>emptySet());
        else
            request.setAttribute("contacts", contacts);
        request.getRequestDispatcher("/WEB-INF/jsp/view/list.jsp")
                .forward(request, response);
    }
}
