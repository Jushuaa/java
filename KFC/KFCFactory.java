//具体工厂
public class KFCFactory implements AbstractKFCFactory{
	@Override
	public Hamburg createHamburg(int num) {
		// TODO Auto-generated method stub
		return new CheeseEagHamburg(num);
	}

	@Override
	public ChickenWings createChickenWings(int num) {
		// TODO Auto-generated method stub
		return new SpicyChickenWings(num);
	}

	@Override
	public FrenchFries createFrenchFries(int num) {
		// TODO Auto-generated method stub
		return new ChinaChickenFrice(num);
	}

	@Override
	public Drink createDrink(int num) {
		// TODO Auto-generated method stub
		return new CokeDrink(num);
	}

	@Override
	public IceCream createIceCream(int num) {
		// TODO Auto-generated method stub
		return new MatchaIceCream(num);
	}
}
