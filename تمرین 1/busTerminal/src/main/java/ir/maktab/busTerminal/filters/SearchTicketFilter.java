package ir.maktab.busTerminal.filters;

import javax.servlet.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SearchTicketFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        filterChain.doFilter(servletRequest,servletResponse);

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(servletRequest.getParameter("date"));

            if (new Date().before(date)){
                filterChain.doFilter(servletRequest,servletResponse);
            }else {
                servletRequest.getRequestDispatcher("searchTicket.jsp").include(servletRequest,servletResponse);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void destroy() {

    }
}
