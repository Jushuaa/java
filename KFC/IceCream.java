//冰淇淋基类
public abstract class IceCream extends BaseFood implements PrintFood{
	public void printConsumptionMessage() {
		System.out.println(this.kind+"冰淇淋：\t单价"+this.price+"  \t数量："+this.num);
	}
}