import java.util.Scanner;
//主方法
public class KFC{
		public static void main(String[] args) {
			System.out.println("本店提供的套餐如下：");
			KfcPackage taocanFactory1 = Director.getTaoCanFactory1();
			System.out.println("套餐一：");
			System.out.println(taocanFactory1.getKind());
			System.out.println("价格:"+taocanFactory1.getPrice());
			
			//生产套餐二
			KfcPackage taocanFatory2 = Director.getTaoCanFactory2();
			System.out.println("套餐二：");
			System.out.println(taocanFatory2.getKind());
			System.out.println("价格:"+taocanFatory2.getPrice());
			Scanner scan = new Scanner(System.in);
			
			
			

			System.out.println("请选择是否订购套餐，是请输入9，否则输入0");
			int num = scan.nextInt();
			if(num == 9) {
			System.out.println("请选择你选则的套餐：1:套餐一      2:套餐二");
			int number = scan.nextInt();
			if( number == 1) {
				System.out.println("------------------账单------------------");
				
				AbstractKFCFactory akfcFoctory = new KFCFactory();
				
				//创建顾客对象
				Customer customer = new Customer(akfcFoctory);
				
				//顾客点餐
				//3个汉堡
				double hamburgCost = customer.orderHamburg(3);
				
				
				//5个鸡翅
				double chickenWingsCost = customer.orderChickenWings(5);
				
				//1份薯条
				double frenchFriesCost = customer.orederFrenchFrices(1);
				
				//2杯饮料
				double drinkCost = customer.orderDrink(2);
				
				//1份冰淇淋
				double iceCreamCost = customer.orderIceCream(1);
				
				System.out.println(taocanFactory1.getKind());
				System.out.println("价格:"+taocanFactory1.getPrice()+"\t 数量:"+taocanFactory1.getNum());
				System.out.println("累计消费:"+(hamburgCost+chickenWingsCost+frenchFriesCost+drinkCost+iceCreamCost+taocanFactory1.getPrice())+"元");
				System.out.println("----------------------------------------");
				System.out.println("用户支付金额：");
				int money = scan.nextInt();
				System.out.println("找零钱"+(money-(hamburgCost+chickenWingsCost+frenchFriesCost+drinkCost+iceCreamCost+taocanFactory1.getPrice()))+"元");
		
			}
			else{
                System.out.println("------------------账单------------------");
				
				AbstractKFCFactory akfcFoctory = new KFCFactory();
				
				//创建顾客对象
				Customer customer = new Customer(akfcFoctory);
				
				//顾客点餐
				//3个汉堡
				double hamburgCost = customer.orderHamburg(3);
				
				
				//5个鸡翅
				double chickenWingsCost = customer.orderChickenWings(5);
				
				//1份薯条
				double frenchFriesCost = customer.orederFrenchFrices(1);
				
				//2杯饮料
				double drinkCost = customer.orderDrink(2);
				
				//1份冰淇淋
				double iceCreamCost = customer.orderIceCream(1);
				
				System.out.println(taocanFatory2.getKind());
				System.out.println("价格:"+taocanFatory2.getPrice()+"\t 数量:"+taocanFatory2.getNum());
				System.out.println("累计消费:"+(hamburgCost+chickenWingsCost+frenchFriesCost+drinkCost+iceCreamCost+taocanFatory2.getPrice())+"元");
				System.out.println("----------------------------------------");
				System.out.println("用户支付金额：");
				int money = scan.nextInt();
				System.out.println("找零钱"+(money-(hamburgCost+chickenWingsCost+frenchFriesCost+drinkCost+iceCreamCost+taocanFatory2.getPrice()))+"元");
		
				
			}
	   }
			else {
				System.out.println("------------------账单------------------");
				
				AbstractKFCFactory akfcFoctory = new KFCFactory();
				
				//创建顾客对象
				Customer customer = new Customer(akfcFoctory);
				
				//顾客点餐
				//3个汉堡
				double hamburgCost = customer.orderHamburg(3);
				
				
				//5个鸡翅
				double chickenWingsCost = customer.orderChickenWings(5);
				
				//1份薯条
				double frenchFriesCost = customer.orederFrenchFrices(1);
				
				//2杯饮料
				double drinkCost = customer.orderDrink(2);
				
				//1份冰淇淋
				double iceCreamCost = customer.orderIceCream(1);
				System.out.println("累计消费:"+(hamburgCost+chickenWingsCost+frenchFriesCost+drinkCost+iceCreamCost)+"元");
				System.out.println("----------------------------------------");
				System.out.println("用户支付金额：");
				int money = scan.nextInt();
				System.out.println("找零钱"+(money-(hamburgCost+chickenWingsCost+frenchFriesCost+drinkCost+iceCreamCost))+"元");
			}
		}
}