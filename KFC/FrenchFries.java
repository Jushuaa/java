//定义薯条类基类
public abstract class FrenchFries extends BaseFood implements PrintFood{

	
	@Override
	public void printConsumptionMessage() {
		
		System.out.println(this.kind+"薯条：\t单价"+this.price+"  \t数量："+this.num);	
	}
}