<%@include file="header.jsp" %>
        <%
            if(request.getMethod().equals("POST")){
            StudentDAO stDAO = new StudentDAOImpl();
            Student st = new Student();
            
            st.setFirstName(request.getParameter("fname"));
            st.setLastName(request.getParameter("lname"));
            st.setEmail(request.getParameter("email"));
            st.setContactNo(request.getParameter("contact"));
            
            stDAO.insert(st);
            }
        %>
        <form method="POST" action>
            <label>First-Name:</label>
            <input type="text" name="fname"/>
            <label>Last-Name:</label>
            <input type="text" name="lname"/>
            <label>Email:</label>
            <input type="text" name="email"/>
            <label>Contact-No:</label>
            <input type="text" name="contact"/>
            
            <button type="submit" >Save</button>
        </form>
        
        <a href="show.jsp">SHOW ALL Students</a>
        <%@include file="footer.jsp" %>
