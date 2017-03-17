<%@include file="header.jsp" %>
<div class="container">
        <h1>Show All Students Records !!</h1>
        
        <table class="table table-stripped table-hover table-bordered">
            <tr>
                <th>ID:</th>
                <th>First-Name:</th>
                <th>Last-Name:</th>
                <th>Email:</th>
                <th>Contact-No:</th>
            </tr>
            
            <%
            StudentDAO stDAO = new StudentDAOImpl();
            for(Student st : stDAO.getAll()){
                
                %>
                <tr>
                    <td><%=st.getId()%></td>
                    <td><%=st.getFirstName()%></td>
                    <td><%=st.getLastName()%></td>
                    <td><%=st.getEmail()%></td>
                    <td><%=st.getContactNo()%></td>
                    
                </tr>
                
                
                
                <%
            }
            %>
        </table>
</div>
            <%@include file="footer.jsp" %>
