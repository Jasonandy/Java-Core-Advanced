/**
 * <html>
 * <body>
 *  <P> Copyright JasonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年6月25日 下午3:15:41</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.core.thread.alpaca.runnable;

/**     
* @Package：cn.ucaner.core.thread.alpaca.runnable   
* @ClassName：ThreadRunnable   
* @Description：   <p> ThreadRunnable </p>
* @Author： - Jason   
* @CreatTime：2018年6月25日 下午3:15:41   
* @Modify By：   
* @ModifyTime：  2018年6月25日
* @Modify marker：   
* @version    V1.0
*/
public class ThreadRunnable implements Runnable {

	@Override
	public synchronized void run() {
		while(true) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("[Java-Core-Advance]Customer Thread Start ...");
		}
	}
	
	public static void main(String[] args) {
		
		ThreadRunnable nt = new ThreadRunnable();
		
		// 初始化状态
		Thread thread = new Thread(nt); // 创建线程,并指定线程任务
		
		thread.start(); // 启动线程
		
		while(true) {
			synchronized (nt) {
				System.out.println("[Java-Core-Advance] Main Thread Satrt ...");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				nt.notifyAll();
			}
		}
		
	}
}
