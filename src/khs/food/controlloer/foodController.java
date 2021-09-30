package khs.food.controlloer;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import khs.common.exception.PageNotFoundException;

@WebServlet("/food/*")
public class foodController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public foodController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. URI 분리 작업 
				String[] uriArr = request.getRequestURI().split("/");
				System.out.println(Arrays.deepToString(uriArr));
				switch (uriArr[uriArr.length-1]) {
				case "food" : 
					System.out.println("food진입");
					food(request, response);
					break;
				case "food-Method" : 
					System.out.println("form진입");
					foodMethod(request, response);
					break; 
				default: 
					System.out.println("Exception진입");
					throw new PageNotFoundException();
				}
	}

	private void foodMethod(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		System.out.println("2. 진입 확인 (Session객체를 바꾸는 용)");
	}

	private void food(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("2. 진입 확인 (food) ");
			request.getRequestDispatcher("/food/food-form").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
