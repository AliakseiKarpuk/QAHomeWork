import org.testng.Assert;
import org.testng.annotations.Test;

import static jdk.nashorn.internal.objects.Global.Infinity;
import static jdk.nashorn.internal.objects.Global.NaN;

public class UnitTest {

    @Test
    public void divTest1(){
        Calculator calc = new Calculator();

        Assert.assertEquals(calc.div(4.6,2.3),2);
    }

    @Test
    public void divTest2(){
        Calculator calc = new Calculator();

        Assert.assertEquals(calc.div(-4.6,-2.3),2);
    }

    @Test
    public void divTest3(){
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.div(4.6,-2.3),-2);
    }

    @Test
    public void divTest4(){
        Calculator calc = new Calculator();

        Assert.assertEquals(calc.div(4.6,0),Infinity);
    }

    @Test
    public void divTest5(){
        Calculator calc = new Calculator();

        Assert.assertEquals(calc.div(-4.6,0),-Infinity);
    }

    @Test
    public void divTest6(){
        Calculator calc = new Calculator();

        Assert.assertEquals(calc.div(0,4.6),0);
    }

    @Test
    public void sqrtTest1(){
        Calculator calc = new Calculator();

        Assert.assertEquals(calc.sqrt(4096),64);
    }

    @Test
    public void sqrtTest2(){
        Calculator calc = new Calculator();

        Assert.assertEquals(calc.sqrt(-4096),NaN);
    }

    @Test
    public void sqrtTest3(){
        Calculator calc = new Calculator();

        Assert.assertEquals(calc.sqrt(0),0);
    }
}
