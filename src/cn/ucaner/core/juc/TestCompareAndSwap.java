/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.  - https://github.com/Jasonandy/Java-Core-Advanced </p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.core.juc;

/**
* @Package：cn.ucaner.core.juc   
* @ClassName：TestCompareAndSwap   
* @Description：   <p> 模拟 CAS 算法 </p>
* @Author： - Jason   
* @CreatTime：2018年7月8日 上午12:24:49   
* @Modify By：   
* @ModifyTime：  2018年7月8日
* @Modify marker：   
* @version    V1.0
 */
public class TestCompareAndSwap {

	public static void main(String[] args) throws InterruptedException {
		
		final CompareAndSwap cas = new CompareAndSwap();
		
		for (int i = 0; i < 10; i++) {
			//Thread.sleep(10);//Sleep一下结果大有不同
			new Thread(new Runnable() {
				@Override
				public void run() {
					int expectedValue = cas.get();//获取当前的值
					int newValue = (int)(Math.random() * 101);
					boolean flag = cas.compareAndSet(expectedValue, newValue);
					System.out.println("V:"+cas+"  A:"+expectedValue+"   B:"+newValue+"  是否加入:"+flag);
				}
			}).start();
		}
		
	}
	
}


/**
* @Package：cn.ucaner.core.juc   
* @ClassName：CompareAndSwap   
* @Description：   <p> CompareAndSwap </p>
* @Author： - Jason   
* @CreatTime：2018年7月8日 上午12:25:02   
* @Modify By：   
* @ModifyTime：  2018年7月8日
* @Modify marker：   
* @version    V1.0
 */
class CompareAndSwap{
	
	/**
	 * value 
	 */
	private int value;
	
	/**
	 * @Description: 获取内存中值
	 * @return int   数据
	 * @Autor: Jason
	 */
	public synchronized int get(){
		return value;
	}
	
	/**
	 * @Description: compare 比较
	 * 一个当前内存值V、旧的预期值A、即将更新的值B
	 * 当且仅当预期值A和内存值V相同时,将内存值修改为B并返回true,否则什么都不做,并返回false
	 * @param expectedValue         期望值 A
	 * @param newValue              新的值 B
	 * @return int
	 * @Autor: Jason
	 */
	public synchronized int compareAndSwap(int expectedValue, int newValue){
		int oldValue = value; //V  - synchronized int get  
		if(oldValue == expectedValue){//当A 和 V 相等表示 B值写入
			this.value = newValue;
		}
		return oldValue;//不相等就不做处理 就是当前的Value咯
	}
	
	/**
	 * @Description: 是否设置值进去
	 * @param expectedValue   期望值  A
	 * @param newValue        新值     B
	 * @return boolean
	 * @Autor: Jason
	 */
	public synchronized boolean compareAndSet(int expectedValue, int newValue){
		//A  - (B OR V) 
		return expectedValue == compareAndSwap(expectedValue, newValue);
	}

	@Override
	public String toString() {
		return "[value=" + value + "]";
	}
	
}
