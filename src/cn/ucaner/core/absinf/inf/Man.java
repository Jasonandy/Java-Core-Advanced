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
* @ClassName：Man   
* @Description：   <p> Man</p>
* @Author： - Jason   
* @CreatTime：2018年6月2日 上午11:26:37   
* @Modify By：   
* @ModifyTime：  2018年6月2日
* @Modify marker：   
* @version    V1.0
*/
public class Man implements Person,Chinese{

	@Override
	public void eat() {
		System.out.println("Man eat cigarettes wine.");
	}

	@Override
	public void province() {
		System.out.println("Chinese Man.");
	}
	
	public static void main(String[] args) {
		Person p = new Man();
		p.eat();
		
		Chinese c = new Man();
		c.province();
	}
}
//Outputs
//Man eat cigarettes wine.
//Chinese Man.