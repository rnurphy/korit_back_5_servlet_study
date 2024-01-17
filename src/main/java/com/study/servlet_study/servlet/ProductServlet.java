package com.study.servlet_study.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.servlet_study.entity.Product;
import com.study.servlet_study.service.ProductService;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService;
       
    public ProductServlet() {
        super();
        productService = ProductService.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productName = request.getParameter("productName");
		
		response.setStatus(200);
		response.getWriter().println(productService.getProduct(productName));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productName = request.getParameter("productName");
		int price = Integer.parseInt(request.getParameter("price"));
		String size = request.getParameter("size");
		String color = request.getParameter("color");
		
		Product product = Product.builder().productName(productName).price(price).size(size).color(color).build();
		
		int result = productService.addProduct(product);
		
		if (result == 1) {
			response.setStatus(201);
		}
		if (result == 0) {
			response.setStatus(400);
		}
		response.getWriter().println(result);
		
		
	}

}
