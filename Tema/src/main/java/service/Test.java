package service;

import model.person.Client;

import java.util.ArrayList;
import java.util.List;

public interface Test {


    float price();
}
abstract class Test1 implements Test{



}
class Test2 extends Test1{

    @Override
    public float price() {
        return 0;
    }
}