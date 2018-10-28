public class TaoCanFactory2 extends KfcBuilder{

	@Override
	public KfcPackage getKfcPackage() {
		super.kfcpackage.setKind("七虾汉堡、烧烤鸡翅、原味薯条、可乐、抹茶冰欺凌");
		super.kfcpackage.setNum(1);
		super.kfcpackage.setPrice(109.0);
		return super.kfcpackage;
	}
}
