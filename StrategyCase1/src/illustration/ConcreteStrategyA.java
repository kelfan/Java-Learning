package illustration;

public class ConcreteStrategyA implements Strategy {

    @Override
    public void strategyInterface() {
        //相关的业务
        System.out.print("inside concrete illustration.Strategy A");
    }
}
