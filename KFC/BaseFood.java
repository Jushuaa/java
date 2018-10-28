public abstract  class BaseFood {

	//定义餐品价格
	protected double price;
	//定义餐品数量
	protected int num;
	//定义物品种类
	protected String kind;
	
	//计算消费总金额
	public double totalPrice(){
		return this.price*this.num;
	}
}
