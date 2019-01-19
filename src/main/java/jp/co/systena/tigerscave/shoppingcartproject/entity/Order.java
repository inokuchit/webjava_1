package jp.co.systena.tigerscave.shoppingcartproject.entity;

/**
 * 注文情報オブジェクト.
 *
 * @author tatsuya.inoguchi
 * @since 1.0.0
 */
public class Order {
	/**
	 * 商品名.
	 */
	private String name;

	/**
	 * 商品名を保持
	 *
	 * @param 商品名
	 * @since 1.0.0
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 商品名を取得
	 *
	 * @return 商品名
	 * @since 1.0.0
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 商品価格.
	 */
	private int price;

	/**
	 * 商品価格を保持
	 *
	 * @param 商品価格
	 * @since 1.0.0
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * 商品価格を取得
	 *
	 * @return 商品価格
	 * @since 1.0.0
	 */
	public int getPrice() {
		return this.price;
	}

	/**
	 * 注文個数.
	 */
	private int num = 0;

	/**
	 * 注文個数を保持
	 *
	 * @param 注文個数
	 * @since 1.0.0
	 */
	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * 注文個数を取得
	 *
	 * @return 注文個数
	 * @since 1.0.0
	 */
	public int getNum(){
		return this.num;
	}

}
