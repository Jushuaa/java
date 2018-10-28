public class Director {

	//套餐1的应用
	private static KfcBuilder taocanFactoey1 = new TaoCanFactory1(); 
	
	//套餐2的应用
	private static KfcBuilder taocanFactory2 = new TaoCanFactory2();
	
	//生产套餐一
	public static KfcPackage getTaoCanFactory1() {
		return taocanFactoey1.getKfcPackage();
	}
	
	//生产套餐二
	public static KfcPackage getTaoCanFactory2() {
		return taocanFactory2.getKfcPackage();
	}
}
