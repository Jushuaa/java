//定义鸡翅类基类
public abstract class ChickenWings extends BaseFood implements PrintFood{

	
	@Override
	public void printConsumptionMessage() {
		
		System.out.println(this.kind+"鸡翅：\t单价"+this.price+"  \t数量："+this.num);	
	}
}