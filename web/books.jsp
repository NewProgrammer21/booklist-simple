<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.techorda.db.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <%@include file="head.jsp"%>
    </head>
    <body>
        <%@include file="navbar.jsp"%>
        <div class="container mt-3">
            <div class="row">
                <h4 class="text-center">
                   Welcome to <%=siteName%>
                </h4>
            </div>
            <div class="row mt-3">
                <div class="col-12">
                    <button type="button" class="btn btn-success btn-sm" data-bs-toggle="modal" data-bs-target="#addBook">
                        + ADD BOOK
                    </button>

                    <!-- Modal -->
                    <div class="modal fade" id="addBook" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <%@include file="addform.jsp"%>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-12">
                    <table class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>NAME</th>
                            <th>AUTHOR</th>
                            <th>GENRE</th>
                            <th>PRICE</th>
                            <th style="width: 10%">DETAILS</th>
                        </tr>
                        </thead>
                        <tbody>
                            <%
                                ArrayList<Book> books=(ArrayList<Book>) request.getAttribute("books");
                                if(books!=null){
                                for(Book b:books){
                            %>
                                <tr>
                                    <td><%=b.getId()%></td>
                                    <td><%=b.getName()%></td>
                                    <td><%=b.getAuthor()%></td>
                                    <td><%=b.getGenre()%></td>
                                    <td><%=b.getPrice()%> KZT</td>
                                    <td><a class="btn btn-success btn-sm" href="details?book_id=<%=b.getId()%>">DETAILS</a></td>
                                </tr>
                            <%
                                    }
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
