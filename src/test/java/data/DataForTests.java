package data;

import org.testng.annotations.DataProvider;

import java.util.Iterator;

public class DataForTests {

    @DataProvider(name = "DataForPost")
    public Object[][] dataForPost(){
        return new Object[][] {
                {"Maulana", 1},
                {"Ishaq",3}
        };
    }



    @DataProvider(name = "DataForDelete")
    public Object[] dataForDelete(){
        return new Object[]{
                4,5,6
        };
    }


}
