//抽象工厂基类
public interface AbstractKFCFactory {

	//生产汉堡
	public Hamburg createHamburg(int num); 
	
	//生产鸡翅
	public ChickenWings createChickenWings(int num);
	
	//生产薯条
	public FrenchFries createFrenchFries(int num);
	
	//生产饮品
	public Drink createDrink(int num);
	
	//生产冰淇淋
	public IceCream createIceCream(int num);
}
