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
package cn.ucaner.core.absinf.inf;

/**     
* @Package：cn.ucaner.core.absinf.inf   
* @ClassName：Women   
* @Description：   <p> Women</p>
* @Author： - Jason   
* @CreatTime：2018年6月2日 上午11:27:11   
* @Modify By：   
* @ModifyTime：  2018年6月2日
* @Modify marker：   
* @version    V1.0
*/
public class Women implements Person,Chinese{

	@Override
	public void eat() {
		System.out.println("Women eat sweet fruite  vegtables. ");
	}

	@Override
	public void province() {
		System.out.println("Chinese women.");
		
	}
	
	public static void main(String[] args) {
		Person p = new Women();
		p.eat();
		
		Chinese c = new Women();
		c.province();
	}

}
//Outputs
//Women eat sweet fruite  vegtables. 
//Chinese women.
