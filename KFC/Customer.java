//顾客类
public class Customer {
	
	private AbstractKFCFactory kfcFactory;
	
	public Customer(AbstractKFCFactory kfcFactory) {
		this.kfcFactory = kfcFactory;
	}
	
	//购买香辣汉堡
	public double orderHamburg(int num) {
		//获得香辣汉堡
		Hamburg hamburg = kfcFactory.createHamburg(num);
		//打印购买信息
		hamburg.printConsumptionMessage();
		//返回总消费
		return hamburg.totalPrice();
	}
	
	
	//购买香辣鸡翅
	public double orderChickenWings(int num) {
		//获得香辣鸡翅
		ChickenWings chicken = kfcFactory.createChickenWings(num);
		//打印购买信息
		chicken.printConsumptionMessage();
		//返回总消费
		return chicken.totalPrice();
	}
	
	//购买薯条
	public double orederFrenchFrices(int num) {
		//获得薯条
		FrenchFries frenchfrice = kfcFactory.createFrenchFries(num);
		//打印购买信息
		frenchfrice.printConsumptionMessage();
		//返回总消费
		return frenchfrice.totalPrice();
	}
	
	//购买饮品
	public double orderDrink(int num) {
		//获得可乐
		Drink drink = kfcFactory.createDrink(num);
		//打印购买信息
		drink.printConsumptionMessage();
		//返回总消费
		return drink.totalPrice();
	}
	
	//购买冰淇淋
	public double orderIceCream(int num) {
		//获得冰淇淋
		IceCream icecream = kfcFactory.createIceCream(num);
		//打印购买信息
		icecream.printConsumptionMessage();
		//返回总消费
		return icecream.totalPrice();
	}
}