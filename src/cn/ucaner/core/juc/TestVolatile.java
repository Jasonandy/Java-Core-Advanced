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
* @ClassName：TestVolatile   
* @Description：   <p> Volatile </p>
* 一、volatile 关键字：当多个线程进行操作共享数据时，可以保证内存中的数据可见。
* 		相较于 synchronized 是一种较为轻量级的同步策略。 （互斥锁） 
* 注意：
* 		1. volatile 不具备"互斥性"                -- 多个线程可以访问 不具备互斥  
* 		2. volatile 不能保证变量的"原子性"        -- 不能保证变量的原子性 不可分割性  所以只是轻量级的
* 
* {@link https://www.cnblogs.com/dolphin0520/p/3920373.html} volatile
* 
* @Author： - Jason   
* @CreatTime：2018年7月7日 下午9:55:35   
* @Modify By：   
* @ModifyTime：  2018年7月7日
* @Modify marker：   
* @version    V1.0
 */
public class TestVolatile {
	
	public static void main(String[] args) {
		
		ThreadDemo2 td = new ThreadDemo2();   
		
		/**
		 * 一个线程Main是去读取  但是ThreadDemo3线程是写（每个线程有独立的内存）
		 * ThreadDemo3 会把共享数据读取到线程的内存中去 然后修改数据值  falg=true
		 * 将改好的数据写回到主存中  这个时候main读取的共享变量  main是读的flag=true
		 * ThreadDemo3 已经变动了 但是Main线程却并不知道.   --- 内存的可见性问题   线程处理的数据的时候是彼此不可见  （轻量级的线程锁）
		 * 
		 * 线程创建  销毁 调度  -- 多线程要注意的   Jdk1.5 对线程有volatile   Syncnoized 1.5 以后出了juc
		 * 
		 * 锁耗费的时间还是比较大的  开销大 
		 * 
		 * Volatile 关键字  内存可见性 
		 */
		//ThreadDemo3 td = new ThreadDemo3();//不可见   虽然已经是true但是进不去
		new Thread(td).start();
		
		while(true){
			/*synchronized (td) {
				加锁可以解决问题 但是效率会偏低
			}*/ 
			if(td.isFlag()){
				System.out.println("------------------");
				break;//跳出
			}
		}
		
	}

}

/**
* @Package：cn.ucaner.core.juc   
* @ClassName：ThreadDemo3   
* @Description：   <p> ThreadDemo3 无volatile 修饰变量</p>
* @Author： - Jason   
* @CreatTime：2018年7月7日 下午10:00:27   
* @Modify By：   
* @ModifyTime：  2018年7月7日
* @Modify marker：   
* @version    V1.0
 */
class ThreadDemo3 implements Runnable {

	private  boolean flag = false;

	@Override
	public void run() {
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			
		}

		flag = true;
		
		System.out.println("flag=" + isFlag());

	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}

/**
* @Package：cn.ucaner.core.juc   
* @ClassName：ThreadDemo2   
* @Description：   <p> ThreadDemo2 </p>
* @Author： - Jason   
* @CreatTime：2018年7月7日 下午9:56:57   
* @Modify By：   
* @ModifyTime：  2018年7月7日
* @Modify marker：   
* @version    V1.0
 */
class ThreadDemo2 implements Runnable {

	private volatile boolean flag = false;

	@Override
	public void run() {
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
		}

		flag = true;
		
		System.out.println("flag=" + isFlag());

	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}