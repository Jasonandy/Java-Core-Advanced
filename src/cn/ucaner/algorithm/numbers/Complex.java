/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018 JasonInternational </p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年4月10日 上午9:46:32</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.algorithm.numbers;


/**
* @Package：cn.ucaner.algorithm.numbers   
* @ClassName：Complex   
* @Description：   <p> 复数</p>
* @Author： - Jason   
* @CreatTime：2018年5月9日 上午9:20:22   
* @Modify By：   
* @ModifyTime：  2018年5月9日
* @Modify marker：   
* @version    V1.0
 */
public class Complex {

    /**
     * 实数部分
     */
    public double real;

    /**
     * 虚数部分
     */
    public double imaginary;

    /**
     * Complex
     */
    public Complex() {
        this.real = 0.0;
        this.imaginary = 0.0;
    }

    /**
     * Complex
     * @param r 实部
     * @param i 虚部
     */
    public Complex(double r, double i) {
        this.real = r;
        this.imaginary = i;
    }

    /**
     * multiply
     * @param x
     * @return
     */
    public Complex multiply(final Complex x) {
        final Complex copy = new Complex(this.real, this.imaginary);
        copy.real = this.real * x.real - this.imaginary * x.imaginary;
        copy.imaginary = this.imaginary * x.real + this.real * x.imaginary;
        return copy;
    }

    /**
     * 加
     * @param x 复数
     * @return
     */
    public Complex add(final Complex x) {
        final Complex copy = new Complex(this.real, this.imaginary);
        copy.real += x.real;
        copy.imaginary += x.imaginary;
        return copy;
    }

    /**
     * sub
     * @param x 复数
     * @return
     */
    public Complex sub(final Complex x) {
        final Complex copy = new Complex(this.real, this.imaginary);
        copy.real -= x.real;
        copy.imaginary -= x.imaginary;
        return copy;
    }

    /**
     * abs
     * @return
     */
    public double abs() {
        return Math.sqrt(this.real * this.real + this.imaginary * this.imaginary);
    }

    @Override
    public String toString() {
        return "(" + this.real + "," + this.imaginary + ")";
    }

    /**
     * polar 极坐标
     * @param rho
     * @param theta
     * @return
     */
    public static Complex polar(final double rho, final double theta) {
        return (new Complex(rho * Math.cos(theta), rho * Math.sin(theta)));
    }

    /**
     * just for test
     * @param args
     */
    public static void main(String[] args) {
        Complex complexa = new Complex(1, 2);
        Complex complexb = new Complex(2, 3);
        System.out.println(complexa.toString());
        System.out.println(complexb.toString());
        System.out.println(complexa.multiply(complexb));
        System.out.println(complexa.sub(complexb));
    }
}
