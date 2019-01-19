package jp.co.systena.tigerscave.shoppingcartproject.service;

import java.util.ArrayList;
import java.util.List;

import jp.co.systena.tigerscave.shoppingcartproject.entity.Item;

/**
 *
 *
 * @author tatsuya.inokuchi
 * @since 1.0.0
 */
public class ListService {
	public List<Item> getItemList() {
		//商品名
	    String[] itemName = {"商品A","商品B","商品C","商品D"};
	    //商品価格
	    int[] price = {10,20,30,40};
	    //商品リスト
	    List<Item> items = new ArrayList<Item>();

	    for(int i = 0; i < itemName.length; i++) {
	    	Item item = new Item();
	    	item.setName(itemName[i]);
	    	item.setPrice(price[i]);
	    	items.add(item);
	    }

	    return items;
	  }

}
