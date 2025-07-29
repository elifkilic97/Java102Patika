# Stream API
JDK 8 ile lambda ifadelerinin Java’ya eklenmesi üzerine, yine bununla ilintili olarak Stream API yazılmıştır. Basitçe söylemek gerekirse, koleksiyonlar üzerinde lambda ifadeleri kullanarak işlem yapmamızı sağlayan metotlar eklemiştir.  

Stream, akış demektir. Nesnelerin art arda gelmesiyle bir akış oluşur. Akış yaratarak, bir dizi veya koleksiyonun elemanları üzerinde işlemler yapabiliriz. Akışlar, verinin nasıl depolanacağıyla ilgilenmez, yalnızca veriyi bir yerden bir yere transfer eder. Bu transfer esnasında veri üzerinde bir veya birden fazla işlem yapılması muhtemeldir. Bu işlem verinin filtrelenmesi, sıralanması veya dönüştürülmesi gibi işlemler olabilir. Bu işlem, akışın kaynağını değiştirmez; fakat yeni bir akış oluşturur. Örneğin, bir akışın içindeki nesneleri sıralarsanız, kaynak değişmez; fakat sıralı nesnelerden oluşan yeni bir akış yaratılır.

JDK 8 ile akışları, Stream türünde bir nesne olarak ifade edebiliriz. Stream API çok kapsamlı bir konu olsa da biz yalnızca koleksiyonlar üzerinde yapılan işlemleri inceleyeceğiz.

Bir koleksiyonun akışını elde edebilmek için, JDK 8 ile Collection arayüzüne stream() adında yeni bir metot eklenmiştir. Bu metodun yapısı aşağıdaki gibidir:

```java
interface Collection<T> { Stream<T> stream(); }
```
Bu metodu kullanarak bir koleksiyon için yeni bir akış oluşturabiliriz. Bu metot her çağrıldığında koleksiyon üzerinde yeni bir akış oluşturulur.

## 🌀 Ara İşlemler (Intermediate Operations) – Stream API

Ara işlemler, stream üzerinde işlem tanımlar ama **sonuç üretmezler**.  
**Lazy (tembel)** çalışırlar, yani ancak terminal işlem çağrıldığında gerçekten işlerler.  
Her ara işlem **yeni bir Stream döndürür**.

### 🔹 En Sık Kullanılan Ara İşlemler

| Metot                           | Açıklama                                                             |
|--------------------------------|----------------------------------------------------------------------|
| `filter(Predicate<T>)`         | Şarta uyan elemanları geçirir                                       |
| `map(Function<T, R>)`          | Elemanları dönüştürür (örneğin kare alma, büyük harfe çevirme)     |
| `flatMap(Function<T, Stream>)` | İç içe stream'leri düzleştirir (liste içindeki listeyi açmak gibi) |
| `sorted()`                     | Doğal sıralama yapar (alfabetik veya sayısal)                       |
| `sorted(Comparator<T>)`        | Belirtilen karşılaştırıcıya göre sıralar                           |
| `distinct()`                   | Aynı olanları tekilleştirir                                         |
| `limit(n)`                     | İlk `n` elemanı alır                                                |
| `skip(n)`                      | İlk `n` elemanı atlar                                               |
| `peek(Consumer<T>)`            | Elemanları değiştirmeden debug/log işlemleri için kullanılır        |

> 💡 Not: Bu işlemler terminal işlem olmadan **çalışmazlar**. Zinciri tanımlarlar ama işlemezler.

## ✅ Sonlandırıcı İşlemler (Terminal Operations) – Stream API

Terminal işlemler, stream üzerinde tanımlanan işlemleri **gerçekleştirir ve sonucu üretir**.  
Stream zincirini sonlandırırlar. Bu işlemden sonra aynı stream **yeniden kullanılamaz**.

### 📋 En Sık Kullanılan Terminal İşlemler

| Metot                          | Açıklama                                                              |
|--------------------------------|-----------------------------------------------------------------------|
| `forEach(Consumer<T>)`         | Her elemanı işler (örneğin ekrana yazdırmak için)                     |
| `collect(Collector)`           | Sonuçları liste, set, map gibi bir koleksiyona çevirir                |
| `count()`                      | Stream’deki eleman sayısını döndürür                                 |
| `reduce(BinaryOperator)`       | Elemanları indirger (toplama, çarpma, birleştirme gibi)              |
| `anyMatch(Predicate<T>)`       | En az bir eleman şarta uyuyorsa `true` döner                         |
| `allMatch(Predicate<T>)`       | Tüm elemanlar şarta uyuyorsa `true` döner                            |
| `noneMatch(Predicate<T>)`      | Hiçbir eleman şarta uymuyorsa `true` döner                           |
| `findFirst()`                  | İlk elemanı `Optional` olarak döndürür                               |
| `findAny()`                    | Rastgele bir elemanı `Optional` olarak döndürür (genelde paralel stream'de) |
| `toArray()`                    | Stream içeriğini bir diziye (`T[]`) çevirir                          |

> 💡 Not: Terminal işlem çağrıldığında zincir tetiklenir. Akış **artık sonlanmıştır**, tekrar kullanılamaz.
