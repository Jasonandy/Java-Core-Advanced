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
package cn.ucaner.core.thread.alpaca.thread;

/**     
* @Package：cn.ucaner.core.thread.alpaca.thread   
* @ClassName：ThreadExtend   
* @Description：   <p> ThreadExtend </p>
* @Author： - Jason     
* @CreatTime：2018年6月25日 下午3:17:32   
* @Modify By：   
* @ModifyTime：  2018年6月25日
* @Modify marker：   
* @version    V1.0
*/
public class ThreadExtend extends Thread{

	public ThreadExtend(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		while(!interrupted()) {
			System.out.println(getName() + "Thread Start ... ");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		ThreadExtend te1 = new ThreadExtend("[First-thread]");
		ThreadExtend te2 = new ThreadExtend("[Second-thread]");
		
		te1.start();
		te2.start();
		
		//te1.stop();    //线程停止
		te1.interrupt(); //线程中断
	}
}
