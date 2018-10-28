//定义汉堡类基类
public abstract class Hamburg extends BaseFood implements PrintFood{
	

	@Override
	public void printConsumptionMessage() {
		
		System.out.println(this.kind+"汉堡：\t单价"+this.price+"  \t数量："+this.num);		
	}	
}