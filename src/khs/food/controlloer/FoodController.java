package khs.food.controlloer;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import khs.common.exception.PageNotFoundException;
import khs.food.model.service.FoodService;

@WebServlet("/food/*")
public class FoodController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private FoodService foodService = new FoodService(); 
	
    public FoodController() {
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
	System.out.println("1. food진입(FoodController)");
			// 0. dummyData로 String을 받는다. 
			String dummy = "field"; 
			// 1. foodService를 통해서 dataBase의 foodDTO를 받아온다. 
			// ***** 1) 리스트로 꺼내 올 것인가? 어떤 방법이 반복문으로 jsp에서 attribute를 꺼낼때 
			// 더 간편하고 쉬운가? 
			// ***** 2) Map으로 꺼내올 것인가? 
			String isNull = foodService.searchFood(dummy); 
			if(isNull == null) {
				System.out.println("결과값 : null(joinController)");
			} else {
				System.out.println("결과값 : 있음(joinController)");
			}
			// 2. foodDTO를 SESSION 객체로 저장, 꺼낼 준비 
			request.getRequestDispatcher("/food/food-form").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
