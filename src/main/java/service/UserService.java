 package service;

 import dao.UsersDao;
 import model.User;

 import javax.servlet.http.HttpServlet;
 import java.sql.Connection;

 public class UserService extends HttpServlet {
     private Connection connection = null;

     private void createConnection(UsersDao dao){
         this.connection = dao.createConnection();
     }

     private void closeConnection(UsersDao dao){
         dao.closeConnection(this.connection);
         this.connection = null;
     }

     public User entry(String userName, int studentId) {
         UsersDao dao = new UsersDao();
         createConnection(dao);
         dao.entry(userName, studentId, connection);
         closeConnection(dao);
         User user = new User();
         return user;
     }
 }
