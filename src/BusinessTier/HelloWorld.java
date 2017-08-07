package BusinessTier;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/json");
		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		
		//TODO: Unpack JSON to get username and password
		
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        //TODO: Verify username and password
        
        //if valid, create new user object
//        User user = new User();
//		user.setUserID("user1");
//       
//        if (user != null) {
//            request.getSession().setAttribute("user", user);
//            //response.sendRedirect("/index.html");
//        }
//        else {
            request.setAttribute("error", "Error, please try again");
            System.out.println("Error");
            request.getRequestDispatcher("/index.html").forward(request, response);
//        }
		
		

//		//Object to JSON in String
//		String jsonInString = mapper.writeValueAsString(user);
//		System.out.println(jsonInString);
	
    
		
//		out.println("<html><body>");
//		out.println("<h3>Hello world</h3>");
//		out.println("</body></html>");
	}
	

}