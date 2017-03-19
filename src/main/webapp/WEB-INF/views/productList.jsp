<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 
<html>
<head>
    <title>Spring MVC Hello World</title>
</head>
 
<body>
    <h2>Store products</h2>
 
    <table border="1">
        <tr>
            <th>Product</th>
            <th>Description</th>
            <th>Category Name</th>
            <th>Category description</th>            
        </tr>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.productName}</td>
                <td>${product.description}</td>
                <td>${product.category.categoryName}</td>
                <td>${product.category.description}</td>
            </tr>
        </c:forEach>
    </table>
 
</body>
</html>