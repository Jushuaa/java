//饮料基类
public abstract class Drink extends BaseFood implements PrintFood{

	public void printConsumptionMessage() {
		
		System.out.println(this.kind+"饮品：\t单价"+this.price+"  \t数量："+this.num);
	}
}