# Input/Output İşlemleri
## I/O Veri Akışları
Java’da veri giriş/çıkış işlemlerini, bir yerden başka bir yere (byte dizileri halinde) akan veriler olarak düşünebiliriz.
Java’da veri akımlarının iki ana gruba ayrıldığını söylemeliyiz:
- Byte akımları (Byte Streams)
- Karakter akımları (Character Streams)
### Byte Akışları (Byte Stream)
- Byte akışı, tek baytlık (8 bit) veriyi okumak ve yazmak için kullanılır. Resim, grafik, ses ve benzeri karakter tipinden olmayan bütün akımlar byte akımlarıdır.
- Tüm byte akışı sınıfları, InputStream ve OutputStream soyut (abstract) sınıflardan türetilir.
### Karakter Akışları (Character Stream)
- Karakter akışı, tek bir veri karakterini okumak ve yazmak için kullanılır. Karakter akımları, adından da anlaşılacağı üzere, karakter tipinden verilerin giriş/çıkışını yapar. Unicode kullandığı için, farklı ülkelerin alfabelerine uyum sağlar.
- Tüm karakter akışı sınıfları, Reader ve Writer soyut (abstract) sınıflarından türetilir.
## File Sınıfı
Java.io paketinin File sınıfı, dosyalar ve dizinler üzerinde çeşitli işlemler gerçekleştirmek için kullanılır.
### Dosya ve Dizinler
Dosya, ilgili bilgileri depolamak için kullanılabilen adlandırılmış bir konumdur.
Dizinler, dosya ve alt dizinlerden oluşan bir koleksiyondur. Bir dizinin içindeki bir dizin, alt dizin olarak bilinir.
Bir File nesnesi oluşturmak için, önce java.io.File paketini içe aktarmamız gerekir.  
```java
File file = new File(String pathName);
```  

| İşlem         | Metot           | Paket               |
|--------------|------------------|----------------------|
| Dosya Oluşturma | `createNewFile()` | `java.io.File`        |
| Dosya Silme     | `delete()`         | `java.io.File`        |
| Dosya Okuma     | `read()`           | `java.io.FileReader`  |
| Dosya Yazma     | `write()`          | `java.io.FileWriter`  |

| Metot | Geri Dönüş Türü | Notlar                                                                                                         |
|-------|-----------------|----------------------------------------------------------------------------------------------------------------|
| createNewFile() | Boolean         | Eğer yeni bir dosya oluşturulursa metot true, dosya zaten belirtilen konumda mevcutsa false değerini döndürür. |
| delete() | Boolean         | Sadece boş dizinleri silebiliriz.(özellikle File nesnesi dizinse).                                                                              |
| mkdir() | Boolean         | Yeni dizin oluşturulursa true, dizin zaten mevcutsa false döndürür.                                            |
| list()  | String[]        | Arrayi foreach ile gezerek ekrana yazabiliriz.                                                                 |

### InputStream Sınıfı
InputStream sınıfı byte akışını temsil eden bir abstract sınıftır ve Java.io paketinden gelmektedir.  
InputStream alt sınıfları : FileInputStream, ByteArrayInputStream, ObjectInputStream  

#### FileInputStream Sınıfı
Java.io paketinin FileInputStream sınıfı, dosyalardan verileri (bayt cinsinden) okumak için kullanılır.  
 Dosya Yolu Kullanma:
```java
FileInputStream input = new FileInputStream(stringPath);
```  
Nesne Kullanma :
```java
FileInputStream input = new FileInputStream(File fileObject);
```  
##### FileInputStream Metotları
| Metot                                 | Geri Dönüş           | Açıklama |
|---------------------------------------|-----------------------|----------|
| `int read()`                          | `int`                | Dosyadan **bir byte** okur (0–255). Dosya sonuysa `-1` döner. |
| `int read(byte[] b)`                  | `int`                | `b` dizisine veri okur, kaç byte okuduğunu döner. |
| `int read(byte[] b, int off, int len)`| `int`                | Belirtilen `off` konumundan itibaren `len` byte okur. |
| `long skip(long n)`                   | `long`               | Akışta belirtilen sayıda byte atlanır, atlanan byte sayısını döner. |
| `void close()`                        | `void`               | Akışı kapatır. Kaynak sızıntısını önlemek için **zorunludur**. |
| `int available()`                     | `int`                | Akışta **okunabilir** byte sayısını döner (tahmini). |
| `FileChannel getChannel()`            | `FileChannel`        | Dosyaya ait **kanalı** döner (NIO kullanımı için). |
| `FileDescriptor getFD()`              | `FileDescriptor`     | Bu akışla ilişkili dosya tanımlayıcısını döner. |

#### FileOutputStream Sınıfı
Java.io paketinin FileOutputStream sınıfı, dosyalara veri (bayt cinsinden) yazmak için kullanılabilir.
OutputStream soyut sınıfını genişletir.  
Bir dosya çıktı akışı oluşturmak için önce java.io.FileOutputStream paketini içe aktarmalıyız.  
Dosya Yolu Kullanmak:  
```java
// Including the boolean parameter
FileOutputStream output = new FileOutputStream(String path, boolean value);

// Not including the boolean parameter
FileOutputStream output = new FileOutputStream(String path);

//İsteğe bağlı bir boolean parametresi gönderilir.
//Bu parametre True olarak ayarlanırsa, yeni veriler dosyadaki mevcut verilerin sonuna eklenecektir. 
//Aksi takdirde, yeni veriler dosyadaki mevcut verilerin üzerine yazar.
```
File Nesnesi Kullanmak:
```java
FileOutputStream output = new FileOutputStream(File fileObject);
```
#### ByteArrayInputStream
Java.io paketinin ByteArrayInputStream sınıfı, bir dizi girdi verisini (bayt cinsinden) okumak için kullanılabilir.  
ByteArrayInputStream'de, girdi akışı bayt dizisi kullanılarak oluşturulur. Bu bayt dizisinin verilerini depolamak için dahili bir dizi içerir.  
Bir bayt dizisi giriş akışı oluşturmak için, önce java.io.ByteArrayInputStream paketini içe aktarmalıyız.  
```java
// Dizinin tamamını okuyan bir ByteArrayInputStream oluşturur 
ByteArrayInputStream input = new ByteArrayInputStream(byte[] arr); 

// Dizinin bir bölümünü okuyan bir ByteArrayInputStream oluşturur 
ByteArrayInputStream input = new ByteArrayInputStream(byte[] arr, int start, int length);

//Burada giriş akışı, başlangıç konumundan başlayarak diziden uzunluğa eşit bayt sayısını okur.
```
#### ByteArrayOutputStream
Java.io paketinin ByteArrayOutputStream sınıfı, bir dizi çıktı verisini (bayt cinsinden) yazmak için kullanılabilir.  
OutputStream soyut sınıfını genişletir.  
ByteArrayOutputStream'de, verileri depolamak için dahili bir bayt dizisi bulunur.  
```java
// Varsayılan boyutta bir ByteArrayOutputStream oluşturur 
ByteArrayOutputStream out = new ByteArrayOutputStream(); 
// Belirtilen boyutta bir ByteArrayOutputStream oluşturma 
ByteArrayOutputStream out = new ByteArrayOutputStream(int size);
```
## Serialization
Java bilindiği üzerine nesneye yönelik bir dil. Ancak nesneleri bazen JVM dışında kullanmak gerekebiliyor. Fakat dışarıda kullandığımız bir nesnemizi tekrar içeride kullanmak istediğimizde nesne içinde kullanılan değerlerin hangi tipte olduğunu öğrenemiyoruz. Yani herhangi bir sınıftan bir nesne üretip, bunu bir dosyaya yazdırıp onu tekrar dosyadan okuduğumuzda değerlerin tip bilgisini bilememe problemimiz var. İşte tam bu durumda Java Serialization API yardımımıza koşuyor.

Java Serialization API sayesinde bir nesnenin birebir kopyasını, Java platformu dışında da depolayabiliriz. Bu mekanizma ile daha sonra, nesneyi depolanan yerden çekip, aynı durum (state) ve özellikleri ile kullanmaya devam edebiliriz. Tüm bu sisteme, Object Serialization (Nesne Serileştirme) adı verilir.

Nesneleri serileştirmek için yapılması gereken tek şey, serileştirilecek nesnemizin serileştirilebilir (serializable) olduğunu tagging interface sayesinde sınıf deklarasyonunun başında belirtmek.  

Java platformu, **nesneleri serileştirmek** (yani bir nesnenin bellekteki halini byte dizisine çevirip diske yazmak veya ağ üzerinden göndermek) için iki temel sınıf sunar:  
🔸 `ObjectOutputStream`  
🔸 `ObjectInputStream`

Bu sınıflar sayesinde, **`Serializable` arayüzünü (interface) uygulayan herhangi bir sınıfın nesnesi** serileştirilebilir ve daha sonra tekrar geri okunabilir.

- **`ObjectOutputStream`**, bir nesneyi **serileştirip** (serialize) bir **çıktı akışına (output stream)** yazar. Bu sınıf, `ObjectOutput` arayüzünü uygular.
- **`ObjectInputStream`** ise daha önce serileştirilmiş bir nesneyi bir **girdi akışından (input stream)** okuyarak **tekrar belleğe alır** (deserialize eder). Bu sınıf da `ObjectInput` arayüzünü uygular.

Bu iki sınıf birlikte kullanılarak bir nesne önce diske (veya bir başka hedefe) yazılır, sonra gerektiğinde geri okunarak orijinal haline dönüştürülür.
### ObjectOutputStream
Java.io paketinin ObjectOutputStream sınıfı, ObjectInputStream tarafından okunabilen nesneleri yazmak için kullanılabilir. OutputStream soyut sınıfını enişletir.

Temel olarak ObjectOutputStream, sınıf adını ve nesne değerlerini kullanarak Java nesnelerini kodlar ve karşılık gelen akışları oluşturur. Bu süreç erileştirme (serialization) olarak bilinir.

Dönüştürülen akışlar dosyalarda saklanabilir ve ağlar arasında aktarılabilir.

Not: ObjectOutputStream sınıfı yalnızca Serializable arabirimini uygulayan nesneleri yazar. Bunun nedeni, nesnelerin akışa yazılırken serileştirilmesi grekmesidir.

Bir nesne çıktı akışı oluşturmak için önce java.io.ObjectOutputStream paketini içe aktarmalıyız.

```java
// ObjectOutputStream'deki nesnelerin yazıldığı bir FileOutputStream oluşturur
FileOutputStream fileStream = new FileOutputStream(String file);

// ObjectOutputStream'i oluşturur
ObjectOutputStream objStream = new ObjectOutputStream(fileStream);
```

### ObjectOutputStream
Java.io paketinin ObjectInputStream sınıfı, daha önce ObjectOutputStream tarafından yazılmış nesneleri okumak için kullanılabilir.  
```java
//InputStream soyut sınıfını genişletir.

import java.io.FileInputStream; 
import java.io.FileOutputStream; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
public class SerialTest { 
	public static void main(String[] args) { 
try { 
	Car car = new Car("Hyundai", "Getz"); 
	FileOutputStream file = new FileOutputStream("output.txt");
	ObjectOutputStream write = new ObjectOutputStream(file);        
	write.writeObject(car);

// Nesneyi Okumak 
	FileInputStream fileIn = new FileInputStream("output.txt"); 
	ObjectInputStream read = new ObjectInputStream(fileIn); 
// Reads the objects       
	Car newCar = (Car) read.readObject();

System.out.println("Car Brand : " + newCar.getBrand()); 
	System.out.println("Car Model: " + newCar.getModel()); 
      		 read.close();
      	write.close();
} 
catch (Exception e) {       
	 System.out.println(e.getMessage());
    }
  }
}
```
### BufferedInputStream
Java.io paketinin BufferedInputStream sınıfı, verileri (bayt cinsinden) daha verimli okumak için diğer giriş akışlarıyla birlikte kullanılır. InputStream soyut sınıfını genişletir.

BufferedInputStream, 8192 baytlık bir dahili arabellek tutar. BufferedInputStream'deki okuma işlemi sırasında, diskten bir bayt yığını okunur ve dahili tamponda saklanır.Ayrıca dahili arabellekten baytlar ayrı ayrı okunur. Böylelikle diskle iletişim sayısı azalır. BufferedInputStream kullanarak bayt okumanın daha hızlı olmasının nedeni budur.  
```java
// FileInputStream
FileInputStream file = new FileInputStream(String path);

// BufferedInputStream
BufferedInputStream buffer = new BufferInputStream(file);
```
### BufferedOutputStream
Java.io paketinin BufferedOutputStream sınıfı, verileri (bayt cinsinden) daha verimli yazmak için diğer çıktı akışlarıyla birlikte kullanılır. OutputStream soyut sınıfını genişletir.

BufferedOutputStream, 8192 baytlık bir dahili arabelleği korur. Yazma işlemi sırasında, baytlar disk yerine dahili tampona yazılır. Tampon doldurulduktan veya akış kapatıldıktan sonra, tüm tampon diske yazılır. Böylelikle diskle iletişim sayısı azalır. BufferedOutputStream kullanarak bayt yazmanın daha hızlı olmasının nedeni budur.  
```java
// FileOutputStream FileOutputStream file = new FileOutputStream(String path); 
// BufferedOutputStream BufferedOutputStream buffer = new BufferOutputStream(file);
```

### PrintStream
Java.io paketinin PrintStream sınıfı, çıktı verilerini bayt yerine yaygın olarak okunabilir biçimde (metin) yazmak için kullanılabilir.   

Soyut OutputStream sınıfını genişletir.   

Diğer output streamlerden farklı olarak, PrintStream ilkel verileri (tamsayı, karakter) bayt yerine metin biçimine dönüştürür. Daha sonra bu biçimlendirilmiş verileri çıktı akışına yazar.   

Ayrıca, PrintStream sınıfı herhangi bir girdi / çıktı istisnası (exception) atmaz. Bunun yerine, içindeki herhangi bir hatayı bulmak için checkError() metodunu kullanmamız gerekir.  
```java
// FileOutputStream 
FileOutputStream file = new FileOutputStream(String file); 
// PrintStream 
/PrintStream output = new PrintStream(file, autoFlush);
```  
System sınıfında sürekli kullandığımız PrintStream objesi :
```java
class Main { public static void main(String[] args) { 
    String data = "Hello World.";         
    System.out.print(data);
    }
}
```  
Aynı nesneyi kendimizde üretebiliriz :  
```java
import java.io.PrintStream; 
class Main { 
    public static void main(String[] args) { 
    String data = "Hello World."; 
    try { 
        PrintStream output = new PrintStream("output.txt"); 
        output.print(data);
        output.close();
            }
    catch(Exception e) {             
        e.getStackTrace();
            }
    }
}
```  
## Reader Sınıfı
Java.io paketinin Reader sınıfı, bir karakter akışını (Characters Stream) temsil eden soyut bir üst sınıftır.

Reader soyut bir sınıf olduğu için kendi başına kullanışlı değildir. Bununla birlikte, alt sınıfları verileri okumak için kullanılabilir.  
### InputStreamReader Sınıfı
Java.io paketinin InputStreamReader sınıfı, bayt cinsinden verileri karakter cinsinden verilere dönüştürmek için kullanılabilir. Soyut Reader sınıfını genişletir.  

InputStreamReader sınıfı, diğer giriş akışlarıyla (Input Streams) çalışır. Bayt akışları ve karakter akışları arasında bir köprü olarak da bilinir. Bunun nedeni, InputStreamReader'ın giriş akışındaki baytları karakter olarak okumasıdır.  

Örneğin, bazı karakterlerin depoda depolanması için 2 bayt gerekiyordu. Bu tür verileri okumak için, 2 baytı birlikte okuyan ve karşılık gelen karaktere dönüştürmek için InputStreamReader sınıfını kullanabiliriz.  
 ```java
 // InputStream 
FileInputStream file = new FileInputStream(String path); 
// InputStreamReader 
InputStreamReader input = new InputStreamReader(file);
 ```  

## Writer Sınıfı
Java.io paketinin Writer sınıfı, bir karakter akışını temsil eden soyut bir üst sınıftır.  

Writer soyut bir sınıf olduğu için kendi başına kullanışlı değildir. Bununla birlikte, alt sınıfları veri yazmak için kullanılabilir.
### OutputStreamWriter
Java.io paketinin OutputStreamWriter sınıfı, karakter biçimindeki verileri bayt biçimindeki verilere dönüştürmek için kullanılabilir. Writer soyut sınıfını genişletir.  

OutputStreamWriter sınıfı, diğer çıktı akışlarıyla çalışır. Bayt akışları ve karakter akışları arasında bir köprü olarak da bilinir. Bunun nedeni, OutputStreamWriter'ın karakterlerini bayta dönüştürmesidir.  

Örneğin, bazı karakterlerin depoda saklanması 2 bayt gerektirir. Bu tür verileri yazmak için, karakteri karşılık gelen baytlara dönüştüren ve baytları birlikte depolaması için OutputStreamWriter sınıfını kullanabiliriz.  
```java
// FileOutputStream 
FileOutputStream file = new FileOutputStream("output.txt"); 
// OutputStreamWriter 
OutputStreamWriter output = new OutputStreamWriter(file);
 ```  
getEncoding() metodu, çıktı akışına veri yazmak için kullanılan kodlama türünü almak için kullanılabilir.  

## FileReader
Java.io paketinin FileReader sınıfı, dosyalardan verileri (karakter olarak) okumak için kullanılabilir. InputStreamReader sınıfını genişletir.  

## FileWriter
Java.io paketinin FileWriter sınıfı, dosyalara (karakter olarak) veri yazmak için kullanılabilir. OutputStreamWriter sınıfını genişletir.

## BufferedReader
Java.io paketinin BufferedReader sınıfı, verileri (karakter olarak) daha verimli okumak için diğer okuyucularla birlikte kullanılabilir. Soyut Reader sınıfını genişletir.

BufferedReader, 8192 karakterlik bir dahili arabellek tutar. BufferedReader'daki okuma işlemi sırasında, diskten bir yığın karakter okunur ve dahili tamponda saklanır ve dahili tampondan karakterler ayrı ayrı okunur. Böylelikle diskle iletişim sayısı azalır. BufferedReader kullanarak karakterleri okumak daha hızlı olmasının nedeni budur.

## BufferedWriter
Java.io paketinin BufferedWriter sınıfı, verileri (karakter olarak) daha verimli yazmak için diğer yazarlarla birlikte kullanılabilir. Writer soyut sınıfını genişletir.

## PrintWriter
Java.io paketinin PrintWriter sınıfı, çıktı verilerini yaygın olarak okunabilir bir biçimde (metin) yazmak için kullanılabilir. Writer soyut sınıfını genişletir.

Diğer Writer sınıflarının aksine, PrintWriter ilkel verileri (int, float, char, vb.) Metin formatına dönüştürür. Daha sonra bu biçimlendirilmiş verileri Writer'a aktarır.

Ayrıca, PrintWriter sınıfı herhangi bir girdi / çıktı istisnası (Exception) atmaz. Bunun yerine, içindeki herhangi bir hatayı bulmak için checkError() metodu kullanmamız gerekir.

## Java I/O Sınıflarının Hiyerarşisi

### 📁 File Sınıfı
- `java.io.File`

---

### 🔽 Byte Streams (Bayt Akışı)

#### 📥 InputStream ve Alt Sınıfları
- `InputStream` _(abstract class)_
 - `FileInputStream` → `Closeable`
 - `ByteArrayInputStream` → `Closeable`
 - `BufferedInputStream` → `Closeable`
 - `ObjectInputStream` → `implements ObjectInput, Closeable`

#### 📤 OutputStream ve Alt Sınıfları
- `OutputStream` _(abstract class)_
 - `FileOutputStream` → `Closeable, Flushable`
 - `ByteArrayOutputStream` → `Closeable, Flushable`
 - `BufferedOutputStream` → `Closeable, Flushable`
 - `ObjectOutputStream` → `implements ObjectOutput, Closeable, Flushable`
 - `PrintStream` → `implements Appendable, Closeable, Flushable`

---

### 📝 Character Streams (Karakter Akışı)

#### 📥 Reader ve Alt Sınıfları
- `Reader` _(abstract class)_
 - `FileReader` → `Closeable`
 - `BufferedReader` → `Closeable`
 - `InputStreamReader` → `Closeable`

#### 📤 Writer ve Alt Sınıfları
- `Writer` _(abstract class)_
 - `FileWriter` → `Closeable, Flushable`
 - `BufferedWriter` → `Closeable, Flushable`
 - `OutputStreamWriter` → `Closeable, Flushable`
 - `PrintWriter` → `Closeable, Flushable, Appendable`

---

### 🧊 Serialization ile İlgili Sınıflar
- `ObjectInputStream` → `implements ObjectInput`, serileştirme için nesneleri akıştan okur.
- `ObjectOutputStream` → `implements ObjectOutput`, serileştirilecek nesneleri akışa yazar.
- Serileştirilecek sınıflar `Serializable` arayüzünü **uygulamak zorundadır.**

