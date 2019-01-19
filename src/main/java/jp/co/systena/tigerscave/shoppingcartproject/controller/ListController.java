package jp.co.systena.tigerscave.shoppingcartproject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jp.co.systena.tigerscave.shoppingcartproject.entity.Item;
import jp.co.systena.tigerscave.shoppingcartproject.entity.Order;
import jp.co.systena.tigerscave.shoppingcartproject.service.ListService;

@Controller // Viewあり。Viewを返却するアノテーション
public class ListController {

	 @Autowired
	  HttpSession session;

	@RequestMapping(value = "/") // URLとのマッピング
	public ModelAndView show(ModelAndView mav) {
		ListService listService = new ListService();

		//商品一覧を取得
		List<Item> list = listService.getItemList();

		mav.addObject("list", list);
		mav.setViewName("listview");

		// Viewのテンプレート名を返す
		return mav;
	}

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public ModelAndView order(ModelAndView mav, @RequestParam(value="name") String name,
			@RequestParam(value="price") int price,
			@RequestParam(value="num") int num) {
		Order order = new Order();

		//商品一覧を取得
		mav = show(mav);

		 //セッション情報をOrderに格納
	    List<Order> orders = (List<Order>) session.getAttribute("orderList");

	    //セッション情報にOrderが無ければ生成
	    if(orders == null) {
			orders = new ArrayList<Order>();
			session.setAttribute("orderList", orders);
		}

	    order.setName(name);
	    order.setPrice(price);
	    order.setNum(num);
	    orders.add(order);
	    session.setAttribute("orderList", orders);

		return mav;
	}

	@RequestMapping(value = "/purchase", method = RequestMethod.GET)
	public ModelAndView order(ModelAndView mav) {
		Order order = new Order();

		//セッション情報をOrderに格納
	    List<Order> orders = (List<Order>) session.getAttribute("orderList");

	    //セッション情報にOrderが無ければ商品一覧を表示
	    if(orders == null) {
	    	mav = show(mav);
	    	return mav;
		}

	    //商品個数を格納
	    int total = 0;
	    for(Order or : orders) {
	    	total += or.getPrice() * or.getNum();
	    }

	    mav.addObject("total", total);
		mav.addObject("order", orders);
		mav.setViewName("purchaselistview");
		return mav;
	}
}
