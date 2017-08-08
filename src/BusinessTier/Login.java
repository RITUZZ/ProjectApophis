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
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("hello from get");
		response.setContentType("text/json");
		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		
		
//		String username = request.getParameter("username");
//		System.out.println(username);
//		String password = request.getParameter("password");
		String username = "alison";
		String password= "gradprog2016@07";
        
        //TODO: Verify username and password
        DatabaseConnector connector = new DatabaseConnector();
        boolean isValid = connector.checklogin(username, password);
        System.out.println("is valid: "+isValid);
        
        //if valid, create new user object
        if (isValid){
	        User user = new User();
			user.setUserID(username);
            request.getSession().setAttribute("user", username);
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
