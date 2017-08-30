# Design Patterns (Java)

**Design Pattern** lar 3 xil kategoriya asosida tashkil topgan : 
1. Generative | Generativ    | Порождающие - _Qulay va xavfsiz obyekt yaratishda hatto obyektlar oilasini yaratishda ishlatiladi._
2. Structural | Strukturaviy | Структурные - _klasslar ierarxiyasini qulay tashkil qilish_ 
3. Behavioral | Vazifali     | Поведенческие - _obyektlar orasi xavfsiz, effektiv aloqani ta'minlash_


### Linklar 

**Generative Patterns**

1. [Factory Pattern](#factory-pattern)
2. [Abstract Factory Pattern](#abstract-factory-pattern)
3. [Singleton Pattern](#singleton-pattern)
4. [Builder Pattern](#builder-pattern)
5. [Prototype Pattern](#prototype-pattern)

**Structural Patterns**

6. [Adapter Pattern](#adapter-pattern)
7. [Bridge Pattern](#bridge-pattern)
8. [Decorator Pattern](#decorator-pattern)
9. [Facade Pattern](#facade-pattern)
10. [Proxy Pattern](#proxy-pattern)
11. [Flyweight Pattern](#flyweight-pattern)
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

### Builder Pattern

> **Builder Pattern** ni yutuqlari _usablity_ va _readability_. Yana yutuq tarafi ko'p maydonga ega classdan obyekt yaratilayotganda ko'plab set metodlari ishlatilmasligida. Yana **Builder Pattern** asosida qurilgan klass _immutability_(o'zgarmas) maydonlarni ishlatishda kontstruktorga hamma maydonlar joylashtirilmaydi builderni o'zidan olinadi.

> Address klass
```java
public class Address {

    private final String city;

    private final String district;

    private final String streetHome;

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getStreetHome() {
        return streetHome;
    }

    //Address klassni builderi
    public static class Builder{

        private final String city;
        private final String district;

        private String streetHome = "";

        public Builder(String city, String district) {
            this.city = city;
            this.district = district;
        }

        public Builder setStreetHome(String streetHome) {
            this.streetHome = streetHome;
            return this;
        }

        public Address build(){
            return new Address(this);
        }
    }

    
    //final maydonlarni shu yerda yuklaymiz
    private Address(Builder builder){
        city = builder.city;
        district = builder.district;
        streetHome = builder.streetHome;

    }
}



```
> User klass

```java
public class User {

    private final String firstName;

    private final String lastName;

    private final int age;

    private final Address address;


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    
    //User klassni builderi
    public static class Builder{

        private final String firstName;

        private final String lastName;

        private final int age;

        private Address address;

        public Builder(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public Builder setAddress(Address address) {
            this.address = address;

            return this;
        }

        public User build(){
            return new User(this);
        }


    }

    //final maydonlar hammas konstruktor argumentiga joylashtirmasdan turib yuklanadi
    private User(Builder builder){

        firstName = builder.firstName;
        lastName = builder.lastName;
        age =builder.age;
        address = builder.address;
    }
}
```

> ishlatish
```java

public class BuilderShow {

    public static void main(String[] args) {

        User user1 = new User.Builder("Muhammadjon","Xasanov",23)
                .setAddress(new Address.Builder("Tashkent","M.Ulug'bek")
                .setStreetHome("Data 4 home")
                .build())
                .build();

        System.out.println(user1.getFirstName());

        System.out.println(user1.getAddress()
                                .getCity());
    }
}
```

>console

```
Muhammadjon
Tashkent

Process finished with exit code 0

```

### Prototype Pattern

### Adapter Pattern

> **Adapter Pattern** - ikkita bir biriga mos kelmaydigan interfacelarga most vazifasini yaratib beradi

> Bir biriga mos tushmaydigan interfacelar
```java
public interface MediaPlayer {

    void play(String audioType,String fileName);
}

public interface AdvancedMediaPlayer {

    void playVLC(String fileName);
    void playMp4(String fileName);
}
```

> **AdvancedMediaPlayer** ga tegishli klasslar
```java
public class MP4Player implements AdvancedMediaPlayer {
    @Override
    public void playVLC(String fileName) {
//        System.out.println("play VLC name + "+fileName);
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("play mp4 name + "+fileName);

    }
}

public class VLCPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVLC(String fileName) {
        System.out.println("play VLC name + "+fileName);
    }

    @Override
    public void playMp4(String fileName) {
//        System.out.println("play VLC name + "+fileName);

    }
}
```
> Biz **AdvancedMediaPlayer** interfaceni **MediaPlayer** dan extend olgan **AudioPlayer** klassga tenglashtirishimiz uchun adapter yaratamiz.

```java
public class MediaAdapter implements MediaPlayer {

    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {

        if (audioType.equalsIgnoreCase("vlc")){
            advancedMediaPlayer = new VLCPlayer();
        }else if (audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer = new MP4Player();
        }

    }

    @Override
    public void play(String audioType, String fileName) {

        if (audioType.equalsIgnoreCase("vlc")){
            advancedMediaPlayer.playVLC(fileName);
        }else if (audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}

```
> Endi **AudioPlayer** ga **AdvancedMediaPlayer** birlashtiramiz
```java
public class AudioPlayer implements MediaPlayer {

    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {

        if (! audioType.equalsIgnoreCase("mp3")){
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType,fileName);

        }else {
            System.out.println("play mp3 name + "+fileName);

        }
    }
}
```
> natijani tekshirib ko'ramiz
```java
public class AdapterPatternDemo {

    public static void main(String[] args) {

        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3","jonim.mp3");
        audioPlayer.play("mp4","kino.mp4");
        audioPlayer.play("vlc","ubuntuKino.vlc");
    }
}

```
> console

```
play mp3 name + jonim.mp3
play mp4 name + kino.mp4
play VLC name + ubuntuKino.vlc

Process finished with exit code 0
```
### Bridge Pattern

> **Bridge Pattern**da ikkita alohida biznes logikani bitta ko'rinishga olib kelib ishlatishni ta'minlab beradi

>2 ta alohida klassimiz bor
```java
public interface Device {

    void setVolume(int i);
    int getVolume();

    void setEnable(boolean enable);
    boolean isEnabled();


    void status();

}

public class Radio implements Device {

    private boolean isEnabled = false;
    private int volume = 0;


    @Override
    public void setVolume(int i) {
        volume = i;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setEnable(boolean enable) {
        isEnabled = enable;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public void status() {
        System.out.println("=====================");
        System.out.println("| volume: "+volume);
        System.out.println("| isEnabled: "+isEnabled);
        System.out.println("=====================");
    }
}

public class TV implements Device {

    private boolean isEnabled = false;
    private int volume = 0;


    @Override
    public void setVolume(int i) {
        volume = i;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setEnable(boolean enable) {
        isEnabled = enable;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public void status() {
        System.out.println("=====================");
        System.out.println("| volume: "+volume);
        System.out.println("| isEnabled: "+isEnabled);
        System.out.println("=====================");
    }
}
```

> buni bir xil tarzda ishlashiga most yaratamiz
```java
public interface Remote {

    void volumeDown();

    void volumeUp();

    void turnOn();
    void turnOff();
}


public class BaseRemote implements Remote {

    protected Device device;

    public BaseRemote(Device device) {
        this.device = device;
    }

    public BaseRemote() {
    }

    @Override
    public void volumeDown() {
        device.setVolume(device.getVolume() - 1);
    }

    @Override
    public void volumeUp() {
        device.setVolume(device.getVolume() + 1);

    }

    @Override
    public void turnOn() {
        device.setEnable(true);

    }

    @Override
    public void turnOff() {
        device.setEnable(false);

    }
}
```
> natijani ishlatib ko'ramiz
```java

public class BridgeDemo {

    public static void main(String[] args) {

        BaseRemote baseRemote = new BaseRemote(new TV());
        baseRemote.turnOn();
        baseRemote.volumeUp();


        MultiRemote multiRemote = new MultiRemote(new TV());
        multiRemote.turnOn();

    }
}
```
### Decorator Pattern
> Bu pattern umumiy interfeys sababli, obyektlarga nastroyka qo'shilib ketishini ta'minlaydi
> misolda oddiy ma'lumotni zichlab shifrlaymiz
> umumiy interfeys
```java
public interface DataSource {

    void writeData(String data);
    String readData();

}

```

>ma'lumotni o'qish yozish
```java

public class FileDataSource implements DataSource {

    private String name;


    public FileDataSource(String name) {
        this.name = name;
    }

    @Override
    public void writeData(String data) {
        File file = new File(name);
        try (OutputStream fos = new FileOutputStream(file)) {
            fos.write(data.getBytes(), 0, data.length());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String readData() {
        char[] buffer = null;
        File file = new File(name);
        try (FileReader reader = new FileReader(file)) {
            buffer = new char[(int) file.length()];
            reader.read(buffer);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return new String(buffer);
    }
}
```
> **Decorator Pattern** ishlatish
```java
public class BaseDecorator implements DataSource {

    private DataSource dataSource;

    public BaseDecorator(DataSource dataSource) {
        this.dataSource =dataSource;
    }

    @Override
    public void writeData(String data) {

        dataSource.writeData(data);
    }

    @Override
    public String readData() {
        return dataSource.readData();
    }
}

```
> zichlash
```java
public class CompressionDecorator extends BaseDecorator {
    private int compLevel = 6;

    public CompressionDecorator(DataSource source) {
        super(source);
    }

    public int getCompressionLevel() {
        return compLevel;
    }

    public void setCompressionLevel(int value) {
        compLevel = value;
    }

    @Override
    public void writeData(String data) {
        super.writeData(compress(data));
    }

    @Override
    public String readData() {
        return decompress(super.readData());
    }

    public String compress(String stringData) {
        byte[] data = stringData.getBytes();
        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream(512);
            DeflaterOutputStream dos = new DeflaterOutputStream(bout, new Deflater(compLevel));
            dos.write(data);
            dos.close();
            bout.close();
            return Base64.getEncoder().encodeToString(bout.toByteArray());
        } catch (IOException ex) {
            return null;
        }
    }

    public String decompress(String stringData) {
        byte[] data = Base64.getDecoder().decode(stringData);
        try {
            InputStream in = new ByteArrayInputStream(data);
            InflaterInputStream iin = new InflaterInputStream(in);
            ByteArrayOutputStream bout = new ByteArrayOutputStream(512);
            int b;
            while ((b = iin.read()) != -1) {
                bout.write(b);
            }
            in.close();
            iin.close();
            bout.close();
            return new String(bout.toByteArray());
        } catch (IOException ex) {
            return null;
        }
    }
}
```
>shifrlash
```java
public class EncryptionDecorator extends BaseDecorator {



    public EncryptionDecorator(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void writeData(String data) {
        super.writeData(encode(data));
    }

    @Override
    public String readData() {
        return decode(super.readData());
    }


    public String readDecodedData() {
        return decode(super.readData());
    }

    public String encode(String data) {
        byte[] result = data.getBytes();
        for (int i = 0; i < result.length; i++) {
            result[i] += (byte) 1;
        }
        return Base64.getEncoder().encodeToString(result);
    }

    public String decode(String data) {
        byte[] result = Base64.getDecoder().decode(data);
        for (int i = 0; i < result.length; i++) {
            result[i] -= (byte) 1;
        }
        return new String(result);
    }
}
```
>ishlatish
```java
public class DecoratorDemo {

    public static void main(String[] args) {
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";

        BaseDecorator baseDecorator = new CompressionDecorator(new EncryptionDecorator(new BaseDecorator(new FileDataSource(salaryRecords)))); // decorator

        baseDecorator.writeData(salaryRecords);

        DataSource plain = new FileDataSource("out/OutputDemo.txt");

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");
        System.out.println(baseDecorator.readData());
    }
}
```
### Facade Pattern


### Proxy Pattern
> Bunda asosiy obyektni ustiga qobiq yaratilib o'zini ishini bajarib va obyektni ishini ham bajaruvchi pattern hisoblanadi.
```java

public interface Image {


    void display();
}


public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName){
        System.out.println("Loading " + fileName);
    }
}

public class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
```

### Flyweight Pattern
> Bu pattern operativ xotira hajmini oshib ketmasligini ta'minlaydi.
> svoystvasi bir xil obyektlarni qayta yaratmaydi
