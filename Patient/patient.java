import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import
java.sql.PreparedStatement;
import javax.servlet.ServletException; import
javax.servlet.annotation.WebServlet; import
javax.servlet.http.HttpServlet; import
javax.servlet.http.HttpServletRequest; import
javax.servlet.http.HttpServletResponse;
@WebServlet("/PatientServlet") public class
PatientServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
public PatientServlet()
{
super(); // TODO Auto-generated
constructor stub }
protected void doGet(HttpServletRequest request, HttpServletResponse
response) throws ServletException, IOException {
} protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
String name = request.getParameter("name");
String age = request.getParameter("age");
String date = request.getParameter("date");
String cause = request.getParameter("cause");
String doctor = request.getParameter("doc");
String treat = request.getParameter("treat");
String s = "";
//System.out.println(s);
try
{
Class.forName("com.mysql.jdbc.Driver"); Connection con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "root");
String updateDB = "insert into PatientRecords values(?,?,?,?,?,?);";
PreparedStatement ps =con.prepareStatement(updateDB); ps.setString(1,
name); ps.setString(2, age); ps.setString(3, date);
ps.setString(4, cause); ps.setString(5, doctor);
ps.setString(6, treat); int i = ps.executeUpdate();
System.out.println("Rows inserted: "+i); s = name + "\n" + age + "\n" + date +
"\n" + cause + "\n" + doctor + "\n" + treat + "\n" + i;
} catch(Exception e){
System.out.println(e); }
request.setAttribute("data", s);
request.getRequestDispatcher("/view.jsp").forward(request,response);
}
} 



import java.io.IOException; import
java.sql.Connection; import
java.sql.DriverManager;
import javax.servlet.ServletException; import
javax.servlet.annotation.WebServlet; import
javax.servlet.http.HttpServlet; import
javax.servlet.http.HttpServletRequest; import
javax.servlet.http.HttpServletResponse;
import
com.mysql.jdbc.ResultSet;
import
com.mysql.jdbc.Statement;
@WebServlet("/GetServlet") public class
GetServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
public GetServlet()
{
super(); // TODO Auto-generated
constructor stub }
protected void doGet(HttpServletRequest request, HttpServletResponse
response) throws ServletException, IOException {
request.getRequestDispatcher("/index.html").forward(request,
response);
} protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
try
{
Class.forName("com.mysql.jdbc.Driver"); Connection con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "root");
Statement stmt = (Statement) con.createStatement(); ResultSet rs = (ResultSet)
stmt.executeQuery("select * from PatientRecords");
String s = "{\n";
while(rs.next()) { s +=
rs.getString(1) + "\n"; s +=
rs.getString(2) + "\n"; s +=
rs.getString(3) + "\n";
s += rs.getString(4) + "\n"; s
+= rs.getString(5) + "\n"; s +=
rs.getString(6) + "\n}\n";
} request.setAttribute("data", s); } catch(Exception e) {
System.out.println(e); } request.getRequestDispatcher("/data.jsp").forward(request,
response);
}
} 




<!DOCTYPE html> <html> <head>
<meta charset="ISO-8859-1">
<title>Insert Patient Details</title>
</head> <body>
<div
align='center'>
<form action='PatientServlet' method='post'>
Name: <input type='text' name='name'/><br><br> Age: <input
type='number' name='age'/><br><br> Date of Admission: <input
type='date' name='date'/><br><br> Cause of Admission: <input
type='text' name='cause'/><br><br> Doctor Diagnosed: <input
type='text' name='doc'/><br><br> Treatment Proposed: <input
type='text' name='treat'/><br><br> <input type="submit"
value='update'/> </form> <br><br><br><br> <form
action='GetServlet' method='post'>
Get Current Database data: <input type='submit' value='GetData'/>
</form> </div>
</body> </html>



<%@ page language="java" contentType="text/html; charset=ISO8859-1"
pageEncoding="ISO-8859-
1"%> <!DOCTYPE html>
<html> <head> <meta
charset="ISO-8859-1">
<title>Insert title here</title>
</head> <body>
<div
align='center'>
<p>Updated Database:</p>
<pre>${requestScope["data"]}</pre>
<br><br><br><br> <form
action='GetServlet' method='post'>
Get Current Database data: <input type='submit' value='Get
Data'/>
</form> </div>
</bo
dy>
</ht
ml>




<%@ page language="java" contentType="text/html; charset=ISO8859-1"
pageEncoding="ISO-8859-
1"%> <!DOCTYPE html>
<html> <head> <meta
charset="ISO-8859-1">
<title>Insert title here</title>
</head> <body>
<div
align='center'>
<p>Database data:</p>
<pre>${requestScope["data"]}</pre>
<form action='GetServlet'
method='get'>
Update Database: <input type='submit' value='Add data'/> </form> </div>
</body> </html>