package cn.ucaner.core.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
* @Package：cn.ucaner.core.juc   
* @ClassName：TestAtomicDemo   
* @Description：   <p> Atomic 原子性问题</p>
* {@link https://www.jianshu.com/p/fb6e91b013cc} 
* {@link https://www.cnblogs.com/xckxue/p/8682059.html}
* {@link https://www.cnblogs.com/kisty/p/5408264.html}
* @Author： - Jason   
* @CreatTime：2018年7月7日 下午11:24:35   
* @Modify By：   
* @ModifyTime：  2018年7月7日
* @Modify marker：   
* @version    V1.0
 */
/*
 * 一、i++ 的原子性问题：i++ 的操作实际上分为三个步骤“读-改-写”
 * 		  int i = 10;
 * 		  i = i++; //10
 * 
 * 		  int temp = i; //先是赋值 读  temp=i
 * 		  i = i + 1;
 * 		  i = temp;
 * 
 * 二、原子变量：在 java.util.concurrent.atomic 包下提供了一些原子变量。
 * 		1. volatile 保证内存可见性
 * 		2. CAS（Compare-And-Swap） 算法保证数据变量的原子性
 * 			unsafe.getAndAddInt(this, valueOffset, 1);
 * 			 native boolean compareAndSwapInt
 * 			CAS 算法是硬件对于并发操作的支持 [一个当前内存值V、旧的预期值A、即将更新的值B]  -- 硬件的支持 
 * 				[当且仅当预期值A和内存值V相同时,将内存值修改为B并返回true,否则什么都不做,并返回false]
 * 			CAS 包含了三个操作数： [比一般的锁性能会好一点]
 * 			①内存值  V
 * 			②预估值  A
 * 			③更新值  B
 * 			当且仅当 V == A 时， V = B; 否则，不会执行任何操作。
 * 		3. 缺点
 * 			CAS存在一个很明显的问题，即ABA问题。
 *			问题：如果变量V初次读取的时候是A，并且在准备赋值的时候检查到它仍然是A，那能说明它的值没有被其他线程修改过了吗？
 *			如果在这段期间曾经被改成B，然后又改回A，那CAS操作就会误认为它从来没有被修改过。
 *			针对这种情况，java并发包中提供了一个带有标记的原子引用类AtomicStampedReference，它可以通过控制变量值的版本来保证CAS的正确性。
 */
public class TestAtomicDemo {

	public static void main(String[] args) {
		
		AtomicDemo ad = new AtomicDemo();
		
		for (int i = 0; i < 10; i++) {
			new Thread(ad).start();
		}
	}
	
}

/**
* @Package：cn.ucaner.core.juc   
* @ClassName：AtomicDemo   
* @Description：   <p> AtomicDemo </p>
* @Author： - Jason   
* @CreatTime：2018年7月7日 下午11:26:22   
* @Modify By：   
* @ModifyTime：  2018年7月7日
* @Modify marker：   
* @version    V1.0
 */
class AtomicDemo implements Runnable{
	
	//private  int serialNumber = 0;
	
	//private volatile int serialNumber = 0;
	
	private AtomicInteger serialNumber = new AtomicInteger(0);

	@Override
	public void run() {
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			
		}
		System.out.println(Thread.currentThread().getName()+":"+getSerialNumber());
	}
	
	/**
	 * @Description: add ++ 
	 * @return int
	 * @Autor: Jason
	 */
	public int getSerialNumber(){
		//return serialNumber++;
		return serialNumber.getAndIncrement();
		/**
		 * unsafe.getAndAddInt(this, valueOffset, 1);
		 * native boolean compareAndSwapInt
		 */
	}
	
}

//Outputs
//无Volatile 无Atomic   - 变量变化不可以见   - 数据也不具备原子性
//Thread-1:1
//Thread-3:3
//Thread-4:2
//Thread-2:0
//Thread-0:1
//Thread-6:4
//Thread-8:5
//Thread-5:8
//Thread-9:7
//Thread-7:6
//volatile  不能保证原子性 可能不同线程拿的数据是同一个 
//Thread-0:0
//Thread-2:0
//Thread-5:2
//Thread-4:4
//Thread-6:6
//Thread-1:1
//Thread-9:5
//Thread-3:3
//Thread-8:8
//Thread-7:7

//native boolean compareAndSwapInt
//Thread-0:1
//Thread-4:2
//Thread-5:4
//Thread-2:0
//Thread-3:5
//Thread-1:3
//Thread-6:6
//Thread-8:8
//Thread-7:7
//Thread-9:9