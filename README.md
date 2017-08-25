# Java Design Patterns

### Linklar 
1. [Factory Pattern](#factory-pattern)
2. [Abstract Factory Pattern](#abstract-factory-pattern)
2. [Singleton Pattern](#singleton-pattern)
### Factory Pattern 


> Universal shape interface
  
  ```java
public interface Shape {
    void draw();
}
  ```
> Uchta shape categoriyasiga tegishli class yaratamiz  

```java
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle::draw() method");

    }
}
```

```java

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle::draw() method");
    }
}
```

```java 
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square::draw() method");

    }
}
```

> Endi asosiy **Factory Pattern** ga ega class yaratamiz

```java
public class ShapeFactory {

    public Shape getShape(String shapeType){

        if (shapeType == null){
            return null;
        }

        if (shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }else if (shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }else if (shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }
         return null;
    }

}
```
> endi priznak bilan kerakli class ni olamiz

```java
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle    = shapeFactory.getShape("CIRCLE");
        circle.draw();

        Shape square    = shapeFactory.getShape("SQUARE");
        square.draw();

        Shape rectangle = shapeFactory.getShape("RECTANGLE");
        rectangle.draw();
```
> console: 
```
Circle::draw() method
Square::draw() method
Rectangle::draw() method

Process finished with exit code 0
```        
  
### Abstract Factory Pattern 

> Bu patternda **Factory Pattern** ham abstraktlashtiriladi

> Bizda 2 ta **MainActivity** va **MainFragment** interface bor ularni o'zini metodlari bor

```java
public interface MainActivity {

    void onCreate();
}

public interface MainFragment {

    void onCreateView();
}
```

> Shu interfacelardan implement qilingan class lar bor

```java
//Activitylar
public class ProfileActivity implements MainActivity {
    @Override
    public void onCreate() {
        System.out.println("ProfileActivity oncreate method called");
    }
}

public class SettingsActivity implements MainActivity {
    @Override
    public void onCreate() {
        System.out.println("SettingsActivity oncreate method called");
    }
}

//Fragmentlar
public class ProfileFragment implements MainFragment {
    @Override
    public void onCreateView() {
        System.out.println("ProfileFragment oncreateview method called");
    }
}

public class SettingsFragment implements MainFragment {
    @Override
    public void onCreateView() {
        System.out.println("SettingsFragment oncreateview method called");
    }
}
```

> Kerakli activity yoki fragmentni oladigan **Abstract Factory Pattern** ga tegishli class

```java
public abstract class AbstractFactory {

    abstract MainActivity getActivity(String activityName);
    abstract MainFragment getFragment(String fragmentName);
}
```
> _AbstractFactory_ classidan extend ogan classlar

```java

//kerakli activityni chiqarib beradigan Factory metodi bor class
public class ActivityFactory extends AbstractFactory {


    public MainActivity getActivity(String activityName){

        if (activityName == null) return null;

        if (activityName.equalsIgnoreCase("profileactivity")){
            return new ProfileActivity();
        }else if (activityName.equalsIgnoreCase("settingsactivity")){
            return new SettingsActivity();
        }

        return null;
    }

    @Override
    MainFragment getFragment(String fragmentName) {
        return null;
    }
}

//kerakli fragmentni chiqarib beradigan Factory metodi bor class
public class FragmentFactory extends AbstractFactory{


    @Override
    MainActivity getActivity(String activityName) {
        return null;
    }

    public MainFragment getFragment(String fragmentName){

        if (fragmentName == null) return null;

        if (fragmentName.equalsIgnoreCase("profilefragment")){
            return new ProfileFragment();
        }else if (fragmentName.equalsIgnoreCase("settingsfragment")){
            return new SettingsFragment();
        }

        return null;
    }
}

```

> Activity yoki Fragmentni chaqirib oladigan **Factory** class

```java
public class FactoryProducer {

    public static AbstractFactory getFactory(String which){
        if (which.equalsIgnoreCase("activity")){
            return new ActivityFactory();
        }else if (which.equalsIgnoreCase("fragment")){
            return new FragmentFactory();
        }
        return null;
    }
}
```

> Endi bularni ishlatish

```java
public class AbstractFactoryPatternDemo {

    public static void main(String[] args) {


        /*
        *
        * Activity lar olinsin
        *
        * */
        AbstractFactory factory = FactoryProducer.getFactory("activity");

        MainActivity profileActivity = factory.getActivity("profileactivity");

        profileActivity.onCreate();

        MainActivity settingsActivity = factory.getActivity("settingsactivity");

        settingsActivity.onCreate();

        /*
        *
        * Fragment lar olinsin
        *
        * */
        factory = FactoryProducer.getFactory("fragment");


        MainFragment profileFragment = factory.getFragment("profilefragment");

        profileFragment.onCreateView();





        MainFragment settingsFragment = factory.getFragment("settingsfragment");

        settingsFragment.onCreateView();


    }
}
```

> console
```
ProfileActivity oncreate method called
SettingsActivity oncreate method called
ProfileFragment oncreateview method called
SettingsFragment oncreateview method called

Process finished with exit code 0
```


### Singleton Pattern

> **Singleton Pattern** class

```java
public class SingletonFragment {

    private static SingletonFragment mInstance;

    public static SingletonFragment getInstance(){
        if (mInstance == null) mInstance = new SingletonFragment();


        return mInstance;

    }

    private SingletonFragment(){

    }
    
    public void showMessage(){
        System.out.println("Singleton message");
    }
}
```
> ishlatamiz
```java
public class GetSingleton {

    public static void main(String[] args) {

        SingletonFragment singletonFragment = SingletonFragment.getInstance();

        singletonFragment.showMessage();

    }
}
```
>console
```
Singleton message

Process finished with exit code 0
```