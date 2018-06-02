/**
 * <html>
 * <body>
 *  <P> Copyright JasonInternational Since 1994 https://github.com/Jasonandy/Spring-Core</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年</p>
 *  <p> Created by Jason </p>
 *  </body>
 * </html>
 */
package cn.ucaner.core.absinf.abs;

/**     
* @Package：cn.ucaner.core.absinf   
* @ClassName：HPPrinter   
* @Description：   <p> HP extends Printer NOT implement </p>
* @Author： - Jason   
* @CreatTime：2018年6月2日 上午11:15:03   
* @Modify By：   
* @ModifyTime：  2018年6月2日
* @Modify marker：   
* @version    V1.0
*/
public class HPPrinter extends Printer{

	@Override
	void print() {
		System.out.println("Hello , I'm HP Printer.");
	}

	public static void main(String[] args) {
		
		Printer p = new HPPrinter();
		p.open();
		p.print();
		p.close();
	}
}
//Outputs
//Printer Open.
//Hello , I'm HP Printer.
//Printer Closed.
