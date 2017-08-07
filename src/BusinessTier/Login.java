package BusinessTier;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import DatabaseTier.DatabaseConnector;

/**
 * Servlet implementation class login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				response.getWriter().append("Served at: ").append(request.getContextPath());
				response.setContentType("text/json");
				PrintWriter out = response.getWriter();
				ObjectMapper mapper = new ObjectMapper();
				
//				String username = request.getParameter("username");
//		        String password = request.getParameter("password");
				String username = "john";
				String password= "gradprog@03";
				boolean isValid = true;
		        
		        //TODO: Verify username and password
		        DatabaseConnector connector = new DatabaseConnector();
		        isValid = connector.checklogin(username, password);
		        System.out.println(isValid);
		        
		        //if valid, create new user object
		        if (isValid){
			        User user = new User();
					user.setUserID("user1");
		            request.getSession().setAttribute("user", user);
		            //Object to JSON in String
					String jsonInString = mapper.writeValueAsString(user);
					System.out.println(jsonInString);
				
		            //response.sendRedirect("/index.html");
		        }
		        else {
		            request.setAttribute("error", "Error, please try again");
		            System.out.println("Error");
		            request.getRequestDispatcher("/index.html").forward(request, response);
		        }
				
		   
//				out.println("<html><body>");
//				out.println("<h3>Hello world</h3>");
//				out.println("</body></html>");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/json");
		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		
//		String username = request.getParameter("username");
//      String password = request.getParameter("password");
		String username = "john";
		String password= "gradprog@03";
        
        //TODO: Verify username and password
        DatabaseConnector connector = new DatabaseConnector();
        boolean isValid = connector.checklogin(username, password);
        System.out.println(isValid);
        
        //if valid, create new user object
        if (isValid){
	        User user = new User();
			user.setUserID("user1");
            request.getSession().setAttribute("user", user);
            //Object to JSON in String
			String jsonInString = mapper.writeValueAsString(user);
			System.out.println(jsonInString);
		
            //response.sendRedirect("/index.html");
        }
        else {
            request.setAttribute("error", "Error, please try again");
            System.out.println("Error");
            request.getRequestDispatcher("/index.html").forward(request, response);
        }
		
	}

}
